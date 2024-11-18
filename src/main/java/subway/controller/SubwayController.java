package subway.controller;

import subway.domain.Station;
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
    }

    private void registerStation() {
        String stationName = inputView.inputStationName();
        InputValidator.validateStationName(stationName);

        StationRepository.addStation(Station.createStation(stationName));
        outputView.printStationRegisterMessage();
    }

    private void manageLine() {

    }

    private void manageSection() {

    }

    private void printSubwayMap() {

    }
}
