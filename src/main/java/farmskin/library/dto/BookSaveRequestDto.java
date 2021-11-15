package farmskin.library.dto;

import farmskin.library.domain.Book;
import farmskin.library.domain.type.BookStatus;
import farmskin.library.domain.type.Category;
import java.util.Calendar;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookSaveRequestDto {

  private String title;
  private String author;
  private Category category;
  private BookStatus status;

  @Builder
  public BookSaveRequestDto(String title, String author, Category category, BookStatus status) {
    this.title = title;
    this.author = author;
    this.category = category;
    this.status = status;
  }

  public Book toEntity() {
    return Book.builder()
        .title(title)
        .author(author)
        .category(category)
        .status(status)
        .build();
  }
}
