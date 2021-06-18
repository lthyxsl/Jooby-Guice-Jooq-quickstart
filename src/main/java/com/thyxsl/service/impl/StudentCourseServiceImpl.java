package com.thyxsl.service.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.thyxsl.dao.StudentCourseDao;
import com.thyxsl.jooq.tables.pojos.StudentCourse;
import com.thyxsl.service.StudentCourseService;

import java.util.List;

/**
 * @author ：thyxsl
 * @date ：Created in 2021/6/18 22:11
 * @version: 1.0
 */
@Singleton
public class StudentCourseServiceImpl implements StudentCourseService {

    @Inject
    private StudentCourseDao studentCourseDao;

    @Override
    public List<StudentCourse> getStudentCourseList() {
        return studentCourseDao.getStudentCourseList();
    }

    @Override
    public StudentCourse getStudentCourseById(Integer id) {
        return studentCourseDao.getStudentCourseById(id);
    }
}
