package subway.view;

import java.util.List;
import subway.domain.Line;
import subway.domain.Station;

public class OutputView {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String OUTPUT_PREFIX = "[INFO] ";
    private static final String STATION_LIST_TITLE = "## 역 목록";
    private static final String LINE_LIST_TITLE = "## 노선 목록";
    private static final String BACK_PREVIOUS_SCREEN = "B. 돌아가기";
    private static final String STATION_REGISTER_SUCCESS = "지하철 역이 등록되었습니다.";
    private static final String STATION_DELETE_SUCCESS = "지하철 역이 삭제되었습니다.";
    private static final String LINE_REGISTER_SUCCESS = "지하철 노선이 등록되었습니다.";
    private static final String LINE_DELETE_SUCCESS = "지하철 노선이 삭제되었습니다.";
    private static final String SECTION_REGISTER_SUCCESS = "구간이 등록되었습니다.";
    private static final String SECTION_DELETE_SUCCESS = "구간이 삭제되었습니다.";

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

    private static final String LINE_TITLE = "## 노선 관리 화면";
    private static final String FIRST_LINE_MENU = "1. 노선 등록";
    private static final String SECOND_LINE_MENU = "2. 노선 삭제";
    private static final String THIRD_LINE_MENU = "3. 노선 조회";

    private static final String SECTION_TITLE = "## 구간 관리 화면";
    private static final String FIRST_SECTION_MENU = "1. 구간 등록";
    private static final String SECOND_SECTION_MENU = "2. 구간 삭제";

    private static final String SUBWAY_MAP_TITLE = "## 지하철 노선도";
    private static final String DIVIDER = "---";

    private void printNewLine() {
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

    public void printStationDeleteMessage() {
        printNewLine();
        System.out.println(OUTPUT_PREFIX + STATION_DELETE_SUCCESS);
    }

    public void printStations(List<Station> stations) {
        printNewLine();
        System.out.println(STATION_LIST_TITLE);
        stations.forEach(station -> System.out.println(OUTPUT_PREFIX + station));
    }

    public void printLineManagementScreen() {
        printNewLine();
        System.out.println(LINE_TITLE);
        System.out.println(FIRST_LINE_MENU);
        System.out.println(SECOND_LINE_MENU);
        System.out.println(THIRD_LINE_MENU);
        System.out.println(BACK_PREVIOUS_SCREEN);
    }

    public void printLineRegisterMessage() {
        printNewLine();
        System.out.println(OUTPUT_PREFIX + LINE_REGISTER_SUCCESS);
    }

    public void printLineDeleteMessage() {
        printNewLine();
        System.out.println(OUTPUT_PREFIX + LINE_DELETE_SUCCESS);
    }

    public void printLines(List<Line> lines) {
        printNewLine();
        System.out.println(LINE_LIST_TITLE);
        lines.forEach(line -> System.out.println(OUTPUT_PREFIX + line));
    }

    public void printSectionManagementScreen() {
        printNewLine();
        System.out.println(SECTION_TITLE);
        System.out.println(FIRST_SECTION_MENU);
        System.out.println(SECOND_SECTION_MENU);
        System.out.println(BACK_PREVIOUS_SCREEN);
    }

    public void printSectionRegisterMessage() {
        printNewLine();
        System.out.println(OUTPUT_PREFIX + SECTION_REGISTER_SUCCESS);
    }

    public void printSectionDeleteMessage() {
        printNewLine();
        System.out.println(OUTPUT_PREFIX + SECTION_DELETE_SUCCESS);
    }

    public void printSubwayMap(List<Line> lines) {
        printNewLine();
        System.out.println(OUTPUT_PREFIX + SUBWAY_MAP_TITLE);
        lines.forEach(line -> {
            List<Station> stations = line.getStations();
            System.out.println(OUTPUT_PREFIX + line);
            System.out.println(OUTPUT_PREFIX + DIVIDER);
            stations.forEach(station -> System.out.println(OUTPUT_PREFIX + station));
            printNewLine();
        });
    }
}
