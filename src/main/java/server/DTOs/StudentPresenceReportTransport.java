package server.DTOs;

import server.annotations.ApiEntity;

import java.sql.Timestamp;
import java.util.List;

@ApiEntity
public class StudentPresenceReportTransport {

    private List<StudentPresenceTransport> studentPresenceTransports;
    private Timestamp dateAndTimeGenerated;

    public StudentPresenceReportTransport() {

    }

    public StudentPresenceReportTransport(List<StudentPresenceTransport> studentPresenceTransports, Timestamp dateAndTimeGenerated) {
        this.studentPresenceTransports = studentPresenceTransports;
        this.dateAndTimeGenerated = dateAndTimeGenerated;
    }

    public List<StudentPresenceTransport> getStudentPresenceTransports() {
        return studentPresenceTransports;
    }

    public void setStudentPresenceTransports(List<StudentPresenceTransport> studentPresenceTransports) {
        this.studentPresenceTransports = studentPresenceTransports;
    }

    public Timestamp getDateAndTimeGenerated() {
        return dateAndTimeGenerated;
    }

    public void setDateAndTimeGenerated(Timestamp dateAndTimeGenerated) {
        this.dateAndTimeGenerated = dateAndTimeGenerated;
    }

}
