package spring.blankpages.api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import spring.blankpages.api.dto.*;
import spring.blankpages.domain.service.LivroService;

import java.util.List;

@RestController
@RequestMapping("livros")
@AllArgsConstructor
public class LivroController {

    private LivroService livroService;

    @PostMapping
    public ResponseEntity<LivroOutputDTO> cadastrar(@RequestBody @Valid LivroCadastroInputDTO dto) {
        return livroService.cadastrar(dto);
    }

    @GetMapping
    public List<LivroListarOutputDTO> listarTodos() {
        return livroService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroOutputDTO> listar(@PathVariable String id) {
        return livroService.listar(id);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<LivroOutputDTO> atualizar(@RequestBody @Valid LivroAtualizarInputDTO dto) {
        return livroService.atualizar(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        return livroService.deletar(id);
    }

    @GetMapping("/genero")
    public List<LivroListarOutputDTO> listarPorGenero(@RequestBody GeneroDTO dto) {
        return livroService.listarPorGenero(dto);
    }

}
