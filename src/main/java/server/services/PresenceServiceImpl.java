package server.services;

import org.springframework.stereotype.Service;
import server.DTOs.*;
import server.integration.models.SerializableEmail;
import server.integration.producers.EmailProducer;
import server.mappers.StudentPresenceMapper;
import server.mappers.TeacherPresenceMapper;
import server.models.*;
import server.repositories.DayTimeFrameInstanceRepo;
import server.repositories.StudentPresenceRepo;
import server.repositories.StudentRepo;
import server.repositories.TeacherPresenceRepo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PresenceServiceImpl implements PresenceService {

    private StudentPresenceRepo studentPresenceRepo;
    private TeacherPresenceRepo teacherPresenceRepo;
    private DayTimeFrameInstanceRepo dayTimeFrameInstanceRepo;
    private StudentRepo studentRepo;
    private EmailProducer emailProducer;

    public PresenceServiceImpl(StudentPresenceRepo studentPresenceRepo, TeacherPresenceRepo teacherPresenceRepo,
                               DayTimeFrameInstanceRepo dayTimeFrameInstanceRepo, StudentRepo studentRepo, EmailProducer emailProducer) {
        this.studentPresenceRepo = studentPresenceRepo;
        this.teacherPresenceRepo = teacherPresenceRepo;
        this.dayTimeFrameInstanceRepo = dayTimeFrameInstanceRepo;
        this.studentRepo = studentRepo;
        this.emailProducer = emailProducer;
    }

    @Override
    public ClassPresenceTransport saveStudentsPresence(ClassPresenceTransport classPresence) {
        String dtfiId = classPresence.getDtfiId();
        DayTimeFrameInstance dayTimeFrameInstance = dayTimeFrameInstanceRepo.findById(dtfiId)
                .orElseThrow(() -> new NoSuchElementException("DayTimeFrame with ID: " + dtfiId + " not found!"));
        List<StudentPresenceTransport> studentPresenceTransports = classPresence.getStudentPresenceTransports();
        List<StudentPresence> studentPresences = new ArrayList<>();
        for(StudentPresenceTransport spt : studentPresenceTransports) {
            Student student = studentRepo.findById(spt.getStudentId()).orElseThrow(() ->  new NoSuchElementException("Student not found"));
            String id = UUID.randomUUID().toString();
            studentPresences.add(StudentPresenceMapper.studentPresenceTransportToStudentPresence(spt, id, student, dayTimeFrameInstance));
        }
        List<StudentPresence> savedStudentPresence = studentPresenceRepo.saveAll(studentPresences);
        notifyParentsForAbsentChildren(savedStudentPresence);
        List<StudentPresenceTransport> savedStudentsPresenceTransport = savedStudentPresence.stream()
                .map(StudentPresenceMapper::studentPresenceToStudentPresenceTransport).collect(Collectors.toList());
        return new ClassPresenceTransport(dtfiId, savedStudentsPresenceTransport);
    }

    private void notifyParentsForAbsentChildren(List<StudentPresence> studentPresenceList) {
        for(StudentPresence studentPresence : studentPresenceList) {
            if(studentPresence.getPresenceStatus().equals(PresenceStatus.ABSENT)) {
                Student student = studentPresence.getStudentId();
                String startTime = studentPresence.getDtfiId().getDtfId().getStartTime().toString();
                String endTime = studentPresence.getDtfiId().getDtfId().getEndTime().toString();
                String subject = "Student Absence Information";
                String content = "You are receiving this email because your child, " +  student.getFirstName() + " " + student.getLastName()
                        + ", was missing today for the lecture held between " + startTime + " and " + " " + endTime + ".\n\nEducation Management System";
                for(Parent parent : student.getParents()) {
                    String parentFirstName = parent.getFirstName();
                    String parentLastName = parent.getLastName();
                    content = "Dear " + parentFirstName + " " + parentLastName + ",\n\n" + content;
                    emailProducer.produce(new SerializableEmail(parent.getEmail(), subject, content));
                }
            }
        }
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
