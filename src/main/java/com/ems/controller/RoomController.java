package com.ems.controller;

import com.ems.entity.Room;
import com.ems.mapper.RoomMapper;
import com.ems.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/roomController")
public class RoomController {

    @Autowired
    private RoomService roomservice;

    @Autowired
    private RoomMapper roommapper;

    @RequestMapping(value ="/roomList")
    public String roomList(HttpServletRequest req,HttpServletResponse resp,Model model){
        if (req.getParameter("position")!= null && !req.getParameter("position").trim().equals("")){
            List<Room> Room = roomservice.queryRoomByPosition(req.getParameter("position"));
            model.addAttribute("Room",Room);
            return "view/room/roomMgmt";
    }
        else {List<Room> Room = roomservice.queryAllRoom();
            model.addAttribute("Room",Room);
            return "view/room/roomMgmt";
        }
    }

    @RequestMapping(value = "/removeRoom")
    public String removeRoom(HttpServletRequest req, HttpServletResponse resp){
        Room record = new Room();
        record.setrId(Integer.parseInt(req.getParameter("rId")));
        roomservice.deleteByPrimaryKey(record.getrId());
        return "redirect:/roomController/roomList";
    }

    @RequestMapping(value = "/addRoom")
    public String addRoom(HttpServletRequest req,HttpServletResponse resp){
        Room record = new Room();
        record.setrId(Integer.valueOf(req.getParameter("rId")));
        record.setPosition(req.getParameter("position"));
        record.setMaxCount(Integer.valueOf(req.getParameter("maxCount")));
        int rs = roomservice.insert(record);
        return "redirect:/roomController/roomList";
    }

    @RequestMapping(value = "/modifyRoom")
    public String modifyRoom(HttpServletRequest req,HttpServletResponse resp){
        Room room = new Room();
        room.setrId(Integer.valueOf(req.getParameter("rId")));
        room.setPosition(req.getParameter("position"));
        room.setMaxCount(Integer.parseInt(req.getParameter("maxCount")));
        int rs = roomservice.updateByPrimaryKey(room);
        return "redirect:/roomController/roomList";
    }

    @RequestMapping(value ="/seekRoom")
    public String seekRoom(HttpServletRequest req,HttpServletResponse resp,Model model){
        List<Room> rs = roomservice.queryRoomByPosition("%" + req.getParameter("position") + "%");
        model.addAttribute("seekedRoom");
        return "view/room/roomMgmt";
    }

    @RequestMapping(value ="/addRoomUI")
    public String addRoomUI(Model model){
        List<Room> room = roommapper.queryAllRoom();
        model.addAttribute("room",room);
        return "view/room/addRoomUI";
    }

    @RequestMapping(value ="/modifyRoomUI")
    public String modifyRoomUI(HttpServletRequest req,HttpServletResponse resp,Model model){
        Room room = roommapper.selectByPrimaryKey(Integer.parseInt(req.getParameter("rId")));
        model.addAttribute("room",room);
        return "view/room/modifyRoomUI";
    }
}
