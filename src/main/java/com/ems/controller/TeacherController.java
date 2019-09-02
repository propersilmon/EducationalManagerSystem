package com.ems.controller;

import com.ems.entity.*;
import com.ems.service.StudentCourseService;
import com.ems.service.StudentSerivce;
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
    @Autowired
    private StudentCourseService studentCourseService;
    @Autowired
    private StudentSerivce studentSerivce;
    @RequestMapping("/selectCourse")
    public String selectCourse(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        TeacherCourseAndRoom teacherCourseAndRoom = new TeacherCourseAndRoom();
        Course course2 = new Course();
        CourseRoom courseRoom2 = new CourseRoom();
        List<Course> courseList;
        List<CourseRoom> courseRoomList;

        List<Room> roomList = null;
        int eId = 1;
        /*通过Employee_id查询courser表中信息*/
        courseList = teacherService.selectCourseById(eId);
        teacherCourseAndRoom.setCourse(courseList);

        /*查询courser_room表中信息*/
        courseRoomList = teacherService.selectCourseRoom();
        teacherCourseAndRoom.setCourseRoom(courseRoomList);

        /*查询room表中信息*/
        roomList = teacherService.selectRoom();
        teacherCourseAndRoom.setRoom(roomList);
        session.setAttribute("teacherCourseAndRoom", teacherCourseAndRoom);
        return "view/teacher/tables";
    }
    @RequestMapping("/scoresList")
    public String ScoresList(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        TeacherCourseAndRoom teacherCourseAndRoom = new TeacherCourseAndRoom();
        List<Course> courseList;
        List<StudentCourse> studentCoursesList;
        List<Student>  studentList;
        /*通过Employee_id查询courser表中信息*/
        int eId = 1;
        courseList = teacherService.selectCourseById(eId);
        teacherCourseAndRoom.setCourse(courseList);
        System.out.println(courseList);
        /*查询t_student_courser表中sid和score信息*/
        studentCoursesList = studentCourseService.selectStudentCourse();
        System.out.println(studentCoursesList);
        /*查询student表中学生信息*/
        studentList = studentSerivce.selectStudent();
        System.out.println(studentList);
        session.setAttribute("teacherCourseAndRoom", teacherCourseAndRoom);
        session.setAttribute("studentCoursesList", studentCoursesList);
        session.setAttribute("studentList", studentList);

        return "view/teacher/tables2";
    }
    @RequestMapping("/entryOneScores")
    public String EntryOneScores(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        StudentCourse studentCourse = new StudentCourse();
        //String s_id = req.getParameter("sId");
        int sCId = Integer.parseInt(req.getParameter("scId"));
        int score = Integer.parseInt(req.getParameter("studentScore"));
        studentCourse.setsScore(score);
        studentCourse.setsCId(sCId);
        System.out.println(sCId);
        System.out.println(score);
        System.out.println(studentCourse);
        /*通过scId录入单个学生成绩*/
        int n =studentCourseService.updateScore(studentCourse);

        if (n>0){
            return "redirect:/teacherController/scoresList";
        }else {
            return null;
        }

    }
    @RequestMapping("/selectByID")
    public String SelectByID(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
       // int s_id = Integer.parseInt(req.getParameter("s_id"));
        String s_id = req.getParameter("s_id");
        int c_id = Integer.parseInt(req.getParameter("c_id"));
        StudentCourse studentCourse = studentCourseService.selectStudentById(s_id,c_id);
        session.setAttribute("studentCourse", studentCourse);
        System.out.println("**********"+studentCourse);
        return "view/teacher/entryOneScore";
    }
    @RequestMapping("/selectAllScoresList")
    public String SelectAllScoresList(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        TeacherCourseAndRoom teacherCourseAndRoom = new TeacherCourseAndRoom();
        List<Course> courseList;
        List<StudentCourse> studentCoursesList;
        List<Student>  studentList;
        /*通过Employee_id查询courser表中信息*/
        int eId = 1;
        courseList = teacherService.selectCourseById(eId);
        teacherCourseAndRoom.setCourse(courseList);
        System.out.println(courseList);
        /*查询t_student_courser表中sid和score信息*/
        studentCoursesList = studentCourseService.selectStudentCourse();
        System.out.println(studentCoursesList);
        /*查询student表中学生信息*/
        studentList = studentSerivce.selectStudent();
        System.out.println(studentList);
        session.setAttribute("teacherCourseAndRoom", teacherCourseAndRoom);
        session.setAttribute("studentCoursesList", studentCoursesList);
        session.setAttribute("studentList", studentList);

        return "view/teacher/teacherCourse";
    }
    @RequestMapping("/searchCourse")
    public String SearchCourse(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        String cName = req.getParameter("courseName");

        List<Course> courseList;  System.out.println(cName);
        List<StudentCourse> studentCoursesList;
        List<Student>  studentList;

        /*通过Employee_id和课程名查询courser表中信息*/
        int eId = 1;
        Course course = teacherService.selectCourseByIdAndCourseName(eId,cName);
        System.out.println(course);

        /*查询t_student_courser表中sid和score信息*/
        studentCoursesList = studentCourseService.selectStudentCourse();
        System.out.println(studentCoursesList);

        /*查询student表中学生信息*/
        studentList = studentSerivce.selectStudent();
        System.out.println(studentList);

        session.setAttribute("studentCoursesList", studentCoursesList);
        session.setAttribute("studentList", studentList);
        session.setAttribute("course", course);

        return "view/teacher/teacherCourse";
    }
}
