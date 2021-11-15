package farmskin.library.dto;

import farmskin.library.domain.Book;
import farmskin.library.domain.type.BookStatus;
import farmskin.library.domain.type.Category;
import lombok.Getter;

@Getter
public class BookResponseDto {

  private Long id;
  private String title;
  private String author;
  private Category category;
  private BookStatus status;

  public BookResponseDto(Book book) {
    this.id = book.getId();
    this.title = book.getTitle();
    this.author = book.getAuthor();
    this.category = book.getCategory();
    this.status = book.getStatus();
  }
}
