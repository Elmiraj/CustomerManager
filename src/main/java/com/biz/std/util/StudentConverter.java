package com.biz.std.util;

import com.biz.std.model.Grade;
import com.biz.std.model.Student;
import com.biz.std.vo.score.ScoreVo;
import com.biz.std.vo.student.StudentVo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 学生实体的VO/PO转换类
 * StudentConverter class
 * @author junzhang
 * @date 2018-12-18
 */

public class StudentConverter {

    private StudentConverter(){
        super();
    }

    /**
     * 将学生VO转换成po
     */
    public static Student toPo(StudentVo studentVo){
        Student student = new Student();
        student.setId(studentVo.getId());
        student.setName(studentVo.getName());
        student.setIsPaid(studentVo.getIsPaid());
        Grade grade = new Grade();
        grade.setId(studentVo.getGradeId());
        student.setGrade(grade);
        student.setScores(ScoreConverter.toPoList(studentVo.getScoreVoList()));
        student.setPaidMoney(studentVo.getPaidMoney());
        student.setTotalTotalPrice(studentVo.getTotalTotalPrice());
        return student;
    }

    /**
     * 将学生po转换成vo
     */
    public static StudentVo toVo(Student student){
        StudentVo studentVo = new StudentVo();
        studentVo.setId(student.getId());
        studentVo.setName(student.getName());
        studentVo.setIsPaid(student.getIsPaid());
        studentVo.setGradeId(student.getGrade().getId());
        studentVo.setGradeName(student.getGrade().getName());
        studentVo.setSubjectCount(student.getScores().size());
        studentVo.setScoreVoList(ScoreConverter.toVoList(student.getScores()));
        // 总价
        for (ScoreVo scoreVo : studentVo.getScoreVoList()){
            if (scoreVo.getStock() == null){
                scoreVo.setStock(BigDecimal.ZERO);
            }
            BigDecimal totalTotalPrice = studentVo.getTotalTotalPrice();
            if (totalTotalPrice == null){
                studentVo.setTotalTotalPrice(scoreVo.getScore().multiply(scoreVo.getPrice()).setScale(
                        2,BigDecimal.ROUND_HALF_UP));
            }else {
                studentVo.setTotalTotalPrice(scoreVo.getScore().multiply(scoreVo.getPrice()).add(totalTotalPrice).setScale(
                        2,BigDecimal.ROUND_HALF_UP));
            }
        }

        studentVo.setTotalScore(Utils.totalScore(student.getScores()));
        if (student.getPaidMoney() == null){
            student.setPaidMoney(BigDecimal.ZERO);
        }
        studentVo.setPaidMoney(student.getPaidMoney());
        return studentVo;
    }

    public static List<Student> toPoList(List<StudentVo> studentVoList){
        List<Student> studentList = new ArrayList<>();
        for (StudentVo studentVo: studentVoList) {
            studentList.add(toPo(studentVo));
        }
        return studentList;
    }

    public static List<StudentVo> toVoList(List<Student> studentList){
        List<StudentVo> studentVoList = new ArrayList<>();
        for (Student student: studentList) {
            studentVoList.add(toVo(student));
        }
        return studentVoList;
    }

}
