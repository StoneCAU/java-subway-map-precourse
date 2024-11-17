package subway.validator;

import subway.exception.ErrorMessage;
import subway.exception.SubwayException;

public class InputValidator {
    public static void validateMenu(String input) {
        isNumber(input);
        validateQuitMenu(input);
    }

    private static void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new SubwayException(ErrorMessage.INVALID_MENU_INPUT);
        }
    }

    private static void validateQuitMenu(String input) {
        if (isQuitMenu(input)) {
            throw new SubwayException(ErrorMessage.INVALID_MENU_INPUT);
        }
    }

    private static boolean isQuitMenu(String input) {
        return input.equals("Q");
    }
}
