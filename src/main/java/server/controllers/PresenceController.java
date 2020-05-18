package server.controllers;

import org.springframework.web.bind.annotation.*;
import server.DTOs.*;
import server.models.PresenceStatus;
import server.services.PresenceService;

@RestController
@RequestMapping(value = "/presence")
public class PresenceController {

    private PresenceService presenceService;

    public PresenceController(PresenceService presenceService) {
        this.presenceService = presenceService;
    }

    @GetMapping("?studentId={studentId}")
    public StudentPresenceReportTransport getPresenceReportForStudent(@RequestParam String studentId) {
        return presenceService.getPresenceReportByStudentId(studentId);
    }

    @GetMapping("?teacherId={teacherId}")
    public TeacherPresenceReportTransport getPresenceReportForTeacher(@RequestParam String teacherId) {
        return presenceService.getPresenceReportByTeacherId(teacherId);
    }

    @PostMapping("/")
    public ClassPresenceTransport setStudentsPresence(@RequestBody ClassPresenceTransport classPresence) {
        return presenceService.saveStudentsPresence(classPresence);
    }

    @PostMapping("/teacher")
    public TeacherPresenceTransport saveTeacherPresence(@RequestBody TeacherPresenceTransport teacherPresenceTransport) {
        return presenceService.saveTeacherPresence(teacherPresenceTransport);
    }

    @PutMapping("/{studentPresenceId}")
    public StudentPresenceTransport changeStudentPresence(@PathVariable String studentPresenceId, @RequestBody String presenceStatus) {
        return presenceService.updateStudentPresence(studentPresenceId, PresenceStatus.valueOf(presenceStatus));
    }

}
