package com.siemens.ifa.activityplanner.api;

import com.siemens.ifa.activityplanner.InfoMessage;
import com.siemens.ifa.activityplanner.model.Appointment;
import com.siemens.ifa.activityplanner.repo.AppointmentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppointmentsController {
    @Autowired
    AppointmentsRepo appointmentsRepo;

    @RequestMapping(path = "/appointments",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity list() {
        List<Appointment> appointments = appointmentsRepo.findAll();
        if(appointments.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(appointments);
        }
    }

    @RequestMapping(path = "/appointments",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody Appointment appointment) {
        if(isValid(appointment)) {
            Appointment created = appointmentsRepo.save(appointment);
        } else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new InfoMessage("Provided appointment is invalid"));
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    private static boolean isValid(Appointment appointment) {
        return !StringUtils.isEmpty(appointment.getTopic()) &&
            !StringUtils.isEmpty(appointment.getLocation()) &&
            appointment.getStartTime() != null &&
            appointment.getEndTime() != null;
    }
}
