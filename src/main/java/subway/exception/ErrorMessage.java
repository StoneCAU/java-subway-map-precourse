package subway.exception;

public enum ErrorMessage {
    INVALID_MENU_INPUT("선택할 수 없는 기능입니다."),
    INVALID_STATION_NAME_LENGTH("역 이름은 2글자 이상이어야 합니다."),
    DUPLICATE_STATION_NAME("이미 존재하는 역입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
