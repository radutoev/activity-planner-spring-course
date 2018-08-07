package com.siemens.ifa.activityplanner.api;

import com.siemens.ifa.activityplanner.model.Appointment;
import com.siemens.ifa.activityplanner.repo.AppointmentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppointmentsController {
    @Autowired
    AppointmentsRepo appointmentsRepo;

    @RequestMapping(path = "/appointments", method = RequestMethod.GET)
    public ResponseEntity list() {
        List<Appointment> appointments = appointmentsRepo.findAll();
        if(appointments.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(appointments);
        }
    }
}
