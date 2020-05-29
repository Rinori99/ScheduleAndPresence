package server.services;

import org.springframework.stereotype.Service;
import server.DTOs.CourseScheduleTransport;
import server.DTOs.DayTimeFrameInstanceTransport;
import server.DTOs.DayTimeFrameTransport;
import server.DTOs.DtfIDescriptionTransport;
import server.mappers.DayTimeFrameInstanceMapper;
import server.models.DayTimeFrame;
import server.models.DayTimeFrameInstance;
import server.repositories.DayTimeFrameInstanceRepo;
import server.repositories.DayTimeFrameRepo;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CourseScheduleServiceImpl implements CourseScheduleService {

    private DayTimeFrameInstanceRepo dayTimeFrameInstanceRepo;
    private DayTimeFrameService dayTimeFrameService;

    public CourseScheduleServiceImpl(DayTimeFrameInstanceRepo dayTimeFrameInstanceRepo, DayTimeFrameService dayTimeFrameService) {
        this.dayTimeFrameInstanceRepo = dayTimeFrameInstanceRepo;
        this.dayTimeFrameService = dayTimeFrameService;
    }

    @Override
    public CourseScheduleTransport saveCourseSchedule(CourseScheduleTransport courseSchedule) {
        List<DayTimeFrameInstanceTransport> dayTimeFrameInstanceTransports = courseSchedule.getDayTimeFrameInstances();
        dayTimeFrameInstanceTransports.forEach(dtfi -> dtfi.setId(UUID.randomUUID().toString()));
        dayTimeFrameInstanceTransports.forEach(dtfi -> dtfi.setCourseId(courseSchedule.getCourseId()));
        List<DayTimeFrameInstance> dayTimeFrameInstances = new ArrayList<>();
        for(DayTimeFrameInstanceTransport dayTimeFrameInstanceTransport : dayTimeFrameInstanceTransports) {
            DayTimeFrame dayTimeFrame = dayTimeFrameService.findById(dayTimeFrameInstanceTransport.getDtfId());
            dayTimeFrameInstances.add(DayTimeFrameInstanceMapper.dtfiTransportToDtfi(dayTimeFrameInstanceTransport, dayTimeFrame));
        }
        List<DayTimeFrameInstanceTransport> savedDtfiTransports = dayTimeFrameInstanceRepo.saveAll(dayTimeFrameInstances)
                .stream().map(DayTimeFrameInstanceMapper::dtfiToDtfiTransport).collect(Collectors.toList());
        return new CourseScheduleTransport(courseSchedule.getCourseId(), savedDtfiTransports);
    }

    @Transactional
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

    @Transactional
    @Override
    public void deleteCourseSchedule(String courseId) {
        dayTimeFrameInstanceRepo.deleteByCourseId(courseId);
    }

    @Override
    public DayTimeFrameInstanceTransport bookEmptyTimeSlot(String dtfId, DayTimeFrameInstanceTransport dtfiTransport) {
        DayTimeFrame dayTimeFrame = dayTimeFrameService.findById(dtfId);
        DayTimeFrameInstance dayTimeFrameInstance = DayTimeFrameInstanceMapper.dtfiTransportToDtfi(dtfiTransport, dayTimeFrame);
        dayTimeFrameInstance.setId(UUID.randomUUID().toString());
        return DayTimeFrameInstanceMapper.dtfiToDtfiTransport(dayTimeFrameInstanceRepo.save(dayTimeFrameInstance));
    }

    @Override
    public void deleteDayTimeFrameInstanceById(String dtfiId) {
        dayTimeFrameInstanceRepo.deleteById(dtfiId);
    }

    @Override
    public DayTimeFrameInstanceTransport setDayTimeFrameInstanceDescription(DtfIDescriptionTransport descriptionTransport) {
        DayTimeFrameInstance dayTimeFrameInstance = dayTimeFrameInstanceRepo.findById(descriptionTransport.getDtfiId())
                .orElseThrow(() -> new NoSuchElementException("DayTimeFrameInstance not found!"));
        dayTimeFrameInstance.setDescription(descriptionTransport.getDescription());
        return DayTimeFrameInstanceMapper.dtfiToDtfiTransport(dayTimeFrameInstanceRepo.save(dayTimeFrameInstance));
    }

}
