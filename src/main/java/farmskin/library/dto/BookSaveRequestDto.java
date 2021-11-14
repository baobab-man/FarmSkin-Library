package farmskin.library.dto;

import farmskin.library.domain.Book;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookSaveRequestDto {

  private String title;
  private String author;

  @Builder
  public BookSaveRequestDto(String title, String author) {
    this.title = title;
    this.author = author;
  }

  public Book toEntity() {
    return Book.builder()
        .title(title)
        .author(author)
        .build();
  }
}
