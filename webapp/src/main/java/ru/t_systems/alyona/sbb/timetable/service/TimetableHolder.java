package ru.t_systems.alyona.sbb.timetable.service;

import ru.t_systems.alyona.sbb.timetable.TimetableDTO;
import ru.t_systems.alyona.sbb.timetable.TimetableUpdateDTO;
import ru.t_systems.alyona.sbb.timetable.config.ApplicationConfiguration;
import ru.t_systems.alyona.sbb.timetable.integration.timetableservice.restclient.TimetableServiceClient;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.ZonedDateTime;

@ApplicationScoped
public class TimetableHolder {

    private String stationName;

    private TimetableDTO timetable;

    @Inject
    private ApplicationConfiguration configuration;

    @Inject
    private TimetableServiceClient timetableServiceClient;

    @PostConstruct
    public void initialize() {
        this.stationName = configuration.getStationName();
        reloadTimetable();
    }

    public TimetableDTO getTimetable() {
        return timetable;
    }

    public void reloadTimetable() {
        this.timetable = timetableServiceClient.downloadTimetableForStation(
                configuration.getStationName(), configuration.getTimetableDate());
    }

    public void updateTimetable(TimetableUpdateDTO timetableUpdate) {

        for (ZonedDateTime departureTime : timetableUpdate.getTrainDepartureDates()) {
            timetable.getSegments().stream()
                    .filter(segment -> segment.getTrainNumber().equals(timetableUpdate.getTrainNumber()) &&
                                       segment.getTrainDepartureDate().isEqual(departureTime))
                    .forEach(segment -> segment.setStatus(timetableUpdate.getNewStatus()));
        }
    }
}
