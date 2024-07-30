package spring.blankpages.domain.service.validacao;

import spring.blankpages.api.dto.LivroCadastroInputDTO;

public interface ValidacaoLivro {
    void validar(LivroCadastroInputDTO dto);
}
