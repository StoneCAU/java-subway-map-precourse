package subway.validator;

import subway.exception.ErrorMessage;
import subway.exception.SubwayException;

public class InputValidator {
    private static final String QUIT = "Q";
    private static final String BACK = "B";
    private static final int MIN_LENGTH = 2;

    public static void validateMainMenu(String input) {
        if (isQuitMenu(input)) return;
        isNumber(input);
    }

    public static void validateStationMenu(String input) {
        if (isBackMenu(input)) return;
        isNumber(input);
    }

    public static void validateStationName(String input) {
        if (!isValidLength(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_STATION_NAME_LENGTH.getMessage());
        }
    }

    private static void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new SubwayException(ErrorMessage.INVALID_MENU_INPUT);
        }
    }

    private static boolean isQuitMenu(String input) {
        return input.equals(QUIT);
    }

    private static boolean isBackMenu(String input) {
        return input.equals(BACK);
    }

    private static boolean isValidLength(String input) {
        return input.length() >= MIN_LENGTH;
    }
}
