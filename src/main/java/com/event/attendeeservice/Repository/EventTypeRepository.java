package com.event.attendeeservice.Repository;

import com.event.attendeeservice.entity.EventType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventTypeRepository extends JpaRepository<EventType,Integer> {
}
