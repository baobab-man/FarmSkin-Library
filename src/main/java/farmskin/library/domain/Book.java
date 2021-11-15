package farmskin.library.domain;

import farmskin.library.domain.type.BookStatus;
import farmskin.library.domain.type.Category;
import farmskin.library.domain.type.converter.BookStatusConverter;
import farmskin.library.domain.type.converter.CategoryConverter;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "book_id", nullable = false)
  private Long id;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "author", nullable = false)
  private String author;

  @Convert(converter = BookStatusConverter.class)
  @Column(name = "status", nullable = false)
  private BookStatus status;

  @Convert(converter = CategoryConverter.class)
  @Column(name = "category", nullable = false)
  private Category category;

  @Builder
  public Book(String title, String author, Category category, BookStatus status) {
    this.title = title;
    this.author = author;
    this.category = category;
    this.status = status;
  }

  public void update(String title, String author, Category category, BookStatus status) {
    this.title = title;
    this.author = author;
    this.category = category;
    this.status = status;
  }
}
