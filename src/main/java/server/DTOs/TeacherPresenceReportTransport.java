package server.DTOs;

import java.sql.Timestamp;
import java.util.List;

public class TeacherPresenceReportTransport {

    private List<TeacherPresenceTransport> teacherPresenceTransports;
    private Timestamp dateAndTimeGenerated;

    public TeacherPresenceReportTransport() {

    }

    public TeacherPresenceReportTransport(List<TeacherPresenceTransport> teacherPresenceTransports, Timestamp dateAndTimeGenerated) {
        this.teacherPresenceTransports = teacherPresenceTransports;
        this.dateAndTimeGenerated = dateAndTimeGenerated;
    }

    public List<TeacherPresenceTransport> getTeacherPresenceTransports() {
        return teacherPresenceTransports;
    }

    public void setTeacherPresenceTransports(List<TeacherPresenceTransport> teacherPresenceTransports) {
        this.teacherPresenceTransports = teacherPresenceTransports;
    }

    public Timestamp getDateAndTimeGenerated() {
        return dateAndTimeGenerated;
    }

    public void setDateAndTimeGenerated(Timestamp dateAndTimeGenerated) {
        this.dateAndTimeGenerated = dateAndTimeGenerated;
    }

}
