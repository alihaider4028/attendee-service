package com.event.attendeeservice.Repository;

import com.event.attendeeservice.entity.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganiserRepository extends JpaRepository<Organizer,Integer> {
}
