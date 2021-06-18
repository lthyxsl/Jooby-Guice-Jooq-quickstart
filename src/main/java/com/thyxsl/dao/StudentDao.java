package com.thyxsl.dao;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.thyxsl.dto.StudentDTO;
import com.thyxsl.jooq.Tables;
import com.thyxsl.jooq.tables.pojos.Course;
import com.thyxsl.jooq.tables.pojos.Student;
import com.thyxsl.jooq.tables.pojos.StudentCourse;
import org.jooq.DSLContext;
import org.jooq.Record5;

import java.util.List;

/**
 * @author ：thyxsl
 * @date ：Created in 2021/6/18 22:05
 * @version: 1.0
 */
@Singleton
public class StudentDao {

    private final DSLContext dslContext;

    @Inject
    public StudentDao(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public List<Student> getStudentList() {
        return dslContext.selectFrom(Tables.STUDENT).fetch(r -> r.into(Student.class));
    }

    public Student getStudentById(Integer id) {
        return dslContext.selectFrom(Tables.STUDENT).where(Tables.STUDENT.ID.eq(id)).fetchOne(r -> r.into(Student.class));
    }

    public StudentDTO getStudentCourseDetail(Integer id) {
        Record5<Integer, String, Integer, String, Integer> record = dslContext.select(Tables.STUDENT.ID, Tables.STUDENT.NAME, Tables.COURSE.ID, Tables.COURSE.NAME, Tables.STUDENT_COURSE.SCORE)
                .from(Tables.STUDENT).leftOuterJoin(Tables.STUDENT_COURSE).on(Tables.STUDENT.ID.eq(Tables.STUDENT_COURSE.STUDENT_ID))
                .leftOuterJoin(Tables.COURSE).on(Tables.STUDENT_COURSE.COURSE_ID.eq(Tables.COURSE.ID)).where(Tables.STUDENT.ID.eq(id))
                .fetchOne();

        StudentDTO studentDTO = new StudentDTO();
        Course course = new Course();
        StudentCourse sc = new StudentCourse();
        assert record != null;
        studentDTO.setId(record.get(Tables.STUDENT.ID));
        studentDTO.setName(record.get(Tables.STUDENT.NAME));
        course.setName(record.get(Tables.COURSE.NAME));
        course.setId(record.get(Tables.COURSE.ID));
        sc.setScore(record.get(Tables.STUDENT_COURSE.SCORE));
        studentDTO.setCourse(course);
        studentDTO.setStudentCourse(sc);
        return studentDTO;
    }
}
