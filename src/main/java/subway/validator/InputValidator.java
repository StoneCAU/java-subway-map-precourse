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
        if (!isValidMenuNum(input, 4)) {
            throw new SubwayException(ErrorMessage.INVALID_MENU_INPUT);
        }
    }

    public static void validateSubMenu(String input, int menuNum) {
        if (isBackMenu(input)) return;
        isNumber(input);
        if (!isValidMenuNum(input, menuNum)) {
            throw new SubwayException(ErrorMessage.INVALID_MENU_INPUT);
        }
    }

    public static void validateNameLength(String input) {
        if (!isValidLength(input)) {
            throw new SubwayException(ErrorMessage.INVALID_STATION_NAME_LENGTH);
        }
    }

    public static void validateIndex(String input) {
        indexIsNumber(input);
        if (!indexIsGreaterThanZero(input)) {
            throw new SubwayException(ErrorMessage.INDEX_IS_SMALL_THAN_ZERO);
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

    private static boolean isValidMenuNum(String input, int menuNum) {
        int menu = Integer.parseInt(input);
        if (menu >= 1 && menu <= menuNum) return true;

        return false;
    }

    private static void indexIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new SubwayException(ErrorMessage.INDEX_IS_NOT_NUMBER);
        }
    }

    private static boolean indexIsGreaterThanZero(String input) {
        return Integer.parseInt(input) > 0;
    }
}
