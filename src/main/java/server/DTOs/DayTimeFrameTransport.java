package server.DTOs;

import server.annotations.ApiEntity;

import java.sql.Time;

@ApiEntity
public class DayTimeFrameTransport {

    private String id;
    private String day;
    private Time startTime;
    private Time endTime;
    private String type;

    public DayTimeFrameTransport() {

    }

    public DayTimeFrameTransport(String day, Time startTime, Time endTime, String type) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
    }

    public DayTimeFrameTransport(String id, String day, Time startTime, Time endTime, String type) {
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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
