package server.DTOs;

import java.sql.Date;

public class DayTimeFrameInstanceTransport {

    private String id;
    private String dtfId;
    private Date date;
    private String courseId;
    private String description;

    public DayTimeFrameInstanceTransport() {

    }

    public DayTimeFrameInstanceTransport(String dtfId, Date date, String courseId, String description) {
        this.dtfId = dtfId;
        this.date = date;
        this.courseId = courseId;
        this.description = description;
    }

    public DayTimeFrameInstanceTransport(String id, String dtfId, Date date, String courseId, String description) {
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

    public String getDtfId() {
        return dtfId;
    }

    public void setDtfId(String dtfId) {
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
