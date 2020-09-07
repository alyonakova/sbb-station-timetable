package ru.t_systems.alyona.sbb.timetable.config;

import javax.enterprise.context.ApplicationScoped;
import java.net.URI;
import java.time.LocalDate;

@ApplicationScoped
public class ApplicationConfiguration {

    public String getStationName() {
        return "Red Volcano";
    }

    public LocalDate getTimetableDate() {
        return LocalDate.of(2020, 10, 27);
    }

    public URI getTimetableServiceURI() {
        return URI.create("http://localhost:8080/sbb/");
    }
}
