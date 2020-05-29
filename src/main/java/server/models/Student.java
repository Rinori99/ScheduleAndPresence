package server.models;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "parent_student",
               joinColumns = { @JoinColumn(name = "student_id") },
               inverseJoinColumns = { @JoinColumn(name = "parent_id") })
    private List<Parent> parents;

    @OneToMany(mappedBy = "studentId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<StudentPresence> studentPresences;

    public Student() {

    }

    public Student(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Parent> getParents() {
        return parents;
    }

}
