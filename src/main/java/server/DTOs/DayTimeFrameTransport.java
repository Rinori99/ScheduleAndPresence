package server.DTOs;

import server.models.Day;
import server.models.TimeFrameType;

import java.sql.Time;

public class DayTimeFrameTransport {

    private String id;
    private Day day;
    private Time startTime;
    private Time endTime;
    private TimeFrameType type;

    public DayTimeFrameTransport() {

    }

    public DayTimeFrameTransport(Day day, Time startTime, Time endTime, TimeFrameType type) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
    }

    public DayTimeFrameTransport(String id, Day day, Time startTime, Time endTime, TimeFrameType type) {
        this.id = id;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public TimeFrameType getType() {
        return type;
    }

    public void setType(TimeFrameType type) {
        this.type = type;
    }

}
