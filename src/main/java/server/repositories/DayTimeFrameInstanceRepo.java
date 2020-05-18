package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import server.DTOs.DayTimeFrameInstanceTransport;
import server.models.DayTimeFrameInstance;

import java.util.List;

@Repository
public interface DayTimeFrameInstanceRepo extends JpaRepository<DayTimeFrameInstance, String> {

    @Query(value = "INSERT INTO day_time_frame_instance values ?1", nativeQuery = true)
    List<DayTimeFrameInstanceTransport> saveAllDayTimeFrameInstances(List<DayTimeFrameInstanceTransport> dayTimeFrameInstanceTransports);

    List<DayTimeFrameInstance> findByCourseId(String courseId);

    void deleteByCourseId(String courseId);
}
