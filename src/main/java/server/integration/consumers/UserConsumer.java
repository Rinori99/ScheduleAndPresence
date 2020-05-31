package server.integration.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import server.integration.models.SerializableParent;
import server.integration.models.SerializableStudent;
import server.services.ParentService;
import server.services.StudentService;

@Service
public class UserConsumer {

    private StudentService studentService;
    private ParentService parentService;

    public UserConsumer(StudentService studentService, ParentService parentService) {
        this.studentService = studentService;
        this.parentService = parentService;
    }

    @RabbitListener(queues = {"${queue.user.new.student}"})
    public void handleNewUserReception(SerializableStudent student) {
        studentService.saveStudent(student.getId(), student.getFirstName(), student.getLastName());
    }

    @RabbitListener(queues = {"${queue.user.new.parent}"})
    public void handleNewUserReception(SerializableParent parent) {
        parentService.saveParent(parent.getId(), parent.getFirstName(), parent.getLastName(), parent.getEmail());
    }

}
