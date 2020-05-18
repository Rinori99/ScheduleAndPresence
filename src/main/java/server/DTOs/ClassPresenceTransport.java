package server.DTOs;

import java.util.List;

public class ClassPresenceTransport {

    private String dtfiId;
    private List<StudentPresenceTransport> studentPresenceTransports;

    public ClassPresenceTransport() {}

    public ClassPresenceTransport(String dtfiId, List<StudentPresenceTransport> studentPresenceTransports) {
        this.dtfiId = dtfiId;
        this.studentPresenceTransports = studentPresenceTransports;
    }

    public String getDtfiId() {
        return dtfiId;
    }

    public void setDtfiId(String dtfiId) {
        this.dtfiId = dtfiId;
    }

    public List<StudentPresenceTransport> getStudentPresenceTransports() {
        return studentPresenceTransports;
    }

    public void setStudentPresenceTransports(List<StudentPresenceTransport> studentPresenceTransports) {
        this.studentPresenceTransports = studentPresenceTransports;
    }

}
