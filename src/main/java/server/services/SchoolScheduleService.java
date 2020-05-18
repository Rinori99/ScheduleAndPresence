package server.services;

import server.DTOs.SchoolScheduleTransport;
import server.models.DayTimeFrame;

import java.util.List;

public interface SchoolScheduleService {

    SchoolScheduleTransport saveSchoolSchedule(SchoolScheduleTransport schoolSchedule);

    SchoolScheduleTransport getSchoolScheduleBySchoolId(String schoolId);

    void deleteSchoolScheduleBySchoolId(String schoolId);

    SchoolScheduleTransport changeSchoolSchedule(SchoolScheduleTransport schoolSchedule);

}
