package com.event.attendeeservice.Controller;

import com.event.attendeeservice.Services.SendMessage;
import com.event.attendeeservice.payload.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sendMessage")
public class MessageController {
    @Autowired
    SendMessage  sendMessage;
    @PostMapping
    public ResponseEntity sendMessage(@RequestBody MessageDto messageDto){

        return ResponseEntity.ok(this.sendMessage(messageDto));
    }
}
