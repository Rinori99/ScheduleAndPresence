package server.services;

import org.springframework.stereotype.Service;
import server.models.DayTimeFrameInstance;
import server.repositories.DayTimeFrameInstanceRepo;

@Service
public class DayTimeFrameInstanceService {

    private DayTimeFrameInstanceRepo dayTimeFrameInstanceRepo;

    public DayTimeFrameInstanceService(DayTimeFrameInstanceRepo dayTimeFrameInstanceRepo) {
        this.dayTimeFrameInstanceRepo = dayTimeFrameInstanceRepo;
    }

    public DayTimeFrameInstance findDayTimeFrameInstanceById(String id) {
        return dayTimeFrameInstanceRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("DayTimeFrameInstance not found!"));
    }

}
