package subway.view;

import java.util.Scanner;

public class InputView {
    private final static String NEW_LINE = System.lineSeparator();
    private final static String ASK_MENU = "## 원하는 기능을 선택하세요.";

    private final static String ASK_REGISTER_STATION = "## 등록할 역 이름을 입력하세요.";
    private final static String ASK_DELETE_STATION = "## 삭제할 역 이름을 입력하세요.";

    private final static String ASK_REGISTER_LINE = "## 등록할 노선 이름을 입력하세요.";
    private final static String ASK_REGISTER_UPSTATION = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private final static String ASK_REGISTER_DOWNSTATION = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private final static String ASK_DELETE_LINE = "## 삭제할 노선의 이름을 입력하세요.";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    private void printNewLine() {
        System.out.printf(NEW_LINE);
    }

    public String inputMenu() {
        printNewLine();
        System.out.println(ASK_MENU);
        return input();
    }

    public String inputRegisterStationName() {
        printNewLine();
        System.out.println(ASK_REGISTER_STATION);
        return input();
    }

    public String inputDeleteStationName() {
        printNewLine();
        System.out.println(ASK_DELETE_STATION);
        return input();
    }

    public String inputRegisterLineName() {
        printNewLine();
        System.out.println(ASK_REGISTER_LINE);
        return input();
    }

    public String inputUpStationName() {
        printNewLine();
        System.out.println(ASK_REGISTER_UPSTATION);
        return input();
    }

    public String inputDownStationName() {
        printNewLine();
        System.out.println(ASK_REGISTER_DOWNSTATION);
        return input();
    }

    public String inputDeleteLineName() {
        printNewLine();
        System.out.println(ASK_DELETE_LINE);
        return input();
    }

    private String input() {
        return scanner.nextLine();
    }
}
