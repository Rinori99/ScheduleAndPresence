package server.services;

import server.DTOs.*;

public interface PresenceService {

    ClassPresenceTransport saveStudentsPresence(ClassPresenceTransport classPresence);

    StudentPresenceTransport updateStudentPresence(String studentPresenceId, StudentPresenceTransport studentPresenceTransport);

    StudentPresenceReportTransport getPresenceReportByStudentId(String studentId);

    TeacherPresenceTransport saveTeacherPresence(TeacherPresenceTransport teacherPresenceTransport);

    TeacherPresenceReportTransport getPresenceReportByTeacherId(String teacherId);
}
