package com.siemens.ifa.activityplanner.repo;

import com.siemens.ifa.activityplanner.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * crud = create/read/update/delete
 */
public interface AppointmentsRepo
        extends JpaRepository<Appointment, Integer> {
}
