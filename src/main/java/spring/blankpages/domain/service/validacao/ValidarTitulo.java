package spring.blankpages.domain.service.validacao;

import org.springframework.stereotype.Component;
import spring.blankpages.api.config.exception.ValidacaoException;
import spring.blankpages.api.dto.LivroCadastroInputDTO;

@Component
public class ValidarTitulo implements ValidacaoLivro{
    @Override
    public void validar(LivroCadastroInputDTO dto) {
        if (dto.getTitulo().length() < 3) { throw new ValidacaoException("Titulo do livro muito pequeno"); }
    }
}
