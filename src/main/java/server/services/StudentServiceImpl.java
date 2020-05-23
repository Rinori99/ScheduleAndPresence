package server.services;

import org.springframework.stereotype.Service;
import server.models.Student;
import server.repositories.StudentRepo;

import java.util.NoSuchElementException;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Student getStudentById(String id) {
        return studentRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Student with id: " + id + " not found!"));
    }

    @Override
    public void saveStudent(String id, String firstName, String lastName) {
        studentRepo.save(new Student(id, firstName, lastName));
    }

}
