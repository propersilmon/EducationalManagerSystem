package com.ems.controller;

import com.ems.entity.Room;
import com.ems.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/room")
public class RoomController {

    @Autowired
    private RoomService roomservice;

    @RequestMapping(value = "/removeRoom")
    public String deleteRoom(HttpServletRequest req, HttpServletResponse resp){
        Room record = new Room();
        record.setrId(Integer.parseInt(req.getParameter("rId")));
        return null;
    }

    @RequestMapping(value = "/addRoom")
    public String addRoom(HttpServletRequest req,HttpServletResponse resp){
        Room record = new Room();
        record.setrId(Integer.valueOf(req.getParameter("rId")));
        record.setPosition(req.getParameter("position"));
        record.setMaxCount(Integer.valueOf(req.getParameter("maxCount")));
        int rs = roomservice.insert(record);
        return null;
    }

    @RequestMapping(value = "/modifyRoom")
    public String updateRoom(HttpServletRequest req,HttpServletResponse resp){
        Room record = new Room();
        record.setrId(Integer.valueOf(req.getParameter("rId")));
        record.setPosition(req.getParameter("position"));
        record.setMaxCount(Integer.valueOf(req.getParameter("maxCOunt")));
        int rs = roomservice.updateByPrimaryKeySelective(record);
        return null;
    }

    @RequestMapping(value ="/seekRoom")
    public String queryRoom(HttpServletRequest req,HttpServletResponse resp){
        List<Room> rs = roomservice.queryRoomByPosition("%" + req.getParameter("position") + "%");
        System.out.println(rs.toString());
        return null;
    }
}
