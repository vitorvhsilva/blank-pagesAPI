package spring.blankpages.domain.service.atualizar;

import spring.blankpages.api.dto.LivroAtualizarInputDTO;
import spring.blankpages.domain.model.Livro;

public interface AtualizacaoLivro {
    void atualizar(Livro livroPego, LivroAtualizarInputDTO dto);
}
