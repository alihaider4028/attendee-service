package com.event.attendeeservice.Controller;

;
import com.event.attendeeservice.Services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Attendee")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;
    @PostMapping("/registerAttendee/attendeeId/{attendeeId}/EventId/{eventId}")
    public ResponseEntity<?> registerAttendee(@PathVariable int attendeeId,@PathVariable int eventId){
        return ResponseEntity.ok(this.attendanceService.registerAttendee(eventId,attendeeId));
    }
    @GetMapping("/eventId/{eventId}")
    public ResponseEntity<?> getAttendeeLIst(@PathVariable("eventId") int eventId ){

        return ResponseEntity.ok(this.attendanceService.getAttendeeList(eventId));
    }
    @DeleteMapping("/eventId/{eventId}/AttendeeId/{AttendeeId}")
    public ResponseEntity<?> deleteAttendee(@PathVariable int eventId, @PathVariable int AttendeeId){
        return ResponseEntity.ok(this.attendanceService.deleteAttendee(eventId,AttendeeId));
    }

}
