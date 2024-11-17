package subway.view;

public class OutputView {
    private static final String MAIN_TITLE = "## 메인 화면";
    private static final String FIRST_MENU = "1. 역 관리";
    private static final String SECOND_MENU = "2. 노선 관리";
    private static final String THIRD_MENU = "3. 구간 관리";
    private static final String FOURTH_MENU = "4. 지하철 노선도 출력";
    private static final String QUIT_MENU = "Q. 종료";

    public void printMainScreen() {
        System.out.println(MAIN_TITLE);
        System.out.println(FIRST_MENU);
        System.out.println(SECOND_MENU);
        System.out.println(THIRD_MENU);
        System.out.println(FOURTH_MENU);
        System.out.println(QUIT_MENU);
    }
}
