package farmskin.library.controller;

import farmskin.library.dto.BookResponseDto;
import farmskin.library.dto.BookSaveRequestDto;
import farmskin.library.dto.BookUpdateRequestDto;
import farmskin.library.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/book")
@RestController
public class BookController {

  private final BookService bookService;

  /** 도서 - 목록 조회  */
  @GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
  public ResponseEntity<List<BookResponseDto>> findAll() {

    List<BookResponseDto> bookResponseDtoList = bookService.findAll();

    return new ResponseEntity<List<BookResponseDto>>(bookResponseDtoList, HttpStatus.OK);
  }

  /** 도서 - 단건 조회 */
  @GetMapping(value = "/{bookId}", produces = { MediaType.APPLICATION_JSON_VALUE })
  public ResponseEntity<BookResponseDto> findById(@PathVariable("bookId") Long bookId) {

    BookResponseDto bookResponseDto = bookService.findById(bookId);

    return new ResponseEntity<BookResponseDto>(bookResponseDto, HttpStatus.OK);
  }

  /** 도서 - 등록 */
  @PostMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
  public ResponseEntity<Long> save(@RequestBody BookSaveRequestDto bookSaveRequestDto) {

    Long savedBookId = bookService.save(bookSaveRequestDto);

    return new ResponseEntity<Long>(savedBookId, HttpStatus.CREATED);
  }

  /** 도서 - 수정 */
  @PutMapping(value = "/{bookId}", produces = { MediaType.APPLICATION_JSON_VALUE })
  public ResponseEntity<Long> update(@PathVariable("bookId") Long bookId, @RequestBody BookUpdateRequestDto bookUpdateRequestDto) {

    Long updatedBookId = bookService.update(bookId, bookUpdateRequestDto);

    return new ResponseEntity<Long>(updatedBookId, HttpStatus.CREATED);
  }

  /** 도서 - 삭제 */
  @DeleteMapping(value = "/{bookId}", produces = { MediaType.APPLICATION_JSON_VALUE })
  public ResponseEntity<Long> delete(@PathVariable("bookId") Long bookId) {

    bookService.delete(bookId);

    return new ResponseEntity<Long>(bookId, HttpStatus.NO_CONTENT);
  }
}
