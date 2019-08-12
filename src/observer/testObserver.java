package observer;

import org.junit.jupiter.api.Test;

public class testObserver {
    @Test
    public void testObserverConference(){
        Conference newConference = new Conference();
        //两个observer的实例化
        MonitorConferenceAttendees conferenceAttendeesPrint = new MonitorConferenceAttendees(newConference);
        CalculateSpeakers calculateSpeakers = new CalculateSpeakers(newConference);

        newConference.setConferenceDetails(20,10,"AllThingsOpen");
    }
}
