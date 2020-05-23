package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.models.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, String> {

}
