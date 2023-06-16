package com.event.attendeeservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    int Id;
    @ManyToOne
    Organizer organizer;
    @ManyToOne
    Event event;
    String content;
}
