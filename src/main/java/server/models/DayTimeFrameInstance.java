package server.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "day_time_frame_instance")
public class DayTimeFrameInstance {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dtf_id")
    private DayTimeFrame dtfId;

    @Column(name = "date")
    private Date date;

    @Column(name = "course_id")
    private String courseId;

    @Column(name = "description")
    private String description;

    public DayTimeFrameInstance() {

    }

    public DayTimeFrameInstance(DayTimeFrame dtfId, Date date, String courseId, String description) {
        this.dtfId = dtfId;
        this.date = date;
        this.courseId = courseId;
        this.description = description;
    }

    public DayTimeFrameInstance(String id, DayTimeFrame dtfId, Date date, String courseId, String description) {
        this.id = id;
        this.dtfId = dtfId;
        this.date = date;
        this.courseId = courseId;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DayTimeFrame getDtfId() {
        return dtfId;
    }

    public void setDtfId(DayTimeFrame dtfId) {
        this.dtfId = dtfId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
