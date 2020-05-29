package server.integration.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import server.integration.models.SerializableParentStudentConnection;
import server.services.ParentService;

@Service
public class ParentStudentConnectionConsumer {

//    private ParentService parentService;
//
//    public ParentStudentConnectionConsumer(ParentService parentService) {
//        this.parentService = parentService;
//    }
//
//    @RabbitListener(queues = {"${queue.connection.student.parent}"})
//    public void handleStudentParentConnection(SerializableParentStudentConnection connection) {
//        parentService.saveParentStudentConnection(connection.getId(), connection.getStudentId(), connection.getParentId());
//    }

}
