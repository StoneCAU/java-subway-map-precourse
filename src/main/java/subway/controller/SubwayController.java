package subway.controller;

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
        outputView.printMainScreen();
        String menu = selectMenu();
    }

    private String selectMenu() {
        String input = inputView.inputMenu();
        InputValidator.validateMenu(input);

        return input;
    }
}
