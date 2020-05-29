package server.services;

import org.springframework.stereotype.Service;
import server.models.DayTimeFrame;
import server.repositories.DayTimeFrameRepo;

import java.util.NoSuchElementException;

@Service
public class DayTimeFrameService implements BaseService<DayTimeFrame, String> {

    private DayTimeFrameRepo dayTimeFrameRepo;

    public DayTimeFrameService(DayTimeFrameRepo dayTimeFrameRepo) {
        this.dayTimeFrameRepo = dayTimeFrameRepo;
    }

    @Override
    public DayTimeFrame create(DayTimeFrame dayTimeFrame) {
        return dayTimeFrameRepo.save(dayTimeFrame);
    }

    @Override
    public DayTimeFrame findById(String id) {
        return dayTimeFrameRepo.findById(id).orElseThrow(() -> new NoSuchElementException("DayTimeFrame not found"));
    }

}
