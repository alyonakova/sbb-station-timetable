package ru.t_systems.alyona.sbb.timetable.integration.timetableservice.restclient;

import ru.t_systems.alyona.sbb.timetable.TimetableDTO;
import ru.t_systems.alyona.sbb.timetable.config.ApplicationConfiguration;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;

@Dependent
public class TimetableServiceClient {

    @Inject
    ApplicationConfiguration configuration;

    public TimetableDTO downloadTimetableForStation(String stationName, LocalDate date) {
        Client client = ClientBuilder.newClient();
        WebTarget serviceTarget = client.target(configuration.getTimetableServiceURI());
        WebTarget endpointTarget = serviceTarget
                .path("stations")
                .path(stationName)
                .path("timetable")
                .queryParam("date", date);
        return endpointTarget.request(MediaType.APPLICATION_JSON).get(TimetableDTO.class);
    }
}
