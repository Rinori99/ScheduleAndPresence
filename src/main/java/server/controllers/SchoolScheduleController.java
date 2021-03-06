package server.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import server.DTOs.SchoolScheduleTransport;
import server.services.SchoolScheduleService;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/school-schedule")
public class SchoolScheduleController {

    private SchoolScheduleService schoolScheduleService;

    public SchoolScheduleController(SchoolScheduleService schoolScheduleService) {
        this.schoolScheduleService = schoolScheduleService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public SchoolScheduleTransport getSchoolScheduleBySchoolId(@RequestParam String schoolId) {
        return schoolScheduleService.getSchoolScheduleBySchoolId(schoolId);
    }

    @PostMapping
    public SchoolScheduleTransport createSchoolSchedule(@RequestBody SchoolScheduleTransport schoolSchedule) {
        return schoolScheduleService.saveSchoolSchedule(schoolSchedule);
    }

    @PutMapping
    public void updateSchoolSchedule(@RequestBody SchoolScheduleTransport schoolSchedule) {
        schoolScheduleService.changeSchoolSchedule(schoolSchedule);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping
    public void deleteSchoolScheduleBySchoolId(@RequestParam("schoolId") String schoolId) {
        schoolScheduleService.deleteSchoolScheduleBySchoolId(schoolId);
    }

}