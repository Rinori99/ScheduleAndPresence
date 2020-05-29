package server.repositories;

import org.hibernate.annotations.SQLUpdate;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import server.models.DayTimeFrame;

import java.util.List;

@Repository
public interface DayTimeFrameRepo extends JpaRepository<DayTimeFrame, String> {

    List<DayTimeFrame> findBySchoolId(String schoolId);

    @Modifying
    @Query(value = "DELETE FROM day_time_frame WHERE school_id = ?1", nativeQuery = true)
    void deleteBySchoolId(String schoolId);

}
