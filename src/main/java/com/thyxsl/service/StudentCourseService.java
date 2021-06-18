package com.thyxsl.service;

import com.google.inject.ImplementedBy;
import com.thyxsl.jooq.tables.pojos.StudentCourse;
import com.thyxsl.service.impl.StudentCourseServiceImpl;

import java.util.List;

/**
 * @author ：thyxsl
 * @date ：Created in 2021/6/18 22:11
 * @version: 1.0
 */
@ImplementedBy(StudentCourseServiceImpl.class)
public interface StudentCourseService {

    List<StudentCourse> getStudentCourseList();

    StudentCourse getStudentCourseById(Integer id);
}
