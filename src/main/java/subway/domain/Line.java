package subway.domain;

import java.util.LinkedList;
import java.util.List;
import subway.repository.StationRepository;

public class Line {
    private String name;
    private List<Station> stations = new LinkedList<>();

    public Line(String name, String upLine, String downLine) {
        createStations(upLine, downLine);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void createStations(String upLine, String downLine) {
        Station upStation = StationRepository.findByName(upLine).orElse(Station.addLineToStation(name));
        Station downStation = StationRepository.findByName(downLine).orElse(Station.addLineToStation(name));

        stations.add(upStation);
        stations.add(downStation);
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
}
