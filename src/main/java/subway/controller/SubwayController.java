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
        if (input.equals("3")) manageStation();
        if (input.equals("4")) printSubwayMap();

        return input;
    }

    private void manageStation() {
        outputView.printStationManagementScreen();
        String input = inputView.inputMenu();
        InputValidator.validateStationMenu(input);

        if (input.equals("1")) registerStation();

        if (input.equals("2")) deleteStation();
    }

    private void registerStation() {
        String stationName = inputView.inputRegisterStationName();
        InputValidator.validateStationName(stationName);

        StationRepository.addStation(Station.createStation(stationName));
        outputView.printStationRegisterMessage();
    }

    private void deleteStation() {
        String stationName = inputView.inputDeleteStationName();
        Station station = StationRepository.findByName(stationName)
                .orElseThrow(() -> new SubwayException(ErrorMessage.NOT_FOUND_STATION_NAME));
        List<Line> lines = LineRepository.lines();

        for (Line line : lines) {
            if (line.containsStation(stationName)) {
                throw new SubwayException(ErrorMessage.REGISTERED_STATION_NAME);
            }
        }

        StationRepository.deleteStation(stationName);
        outputView.printStationDeleteMessage();
    }

    private void manageLine() {

    }

    private void manageSection() {

    }

    private void printSubwayMap() {

    }
}
