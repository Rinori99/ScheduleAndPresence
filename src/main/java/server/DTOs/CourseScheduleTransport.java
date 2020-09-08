package server.DTOs;

import server.annotations.ApiEntity;

import java.util.List;

@ApiEntity
public class CourseScheduleTransport {

    private String courseId;
    private List<DayTimeFrameInstanceTransport> dayTimeFrameInstances;

    public CourseScheduleTransport() {

    }

    public CourseScheduleTransport(List<DayTimeFrameInstanceTransport> dayTimeFrameInstances) {
        this.dayTimeFrameInstances = dayTimeFrameInstances;
    }

    public CourseScheduleTransport(String courseId, List<DayTimeFrameInstanceTransport> dayTimeFrameInstances) {
        this.courseId = courseId;
        this.dayTimeFrameInstances = dayTimeFrameInstances;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public List<DayTimeFrameInstanceTransport> getDayTimeFrameInstances() {
        return dayTimeFrameInstances;
    }

    public void setDayTimeFrameInstances(List<DayTimeFrameInstanceTransport> dayTimeFrameInstances) {
        this.dayTimeFrameInstances = dayTimeFrameInstances;
    }

}
