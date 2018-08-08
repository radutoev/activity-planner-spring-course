package com.siemens.ifa.activityplanner.api;

import com.siemens.ifa.activityplanner.InfoMessage;
import com.siemens.ifa.activityplanner.model.Appointment;
import com.siemens.ifa.activityplanner.repo.AppointmentsRepo;
import com.siemens.ifa.activityplanner.service.AppointmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class AppointmentsController {
    @Autowired
    AppointmentsRepo appointmentsRepo;

    @Autowired
    AppointmentsService appointmentsService;

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
            //ACID (atomicity, consistency, integrity, durability)
            Appointment created = appointmentsRepo.save(appointment);
            //
            return ResponseEntity
                    .created(URI.create("http://localhost:8081/appointments/" + created.getId()))
                    .body(created);
        } else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new InfoMessage("Provided appointment is invalid"));
        }
    }

    @RequestMapping(path = "/appointments/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity get(@PathVariable("id") Integer id) {
        Optional<Appointment> maybeApp = appointmentsService.find(id);

        if(maybeApp.isPresent()) {
            return ResponseEntity.ok(maybeApp);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    private static boolean isValid(Appointment appointment) {
        return !StringUtils.isEmpty(appointment.getTopic()) &&
            !StringUtils.isEmpty(appointment.getLocation()) &&
            appointment.getStartTime() != null &&
            appointment.getEndTime() != null;
    }
}
