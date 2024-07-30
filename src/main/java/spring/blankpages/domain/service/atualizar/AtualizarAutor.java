package spring.blankpages.domain.service.atualizar;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import spring.blankpages.api.config.exception.ValidacaoException;
import spring.blankpages.api.dto.LivroAtualizarInputDTO;
import spring.blankpages.domain.model.Livro;
import spring.blankpages.domain.repository.AutorRepository;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class AtualizarAutor implements AtualizacaoLivro{

    private AutorRepository autorRepository;

    @Override
    public void atualizar(Livro livroPego, LivroAtualizarInputDTO dto) {
        if (!livroPego.getAutores().equals(dto.getAutores())) {
            livroPego.setAutores(dto.getAutores().stream()
                    .map(autor -> {
                        if (autor.getId() != null) {
                            return autorRepository.findById(autor.getId())
                                    .orElseThrow(() -> new ValidacaoException("Autor não encontrado"));
                        }
                        return autorRepository.save(autor);
                    })
                    .collect(Collectors.toList()));
        }
    }
}
