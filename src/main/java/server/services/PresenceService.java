package server.services;

import server.DTOs.*;
import server.models.PresenceStatus;

public interface PresenceService {

    ClassPresenceTransport saveStudentsPresence(ClassPresenceTransport classPresence);

    StudentPresenceTransport updateStudentPresence(String studentPresenceId, PresenceStatus presenceStatus);

    StudentPresenceReportTransport getPresenceReportByStudentId(String studentId);

    TeacherPresenceTransport saveTeacherPresence(TeacherPresenceTransport teacherPresenceTransport);

    TeacherPresenceReportTransport getPresenceReportByTeacherId(String teacherId);
}
