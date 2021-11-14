package farmskin.library.dto;

import farmskin.library.domain.Book;
import lombok.Getter;

@Getter
public class BookResponseDto {

  private Long bookId;
  private String title;
  private String author;

  public BookResponseDto(Book book) {
    this.bookId = book.getId();
    this.title = book.getTitle();
    this.author = book.getAuthor();
  }
}
