package server.mappers;

import server.DTOs.TeacherPresenceTransport;
import server.models.DayTimeFrameInstance;
import server.models.TeacherPresence;

public class TeacherPresenceMapper {

    public static TeacherPresence teacherPresenceTransportToTeacherPresence(TeacherPresenceTransport teacherPresenceTransport,
                                                                            DayTimeFrameInstance dtfi) {
        return new TeacherPresence(teacherPresenceTransport.getTeacherId(), dtfi, teacherPresenceTransport.isHeld());
    }

    public static TeacherPresenceTransport teacherPresenceToTeacherPresenceTransport(TeacherPresence teacherPresence) {
        return new TeacherPresenceTransport(teacherPresence.getId(), teacherPresence.getTeacherId(), teacherPresence.getDtfiId().toString(),
                teacherPresence.isHeld());
    }

}
