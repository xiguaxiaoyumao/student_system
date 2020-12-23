package com.sunjob.pojo;

/**
 * @author zht
 * @date 2020/12/20 14:02
 */
public class Grade {
    private int grade_id;
    private String student_id;
    private String student_name;
    private String class_type;
    private Float chinese;
    private Float math;
    private Float english;
    private Float computer;

    public int getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(int grade_id) {
        this.grade_id = grade_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getClass_type() {
        return class_type;
    }

    public void setClass_type(String class_type) {
        this.class_type = class_type;
    }

    public Float getChinese() {
        return chinese;
    }

    public void setChinese(Float chinese) {
        this.chinese = chinese;
    }

    public Float getMath() {
        return math;
    }

    public void setMath(Float math) {
        this.math = math;
    }

    public Float getEnglish() {
        return english;
    }

    public void setEnglish(Float english) {
        this.english = english;
    }

    public Float getComputer() {
        return computer;
    }

    public void setComputer(Float computer) {
        this.computer = computer;
    }
}
