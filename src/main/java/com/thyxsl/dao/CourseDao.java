package com.thyxsl.dao;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.thyxsl.jooq.Tables;
import com.thyxsl.jooq.tables.pojos.Course;
import org.jooq.DSLContext;

import java.util.List;

/**
 * @author ：thyxsl
 * @date ：Created in 2021/6/18 22:05
 * @version: 1.0
 */
@Singleton
public class CourseDao {

    private final DSLContext dslContext;

    @Inject
    public CourseDao(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public List<Course> getCourseList() {
        return dslContext.selectFrom(Tables.COURSE).fetch(r -> r.into(Course.class));
    }

    public Course getCourseById(Integer id) {
        return dslContext.selectFrom(Tables.COURSE).where(Tables.COURSE.ID.eq(id)).fetchOne(r -> r.into(Course.class));
    }
}
