package subway.controller;

import java.util.List;
import subway.domain.Line;
import subway.domain.Station;
import subway.exception.ErrorMessage;
import subway.exception.SubwayException;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.validator.InputValidator;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {

    private final InputView inputView;
    private final OutputView outputView;

    public SubwayController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String select;

        do {
            outputView.printMainScreen();
            select = selectMenu();
        } while (!select.equals("Q"));
    }

    private String selectMenu() {
        String input = inputView.inputMenu();
        InputValidator.validateMainMenu(input);

        if (input.equals("1")) manageStation();
        if (input.equals("2")) manageLine();
        if (input.equals("3")) manageSection();
        if (input.equals("4")) printSubwayMap();

        return input;
    }

    private void manageStation() {
        outputView.printStationManagementScreen();
        String input = inputView.inputMenu();
        InputValidator.validateSubMenu(input,3);

        if (input.equals("1")) registerStation();
        if (input.equals("2")) deleteStation();
        if (input.equals("3")) printAllStations();
    }

    private void registerStation() {
        String stationName = inputView.inputRegisterStationName();
        InputValidator.validateNameLength(stationName);

        StationRepository.addStation(Station.createStation(stationName));
        outputView.printStationRegisterMessage();
    }

    private void deleteStation() {
        String stationName = inputView.inputDeleteStationName();
        Station station = StationRepository.findByName(stationName).orElseThrow(() -> new SubwayException(ErrorMessage.NOT_FOUND_STATION_NAME));
        List<Line> lines = LineRepository.lines();

        for (Line line : lines) {
            if (line.containsStation(stationName)) {
                throw new SubwayException(ErrorMessage.REGISTERED_STATION_NAME);
            }
        }

        StationRepository.deleteStation(stationName);
        outputView.printStationDeleteMessage();
    }

    private void printAllStations() {
        List<Station> stations = StationRepository.stations();
        outputView.printStations(stations);
    }

    private void manageLine() {
        outputView.printLineManagementScreen();
        String input = inputView.inputMenu();
        InputValidator.validateSubMenu(input,3);

        if (input.equals("1")) registerLine();
        if (input.equals("2")) deleteLine();
        if (input.equals("3")) printAllLines();
    }

    private void registerLine() {
        String lineName = inputView.inputRegisterLineName();
        InputValidator.validateNameLength(lineName);
        Line.validateName(lineName);

        String upStationName = inputView.inputUpStationName();
        String downStationName = inputView.inputDownStationName();

        LineRepository.addLine(new Line(lineName, upStationName, downStationName));
        outputView.printLineRegisterMessage();
    }

    private void deleteLine() {
        String lineName = inputView.inputDeleteLineName();
        Line line = LineRepository.findLineByName(lineName).orElseThrow(() -> new SubwayException(ErrorMessage.NOT_FOUND_LINE_NAME));

        LineRepository.deleteLineByName(lineName);
        outputView.printLineDeleteMessage();
    }

    private void printAllLines() {
        List<Line> lines = LineRepository.lines();
        outputView.printLines(lines);
    }

    private void manageSection() {
        outputView.printSectionManagementScreen();
        String input = inputView.inputMenu();
        InputValidator.validateSubMenu(input,2);

        if (input.equals("1")) registerSection();
        if (input.equals("2")) deleteSection();
    }

    private void registerSection() {
        String lineName = inputView.inputRegisterSectionLineName();
        Line line = LineRepository.findLineByName(lineName).orElseThrow(() -> new SubwayException(ErrorMessage.NOT_FOUND_LINE_NAME));

        String stationName = inputView.inputRegisterSectionStationName();
        Station station = StationRepository.findByName(stationName).orElse(null);
        if (station != null) throw new SubwayException(ErrorMessage.DUPLICATE_STATION_NAME);

        String index = inputView.inputRegisterSectionIndex();
        InputValidator.validateIndex(index);

        line.addStation(stationName, Integer.parseInt(index));
        outputView.printSectionRegisterMessage();
    }

    private void deleteSection() {
        String lineName = inputView.inputDeleteSectionLineName();
        Line line = LineRepository.findLineByName(lineName).orElseThrow(() -> new SubwayException(ErrorMessage.NOT_FOUND_LINE_NAME));

        String stationName = inputView.inputDeleteSectionStationName();
        Station station = StationRepository.findByName(stationName).orElseThrow(() -> new SubwayException(ErrorMessage.NOT_FOUND_STATION_NAME));

        line.deleteStation(stationName);
        outputView.printSectionDeleteMessage();
    }

    private void printSubwayMap() {

    }
}
