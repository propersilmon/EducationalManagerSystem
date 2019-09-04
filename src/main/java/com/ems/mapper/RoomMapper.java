package com.ems.mapper;

import com.ems.entity.Room;

import java.util.List;

public interface RoomMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(Room record);

    int insertSelective(Room record);

    Room selectByPrimaryKey(Integer rId);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);

    List<Room> queryRoomByPosition(String position);

            /*查询room*/
    List<Room> selectRoom();
    List<Room> queryAllRoom();
}