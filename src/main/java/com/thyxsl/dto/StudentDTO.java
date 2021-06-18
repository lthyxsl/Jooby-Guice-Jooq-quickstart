package com.thyxsl.dto;

import com.thyxsl.jooq.tables.pojos.Course;
import com.thyxsl.jooq.tables.pojos.Student;
import com.thyxsl.jooq.tables.pojos.StudentCourse;

/**
 * @author ：thyxsl
 * @date ：Created in 2021/6/18 23:05
 * @version: 1.0
 */
public class StudentDTO extends Student {

    private Course course;

    private StudentCourse studentCourse;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public StudentCourse getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(StudentCourse studentCourse) {
        this.studentCourse = studentCourse;
    }
}
