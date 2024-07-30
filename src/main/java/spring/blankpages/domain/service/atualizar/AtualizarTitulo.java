package spring.blankpages.domain.service.atualizar;

import org.springframework.stereotype.Component;
import spring.blankpages.api.dto.LivroAtualizarInputDTO;
import spring.blankpages.domain.model.Livro;

@Component
public class AtualizarTitulo implements AtualizacaoLivro{
    @Override
    public void atualizar(Livro livroPego, LivroAtualizarInputDTO dto) {
        if (!livroPego.getTitulo().equals(dto.getTitulo())) {
            livroPego.setTitulo(dto.getTitulo());
        }
    }
}
