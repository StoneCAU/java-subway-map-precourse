package subway.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class SetUpManager {
    private static final List<String> initialStations = List.of("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    private static final List<String> initialLines = List.of("2호선", "3호선", "신분당선");
    private static final Map<String, List<String>> initialMap = new HashMap<>() {{
        put("2호선", List.of("교대역", "강남역", "역삼역"));
        put("3호선", List.of("교대역", "남부터미널역", "양재역", "매봉역"));
        put("신분당선", List.of("강남역", "양재역", "양재시민의숲역"));
    }};

    public void setUp() {
        initializeStations();
        addLine();
        addStation();
    }

    private void initializeStations() {
        initialStations.forEach(station -> StationRepository.addStation(Station.createStation(station)));
    }

    private void addLine() {
        initialLines.forEach(line -> {
            List<String> lineStations = initialMap.get(line);
            String upLine = lineStations.get(0);
            String downLine = lineStations.get(lineStations.size() - 1);
            LineRepository.addLine(new Line(line, upLine, downLine));
        });
    }

    private void addStation() {
        initialMap.forEach((line, stations) -> stations.stream()
                .skip(1)
                .limit(stations.size() - 2)
                .forEach(station -> {
                    Line originLine = LineRepository.findLineByName(line).orElseThrow(
                            IllegalArgumentException::new);
                    originLine.addStation(station, stations.indexOf(station));
                }));
    }
}
