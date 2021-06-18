package com.thyxsl.service.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.thyxsl.dao.TeacherDao;
import com.thyxsl.jooq.tables.pojos.Teacher;
import com.thyxsl.service.TeacherService;

import java.util.List;

/**
 * @author ：thyxsl
 * @date ：Created in 2021/6/18 22:11
 * @version: 1.0
 */
@Singleton
public class TeacherServiceImpl implements TeacherService {

    @Inject
    private TeacherDao teacherDao;


    @Override
    public List<Teacher> getTeacherList() {
        return teacherDao.getTeacherList();
    }

    @Override
    public Teacher getTeacherById(Integer id) {
        return teacherDao.getTeacherById(id);
    }
}
