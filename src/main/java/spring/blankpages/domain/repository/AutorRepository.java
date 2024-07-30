package spring.blankpages.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.blankpages.domain.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, String> {
}
