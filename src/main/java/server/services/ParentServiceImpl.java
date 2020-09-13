package server.services;

import org.springframework.stereotype.Service;
import server.models.Parent;
import server.models.Student;
import server.repositories.ParentRepo;
import server.repositories.StudentRepo;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ParentServiceImpl implements ParentService {

    private ParentRepo parentRepo;
    private StudentRepo studentRepo;

    public ParentServiceImpl(ParentRepo parentRepo, StudentRepo studentRepo) {
        this.parentRepo = parentRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public Parent getParentById(String id) {
        return parentRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Parent with id " + id + " not found!"));
    }

    @Override
    public void saveParent(String id, String firstName, String lastName, String email) {
        parentRepo.save(new Parent(id, firstName, lastName, email));
    }

    @Override
    public void saveParentStudentConnection(String connectionId, String studentId, String parentId) {
        Parent parent = parentRepo.findById(parentId).orElseThrow(() -> new RuntimeException("Parent not found!"));
        Student student = studentRepo.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found!"));
        List<Student> students = parent.getStudents();
        students.add(student);
        parent.setStudents(students);
        parentRepo.save(parent);
    }

}
