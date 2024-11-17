package subway.exception;

public class SubwayException extends IllegalArgumentException{
    private static final String PREFIX = "[ERROR] ";

    public SubwayException(ErrorMessage errorMessage) {
        super(PREFIX + errorMessage.getMessage());
    }
}
