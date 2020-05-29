package server.models;

import javax.persistence.*;

@Entity
@Table(name = "student_presence")
public class StudentPresence {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student studentId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dtfi_id")
    private DayTimeFrameInstance dtfiId;

    @Column(name = "presence_status")
    private String presenceStatus;

    public StudentPresence() {

    }

    public StudentPresence(Student studentId, DayTimeFrameInstance dtfiId, String presenceStatus) {
        this.studentId = studentId;
        this.dtfiId = dtfiId;
        this.presenceStatus = presenceStatus;
    }

    public StudentPresence(String id, Student studentId, DayTimeFrameInstance dtfiId, String presenceStatus) {
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

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    public DayTimeFrameInstance getDtfiId() {
        return dtfiId;
    }

    public void setDtfiId(DayTimeFrameInstance dtfiId) {
        this.dtfiId = dtfiId;
    }

    public String getPresenceStatus() {
        return presenceStatus;
    }

    public void setPresenceStatus(String presenceStatus) {
        this.presenceStatus = presenceStatus;
    }

}
