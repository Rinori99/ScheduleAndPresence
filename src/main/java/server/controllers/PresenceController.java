package server.controllers;

import org.springframework.web.bind.annotation.*;
import server.DTOs.*;
import server.services.PresenceService;

@RestController
@RequestMapping("presence")
public class PresenceController {

    private PresenceService presenceService;

    public PresenceController(PresenceService presenceService) {
        this.presenceService = presenceService;
    }

    @GetMapping("student")
    public StudentPresenceReportTransport getPresenceReportForStudent(@RequestParam(required = false) String studentId) {
        return presenceService.getPresenceReportByStudentId(studentId);
    }

    @GetMapping("teacher")
    public TeacherPresenceReportTransport getPresenceReportForTeacher(@RequestParam(required = false) String teacherId) {
        return presenceService.getPresenceReportByTeacherId(teacherId);
    }

    @PostMapping
    public ClassPresenceTransport setStudentsPresence(@RequestBody ClassPresenceTransport classPresence) {
        return presenceService.saveStudentsPresence(classPresence);
    }

    @PostMapping("teacher")
    public TeacherPresenceTransport saveTeacherPresence(@RequestBody TeacherPresenceTransport teacherPresenceTransport) {
        return presenceService.saveTeacherPresence(teacherPresenceTransport);
    }

    @PutMapping("{studentPresenceId}")
    public StudentPresenceTransport updateStudentPresence(@PathVariable String studentPresenceId, @RequestBody StudentPresenceTransport studentPresenceTransport) {
        return presenceService.updateStudentPresence(studentPresenceId, studentPresenceTransport);
    }

}
