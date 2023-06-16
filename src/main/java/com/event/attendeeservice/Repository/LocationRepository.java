package com.event.attendeeservice.Repository;

import com.event.attendeeservice.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Integer> {
}
