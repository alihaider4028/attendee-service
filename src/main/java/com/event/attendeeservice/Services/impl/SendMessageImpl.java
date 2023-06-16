package com.event.attendeeservice.Services.impl;

import com.event.attendeeservice.Repository.EventRepository;
import com.event.attendeeservice.Repository.MessageRepository;
import com.event.attendeeservice.Repository.OrganiserRepository;
import com.event.attendeeservice.Response.ApiResponse;
import com.event.attendeeservice.Services.SendMessage;
import com.event.attendeeservice.entity.Event;
import com.event.attendeeservice.entity.Message;
import com.event.attendeeservice.entity.Organizer;
import com.event.attendeeservice.exception.resourceException;
import com.event.attendeeservice.payload.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class SendMessageImpl implements SendMessage {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    OrganiserRepository  organiserRepository;
    @Autowired
    MessageRepository messageRepository;

    @Override
    public ApiResponse<?> messageSend(MessageDto messageDto) {
      Event event = this.eventRepository.findById(messageDto.getEventID()).orElseThrow(()-> new resourceException("event","eventId:",messageDto.getEventID()));
        Organizer organizer= this.organiserRepository.findById(messageDto.getOrganizerId()).orElseThrow(()-> new resourceException("Organiser","OrganiserId:",messageDto.getOrganizerId()));
      Message message= new Message();
      message.setContent(messageDto.getContent());
      message.setEvent(event);
      message.setOrganizer(organizer);
      this.messageRepository.save(message);
        return new ApiResponse<>(HttpStatus.OK.value(), "message sent",message);
    }
}
