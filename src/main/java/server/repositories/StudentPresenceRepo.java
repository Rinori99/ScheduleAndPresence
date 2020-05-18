package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.models.StudentPresence;

import java.util.List;

@Repository
public interface StudentPresenceRepo extends JpaRepository<StudentPresence, String> {

    List<StudentPresence> findByStudentId(String studentId);

}
