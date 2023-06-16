package com.event.attendeeservice.Repository;

import com.event.attendeeservice.entity.FeedbackForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FeedbackFormRepository extends JpaRepository<FeedbackForm,Integer> {
    @Query("SELECT f FROM FeedbackForm f WHERE f.feedback.attendeeId.userId = :attendeeId AND f.eventId.eventId = :eventId")
    FeedbackForm findFeedbackByEventIdAndAndAttendeeId(int attendeeId, int eventId);

}
