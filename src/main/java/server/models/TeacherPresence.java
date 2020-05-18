package server.models;

import javax.persistence.*;

@Entity
@Table(name = "teacher_presence")
public class TeacherPresence {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "teacher_id")
    private String teacherId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dtfi_id")
    private DayTimeFrameInstance dtfiId;

    @Column(name = "held")
    private boolean held;

    public TeacherPresence() {

    }

    public TeacherPresence(String teacherId, DayTimeFrameInstance dtfiId, boolean held) {
        this.teacherId = teacherId;
        this.dtfiId = dtfiId;
        this.held = held;
    }

    public TeacherPresence(String id, String teacherId, DayTimeFrameInstance dtfiId, boolean held) {
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

    public DayTimeFrameInstance getDtfiId() {
        return dtfiId;
    }

    public void setDtfiId(DayTimeFrameInstance dtfiId) {
        this.dtfiId = dtfiId;
    }

    public boolean isHeld() {
        return held;
    }

    public void setHeld(boolean held) {
        this.held = held;
    }

}
