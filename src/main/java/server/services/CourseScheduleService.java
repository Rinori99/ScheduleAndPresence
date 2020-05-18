package server.services;

import server.DTOs.CourseScheduleTransport;
import server.DTOs.DayTimeFrameInstanceTransport;

public interface CourseScheduleService {

    CourseScheduleTransport saveCourseSchedule(CourseScheduleTransport courseSchedule);

    CourseScheduleTransport getCourseScheduleByCourseId(String courseId);

    CourseScheduleTransport changeCourseSchedule(CourseScheduleTransport courseSchedule);

    void deleteCourseSchedule(String courseId);

    DayTimeFrameInstanceTransport bookEmptyTimeSlot(String dtfId, DayTimeFrameInstanceTransport dtfiTransport);

    void deleteDayTimeFrameInstanceById(String dtfiId);

    DayTimeFrameInstanceTransport setDayTimeFrameInstanceDescription(String dtfiId, String description);
}
