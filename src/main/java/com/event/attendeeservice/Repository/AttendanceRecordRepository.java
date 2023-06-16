package com.event.attendeeservice.Repository;

import com.event.attendeeservice.entity.AttendanceRecord;
import com.event.attendeeservice.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AttendanceRecordRepository extends JpaRepository<AttendanceRecord,Integer> {
    @Query("select a from AttendanceRecord a where a.attendeeId.userId=:attendeeId and a.eventId.eventId=:eventId ")

    public Optional <AttendanceRecord> findByAttendeeIdAndEventId(int attendeeId, int eventId);

    public Optional<List<AttendanceRecord>> findAllByEventId(Event event);
}
