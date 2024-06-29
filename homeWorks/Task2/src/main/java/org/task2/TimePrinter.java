package org.task2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TimePrinter {
    TimeService timeService;

    @Autowired
    public TimePrinter(TimeService timeService) {
        this.timeService = timeService;
    }
    public void printTime() {
        System.out.println(timeService.getCurrentTime());
    }
}
