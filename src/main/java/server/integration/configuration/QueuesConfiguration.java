package server.integration.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueuesConfiguration {

    @Value("${queue.user.new.student}")
    private String newStudentsQueueName;

    @Value("${queue.user.new.parent}")
    private String newParentsQueueName;

    @Value("${routing.connection.student.parent}")
    private String studentParentConnectionQueueName;

    @Bean(name = "newStudentsQueue")
    public Queue newStudentsQueue() {
        return new Queue(newStudentsQueueName);
    }

    @Bean(name = "newParentsQueue")
    public Queue newParentsQueue() {
        return new Queue(newParentsQueueName);
    }

    @Bean(name = "parentStudentConnectionQueue")
    public Queue parentStudentConnectionQueue() {
        return new Queue(studentParentConnectionQueueName);
    }

}
