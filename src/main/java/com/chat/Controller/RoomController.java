package com.chat.Controller;



import com.chat.Service.RoomServiceImpl;
import com.chat.entities.Message;
import com.chat.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/rooms")
@CrossOrigin(origins = "http://localhost:5173")
public class RoomController {

    @Autowired
    private RoomServiceImpl roomServiceimpl;

    // create room
    @PostMapping
    public ResponseEntity<?> createRoom(@RequestBody String roomId ){

        if(this.roomServiceimpl.getRoomByRoomId(roomId) != null){
            // room is already there
            return ResponseEntity.badRequest().body("room already exists!");
        }

        //create new room
        Room room = new Room();
        room.setRoomId(roomId);
        Room savedRoom = this.roomServiceimpl.createRoom(room);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRoom);
    }
    //get room: join
    @GetMapping("/{roomId}")
    public ResponseEntity<?> joinRoom(@PathVariable  String roomId){
        Room room = this.roomServiceimpl.getRoomByRoomId(roomId);
        if(room == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room not found!");
        }
        return ResponseEntity.ok(room);
    }
    //get message from room
    @GetMapping("/{roomId}/messages")
    public ResponseEntity<List<Message>> getMessage(@PathVariable String roomId,
                                                    @RequestParam(value="page",defaultValue = "0", required = false) int page,
                                                    @RequestParam(value="size",defaultValue = "20",required = false)int size)
    {

        Room room = this.roomServiceimpl.getRoomByRoomId(roomId);
        if(room == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        //get messages:
        //pagination
        List<Message> messages = room.getMessages();
        int start = Math.max(0,messages.size()-(page+1)*size);
        int end = Math.min(messages.size(),start+size);

        List<Message> paginatedMessages = messages.subList(start, end);
        return ResponseEntity.ok(paginatedMessages);
    }
}
