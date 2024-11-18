package subway;

import java.util.Scanner;
import subway.controller.SubwayController;
import subway.domain.SetUpManager;
import subway.view.InputView;
import subway.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        OutputView outputView = new OutputView();

        start(inputView, outputView);
    }

    private static void start(InputView inputView, OutputView outputView) {
        SubwayController subwayController = new SubwayController(inputView, outputView);
        SetUpManager setUpManager = new SetUpManager();
        setUpManager.setUp();

        subwayController.run();
    }
}
