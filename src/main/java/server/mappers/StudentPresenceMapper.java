package server.mappers;

import server.DTOs.StudentPresenceTransport;
import server.models.DayTimeFrameInstance;
import server.models.StudentPresence;

public class StudentPresenceMapper {

    public static StudentPresence studentPresenceTransportToStudentPresence(StudentPresenceTransport studentPresenceTransport,
                                                                            DayTimeFrameInstance dtfi) {
        return new StudentPresence(studentPresenceTransport.getStudentId(), dtfi, studentPresenceTransport.getPresenceStatus());
    }

    public static StudentPresenceTransport studentPresenceToStudentPresenceTransport(StudentPresence studentPresence) {
        return new StudentPresenceTransport(studentPresence.getId(), studentPresence.getStudentId(), studentPresence.getDtfiId().toString(),
                                            studentPresence.getPresenceStatus());
    }

}
