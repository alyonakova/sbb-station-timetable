package ru.t_systems.alyona.sbb.timetable.backing;

import ru.t_systems.alyona.sbb.timetable.Segment;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Named
@SessionScoped
public class TimetableBackingBean implements Serializable {

    private String stationName = "Green Hills";
    private List<Segment> segments;

    public String getStationName() {
        return this.stationName;
    }

    public List<Segment> getSegments() {
        Segment segment1 = new Segment("121a", Instant.parse("2020-11-10T18:35:24.00Z"),
                "Green Hills", Instant.parse("2020-11-12T18:00:24.00Z"), "Red Volcano", "Cancelled");
        Segment segment2 = new Segment("121a", Instant.parse("2020-11-12T18:30:24.00Z"),
                "Red Volcano", Instant.parse("2020-11-13T10:00:24.00Z"), "Chemical Plant", "Cancelled");
        return List.of(segment1, segment2);
    }
}
