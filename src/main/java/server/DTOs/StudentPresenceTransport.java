package server.DTOs;

import server.annotations.ApiEntity;

@ApiEntity
public class StudentPresenceTransport {

    private String id;
    private String studentId;
    private String dtfiId;
    private String presenceStatus;

    public StudentPresenceTransport() {}

    public StudentPresenceTransport(String studentId, String dtfiId, String presenceStatus) {
        this.studentId = studentId;
        this.dtfiId = dtfiId;
        this.presenceStatus = presenceStatus;
    }

    public StudentPresenceTransport(String id, String studentId, String dtfiId, String presenceStatus) {
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

    public String getPresenceStatus() {
        return presenceStatus;
    }

    public void setPresenceStatus(String presenceStatus) {
        this.presenceStatus = presenceStatus;
    }

}
