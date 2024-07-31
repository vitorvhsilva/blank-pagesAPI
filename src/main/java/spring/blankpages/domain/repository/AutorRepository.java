package spring.blankpages.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.blankpages.domain.model.Autor;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, String> {
    @Query("SELECT a FROM Autor a WHERE a.nome IN :autores")
    List<Autor> encontrarPorNome(List<String> autores);
}
