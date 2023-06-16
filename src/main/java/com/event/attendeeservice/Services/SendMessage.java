package com.event.attendeeservice.Services;

import com.event.attendeeservice.Response.ApiResponse;
import com.event.attendeeservice.payload.MessageDto;

public interface SendMessage {

    ApiResponse<?> messageSend(MessageDto message);
}
