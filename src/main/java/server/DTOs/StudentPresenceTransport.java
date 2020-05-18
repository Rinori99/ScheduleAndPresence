package server.DTOs;

import server.models.PresenceStatus;

public class StudentPresenceTransport {

    private String id;
    private String studentId;
    private String dtfiId;
    private PresenceStatus presenceStatus;

    public StudentPresenceTransport() {}

    public StudentPresenceTransport(String studentId, String dtfiId, PresenceStatus presenceStatus) {
        this.studentId = studentId;
        this.dtfiId = dtfiId;
        this.presenceStatus = presenceStatus;
    }

    public StudentPresenceTransport(String id, String studentId, String dtfiId, PresenceStatus presenceStatus) {
        this.id = id;
        this.studentId = studentId;
        this.dtfiId = dtfiId;
        this.presenceStatus = presenceStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getDtfiId() {
        return dtfiId;
    }

    public void setDtfiId(String dtfiId) {
        this.dtfiId = dtfiId;
    }

    public PresenceStatus getPresenceStatus() {
        return presenceStatus;
    }

    public void setPresenceStatus(PresenceStatus presenceStatus) {
        this.presenceStatus = presenceStatus;
    }

}
