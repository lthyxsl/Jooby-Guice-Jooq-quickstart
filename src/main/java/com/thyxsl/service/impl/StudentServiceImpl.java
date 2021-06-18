package com.thyxsl.service.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.thyxsl.dao.StudentDao;
import com.thyxsl.dto.StudentDTO;
import com.thyxsl.jooq.tables.pojos.Student;
import com.thyxsl.service.StudentService;

import java.util.List;

/**
 * @author ：thyxsl
 * @date ：Created in 2021/6/18 22:11
 * @version: 1.0
 */
@Singleton
public class StudentServiceImpl implements StudentService {

    @Inject
    private StudentDao studentDao;

    @Override
    public List<Student> getStudentList() {
        return studentDao.getStudentList();
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public StudentDTO getStudentCourseDetail(Integer id) {
        return studentDao.getStudentCourseDetail(id);
    }
}
