package com.event.attendeeservice.Repository;

import com.event.attendeeservice.entity.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendeeRepository extends JpaRepository<Attendee,Integer> {
}
