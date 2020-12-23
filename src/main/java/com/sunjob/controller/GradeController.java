package com.sunjob.controller;

import com.sunjob.pojo.Grade;
import com.sunjob.pojo.User;
import com.sunjob.service.GradeService;
import com.sunjob.util.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zht
 * @date 2020/12/20 15:42
 */
@Controller
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @RequestMapping(path = "/get_grade")
    @ResponseBody
    public List getGrade(HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Grade> grade = gradeService.selectStudentGradeById(user);
        return grade;
    }

    @RequestMapping(path = "/get_grades")
    @ResponseBody
    public List getGrades() {
        List<Grade> grade = gradeService.selectAllGrades();
        return grade;
    }

    @RequestMapping(path = "/insert_or_update")
    @ResponseBody
    public ResponseCode insertOrUpdate(@RequestBody Grade grade) {
        int i = gradeService.insertOrUpdate(grade);
        if (i >= 0) {
            return ResponseCode.success();
        } else {
            return ResponseCode.error();
        }
    }

    @RequestMapping(path = "/search")
    @ResponseBody
    public ResponseCode search(@RequestBody Grade grade) {
        List<Grade> grades = gradeService.search(grade);
        return ResponseCode.success().put("grades", grades);
    }

    @RequestMapping(path = "/delete_grade")
    @ResponseBody
    public ResponseCode deleteGrade(@RequestBody Grade grade) {
        int i = gradeService.deleteGrade(grade);
        if (i >= 0) {
            return ResponseCode.success();
        } else {
            return ResponseCode.error();
        }
    }
}
