package server.mappers;

import server.DTOs.DayTimeFrameInstanceTransport;
import server.models.DayTimeFrame;
import server.models.DayTimeFrameInstance;

import java.util.UUID;

public class DayTimeFrameInstanceMapper {

    public static DayTimeFrameInstance dtfiTransportToDtfi(DayTimeFrameInstanceTransport dtfiTransport, DayTimeFrame dayTimeFrame) {
        return new DayTimeFrameInstance(dayTimeFrame, dtfiTransport.getDate(), dtfiTransport.getCourseId(), dtfiTransport.getDescription());
    }

    public static DayTimeFrameInstanceTransport dtfiToDtfiTransport(DayTimeFrameInstance dtfi) {
        return new DayTimeFrameInstanceTransport(dtfi.getId(), dtfi.getDtfId().getId(), dtfi.getDate(), dtfi.getCourseId(), dtfi.getDescription());
    }

}
