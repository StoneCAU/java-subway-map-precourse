package subway.exception;

public enum ErrorMessage {
    INVALID_MENU_INPUT("선택할 수 없는 기능입니다."),
    INVALID_STATION_NAME_LENGTH("역 이름은 2글자 이상이어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
