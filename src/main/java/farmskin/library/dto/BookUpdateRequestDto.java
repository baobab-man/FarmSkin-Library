package farmskin.library.dto;

import farmskin.library.domain.type.BookStatus;
import farmskin.library.domain.type.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookUpdateRequestDto {

  private String title;
  private String author;
  private Category category;
  private BookStatus status;

  @Builder
  public BookUpdateRequestDto(String title, String author, Category category, BookStatus status) {
    this.title = title;
    this.author = author;
    this.category = category;
    this.status = status;
  }
}
