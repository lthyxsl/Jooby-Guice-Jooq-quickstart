package com.thyxsl.dao;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.thyxsl.jooq.Tables;
import com.thyxsl.jooq.tables.pojos.Teacher;
import org.jooq.DSLContext;

import java.util.List;

/**
 * @author ：thyxsl
 * @date ：Created in 2021/6/18 22:05
 * @version: 1.0
 */
@Singleton
public class TeacherDao {

    private final DSLContext dslContext;

    @Inject
    public TeacherDao(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public List<Teacher> getTeacherList() {
        return dslContext.selectFrom(Tables.TEACHER).fetch(r -> r.into(Teacher.class));
    }

    public Teacher getTeacherById(Integer id) {
        return dslContext.selectFrom(Tables.TEACHER).where(Tables.TEACHER.ID.eq(id)).fetchOne(r -> r.into(Teacher.class));
    }
}
