package spring.blankpages.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.blankpages.domain.model.Autor;
import spring.blankpages.domain.model.Genero;
import spring.blankpages.domain.model.Livro;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, String> {

    @Query("SELECT l FROM Livro l JOIN l.generos g WHERE g IN :generos")
    List<Livro> findByGeneros(List<Genero> generos);

    @Query("SELECT l FROM Livro l JOIN l.autores a WHERE a IN :autores")
    List<Livro> findAllByAutores(List<Autor> autores);

    @Query("SELECT l FROM Livro l WHERE l.ano = :ano")
    List<Livro> findAllByAno (Integer ano);
}
