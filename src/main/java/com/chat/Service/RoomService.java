package com.chat.Service;

import com.chat.entities.Message;
import com.chat.entities.Room;

import java.util.List;

public interface RoomService {

    //create a new room
    Room createRoom(Room room);

    // get room by RoomId
    Room getRoomByRoomId(String roomId);

    // get all messages from a room
    List<Message> getMessageFromRoom(String roomId);
}
