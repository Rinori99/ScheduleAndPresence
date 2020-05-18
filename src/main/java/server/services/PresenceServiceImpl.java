package server.services;

import org.springframework.stereotype.Service;
import server.DTOs.*;
import server.mappers.StudentPresenceMapper;
import server.mappers.TeacherPresenceMapper;
import server.models.DayTimeFrameInstance;
import server.models.PresenceStatus;
import server.models.StudentPresence;
import server.models.TeacherPresence;
import server.repositories.DayTimeFrameInstanceRepo;
import server.repositories.StudentPresenceRepo;
import server.repositories.TeacherPresenceRepo;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PresenceServiceImpl implements PresenceService {

    private StudentPresenceRepo studentPresenceRepo;
    private TeacherPresenceRepo teacherPresenceRepo;
    private DayTimeFrameInstanceRepo dayTimeFrameInstanceRepo;

    public PresenceServiceImpl(StudentPresenceRepo studentPresenceRepo, TeacherPresenceRepo teacherPresenceRepo,
                               DayTimeFrameInstanceRepo dayTimeFrameInstanceRepo) {
        this.studentPresenceRepo = studentPresenceRepo;
        this.teacherPresenceRepo = teacherPresenceRepo;
        this.dayTimeFrameInstanceRepo = dayTimeFrameInstanceRepo;
    }

    @Override
    public ClassPresenceTransport saveStudentsPresence(ClassPresenceTransport classPresence) {
        String dtfiId = classPresence.getDtfiId();
        DayTimeFrameInstance dayTimeFrameInstance = dayTimeFrameInstanceRepo.findById(dtfiId)
                .orElseThrow(() -> new NoSuchElementException("DayTimeFrame with ID: " + dtfiId + " not found!"));
        List<StudentPresence> studentPresenceList = classPresence.getStudentPresenceTransports().stream()
                .map(spt -> StudentPresenceMapper.studentPresenceTransportToStudentPresence(spt, dayTimeFrameInstance)).collect(Collectors.toList());
        studentPresenceList.forEach(sp -> sp.setId(UUID.randomUUID().toString()));
        studentPresenceList.forEach(sp -> sp.setDtfiId(dayTimeFrameInstance));
        for(StudentPresence sp : studentPresenceList) {
            sp.setId(UUID.randomUUID().toString());
            sp.setDtfiId(dayTimeFrameInstance);
        }
        List<StudentPresenceTransport> savedStudentsPresence = studentPresenceRepo.saveAll(studentPresenceList).stream()
                .map(StudentPresenceMapper::studentPresenceToStudentPresenceTransport).collect(Collectors.toList());
        return new ClassPresenceTransport(dtfiId, savedStudentsPresence);
    }

    @Override
    public StudentPresenceTransport updateStudentPresence(String studentPresenceId, PresenceStatus presenceStatus) {
        StudentPresence studentPresence = studentPresenceRepo.findById(studentPresenceId)
                .orElseThrow(() -> new NoSuchElementException("Student Presence not found!"));
        studentPresence.setPresenceStatus(presenceStatus);
        return StudentPresenceMapper.studentPresenceToStudentPresenceTransport(studentPresenceRepo.save(studentPresence));
    }

    @Override
    public StudentPresenceReportTransport getPresenceReportByStudentId(String studentId) {
        Timestamp currentDateAndTime = new Timestamp(System.currentTimeMillis());
        List<StudentPresenceTransport> studentPresenceTransports = studentPresenceRepo.findByStudentId(studentId).stream()
                .map(StudentPresenceMapper::studentPresenceToStudentPresenceTransport).collect(Collectors.toList());
        return new StudentPresenceReportTransport(studentPresenceTransports, currentDateAndTime);
    }

    @Override
    public TeacherPresenceTransport saveTeacherPresence(TeacherPresenceTransport teacherPresenceTransport) {
        DayTimeFrameInstance dayTimeFrameInstance = dayTimeFrameInstanceRepo.findById(teacherPresenceTransport.getDtfiId())
                .orElseThrow(() -> new NoSuchElementException("DayTimeFrame with ID: " + teacherPresenceTransport.getDtfiId() + " not found!"));
        TeacherPresence teacherPresence = TeacherPresenceMapper.teacherPresenceTransportToTeacherPresence(teacherPresenceTransport, dayTimeFrameInstance);
        teacherPresence.setId(UUID.randomUUID().toString());
        return TeacherPresenceMapper.teacherPresenceToTeacherPresenceTransport(teacherPresenceRepo.save(teacherPresence));
    }

    @Override
    public TeacherPresenceReportTransport getPresenceReportByTeacherId(String teacherId) {
        Timestamp currentDateAndTime = new Timestamp(System.currentTimeMillis());
        List<TeacherPresenceTransport> teacherPresenceTransports = teacherPresenceRepo.findByTeacherId(teacherId).stream()
                .map(TeacherPresenceMapper::teacherPresenceToTeacherPresenceTransport).collect(Collectors.toList());
        return new TeacherPresenceReportTransport(teacherPresenceTransports, currentDateAndTime);
    }

}
