package server.mappers;

import server.DTOs.StudentPresenceTransport;
import server.models.DayTimeFrameInstance;
import server.models.Student;
import server.models.StudentPresence;

public class StudentPresenceMapper {

    public static StudentPresence studentPresenceTransportToStudentPresence(StudentPresenceTransport studentPresenceTransport, String id,
                                                                            Student student, DayTimeFrameInstance dtfi) {
        return new StudentPresence(id, student, dtfi, studentPresenceTransport.getPresenceStatus());
    }

    public static StudentPresenceTransport studentPresenceToStudentPresenceTransport(StudentPresence studentPresence) {
        return new StudentPresenceTransport(studentPresence.getId(), studentPresence.getStudentId().getId(), studentPresence.getDtfiId().getId(),
                                            studentPresence.getPresenceStatus());
    }

}
