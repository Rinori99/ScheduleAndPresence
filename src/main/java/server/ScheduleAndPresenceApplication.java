package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ScheduleAndPresenceApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ScheduleAndPresenceApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ScheduleAndPresenceApplication.class, args);
    }

}

// course (file upload)
// school
// calendar
// meetings
// notifications (some pushing tech)
// performance (from the beginning)

// -------------------------------------------------------

// make the config app and test if things still work
// look at the file upload
// make the existing apps completely communicative
// get the other apps and look at their current state
// look for the web socket notifications
// double check if functionality is being fulfilled
// implement performance

// integrate all apps together
// fix what is left
// make server side validation
// make endpoints authorization

// work on documents
// help in front end
// look for docker
// look for deployment

// -------------------------------------------------------

// WORK on connecting to front end.
