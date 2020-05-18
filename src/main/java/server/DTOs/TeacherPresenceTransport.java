package server.DTOs;

public class TeacherPresenceTransport {

    private String id;
    private String teacherId;
    private String dtfiId;
    private boolean held;

    public TeacherPresenceTransport() {

    }

    public TeacherPresenceTransport(String teacherId, String dtfiId, boolean held) {
        this.teacherId = teacherId;
        this.dtfiId = dtfiId;
        this.held = held;
    }

    public TeacherPresenceTransport(String id, String teacherId, String dtfiId, boolean held) {
        this.id = id;
        this.teacherId = teacherId;
        this.dtfiId = dtfiId;
        this.held = held;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getDtfiId() {
        return dtfiId;
    }

    public void setDtfiId(String dtfiId) {
        this.dtfiId = dtfiId;
    }

    public boolean isHeld() {
        return held;
    }

    public void setHeld(boolean held) {
        this.held = held;
    }

}
