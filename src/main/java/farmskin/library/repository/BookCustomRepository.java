package farmskin.library.repository;

import farmskin.library.domain.Book;
import farmskin.library.domain.type.Category;
import java.util.List;

public interface BookCustomRepository {

  List<Book> findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(String title, String author);

  List<Book> findByCategory(Category category);
}
