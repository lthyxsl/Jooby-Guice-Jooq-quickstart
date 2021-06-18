package com.thyxsl.router;

import com.alibaba.fastjson.JSONObject;
import com.thyxsl.jooq.tables.pojos.StudentCourse;
import com.thyxsl.service.StudentCourseService;
import io.jooby.Context;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * @author ：thyxsl
 * @date ：Created in 2021/6/17 23:20
 * @description：user router
 * @modified By：
 * @version: 1.0$
 */
public class StudentCourseRouter {

    @Nonnull
    public static JSONObject findStudentCourseList(Context ctx) {
        StudentCourseService studentCourseService = ctx.require(StudentCourseService.class);
        List<StudentCourse> studentCourseList = studentCourseService.getStudentCourseList();
        return new JSONObject().fluentPut("code", 200).fluentPut("msg", "getStudentCourseList success").fluentPut("data", studentCourseList);
    }

    @Nonnull
    public static JSONObject findStudentCourseById(Context ctx) {
        StudentCourseService studentCourseService = ctx.require(StudentCourseService.class);
        StudentCourse studentCourse = studentCourseService.getStudentCourseById(Integer.parseInt(ctx.path("id").value()));
        return new JSONObject().fluentPut("code", 200).fluentPut("msg", "getStudentCourseById success").fluentPut("data", studentCourse);
    }
}
