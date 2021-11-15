package farmskin.library.domain.type;

public enum BookStatus {
  INSTOCK("대여가능"),
  EMPTY("대여중"),
  DAMAGE("훼손"),
  LOST("분실");

  private final String value;

  BookStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
