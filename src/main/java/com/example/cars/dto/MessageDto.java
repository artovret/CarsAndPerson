package com.example.cars.dto;

import com.example.cars.model.Message;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageDto {
    private String message;


    public static MessageDto fromMessage(Message message){
        MessageDto messageDto = new MessageDto();
        messageDto.setMessage(message.getMessage());
        return messageDto;
    }
}
