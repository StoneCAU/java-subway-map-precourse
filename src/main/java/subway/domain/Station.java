package subway.domain;

import subway.exception.ErrorMessage;
import subway.exception.SubwayException;
import subway.repository.StationRepository;

public class Station {
    private String name;

    private Station(String name) {
        this.name = name;
    }

    public static Station createStation(String name) {
        validate(name);
        return new Station(name);
    }

    public static Station addLineToStation(String name) {
        return new Station(name);
    }

    public String getName() {
        return name;
    }

    private static void validate(String name) {
        if (isDuplicateName(name)) {
            throw new SubwayException(ErrorMessage.DUPLICATE_STATION_NAME);
        }
    }

    private static boolean isDuplicateName(String name) {
        Station station = StationRepository.findByName(name).orElse(null);
        return station != null;
    }

    @Override
    public String toString() {
        return name;
    }
}
