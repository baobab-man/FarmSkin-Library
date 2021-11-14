package farmskin.library.service;

import farmskin.library.domain.Book;
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

  /** 도서 - 등록 */
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
  public BookResponseDto findById(Long bookId) {

    Book book = bookRepository.findById(bookId)
        .orElseThrow(() -> new IllegalAccessError("[bookId=" + bookId + "] 해당 도서가 존재하지 않습니다."));

    return new BookResponseDto(book);
  }

  /** 도서 - 수정 */
  @Transactional
  public Long update(Long bookId, BookUpdateRequestDto bookUpdateRequestDto) {

    Book book = bookRepository.findById(bookId)
        .orElseThrow(() -> new IllegalAccessError("[bookId=" + bookId + "] 해당 도서가 존재하지 않습니다."));

    book.update(bookUpdateRequestDto.getTitle(), bookUpdateRequestDto.getAuthor());

    return bookId;
  }

  /** 도서 - 삭제 */
  @Transactional
  public void delete(Long bookId) {

    Book book = bookRepository.findById(bookId)
        .orElseThrow(() -> new IllegalAccessError("[bookId=" + bookId + "] 해당 도서가 존재하지 않습니다."));

    bookRepository.delete(book);
  }
}
