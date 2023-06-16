package com.event.attendeeservice.payload;

import com.event.attendeeservice.entity.Event;
import com.event.attendeeservice.entity.Organizer;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
    int Id;
    int organizerId;

    int eventID;
    String content;
}
