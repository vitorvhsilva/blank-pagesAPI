package spring.blankpages.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Livro {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank
    private String titulo;

    @NotNull
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Autor> autores;

    @NotNull
    private Integer ano;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    @ElementCollection(targetClass = Genero.class)
    private List<Genero> generos;

}
