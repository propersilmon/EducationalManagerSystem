package com.ems.service.impl;

import com.ems.entity.*;
import com.ems.mapper.*;
import com.ems.service.StudentSerivce;
import com.ems.vo.StudentChoseCourse;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentSerivce {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentCourseMapper studentCourseMapper;
    @Autowired
    private  CourseMapper courseMapper;
    @Autowired
    private ClassCourseMapper classCourseMapper;
    @Autowired
    private CourseRoomMapper courseRoomMapper;
    @Autowired
    private RoomMapper roomMapper;
    @Override
    public List<Student> queryStudentByPage(int currentPageIdx) {
        //每页查10个
        return studentMapper.queryStudentByPage((currentPageIdx-1),10);
    }

    @Override
    public int totalStudentCount() {
        return studentMapper.totalStudentCount();
    }

    @Override
    public int addStudent(Student student) {
        return studentMapper.insertSelective(student);
    }

    @Override
    public int updateStudentByStudent(Student student) {
        return studentMapper.updateByPrimaryKeySelective(student);
    }

    @Override
    public int delteStudentById(String id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Student queryStudentById(String id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Student> queryByPage(int currentPage, int recordPerPage) {
        return studentMapper.queryStudentByPage((currentPage-1)*recordPerPage,recordPerPage);
    }

    @Override
    public int dropCourseCourseByS_c_id(int sCId) {
        return studentMapper.dropCourseCourseByS_c_id(sCId);
    }

    @Override
    public List<StudentChoseCourse> queryAllStudentCourseByS_id(String sId) {
        List<StudentChoseCourse> studentChoseCourse = new ArrayList<>();
        List<StudentCourse> studentCourse = studentCourseMapper.queryAllStudentCourseByS_id(sId);
        for (StudentCourse studentCourse1:studentCourse) {
            StudentChoseCourse studentChoseCourse1 = new StudentChoseCourse();
            studentChoseCourse1.setcId(studentCourse1.getcId());
            studentChoseCourse1.setsCId(studentCourse1.getsCId());
            studentChoseCourse1.setsId(studentCourse1.getsId());
            studentChoseCourse1.setsScore(studentCourse1.getsScore());
            studentChoseCourse1.settScore(studentCourse1.gettScore());
            Course course = courseMapper.selectByPrimaryKey(studentCourse1.getcId());
            studentChoseCourse1.setcName(course.getcName());
            studentChoseCourse.add(studentChoseCourse1);
        }
        return studentChoseCourse;
    }

    @Override
    public int updateT_scoreByS_c_id(@Param("tScore") int tScore, @Param("sCId")int sCId) {
        return studentMapper.updateT_scoreByS_c_id(tScore,sCId);
    }

    @Override
    public List<ClassCourse> queryAllBXCourse(String sClass) {
       return classCourseMapper.queryAllBXCourse(sClass);
    }

    @Override
    public List<ClassCourse> queryBXByID(int cId) {
        return courseMapper.queryBXByID(cId);
    }

    @Override
    public int delteXK(StudentCourse studentCourse) {
        return studentCourseMapper.delteXK(studentCourse);

    }

    @Override
    public int addAllBXCourse(StudentCourse studentCourse) {
        return studentCourseMapper.insert(studentCourse);

    }

    @Override
    public List<Course> queryAllXXCourse() {
        return courseMapper.queryAllXXCourse();

    }

    @Override
    public List<Course> queryAllCourse1(String sId) {
        return courseMapper.queryAllCourse1(sId);
    }

    @Override
    public int delteXX(StudentCourse studentCourse) {
        return studentCourseMapper.delteXX(studentCourse);

    }

    @Override
    public int addXXcourse(StudentCourse studentCourse) {
        return studentCourseMapper.insert(studentCourse);

    }

    @Override
    public List<Course> queryAllC() {
        return courseMapper.queryAllC();

    }

    @Override
    public List<CourseRoom> queryAllCR(String sId) {
        return courseRoomMapper.queryAllCR(sId);

    }

    @Override
    public List<Room> queryAllRoom1() {
        return roomMapper.queryAllRoom1();

    }


}
