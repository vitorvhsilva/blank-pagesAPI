package spring.blankpages.api.dto;

import lombok.Data;
import spring.blankpages.domain.model.Autor;
import spring.blankpages.domain.model.Genero;

import java.util.List;

@Data
public class LivroAtualizarInputDTO {
    private String id;
    private String titulo;
    private List<Autor> autores;
    private Integer ano;
    private List<Genero> generos;
}
