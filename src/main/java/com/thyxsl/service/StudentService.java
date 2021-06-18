package com.thyxsl.service;

import com.google.inject.ImplementedBy;
import com.thyxsl.dto.StudentDTO;
import com.thyxsl.jooq.tables.pojos.Student;
import com.thyxsl.service.impl.StudentServiceImpl;

import java.util.List;

/**
 * @author ：thyxsl
 * @date ：Created in 2021/6/18 22:11
 * @version: 1.0
 */
@ImplementedBy(StudentServiceImpl.class)
public interface StudentService {

    List<Student> getStudentList();

    Student getStudentById(Integer id);

    StudentDTO getStudentCourseDetail(Integer id);
}
