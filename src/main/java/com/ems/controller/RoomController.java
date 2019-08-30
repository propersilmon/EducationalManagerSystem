package com.ems.controller;

import com.ems.entity.Room;
import com.ems.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/room")
public class RoomController {

    @Autowired
    private RoomService roomservice;

    @RequestMapping(value = "/removeRoom")
    public String deleteRoom(@RequestParam("rId")Integer rId){
        int rs = roomservice.deleteByPrimaryKey(rId);
        return null;
    }

    @RequestMapping(value = "/addRoom")
    public String addRoom(@RequestParam("rId")Integer rId,@RequestParam("position")String position,@RequestParam("maxCount")Integer maxCount){
        Room record = new Room();
        record.setrId(rId);
        record.setPosition(position);
        record.setMaxCount(maxCount);
        int rs = roomservice.insert(record);
        return null;
    }

    @RequestMapping(value = "/modifyRoom")
    public String updateRoom(@RequestParam("rId")Integer rId,@RequestParam("position")String position,@RequestParam("maxCount")Integer maxCount){
        Room record = new Room();
        record.setrId(rId);
        record.setPosition(position);
        record.setMaxCount(maxCount);
        int rs = roomservice.updateByPrimaryKeySelective(record);
        return null;
    }

    @RequestMapping(value ="/seekRoom")
    public String queryRoom(@RequestParam("position")String position){
        List<Room> rs = roomservice.queryRoomByPosition("%" + position + "%");
        return null;
    }
}
