package spring.blankpages.domain.service;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import spring.blankpages.api.dto.*;
import spring.blankpages.domain.model.Autor;
import spring.blankpages.domain.model.Genero;
import spring.blankpages.domain.model.Livro;
import spring.blankpages.domain.repository.AutorRepository;
import spring.blankpages.domain.repository.LivroRepository;
import spring.blankpages.domain.service.atualizar.AtualizacaoLivro;
import spring.blankpages.domain.service.validacao.ValidacaoLivro;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LivroService {

    private final AutorRepository autorRepository;
    private LivroRepository livroRepository;
    private ModelMapper modelMapper;
    private List<ValidacaoLivro> validacoes;
    private List<AtualizacaoLivro> atualizacoes;

    public ResponseEntity<LivroOutputDTO> cadastrar(LivroCadastroInputDTO dto) {
        validacoes.forEach(v -> v.validar(dto));

        Livro livro = modelMapper.map(dto, Livro.class);
        livro = livroRepository.save(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(livro, LivroOutputDTO.class));
    }

    public List<LivroListarOutputDTO> listarTodos() {
        List<Livro> livros = livroRepository.findAll();

        if (livros.isEmpty()) { throw new RuntimeException("Nenhum livro cadastrado"); }

        return livros.stream()
                .map(l -> modelMapper.map(l, LivroListarOutputDTO.class)).collect(Collectors.toList());

    }


    public ResponseEntity<LivroOutputDTO> listar(String id) {
        return ResponseEntity.ok(modelMapper.map(buscarLivro(id), LivroOutputDTO.class));
    }

    public ResponseEntity<LivroOutputDTO> atualizar(LivroAtualizarInputDTO dto) {
        Livro livroPego = buscarLivro(dto.getId());

        atualizacoes.forEach(a -> a.atualizar(livroPego, dto));

        return ResponseEntity.ok(modelMapper.map(livroPego, LivroOutputDTO.class));

    }

    public ResponseEntity<Void> deletar(String id) {
        Livro livro = buscarLivro(id);

        livroRepository.delete(livro);

        return ResponseEntity.noContent().build();
    }

    public List<LivroListarOutputDTO> listarPorGenero(GeneroDTO dto) {
        List<Genero> generoList = dto.getGeneros()
                .stream()
                .map(Genero::valueOf)
                .collect(Collectors.toList());

        List<Livro> livros = livroRepository.findByGeneros(generoList);

        return converterLista(livros);
    }

    public List<LivroListarOutputDTO> listarPorAutor(AutorDTO dto) {
        List<Autor> autores = autorRepository.encontrarPorNome(dto.getAutores());

        if (autores.isEmpty()) throw new RuntimeException("Autores não encontrado");

        List<Livro> livros = livroRepository.findAllByAutores(autores);

        return converterLista(livros);
    }

    public List<LivroListarOutputDTO> listarPorAno(AnoDTO dto) {
        List<Livro> livros = livroRepository.findAllByAno(dto.getAno());

        return converterLista(livros);
    }

    private Livro buscarLivro(String id) {
        Optional<Livro> livro = livroRepository.findById(id);

        if (livro.isEmpty()) throw new RuntimeException("Livro não encontrado");

        return livro.get();
    }

    private List<LivroListarOutputDTO> converterLista(List<Livro> livros) {
        if (livros.isEmpty()) throw new RuntimeException("Nenhum livro encontrado");

        return livros.stream()
                .map(l -> modelMapper.map(l, LivroListarOutputDTO.class)).collect(Collectors.toList());
    }

}
