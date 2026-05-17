package com.chat.Controller;

import com.chat.Repository.RoomRepository;
import com.chat.entities.Message;
import com.chat.entities.Room;
import com.chat.payload.MessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.UUID;

@Controller
@CrossOrigin(origins = "http://localhost:5173")
public class ChatController {

    @Autowired
    private RoomRepository roomRepository;
    
    @Autowired
    private MongoTemplate mongoTemplate;

    public ChatController(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    // for sending and receiving message
    @MessageMapping("/sendMessage/{roomId}") ///app/chat/sendMessage/roomId
    @SendTo("/topic/room/{roomId}") // subscribe
    public Message sendMessage(
            @DestinationVariable String roomId,
            @RequestBody MessageRequest request
    ) throws Exception {
        Room room = this.roomRepository.findByRoomId(request.getRoomId());
        Message message = new Message();
        message.setId(UUID.randomUUID().toString());
        message.setContent(request.getContent());
        message.setSender(request.getSender());
        message.setTimeStamp(LocalDateTime.now());


        if(room != null){
            room.getMessages().add(message);
            this.roomRepository.save(room);
        }else{
            throw new RuntimeException("room not found !!");
        }

        return message;
    }
}
