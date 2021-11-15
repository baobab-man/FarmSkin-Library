package farmskin.library.domain.type.converter;

import farmskin.library.domain.type.Category;
import java.util.stream.Stream;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class CategoryConverter implements AttributeConverter<Category, String> {

  @Override
  public String convertToDatabaseColumn(Category category) {
    return category.getValue();
  }

  @Override
  public Category convertToEntityAttribute(String dbData) {
    return Stream.of(Category.values())
        .filter(c -> c.getValue().equals(dbData))
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }
}