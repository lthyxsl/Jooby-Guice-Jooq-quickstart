package com.thyxsl.router;

import com.alibaba.fastjson.JSONObject;
import com.thyxsl.jooq.tables.pojos.Course;
import com.thyxsl.service.CourseService;
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
public class CourseRouter {

    @Nonnull
    public static JSONObject findCourseList(Context ctx) {
        CourseService courseService = ctx.require(CourseService.class);
        List<Course> courseList = courseService.getCourseList();
        return new JSONObject().fluentPut("code", 200).fluentPut("msg", "getCourseList success").fluentPut("data", courseList);
    }

    @Nonnull
    public static JSONObject findCourseById(Context ctx) {
        CourseService courseService = ctx.require(CourseService.class);
        Course course = courseService.getCourseById(Integer.parseInt(ctx.path("id").value()));
        return new JSONObject().fluentPut("code", 200).fluentPut("msg", "getCourseById success").fluentPut("data", course);
    }
}
