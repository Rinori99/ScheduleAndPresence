package server.models;

import javax.persistence.*;
import java.sql.Time;
import java.util.UUID;

@Entity
@Table(name = "day_time_frame")
public class DayTimeFrame {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "day")
    private Day day;

    @Column(name = "start_time")
    private Time startTime;

    @Column(name = "end_time")
    private Time endTime;

    @Column(name = "type")
    private TimeFrameType type;

    @Column(name = "school_id")
    private String schoolId;

    public DayTimeFrame() {

    }

    public DayTimeFrame(Day day, Time startTime, Time endTime, TimeFrameType type, String schoolId) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
        this.schoolId = schoolId;
    }

    public DayTimeFrame(String id, Day day, Time startTime, Time endTime, TimeFrameType type, String schoolId) {
        this.id = id;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
        this.schoolId = schoolId;
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

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

}
