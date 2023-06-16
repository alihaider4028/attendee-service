package com.event.attendeeservice.Repository;

import com.event.attendeeservice.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
    @Query("SELECT f FROM Feedback f WHERE f.attendeeId.userId = :attendeeId AND f.eventId.eventId = :eventId")
    List<Feedback> findByAttendeeIdAndEventId(int attendeeId, int eventId);

    @Query("SELECT f FROM Feedback f WHERE f.eventId.eventId = :eventId")
    List<Feedback> findAllByEventId(int eventId);

    @Query("SELECT f FROM Feedback f WHERE f.attendeeId.userId = :attendeeId AND f.eventId.eventId = :eventId")
    Feedback findFeedbackByEventIdAndAndAttendeeId(int attendeeId, int eventId);

}
