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

    public List<Station> getStations() {
        return stations;
    }

    public void addStation(String stationName, int index) {
        validateIndex(index);
        Station station = StationRepository.findByName(stationName).orElseGet(() ->{
            Station temp = Station.addLineToStation(stationName);
            StationRepository.addStation(temp);
            return temp;
        });
        stations.add(index - 1, station);
    }

    public void deleteStation(String stationName) {
        validateStationNumber();
        Station station = StationRepository.findByName(stationName).orElseThrow(() -> new SubwayException(ErrorMessage.NOT_FOUND_STATION_NAME));
        validateContainsStation(station);
        stations.remove(station);
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

    private void validateIndex(int index) {
        if (indexIsGreaterThanStationNumber(index)) {
            throw new SubwayException(ErrorMessage.INDEX_IS_BIGGER_THAN_STATIONS_SIZE);
        }
    }

    private void validateStationNumber() {
        if (stationNumberIsStorage()) {
            throw new SubwayException(ErrorMessage.STATION_NUMBER_IS_STORAGE);
        }
    }

    private void validateContainsStation(Station station) {
        if (!lineContainsStation(station)) {
            throw new SubwayException(ErrorMessage.LINE_NOT_CONTAINS_STATION);
        }
    }

    private void validateDuplicate(String upStationName, String downStationName) {
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

    private boolean isDuplicateUpStationAndDownStation(String upStationName, String downStationName) {
        return upStationName.equals(downStationName);
    }

    private boolean indexIsGreaterThanStationNumber(int index) {
        return index > stations.size();
    }

    private boolean stationNumberIsStorage() {
        return stations.size() <= 2;
    }

    private boolean lineContainsStation(Station station) {
        return stations.contains(station);
    }

    @Override
    public String toString() {
        return name;
    }
}
