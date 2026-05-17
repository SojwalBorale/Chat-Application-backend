package com.chat.Service;

import com.chat.Repository.RoomRepository;
import com.chat.entities.Message;
import com.chat.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room createRoom(Room room) {
        return this.roomRepository.save(room);
    }

    @Override
    public Room getRoomByRoomId(String roomId) {
        return this.roomRepository.findByRoomId(roomId);
    }

    @Override
    public List<Message> getMessageFromRoom(String roomId) {
        Room room = this.roomRepository.findByRoomId(roomId);
        if(room != null){
            return room.getMessages();
        }
        return List.of(); // return emplty list is room not found
    }
}
