package server.DTOs;

import server.annotations.ApiEntity;

import java.util.List;

@ApiEntity
public class SchoolScheduleTransport {

    private String schoolId;
    private List<DayTimeFrameTransport> dayTimeFrames;

    public SchoolScheduleTransport() {

    }

    public SchoolScheduleTransport(String schoolId, List<DayTimeFrameTransport> dayTimeFrames) {
        this.dayTimeFrames = dayTimeFrames;
        this.schoolId = schoolId;
    }

    public List<DayTimeFrameTransport> getDayTimeFrames() {
        return dayTimeFrames;
    }

    public void setDayTimeFrames(List<DayTimeFrameTransport> dayTimeFrames) {
        this.dayTimeFrames = dayTimeFrames;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

}
