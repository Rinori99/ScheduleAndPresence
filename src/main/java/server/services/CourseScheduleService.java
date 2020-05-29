package server.services;

import server.DTOs.CourseScheduleTransport;
import server.DTOs.DayTimeFrameInstanceTransport;
import server.DTOs.DtfIDescriptionTransport;

public interface CourseScheduleService {

    CourseScheduleTransport saveCourseSchedule(CourseScheduleTransport courseSchedule);

    CourseScheduleTransport getCourseScheduleByCourseId(String courseId);

    CourseScheduleTransport changeCourseSchedule(CourseScheduleTransport courseSchedule);

    void deleteCourseSchedule(String courseId);

    DayTimeFrameInstanceTransport bookEmptyTimeSlot(String dtfId, DayTimeFrameInstanceTransport dtfiTransport);

    void deleteDayTimeFrameInstanceById(String dtfiId);

    DayTimeFrameInstanceTransport setDayTimeFrameInstanceDescription(DtfIDescriptionTransport descriptionTransport);
}
