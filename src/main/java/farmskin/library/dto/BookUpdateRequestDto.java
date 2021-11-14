package farmskin.library.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookUpdateRequestDto {

  private String title;
  private String author;

  @Builder
  public BookUpdateRequestDto(String title, String author) {
    this.title = title;
    this.author = author;
  }
}
