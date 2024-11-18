package subway.exception;

public enum ErrorMessage {
    INVALID_MENU_INPUT("선택할 수 없는 기능입니다."),
    INVALID_STATION_NAME_LENGTH("역 이름은 2글자 이상이어야 합니다."),
    DUPLICATE_STATION_NAME("이미 존재하는 역입니다."),
    NOT_FOUND_STATION_NAME("존재하지 않는 역입니다."),
    REGISTERED_STATION_NAME("노선에 등록된 역은 삭제할 수 없습니다."),
    DUPLICATE_LINE_NAME("이미 존재하는 노선입니다."),
    DUPLICATE_UPSTATION_AND_DOWNSTATION("상행 종점역과 하행 종점역은 같을 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
