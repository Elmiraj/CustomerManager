package com.biz.std.service.impl;

import com.biz.std.model.Score;
import com.biz.std.model.Student;
import com.biz.std.repository.StudentRepository;
import com.biz.std.service.ScoreService;
import com.biz.std.service.StudentService;
import com.biz.std.util.ScoreConverter;
import com.biz.std.util.StudentConverter;
import com.biz.std.util.Utils;
import com.biz.std.vo.PageReqVo;
import com.biz.std.vo.PageVo;
import com.biz.std.vo.score.ScoreVo;
import com.biz.std.vo.student.StdSubVo;
import com.biz.std.vo.student.StudentListVo;
import com.biz.std.vo.student.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * StudentServiceImpl class
 * @author junzhang
 * @date 2018-12-26
 */
@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    private final ScoreService scoreService;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, ScoreService scoreService) {
        this.studentRepository = studentRepository;
        this.scoreService = scoreService;
    }

    @Override
    public StudentListVo findStudentList(PageReqVo reqVo) {
        Page<Student> students = studentRepository.findAll((Specification<Student>) (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        },PageRequest.of(reqVo.getPageIndex()-1,reqVo.getPageSize()));
        PageVo pageVo = Utils.getPageVo(reqVo,students);

        List<Student> studentList = studentRepository.findAllByOrderByName();
        List<StudentVo> studentVoList = StudentConverter.toVoList(studentList);
        for (StudentVo studentVo : studentVoList){
            List<ScoreVo> scoreVoList = studentVo.getScoreVoList();
            for (ScoreVo scoreVo : scoreVoList){
                if (scoreVo.getScore().equals(BigDecimal.ZERO.setScale(2,BigDecimal.ROUND_HALF_UP))){
                    scoreService.deleteScore(scoreVo.getId());
                }
            }
        }
        return new StudentListVo(pageVo,studentVoList);
    }

    @Override
    public StudentVo getStudent(Long id) {
        Student student = studentRepository.findStudentById(id);
        if (student != null){
            return StudentConverter.toVo(student);
        }
        return null;
    }

    @Override
    public void saveStudent(StudentVo studentVo) {
        Student student = StudentConverter.toPo(studentVo);
        studentRepository.saveAndFlush(student);
    }


    @Override
    public void saveStudent(StdSubVo stdSubVo) {
        Student student = studentRepository.findStudentById(stdSubVo.getStudentVo().getId());
        student.setTotalTotalPrice(stdSubVo.getStudentVo().getTotalTotalPrice());
        List<ScoreVo> scoreList = stdSubVo.getScoreVoList();
        List<Score> checkedScoreList = new ArrayList<>();

        if (scoreList != null){
            for (ScoreVo scoreVo:scoreList) {
                if (scoreVo.getScore() == null){
                    //如果是选课保存，则设置默认分数为0
                    scoreVo.setScore(new BigDecimal("0"));
                    //如果是选课保存，并且信息该条信息没有被选中，则进入跳过该信息
                    if (!scoreVo.isChecked()){
                        continue;
                    }
                }
                Score score = ScoreConverter.toPo(scoreVo);
                ScoreVo existScoreVo = scoreService.getScore(student.getId(), scoreVo.getSubjectId());
                if (existScoreVo != null) {
                    //如果该生选择该门课程信息已经存在，则引用该信息ID，覆盖数据，不会重新创建一条数据
                    score.setId(existScoreVo.getId());
                    if (existScoreVo.getScore().equals(BigDecimal.ZERO)){
                        scoreService.deleteScore(score.getId());
                    }
                }
                score.setStudent(student);
                checkedScoreList.add(score);
            }
        }
        student.setScores(checkedScoreList);
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
