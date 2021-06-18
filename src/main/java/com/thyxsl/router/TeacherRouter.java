package com.thyxsl.router;

import com.alibaba.fastjson.JSONObject;
import com.thyxsl.jooq.tables.pojos.Teacher;
import com.thyxsl.service.TeacherService;
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
public class TeacherRouter {

    @Nonnull
    public static JSONObject findTeacherList(Context ctx) {
        TeacherService teacherService = ctx.require(TeacherService.class);
        List<Teacher> teacherList = teacherService.getTeacherList();
        return new JSONObject().fluentPut("code", 200).fluentPut("msg", "getTeacherList success").fluentPut("data", teacherList);
    }

    @Nonnull
    public static JSONObject findTeacherById(Context ctx) {
        TeacherService teacherService = ctx.require(TeacherService.class);
        Teacher teacher = teacherService.getTeacherById(Integer.parseInt(ctx.path("id").value()));
        return new JSONObject().fluentPut("code", 200).fluentPut("msg", "getTeacherById success").fluentPut("data", teacher);
    }
}
