package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import server.models.Parent;

public interface ParentRepo extends JpaRepository<Parent, String> {

    @Query(value = "INSERT INTO parent_student values (?1, ?2, ?3)", nativeQuery = true)
    void saveParentStudent(String id, String studentId, String parentId);

}
