package ru.t_systems.alyona.sbb.timetable.ui.web.jsf.backing;

import ru.t_systems.alyona.sbb.timetable.TimetableSegmentDTO;
import ru.t_systems.alyona.sbb.timetable.config.ApplicationConfiguration;
import ru.t_systems.alyona.sbb.timetable.service.TimetableHolder;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class TimetablePage implements Serializable {

    @Inject
    private TimetableHolder timetableHolder;

    @Inject
    private ApplicationConfiguration configuration;

    public String getStationName() {
        return configuration.getStationName();
    }

    public List<TimetableSegmentDTO> getTimetableSegments() {
        return timetableHolder.getTimetable().getSegments();
    }

    public void reloadTimetable() {
        timetableHolder.reloadTimetable();
    }
}
