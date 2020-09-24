package com.rba.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rba.demo.model.Book;
import com.rba.demo.model.Room;
import com.rba.demo.service.RoomService;

//@Controller
@RestController
@RequestMapping("/rooms/api")
public class RoomBookingController {

	@Autowired
	RoomService roomService;
	
	@Autowired
	Book book;
	
	//RequestHandler Methods
	//GET,POST,PUT,DELETE
	//doGet(),doPost()
	@RequestMapping(value = "/welcome",method = RequestMethod.GET)
	//@GetMapping("/welcome")
	//@PostMapping
	//@PutMapping
	//@DeleteMapping
	@ResponseBody
	//Annotation that indicates a method return value 
			//should be bound to the webresponse body
	public String welcome() {
		return "Welcome To Room Booking!";
	}
	
	@GetMapping("/allrooms")
	//@ResponseBody
	public List<Room> getAllRooms() {
		return roomService.getAllRoom();
	}
	
//	1. RequestParam
//	2. PathVariable - URITemplating Concept
//	3. Sending the complete Object DATA - RequestBody
	
//	@GetMapping("/roomid")
//	public Room findByRoomId(@RequestParam("rid") int roomId,
//				@RequestParam("rname") String roomname) {
//		
////		HttpServletRequest request;
////		
////		String id = request.getParameter("rid");
////		
////		int rid = Integer.parseInt(id);
//		
//		return roomService.findByRoomId(roomId);
//	
//	}
	
	//URITempalting - Concept
	//URITemplating Variable in your endpoint
	@GetMapping(value = "/roomid/{roomId}/{roomName}"
			,produces = {MediaType.APPLICATION_XML_VALUE})
	public Room findByRoomId(@PathVariable int roomId,
			@PathVariable String roomName) {
		
		return roomService.findByRoomId(roomId);
	
	}
	
	@GetMapping(value="/roomcapacity/{rcapacity}",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public List<Room> findByRoomCapacity(@PathVariable(value = "rcapacity") int roomCapacity){
		
		return roomService.findByRoomCapacity(roomCapacity);
	}
	
	
	@PostMapping(value= "/insertroom",consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> insertRoom(@RequestBody @Valid Room room) {
		
		return ResponseEntity.ok("Valid");
		
	}
	
	
	@GetMapping("/book")
	public void printBookDetails() {
		book.printBookName();
	}
	
}