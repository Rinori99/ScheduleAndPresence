package server.controllers;

import org.springframework.web.bind.annotation.*;
import server.DTOs.CourseScheduleTransport;
import server.DTOs.DayTimeFrameInstanceTransport;
import server.DTOs.DtfIDescriptionTransport;
import server.services.CourseScheduleService;

@RestController
@RequestMapping("/course-schedule")
public class CourseScheduleController {

    private CourseScheduleService courseScheduleService;

    public CourseScheduleController(CourseScheduleService courseScheduleService) {
        this.courseScheduleService = courseScheduleService;
    }

    @GetMapping
    public CourseScheduleTransport getCourseScheduleByCourseId(@RequestParam("courseId") String courseId) {
        return courseScheduleService.getCourseScheduleByCourseId(courseId);
    }

    @PostMapping
    public CourseScheduleTransport saveCourseSchedule(@RequestBody CourseScheduleTransport courseSchedule) {
        return courseScheduleService.saveCourseSchedule(courseSchedule);
    }

    @PutMapping
    public CourseScheduleTransport updateCourseSchedule(@RequestBody CourseScheduleTransport courseSchedule) {
        return courseScheduleService.changeCourseSchedule(courseSchedule);
    }

    @DeleteMapping
    public void deleteCourseSchedule(@RequestParam("courseId") String courseId) {
        courseScheduleService.deleteCourseSchedule(courseId);
    }

    @PostMapping("bookings")
    public DayTimeFrameInstanceTransport bookTimeSlot(@RequestParam("dtfId") String dtfId, @RequestBody DayTimeFrameInstanceTransport dtfiTransport) {
        return courseScheduleService.bookEmptyTimeSlot(dtfId, dtfiTransport);
    }

    @DeleteMapping("{dtfiId}")
    public void emptyTimeSlot(@PathVariable String dtfiId) {
        courseScheduleService.deleteDayTimeFrameInstanceById(dtfiId);
    }

    @PutMapping("description")
    public DayTimeFrameInstanceTransport setDescription(@RequestBody DtfIDescriptionTransport descriptionTransport) {
        return courseScheduleService.setDayTimeFrameInstanceDescription(descriptionTransport);
    }

}
