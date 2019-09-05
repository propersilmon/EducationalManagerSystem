package com.ems.controller;

import com.ems.entity.Course;
import com.ems.entity.Student;
import com.ems.service.TeacherService;
import com.ems.vo.ActiveEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import com.ems.entity.*;
import com.ems.service.StudentCourseService;
import com.ems.service.StudentSerivce;
import com.ems.vo.TeacherCourseAndRoom;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
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
        /**
         * 查询教师对应课程及其教室位置
         * */
    @RequestMapping("/selectCourse")
    public String selectCourse(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        TeacherCourseAndRoom teacherCourseAndRoom = new TeacherCourseAndRoom();
        List<Course> courseList;
        List<CourseRoom> courseRoomList;
        List<Room> roomList ;
        ActiveEmployee activeEmployee = (ActiveEmployee) session.getAttribute("activeEmployee");
        int eId =activeEmployee.getEmployeeId();
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
    @RequestMapping("/updateUI")
    public  String seleteCourseToUodateUI(HttpServletRequest req, HttpServletResponse resp , HttpSession session , Model model){
        ActiveEmployee activeEmployee = (ActiveEmployee) session.getAttribute("activeEmployee");
        int eId = activeEmployee.getEmployeeId();
        List<Course> courseList = teacherService.selectCNameByEId(eId);
        model.addAttribute("courseList",courseList);
        return "view/teacher/showStudents";
    }

    /**
     *查找教师课程对应的学生选课信息
     * */
    @RequestMapping("/scoresList")
    public String ScoresList(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        TeacherCourseAndRoom teacherCourseAndRoom = new TeacherCourseAndRoom();
        List<Course> courseList;
        List<StudentCourse> studentCoursesList;
        List<Student> studentList;
        /*通过Employee_id查询courser表中信息*/
        ActiveEmployee activeEmployee = (ActiveEmployee) session.getAttribute("activeEmployee");
        int eId =activeEmployee.getEmployeeId();
        courseList = teacherService.selectCourseById(eId);
        teacherCourseAndRoom.setCourse(courseList);
        /*查询t_student_courser表中sid和score信息*/
        studentCoursesList = studentCourseService.selectStudentCourse();
        /*查询student表中学生信息*/
        studentList = studentSerivce.selectStudent();
        session.setAttribute("teacherCourseAndRoom", teacherCourseAndRoom);
        session.setAttribute("studentCoursesList", studentCoursesList);
        session.setAttribute("studentList", studentList);
        return "view/teacher/tables2";
    }
    @RequestMapping("/selectStudents")
    public  String seleteStudentsByCId(HttpServletRequest req, HttpServletResponse resp , HttpSession session , Model model){
        int cId = Integer.parseInt(req.getParameter("cId"));
        ActiveEmployee activeEmployee = (ActiveEmployee) session.getAttribute("activeEmployee");
        int eId = activeEmployee.getEmployeeId();
        List<Course> courseList = teacherService.selectCNameByEId(eId);
        List<Student> studentList = teacherService.seleteStudentsByCId(cId);
        model.addAttribute("studentList",studentList);
        model.addAttribute("courseList",courseList);
        return "view/teacher/showStudents";
    }

    /**
     * 录入单个学生成绩
     * */
    @RequestMapping("/entryOneScores")
    public String EntryOneScores(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        StudentCourse studentCourse = new StudentCourse();
        int sCId = Integer.parseInt(req.getParameter("scId"));
        int score = Integer.parseInt(req.getParameter("studentScore"));
        studentCourse.setsScore(score);
        studentCourse.setsCId(sCId);
        /*通过scId录入单个学生成绩*/
        int n = studentCourseService.updateScore(studentCourse);
        if (n > 0) {
            return "redirect:/teacherController/scoresList";
        } else {
            return null;
        }

    }
    /**
     * 通过学生id，课程id查找学生对应的课程
     * */
    @RequestMapping("/selectByID")
    public String SelectByID(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        // int s_id = Integer.parseInt(req.getParameter("s_id"));
        String s_id = req.getParameter("s_id");
        int c_id = Integer.parseInt(req.getParameter("c_id"));
        StudentCourse studentCourse = studentCourseService.selectStudentById(s_id, c_id);
        session.setAttribute("studentCourse", studentCourse);
        return "view/teacher/tables2";
    }
    /**
     * 查看教师课程下面所有学生的成绩信息
     * */
    @RequestMapping("/selectAllScoresList")
    public String SelectAllScoresList(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        TeacherCourseAndRoom teacherCourseAndRoom = new TeacherCourseAndRoom();
        List<Course> courseList;
        List<StudentCourse> studentCoursesList;
        List<Student> studentList;
        /*通过Employee_id查询courser表中信息*/
        ActiveEmployee activeEmployee = (ActiveEmployee) session.getAttribute("activeEmployee");
        int eId =activeEmployee.getEmployeeId();
        courseList = teacherService.selectCourseById(eId);
        teacherCourseAndRoom.setCourse(courseList);
        /*查询t_student_courser表中sid和score信息*/
        studentCoursesList = studentCourseService.selectStudentCourse();
        /*查询student表中学生信息*/
        studentList = studentSerivce.selectStudent();
        session.setAttribute("teacherCourseAndRoom", teacherCourseAndRoom);
        session.setAttribute("studentCoursesList", studentCoursesList);
        session.setAttribute("studentList", studentList);

        return "view/teacher/teacherCourse";
    }

    /**
     *根据录入成绩界面搜索框输入课程查找该门课程对应学生信息
     * */
    @RequestMapping("/searchCourse")
    public String SearchCourse(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        String cName = req.getParameter("courseName");
        if (cName!=""){
        List<Course> courseList;
        List<StudentCourse> studentCoursesList;
        List<Student> studentList;

        /*通过Employee_id和课程名查询courser表中信息*/
        int eId = 1;
        Course course = teacherService.selectCourseByIdAndCourseName(eId, cName);

        /*查询t_student_courser表中sid和score信息*/
        studentCoursesList = studentCourseService.selectStudentCourse();

        /*查询student表中学生信息*/
        studentList = studentSerivce.selectStudent();

        session.setAttribute("studentCoursesList", studentCoursesList);
        session.setAttribute("studentList", studentList);
        session.setAttribute("course", course);

        return "view/teacher/searchCourse";
    }else{
            return "redirect:/teacherController/scoresList";
        }
    }
    /**
     *根据学生成绩信息界面搜索框输入课程查找学生信息
     * */
    @RequestMapping("/teacherSearchCourse")
    public String TeacherSearchCourse(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        String cName = req.getParameter("courseName");
        if (cName != "") {
            List<Course> courseList;
            System.out.println(cName);
            List<StudentCourse> studentCoursesList;
            List<Student> studentList;

            /*通过Employee_id和课程名查询courser表中信息*/
            ActiveEmployee activeEmployee = (ActiveEmployee) session.getAttribute("activeEmployee");
            int eId = activeEmployee.getEmployeeId();
            Course course = teacherService.selectCourseByIdAndCourseName(eId, cName);

            /*查询t_student_courser表中sid和score信息*/
            studentCoursesList = studentCourseService.selectStudentCourse();

            /*查询student表中学生信息*/
            studentList = studentSerivce.selectStudent();

            session.setAttribute("studentCoursesList", studentCoursesList);
            session.setAttribute("studentList", studentList);
            session.setAttribute("course", course);

            return "view/teacher/teacherSearchCourse";
        }else {
            return "redirect:/teacherController/selectAllScoresList";
        }
    }
    /**
     * 接受前端传来的数据，插入成绩数据到数据库
     */
    @RequestMapping("/batchInsert")
    @ResponseBody
    public String BatchInsert(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws IOException {
        List<StudentCourse> list2 = new ArrayList<>();

        String items = req.getParameter("checkList");
        System.out.println(items);
        String[] strings = items.split(",");
        for (int i = 0; i < strings.length; i++) {
            try {
                int scId = Integer.parseInt(strings[i]);
                System.out.println(scId);
                List<StudentCourse> list = studentCourseService.selectStudentCourse();
                for (StudentCourse studentCourse : list) {
                    if (studentCourse.getsCId() == scId) {
                        list2.add(studentCourse);
                    }
                }
            } catch (Exception e) {
            }
        }
        session.setAttribute("list2", list2);
        System.out.println(list2);
        String basePath = req.getContextPath();
        return "window.location.href='" + basePath + "/teacherController/jump'";
    }
    /**
     *查找学生信息显示在批量录入界面
     * */
    @RequestMapping("/jump")
    public String Jump(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {

        TeacherCourseAndRoom teacherCourseAndRoom = new TeacherCourseAndRoom();
        List<Course> courseList;
        List<Student> studentList;
        /*通过Employee_id查询courser表中信息*/
        ActiveEmployee activeEmployee = (ActiveEmployee) session.getAttribute("activeEmployee");
        int eId =activeEmployee.getEmployeeId();
        courseList = teacherService.selectCourseById(eId);
        teacherCourseAndRoom.setCourse(courseList);

        /*查询student表中学生信息*/
        studentList = studentSerivce.selectStudent();

        session.setAttribute("teacherCourseAndRoom", teacherCourseAndRoom);
        session.setAttribute("studentList", studentList);

        return "view/teacher/batchInsert";
    }
    /**
     *批量录入所有学生成绩
     * */
    @RequestMapping("/entryAllScores")
    public String EntryAllScores(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        List<StudentCourse> studentCoursesList;
        studentCoursesList = studentCourseService.selectStudentCourse();
        String[] strings = req.getParameterValues("scores");
        String[] scId = req.getParameterValues("scId");
        int n = strings.length + scId.length;
        System.out.println("+++" + n);
        String[] arr = new String[n];
        for (int i = 0; i < scId.length; i++) {

            arr[i] = scId[i];
            arr[i + 1] = strings[i];
            System.out.println("id" + arr[i]);
            System.out.println("course" + arr[i + 1]);
            int sCId = Integer.parseInt(arr[i]);
            int course=Integer.parseInt(arr[i + 1] );
            studentCourseService.insertCourse(sCId, course);

            }
        return "redirect:/teacherController/scoresList";
    }



}
