package server.services;

import org.springframework.stereotype.Service;
import server.models.Parent;
import server.repositories.ParentRepo;

import java.util.NoSuchElementException;

@Service
public class ParentServiceImpl implements ParentService {

    private ParentRepo parentRepo;

    public ParentServiceImpl(ParentRepo parentRepo) {
        this.parentRepo = parentRepo;
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
        parentRepo.saveParentStudent(connectionId, studentId, parentId);
    }

}
