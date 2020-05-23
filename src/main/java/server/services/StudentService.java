package server.services;

import server.models.Student;

public interface StudentService {

    Student getStudentById(String id);

    void saveStudent(String id, String firstName, String lastName);

}
