package server.controllers;

import org.springframework.web.bind.annotation.*;
import server.DTOs.CourseScheduleTransport;
import server.DTOs.DayTimeFrameInstanceTransport;
import server.services.CourseScheduleService;

@RestController
@RequestMapping(value = "/course-schedule")
public class CourseScheduleController {

    private CourseScheduleService courseScheduleService;

    public CourseScheduleController(CourseScheduleService courseScheduleService) {
        this.courseScheduleService = courseScheduleService;
    }

    @GetMapping("?courseId={courseId}")
    public CourseScheduleTransport getCourseSchedule(@RequestParam String courseId) {
        return courseScheduleService.getCourseScheduleByCourseId(courseId);
    }

    @PostMapping("/")
    public CourseScheduleTransport saveCourseSchedule(@RequestBody CourseScheduleTransport courseSchedule) {
        return courseScheduleService.saveCourseSchedule(courseSchedule);
    }

    @PutMapping("/")
    public CourseScheduleTransport changeCourseSchedule(@RequestBody CourseScheduleTransport courseSchedule) {
        return courseScheduleService.changeCourseSchedule(courseSchedule);
    }

    @DeleteMapping("?courseId={courseId}")
    public void deleteCourseSchedule(@RequestParam String courseId) {
        courseScheduleService.deleteCourseSchedule(courseId);
    }

    @PostMapping("?dtfId={dtfId}")
    public DayTimeFrameInstanceTransport bookTimeSlot(@RequestParam String dtfId, @RequestBody DayTimeFrameInstanceTransport dtfiTransport) {
        return courseScheduleService.bookEmptyTimeSlot(dtfId, dtfiTransport);
    }

    @DeleteMapping("/{dtfiId}")
    public void emptyTimeSlot(@PathVariable String dtfiId) {
        courseScheduleService.deleteDayTimeFrameInstanceById(dtfiId);
    }

    @PutMapping("/{dtfiId}")
    public DayTimeFrameInstanceTransport setDescription(@PathVariable String dtfiId, @RequestBody String description) {
        return courseScheduleService.setDayTimeFrameInstanceDescription(dtfiId, description);
    }

    // GET schedule for a student
    // GET schedule for a teacher

}
