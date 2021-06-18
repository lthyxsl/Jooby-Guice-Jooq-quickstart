package com.thyxsl.router;

import com.alibaba.fastjson.JSONObject;
import com.thyxsl.jooq.tables.pojos.Student;
import com.thyxsl.service.StudentService;
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
public class StudentRouter {

    @Nonnull
    public static JSONObject findStudentList(Context ctx) {
        StudentService studentService = ctx.require(StudentService.class);
        List<Student> studentList = studentService.getStudentList();
        return new JSONObject().fluentPut("code", 200).fluentPut("msg", "getStudentList success").fluentPut("data", studentList);
    }

    @Nonnull
    public static JSONObject findStudentById(Context ctx) {
        StudentService studentService = ctx.require(StudentService.class);
        Student student = studentService.getStudentById(Integer.parseInt(ctx.path("id").value()));
        return new JSONObject().fluentPut("code", 200).fluentPut("msg", "getStudentById success").fluentPut("data", student);
    }

    @Nonnull
    public static JSONObject findStudentCourseDetail(Context ctx) {
        StudentService studentService = ctx.require(StudentService.class);
        Student student = studentService.getStudentCourseDetail(Integer.parseInt(ctx.path("id").value()));
        return new JSONObject().fluentPut("code", 200).fluentPut("msg", "getStudentCourseDetail success").fluentPut("data", student);
    }
}
