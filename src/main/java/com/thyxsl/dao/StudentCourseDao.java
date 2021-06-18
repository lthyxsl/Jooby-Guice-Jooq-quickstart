package com.thyxsl.dao;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.thyxsl.jooq.Tables;
import com.thyxsl.jooq.tables.pojos.StudentCourse;
import org.jooq.DSLContext;

import java.util.List;

/**
 * @author ：thyxsl
 * @date ：Created in 2021/6/18 22:05
 * @version: 1.0
 */
@Singleton
public class StudentCourseDao {

    private final DSLContext dslContext;

    @Inject
    public StudentCourseDao(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public List<StudentCourse> getStudentCourseList() {
        return dslContext.selectFrom(Tables.STUDENT_COURSE).fetch(r -> r.into(StudentCourse.class));
    }

    public StudentCourse getStudentCourseById(Integer id) {
        return dslContext.selectFrom(Tables.STUDENT_COURSE).where(Tables.STUDENT_COURSE.ID.eq(id)).fetchOne(r -> r.into(StudentCourse.class));
    }
}
