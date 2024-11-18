package subway.domain;

import java.util.LinkedList;
import java.util.List;
import subway.exception.ErrorMessage;
import subway.exception.SubwayException;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class Line {
    private String name;
    private List<Station> stations = new LinkedList<>();

    public Line(String name, String upStationName, String downStationName) {
        validateDuplicate(upStationName, downStationName);
        createStations(upStationName, downStationName);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStation(String stationName, int index) {
        Station station = StationRepository.findByName(stationName).orElse(Station.addLineToStation(name));
        stations.add(index, station);
    }

    public boolean containsStation(String stationName) {
        Station station = StationRepository.findByName(stationName).orElse(null);
        if (station != null) {
            return stations.contains(station);
        }
        return false;
    }

    public static void validateName(String name) {
        if (isDuplicateName(name)) {
            throw new SubwayException(ErrorMessage.DUPLICATE_LINE_NAME);
        }
    }

    public static void validateDuplicate(String upStationName, String downStationName) {
        if (isDuplicateUpStationAndDownStation(upStationName, downStationName)) {
            throw new SubwayException(ErrorMessage.DUPLICATE_UPSTATION_AND_DOWNSTATION);
        }
    }

    private void createStations(String upStationName, String downStationName) {
        Station upStation = StationRepository.findByName(upStationName).orElseGet(() -> {
            Station temp = Station.addLineToStation(upStationName);
            StationRepository.addStation(temp);
            return temp;
        });
        Station downStation = StationRepository.findByName(downStationName).orElseGet(() -> {
            Station temp = Station.addLineToStation(downStationName);
            StationRepository.addStation(temp);
            return temp;
        });

        stations.add(upStation);
        stations.add(downStation);
    }

    private static boolean isDuplicateName(String name) {
        Line line = LineRepository.findLineByName(name).orElse(null);
        return line != null;
    }

    private static boolean isDuplicateUpStationAndDownStation(String upStationName, String downStationName) {
        return upStationName.equals(downStationName);
    }
}
