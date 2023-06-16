package com.event.attendeeservice.Services;

import com.event.attendeeservice.Response.ApiResponse;
import com.event.attendeeservice.entity.Attendee;
import com.event.attendeeservice.exception.resourceException;

public interface AttendanceService {
    ApiResponse<?> registerAttendee(int eventId,int attendeeId) throws resourceException;
    ApiResponse<?> getAttendeeList(int eventId);
    ApiResponse<?> deleteAttendee(int eventId,int attendeeId);




}
