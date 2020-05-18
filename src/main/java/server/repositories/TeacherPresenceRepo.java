package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.models.TeacherPresence;

import java.util.List;

@Repository
public interface TeacherPresenceRepo extends JpaRepository<TeacherPresence, String> {

    List<TeacherPresence> findByTeacherId(String teacherId);

}
