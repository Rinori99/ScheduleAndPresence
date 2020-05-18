package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import server.models.DayTimeFrame;

import java.util.List;

public interface DayTimeFrameRepo extends JpaRepository<DayTimeFrame, String> {

    List<DayTimeFrame> findBySchoolId(String schoolId);

    void deleteBySchoolId(String schoolId);
}
