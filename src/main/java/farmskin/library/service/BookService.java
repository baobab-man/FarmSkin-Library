package farmskin.library.service;

import farmskin.library.domain.Book;
import farmskin.library.domain.type.Category;
import farmskin.library.dto.BookResponseDto;
import farmskin.library.dto.BookSaveRequestDto;
import farmskin.library.dto.BookUpdateRequestDto;
import farmskin.library.repository.BookRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BookService {

  private final BookRepository bookRepository;

  /** 도서 - 신규 등록 */
  @Transactional
  public Long save(BookSaveRequestDto bookSaveRequestDto) {

    return bookRepository.save(bookSaveRequestDto.toEntity())
        .getId();
  }

  /** 도서 - 목록 조회 */
  @Transactional(readOnly = true)
  public List<BookResponseDto> findAll() {

    return bookRepository.findAll()
        .stream()
        .map(BookResponseDto::new)
        .collect(Collectors.toList());
  }

  /** 도서 - 단건 조회 */
  @Transactional(readOnly = true)
  public BookResponseDto findById(Long id) {

    Book book = bookRepository.findById(id)
        .orElseThrow(() -> new IllegalAccessError("[id=" + id + "] 해당 도서가 존재하지 않습니다."));

    return new BookResponseDto(book);
  }

  /** 도서 - 정보 변경 */
  @Transactional
  public Long update(Long id, BookUpdateRequestDto bookUpdateRequestDto) {

    Book book = bookRepository.findById(id)
        .orElseThrow(() -> new IllegalAccessError("[id=" + id + "] 해당 도서가 존재하지 않습니다."));

    book.update(
        bookUpdateRequestDto.getTitle(),
        bookUpdateRequestDto.getAuthor(),
        bookUpdateRequestDto.getCategory(),
        bookUpdateRequestDto.getStatus()
    );

    return id;
  }

  /** 도서 - 삭제 */
  @Transactional
  public void delete(Long id) {

    Book book = bookRepository.findById(id)
        .orElseThrow(() -> new IllegalAccessError("[id=" + id + "] 해당 도서가 존재하지 않습니다."));

    bookRepository.delete(book);
  }

  /** 도서 - 키워드(제목이나 저자) 조회 */
  @Transactional(readOnly = true)
  public List<BookResponseDto> findByTitleAndAuthor(String keyword) {

    return bookRepository
        .findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(keyword, keyword)
        .stream()
        .map(BookResponseDto::new)
        .collect(Collectors.toList());
  }

  /** 도서 - 카테고리 조회 */
  @Transactional(readOnly = true)
  public List<BookResponseDto> findByCategory(Category category) {

    return bookRepository
        .findByCategory(category)
        .stream()
        .map(BookResponseDto::new)
        .collect(Collectors.toList());
  }
}
