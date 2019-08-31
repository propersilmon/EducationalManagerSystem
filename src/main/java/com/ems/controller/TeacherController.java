package com.ems.controller;

import com.ems.entity.Course;
import com.ems.entity.CourseRoom;
import com.ems.entity.Room;
import com.ems.service.TeacherService;
import com.ems.vo.TeacherCourseAndRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/teacherController")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @RequestMapping("/selectCourse")
    public String selectCourse(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        TeacherCourseAndRoom teacherCourseAndRoom = new TeacherCourseAndRoom();
        Course course2 = new Course();
        CourseRoom courseRoom2 = new CourseRoom();
        List<Course> courseList;
        List<CourseRoom> courseRoomList;

        List<Room> roomList = null;
        int employeeId = 1;
        /*通过Employee_id查询courser表中信息*/
        courseList = teacherService.selectCourseById(employeeId);
        teacherCourseAndRoom.setCourse(courseList);

        /*查询courser_room表中信息*/
        courseRoomList = teacherService.selectCourseRoom();
        teacherCourseAndRoom.setCourseRoom(courseRoomList);

        /*查询room表中信息*/
        roomList = teacherService.selectRoom();
        teacherCourseAndRoom.setRoom(roomList);
        session.setAttribute("teacherCourseAndRoom", teacherCourseAndRoom);
        return "TeacherCourseRoomList";
    }
}
