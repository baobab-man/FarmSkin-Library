package farmskin.library.controller;

import farmskin.library.domain.type.Category;
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
@RequestMapping("/api/books")
@RestController
public class BookController {

  private final BookService bookService;

  /** 도서 - 신규 등록 */
  @PostMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
  public ResponseEntity<Long> save(@RequestBody BookSaveRequestDto bookSaveRequestDto) {

    Long savedId = bookService.save(bookSaveRequestDto);

    return new ResponseEntity<Long>(savedId, HttpStatus.CREATED);
  }

  /** 도서 - 목록 조회  */
  @GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
  public ResponseEntity<List<BookResponseDto>> findAll() {

    List<BookResponseDto> bookResponseDtoList = bookService.findAll();

    return new ResponseEntity<List<BookResponseDto>>(bookResponseDtoList, HttpStatus.OK);
  }

  /** 도서 - 단건 조회 */
  @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
  public ResponseEntity<BookResponseDto> findById(@PathVariable("id") Long id) {

    BookResponseDto bookResponseDto = bookService.findById(id);

    return new ResponseEntity<BookResponseDto>(bookResponseDto, HttpStatus.OK);
  }

  /** 도서 - 정보 변경 */
  @PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
  public ResponseEntity<Long> update(@PathVariable("id") Long id, @RequestBody BookUpdateRequestDto bookUpdateRequestDto) {

    Long updatedId = bookService.update(id, bookUpdateRequestDto);

    return new ResponseEntity<Long>(updatedId, HttpStatus.CREATED);
  }

  /** 도서 - 삭제 */
  @DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
  public ResponseEntity<Long> delete(@PathVariable("id") Long id) {

    bookService.delete(id);

    return new ResponseEntity<Long>(id, HttpStatus.NO_CONTENT);
  }

  /** 도서 - 키워드(제목이나 저자) 조회 */
  @GetMapping(value = "/keyword", produces = { MediaType.APPLICATION_JSON_VALUE })
  public ResponseEntity<List<BookResponseDto>> findByTitleAndAuthor(String keyword) {

    List<BookResponseDto> bookResponseDtoList = bookService.findByTitleAndAuthor(keyword);

    return new ResponseEntity<List<BookResponseDto>>(bookResponseDtoList, HttpStatus.OK);
  }

  /** 도서 - 카테고리 조회 */
  @GetMapping(value = "/category", produces = { MediaType.APPLICATION_JSON_VALUE })
  public ResponseEntity<List<BookResponseDto>> findByCategory(Category category) {

    List<BookResponseDto> bookResponseDtoList = bookService.findByCategory(category);

    return new ResponseEntity<List<BookResponseDto>>(bookResponseDtoList, HttpStatus.OK);
  }
}
