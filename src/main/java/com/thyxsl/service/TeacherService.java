package com.thyxsl.service;

import com.google.inject.ImplementedBy;
import com.thyxsl.jooq.tables.pojos.Teacher;
import com.thyxsl.service.impl.TeacherServiceImpl;

import java.util.List;

/**
 * @author ：thyxsl
 * @date ：Created in 2021/6/18 22:11
 * @version: 1.0
 */
@ImplementedBy(TeacherServiceImpl.class)
public interface TeacherService {

    List<Teacher> getTeacherList();

    Teacher getTeacherById(Integer id);
}
