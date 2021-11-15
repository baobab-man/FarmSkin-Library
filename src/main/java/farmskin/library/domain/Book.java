package farmskin.library.domain;

import javax.persistence.Column;
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

//  @Enumerated(EnumType.STRING)
//  @Column(name = "status", nullable = false)
//  private BookStatus status;
//
//  @Enumerated(EnumType.STRING)
//  @Column(name = "category", nullable = false)
//  private Category category;

  @Builder
  public Book(String title, String author) {
    this.title = title;
    this.author = author;
  }

  public void update(String title, String author) {
    this.title = title;
    this.author = author;
  }
}
