package com.event.attendeeservice.Services.impl;

import com.event.attendeeservice.Repository.AttendanceRecordRepository;
import com.event.attendeeservice.Repository.AttendeeRepository;
import com.event.attendeeservice.Repository.EventRepository;
import com.event.attendeeservice.Response.ApiResponse;
import com.event.attendeeservice.Services.AttendanceService;
import com.event.attendeeservice.entity.AttendanceRecord;
import com.event.attendeeservice.entity.Attendee;
import com.event.attendeeservice.entity.Event;
import com.event.attendeeservice.exception.resourceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceRecordRepository attendanceRecordRepository;
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private AttendeeRepository attendeeRepository;

    @Override
    public ApiResponse<?> registerAttendee(int eventId, int attendeeId) throws resourceException {
        ApiResponse resp = new ApiResponse<>(HttpStatus.CREATED.value(), "attendee  registered ", attendeeId);
            if(this.attendanceRecordRepository.findByAttendeeIdAndEventId(attendeeId,eventId).isPresent()){
                throw    new resourceException("attendee with attendee id:"+attendeeId," already registered with event id:"+eventId);
            }

        Attendee attendee = this.attendeeRepository.findById(attendeeId).orElseThrow(() -> new resourceException("attendee", "attendee id", attendeeId));
        this.eventRepository.findById(eventId).ifPresentOrElse(event -> {
                    List list = this.attendanceRecordRepository.findAllByEventId(event).get();

                    if (event.getCapacity() > list.size()) {

                        AttendanceRecord attendanceRecord = new AttendanceRecord();
                        attendanceRecord.setAttendeeId(attendee);
                        attendanceRecord.setEventId(event);
                        this.attendanceRecordRepository.save(attendanceRecord);
                    } else {
                        throw new resourceException("capacity exceeded in event with", "event id:"+eventId);
                    }

                },
                () -> {
                    throw new resourceException("event", "event id", eventId);
                }
        );

        return resp;
    }

    @Override
    public ApiResponse<?> getAttendeeList(int eventId) {
        Event event =this.eventRepository.findById(eventId).orElseThrow( ()-> new resourceException("event", "event id", eventId));
        if(this.attendanceRecordRepository.findAllByEventId(event).get().isEmpty()){
            throw  new resourceException("no record found with event id: "+eventId, "register with any attendee" );
        }

        return new ApiResponse<>(HttpStatus.OK.value(), "Event found in Attendee List",this.attendanceRecordRepository.findAllByEventId(event));
    }

    @Override
    public ApiResponse<?> deleteAttendee(int eventId, int attendeeId) {
        AttendanceRecord attendanceRecord = this.attendanceRecordRepository.findByAttendeeIdAndEventId(attendeeId,eventId).orElseThrow(
                ()->  new     resourceException("","with following Attendee Id:"+attendeeId+" and eventId:"+eventId));
        this.attendanceRecordRepository.delete(attendanceRecord);

        return new ApiResponse<>(HttpStatus.OK.value(), "attendee deleted",attendeeId);
    }


}
