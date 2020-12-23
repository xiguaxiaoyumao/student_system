package com.sunjob.service;

import com.sunjob.mapper.GradeMapper;
import com.sunjob.pojo.Grade;
import com.sunjob.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zht
 * @date 2020/12/20 15:37
 */
@Service
public class GradeService {
    @Autowired
    private GradeMapper gradeMapper;

    public List<Grade> selectAllGrades() {
        return gradeMapper.selectAllGrades();
    }

    public List<Grade> selectStudentGradeById(User user_id) {
        return gradeMapper.selectStudentGradeById(user_id);
    }

    public List<Grade> search(Grade grade) {
        List<Grade> grades;
        if (grade.getStudent_name() != "" && grade.getClass_type() == "") {
            grades = gradeMapper.selectStudentGradeByName(grade);
        } else if (grade.getStudent_name() == "" && grade.getClass_type() != "") {
            grades = gradeMapper.selectClassGrades(grade);
        } else {
            grades = gradeMapper.selectStudentGradeByNameAndClass(grade);
        }
        return grades;
    }

    public int insertOrUpdate(Grade grade) {
        User user = new User();
        user.setUser_id(grade.getStudent_id());

        int j = gradeMapper.selectStudentGradeById(user).size();
        int i = 0;
        if (j == 0) {
            i = gradeMapper.insert(grade);
        } else {
            i = gradeMapper.update(grade);
        }
        return i;
    }

    public int deleteGrade(Grade grade) {
        return gradeMapper.delete(grade);
    }
}
