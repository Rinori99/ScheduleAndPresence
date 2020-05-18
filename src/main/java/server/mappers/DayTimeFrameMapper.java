package server.mappers;

import server.DTOs.DayTimeFrameTransport;
import server.models.DayTimeFrame;

import java.util.UUID;

public class DayTimeFrameMapper {

    public static DayTimeFrame dtfTransportToDtf(DayTimeFrameTransport dtfTransport, String schoolId) {
        return new DayTimeFrame(dtfTransport.getDay(), dtfTransport.getStartTime(), dtfTransport.getEndTime(),
                dtfTransport.getType(), schoolId);
    }

    public static DayTimeFrameTransport dtfToDtfTransport(DayTimeFrame dtf) {
        return new DayTimeFrameTransport(dtf.getId(), dtf.getDay(), dtf.getStartTime(), dtf.getEndTime(), dtf.getType());
    }

}
