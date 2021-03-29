package am.itspace.common.repository;


import am.itspace.common.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepo extends JpaRepository<Book, Integer> {
}
