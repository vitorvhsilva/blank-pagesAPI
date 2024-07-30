package spring.blankpages.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.blankpages.domain.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, String> {
}
