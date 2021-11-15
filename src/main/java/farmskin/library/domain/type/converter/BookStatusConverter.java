package farmskin.library.domain.type.converter;

import farmskin.library.domain.type.BookStatus;
import java.util.stream.Stream;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class BookStatusConverter implements AttributeConverter<BookStatus, String> {

  @Override
  public String convertToDatabaseColumn(BookStatus bookStatus) {
    return bookStatus.getValue();
  }

  @Override
  public BookStatus convertToEntityAttribute(String dbData) {
    return Stream.of(BookStatus.values())
        .filter(c -> c.getValue().equals(dbData))
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }
}

