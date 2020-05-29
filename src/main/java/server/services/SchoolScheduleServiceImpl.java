package server.services;

import org.springframework.stereotype.Service;
import server.DTOs.DayTimeFrameTransport;
import server.DTOs.SchoolScheduleTransport;
import server.mappers.DayTimeFrameMapper;
import server.models.DayTimeFrame;
import server.repositories.DayTimeFrameRepo;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SchoolScheduleServiceImpl implements SchoolScheduleService {

    private DayTimeFrameRepo dayTimeFrameRepo;

    public SchoolScheduleServiceImpl(DayTimeFrameRepo dayTimeFrameRepo) {
        this.dayTimeFrameRepo = dayTimeFrameRepo;
    }

    @Override
    public SchoolScheduleTransport getSchoolScheduleBySchoolId(String schoolId) {
        List<DayTimeFrameTransport> dayTimeFrameTransports = dayTimeFrameRepo.findBySchoolId(schoolId).stream()
                .map(DayTimeFrameMapper::dtfToDtfTransport).collect(Collectors.toList());
        return new SchoolScheduleTransport(schoolId, dayTimeFrameTransports);
    }

    @Transactional
    @Override
    public SchoolScheduleTransport changeSchoolSchedule(SchoolScheduleTransport schoolSchedule) {
        String schoolId = schoolSchedule.getSchoolId();
        deleteSchoolScheduleBySchoolId(schoolId);
        return saveSchoolSchedule(schoolSchedule);
    }

    @Override
    public SchoolScheduleTransport saveSchoolSchedule(SchoolScheduleTransport schoolSchedule) {
        String schoolId = schoolSchedule.getSchoolId();
        List<DayTimeFrame> dayTimeFrames = schoolSchedule.getDayTimeFrames().stream()
                .map(dtfTransport -> DayTimeFrameMapper.dtfTransportToDtf(dtfTransport, schoolId)).collect(Collectors.toList());
        dayTimeFrames.forEach(dtf -> dtf.setId(UUID.randomUUID().toString()));
        List<DayTimeFrameTransport> savedDayTimeFrameTransports = dayTimeFrameRepo.saveAll(dayTimeFrames)
                .stream().map(DayTimeFrameMapper::dtfToDtfTransport).collect(Collectors.toList());
        return new SchoolScheduleTransport(schoolId, savedDayTimeFrameTransports);
    }

    @Transactional
    @Override
    public void deleteSchoolScheduleBySchoolId(String schoolId) {
        dayTimeFrameRepo.deleteBySchoolId(schoolId);
    }

}
