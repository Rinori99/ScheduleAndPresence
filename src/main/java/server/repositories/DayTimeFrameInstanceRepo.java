package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import server.DTOs.DayTimeFrameInstanceTransport;
import server.models.DayTimeFrameInstance;

import java.util.List;

@Repository
public interface DayTimeFrameInstanceRepo extends JpaRepository<DayTimeFrameInstance, String> {

    List<DayTimeFrameInstance> findByCourseId(String courseId);

    @Modifying
    @Query(value = "DELETE FROM day_time_frame_instance WHERE course_id = ?1", nativeQuery = true)
    void deleteByCourseId(String courseId);

}
