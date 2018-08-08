package com.siemens.ifa.activityplanner.service;

import com.siemens.ifa.activityplanner.model.Appointment;
import com.siemens.ifa.activityplanner.repo.AppointmentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

//for dep injection
//a.k.a controller din MVC

@Service
public class AppointmentsService {
    @Autowired
    AppointmentsRepo appointmentsRepo;

    public Optional<Appointment> find(Integer id) {
        Appointment a = appointmentsRepo.findOne(id);
        return (a != null) ? Optional.of(a) : Optional.empty();
    }
}
