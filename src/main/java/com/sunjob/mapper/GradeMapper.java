package com.sunjob.mapper;

import com.sunjob.pojo.Grade;
import com.sunjob.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zht
 * @date 2020/12/20 14:01
 */
@Repository
public interface GradeMapper {

    /**
     * 查询所有成绩
     *
     * @return List<Grade>
     */
    @Select("select student_id, student_name, class_type, chinese, math, english, computer from grade")
    List<Grade> selectAllGrades();

    /**
     * 查询某个班的所有成绩
     *
     * @param classType 班级类型
     * @return List<Grade>
     */
    @Select("select student_id, student_name, class_type, chinese, math, english, computer from grade where class_type = #{class_type}")
    List<Grade> selectClassGrades(Grade classType);

    /**
     * 根据姓名查询某学生成绩
     *
     * @param student_name 学生姓名
     * @return List<Grade> 学生成绩
     */
    @Select("select student_id, student_name, class_type, chinese, math, english, computer from grade where student_name like concat('%',#{student_name},'%');")
    List<Grade> selectStudentGradeByName(Grade student_name);

    /**
     * 根据姓名和班级查询某学生成绩
     *
     * @param grade 学生姓名 和 班级
     * @return List<Grade> 学生成绩
     */
    @Select("select student_id, student_name, class_type, chinese, math, english, computer from grade where student_name like concat('%',#{student_name},'%') and class_type = #{class_type}")
    List<Grade> selectStudentGradeByNameAndClass(Grade grade);

    /**
     * 根据id查询某学生成绩
     *
     * @param user_id
     * @return List<Grade> 学生成绩
     */
    @Select("select student_id, student_name, class_type, chinese, math, english, computer from grade where student_id = #{user_id};")
    List<Grade> selectStudentGradeById(User user_id);

    /**
     * 根据id更新数据
     *
     * @param grade 新数据
     * @return int 影响条数
     */
    @Update("update grade set chinese = #{chinese}, math = #{math}, english = #{english}, computer = #{computer}  where student_id = #{student_id} and student_name = #{student_name} and class_type = #{class_type};")
    int update(Grade grade);

    /**
     * 添加数据
     *
     * @param grade 成绩
     * @return 影响条数
     * @author 张海涛
     */
    @Insert("insert into grade(student_id, student_name, class_type,chinese, math, english, computer) values(#{student_id},#{student_name},#{class_type},#{chinese},#{math},#{english},#{computer})")
    int insert(Grade grade);

    /**
     * 删除数据
     *
     * @param grade
     * @return 影响条数
     */
    @Delete("delete from grade where student_id = #{student_id};")
    int delete(Grade grade);
}
