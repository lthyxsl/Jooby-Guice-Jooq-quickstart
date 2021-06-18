package com.thyxsl.service.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.thyxsl.dao.CourseDao;
import com.thyxsl.jooq.tables.pojos.Course;
import com.thyxsl.service.CourseService;

import java.util.List;

/**
 * @author ：thyxsl
 * @date ：Created in 2021/6/18 22:11
 * @version: 1.0
 */
@Singleton
public class CourseServiceImpl implements CourseService {

    @Inject
    private CourseDao courseDao;


    @Override
    public List<Course> getCourseList() {
        return courseDao.getCourseList();
    }

    @Override
    public Course getCourseById(Integer id) {
        return courseDao.getCourseById(id);
    }
}
