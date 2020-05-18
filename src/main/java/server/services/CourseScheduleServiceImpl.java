package server.services;

import org.springframework.stereotype.Service;
import server.DTOs.CourseScheduleTransport;
import server.DTOs.DayTimeFrameInstanceTransport;
import server.mappers.DayTimeFrameInstanceMapper;
import server.models.DayTimeFrame;
import server.models.DayTimeFrameInstance;
import server.repositories.DayTimeFrameInstanceRepo;
import server.repositories.DayTimeFrameRepo;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CourseScheduleServiceImpl implements CourseScheduleService {

    private DayTimeFrameInstanceRepo dayTimeFrameInstanceRepo;
    private DayTimeFrameRepo dayTimeFrameRepo;

    public CourseScheduleServiceImpl(DayTimeFrameInstanceRepo dayTimeFrameInstanceRepo, DayTimeFrameRepo dayTimeFrameRepo) {
        this.dayTimeFrameInstanceRepo = dayTimeFrameInstanceRepo;
        this.dayTimeFrameRepo = dayTimeFrameRepo;
    }

    @Override
    public CourseScheduleTransport saveCourseSchedule(CourseScheduleTransport courseSchedule) {
        List<DayTimeFrameInstanceTransport> dayTimeFrameInstanceTransports = courseSchedule.getDayTimeFrameInstances();
        dayTimeFrameInstanceTransports.forEach(dtfi -> dtfi.setId(UUID.randomUUID().toString()));
        List<DayTimeFrameInstanceTransport> dtfiTransports = dayTimeFrameInstanceRepo.saveAllDayTimeFrameInstances(dayTimeFrameInstanceTransports);
        return new CourseScheduleTransport(courseSchedule.getCourseId(), dtfiTransports);
    }

    @Override
    public CourseScheduleTransport changeCourseSchedule(CourseScheduleTransport courseSchedule) {
        deleteCourseSchedule(courseSchedule.getCourseId());
        return saveCourseSchedule(courseSchedule);
    }

    @Override
    public CourseScheduleTransport getCourseScheduleByCourseId(String courseId) {
        List<DayTimeFrameInstance> dayTimeFrameInstances = dayTimeFrameInstanceRepo.findByCourseId(courseId);
        List<DayTimeFrameInstanceTransport> dayTimeFrameInstanceTransports = dayTimeFrameInstances.stream()
                .map(DayTimeFrameInstanceMapper::dtfiToDtfiTransport).collect(Collectors.toList());
        return new CourseScheduleTransport(courseId, dayTimeFrameInstanceTransports);
    }

    @Override
    public void deleteCourseSchedule(String courseId) {
        dayTimeFrameInstanceRepo.deleteByCourseId(courseId);
    }

    @Override
    public DayTimeFrameInstanceTransport bookEmptyTimeSlot(String dtfId, DayTimeFrameInstanceTransport dtfiTransport) {
        DayTimeFrame dayTimeFrame = dayTimeFrameRepo.findById(dtfId).orElseThrow(
                () -> new NoSuchElementException("DayTimeFrame with ID: " + dtfId + " not found!"));
        DayTimeFrameInstance dayTimeFrameInstance = DayTimeFrameInstanceMapper.dtfiTransportToDtfi(dtfiTransport, dayTimeFrame);
        dayTimeFrameInstance.setId(UUID.randomUUID().toString());
        return DayTimeFrameInstanceMapper.dtfiToDtfiTransport(dayTimeFrameInstanceRepo.save(dayTimeFrameInstance));
    }

    @Override
    public void deleteDayTimeFrameInstanceById(String dtfiId) {
        dayTimeFrameInstanceRepo.deleteById(dtfiId);
    }

    @Override
    public DayTimeFrameInstanceTransport setDayTimeFrameInstanceDescription(String dtfiId, String description) {
        DayTimeFrameInstance dayTimeFrameInstance = dayTimeFrameInstanceRepo.findById(dtfiId)
                .orElseThrow(() -> new NoSuchElementException("DayTimeFrameInstance with ID: " + dtfiId + " not found!"));
        dayTimeFrameInstance.setDescription(description);
        return DayTimeFrameInstanceMapper.dtfiToDtfiTransport(dayTimeFrameInstanceRepo.save(dayTimeFrameInstance));
    }

}
