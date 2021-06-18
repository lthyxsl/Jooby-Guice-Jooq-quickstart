package com.thyxsl;

import com.thyxsl.module.BasicModule;
import com.thyxsl.router.CourseRouter;
import com.thyxsl.router.StudentCourseRouter;
import com.thyxsl.router.StudentRouter;
import com.thyxsl.router.TeacherRouter;
import io.jooby.Jooby;
import io.jooby.di.GuiceModule;
import io.jooby.json.JacksonModule;

/**
 * @author ：thyxsl
 * @date ：Created in 2021/6/17 23:11
 * @description：web server
 * @modified By：
 * @version: 1.0$
 */
public class WebApplication{

    public static void main(String[] args) {
        Jooby.runApp(args, app -> {
            app.install(new GuiceModule(new BasicModule()));
            app.install(new JacksonModule());
            app.get("/students", StudentRouter::findStudentList);
            app.get("/students/{id}", StudentRouter::findStudentById);
            app.get("/students/detail/{id}", StudentRouter::findStudentCourseDetail);

            app.get("/teachers", TeacherRouter::findTeacherList);
            app.get("/teachers/{id}", TeacherRouter::findTeacherById);

            app.get("/courses", CourseRouter::findCourseList);
            app.get("/courses/{id}", CourseRouter::findCourseById);

            app.get("/sc", StudentCourseRouter::findStudentCourseList);
            app.get("/sc/{id}", StudentCourseRouter::findStudentCourseById);
        });

    }
}
