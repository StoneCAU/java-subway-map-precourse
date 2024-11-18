package subway.view;

public class OutputView {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String OUTPUT_PREFIX = "[INFO] ";
    private static final String STATION_REGISTER_SUCCESS = "지하철 역이 등록되었습니다.";

    private static final String MAIN_TITLE = "## 메인 화면";
    private static final String FIRST_MAIN_MENU = "1. 역 관리";
    private static final String SECOND_MAIN_MENU = "2. 노선 관리";
    private static final String THIRD_MAIN_MENU = "3. 구간 관리";
    private static final String FOURTH_MAIN_MENU = "4. 지하철 노선도 출력";
    private static final String QUIT_MAIN_MENU = "Q. 종료";

    private static final String STATION_TITLE = "## 역 관리 화면";
    private static final String FIRST_STATION_MENU = "1. 역 등록";
    private static final String SECOND_STATION_MENU = "2. 역 삭제";
    private static final String THIRD_STATION_MENU = "3. 역 조회";
    private static final String BACK_PREVIOUS_SCREEN = "B. 돌아가기";

    public void printNewLine() {
        System.out.printf(NEW_LINE);
    }

    public void printMainScreen() {
        printNewLine();
        System.out.println(MAIN_TITLE);
        System.out.println(FIRST_MAIN_MENU);
        System.out.println(SECOND_MAIN_MENU);
        System.out.println(THIRD_MAIN_MENU);
        System.out.println(FOURTH_MAIN_MENU);
        System.out.println(QUIT_MAIN_MENU);
    }

    public void printStationManagementScreen() {
        printNewLine();
        System.out.println(STATION_TITLE);
        System.out.println(FIRST_STATION_MENU);
        System.out.println(SECOND_STATION_MENU);
        System.out.println(THIRD_STATION_MENU);
        System.out.println(BACK_PREVIOUS_SCREEN);
    }

    public void printStationRegisterMessage() {
        printNewLine();
        System.out.println(OUTPUT_PREFIX + STATION_REGISTER_SUCCESS);
    }
}
