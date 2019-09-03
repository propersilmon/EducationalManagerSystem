package com.ems.service.impl;

import com.ems.entity.Room;
import com.ems.mapper.RoomMapper;
import com.ems.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
@Autowired
RoomMapper roommapper;

    public int deleteByPrimaryKey(Integer rId){
        return roommapper.deleteByPrimaryKey(rId);
    }

    public int insert(Room record){
        return roommapper.insert(record);
    }

    public int insertSelective(Room record){
        return roommapper.insertSelective(record);
    }

    public Room selectByPrimaryKey(Integer rId){
        return roommapper.selectByPrimaryKey(rId);
    }

    public int updateByPrimaryKeySelective(Room record){
        return roommapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Room record){
        return roommapper.updateByPrimaryKeySelective(record);
    }

    public List<Room> queryRoomByPosition(String position){
        return roommapper.queryRoomByPosition(position);
    }

    @Override
    public List<Room> queryAllRoom() {
        return roommapper.queryAllRoom();
    }
}
