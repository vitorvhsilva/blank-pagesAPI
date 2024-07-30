package spring.blankpages.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import spring.blankpages.domain.model.Autor;
import spring.blankpages.domain.model.Genero;

import java.util.List;

@Data
public class LivroCadastroInputDTO {
    @NotBlank
    private String titulo;

    @NotNull
    private List<Autor> autores;

    @NotNull
    private Integer ano;

    @NotNull
    private List<Genero> generos;
}
