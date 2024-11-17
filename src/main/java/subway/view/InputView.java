package subway.view;

import java.util.Scanner;

public class InputView {
    private final static String ASK_MENU = "## 원하는 기능을 선택하세요";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputMenu() {
        System.out.println(ASK_MENU);
        return input();
    }

    private String input() {
        return scanner.nextLine();
    }
}
