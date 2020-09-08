package server.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.DTOs.DayTimeFrameInstanceTransport;
import server.mappers.DayTimeFrameInstanceMapper;
import server.services.DayTimeFrameInstanceService;

@RestController
@RequestMapping("dtfi")
public class DayTimeFrameInstanceController {

    private DayTimeFrameInstanceService dayTimeFrameInstanceService;

    public DayTimeFrameInstanceController(DayTimeFrameInstanceService dayTimeFrameInstanceService) {
        this.dayTimeFrameInstanceService = dayTimeFrameInstanceService;
    }

    @GetMapping("{id}")
    public DayTimeFrameInstanceTransport getDayTimeFrameInstanceById(@PathVariable String id) {
        return DayTimeFrameInstanceMapper.dtfiToDtfiTransport(dayTimeFrameInstanceService.findDayTimeFrameInstanceById(id));
    }

}
