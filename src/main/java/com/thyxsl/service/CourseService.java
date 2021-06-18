package com.thyxsl.service;

import com.google.inject.ImplementedBy;
import com.thyxsl.jooq.tables.pojos.Course;
import com.thyxsl.service.impl.CourseServiceImpl;

import java.util.List;

/**
 * @author ：thyxsl
 * @date ：Created in 2021/6/18 22:11
 * @version: 1.0
 */
@ImplementedBy(CourseServiceImpl.class)
public interface CourseService {

    List<Course> getCourseList();

    Course getCourseById(Integer id);
}
