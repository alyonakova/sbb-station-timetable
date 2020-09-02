package ru.t_systems.alyona.sbb.timetable;

import java.io.Serializable;
import java.time.Instant;

public class Segment implements Serializable {

    private String trainNumber;
    private Instant departureDate;
    private String departureStation;
    private Instant arrivalDate;
    private String arrivalStation;
    private String status;

    public Segment() {
    }

    public Segment(String trainNumber, Instant departureDate, String departureStation, Instant arrivalDate,
                   String arrivalStation, String status) {
        this.trainNumber = trainNumber;
        this.departureDate = departureDate;
        this.departureStation = departureStation;
        this.arrivalDate = arrivalDate;
        this.arrivalStation = arrivalStation;
        this.status = status;
    }

    public String getTrainNumber() {
        return this.trainNumber;
    }

    public Instant getDepartureDate() {
        return this.departureDate;
    }

    public String getDepartureStation() {
        return this.departureStation;
    }

    public Instant getArrivalDate() {
        return this.arrivalDate;
    }

    public String getArrivalStation() {
        return this.arrivalStation;
    }

    public String getStatus() {
        return this.status;
    }
}
