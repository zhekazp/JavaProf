package org.task2;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class TimeService {
    public String  getCurrentTime(){
        return LocalTime.now().toString();
    }
}
