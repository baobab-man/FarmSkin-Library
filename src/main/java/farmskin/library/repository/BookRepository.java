package farmskin.library.repository;

import farmskin.library.domain.Book;
import farmskin.library.domain.type.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

  List<Book> findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(String title, String author);

  List<Book> findByCategory(Category category);
}
