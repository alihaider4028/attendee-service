package com.event.attendeeservice.Repository;

import com.event.attendeeservice.entity.Message;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer>{



}
