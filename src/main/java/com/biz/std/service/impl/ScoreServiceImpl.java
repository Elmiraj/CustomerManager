package com.biz.std.service.impl;

import com.biz.std.model.Score;
import com.biz.std.model.Student;
import com.biz.std.model.Subject;
import com.biz.std.repository.ScoreRepository;
import com.biz.std.service.ScoreService;
import com.biz.std.util.ScoreConverter;
import com.biz.std.vo.score.ScoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ScoreServiceImpl class
 * @author junzhang
 * @date 2018-12-25
 */

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Override
    public ScoreVo getScore(Long studentId, Long subjectId) {
        Student student = new Student();
        student.setId(studentId);
        Subject subject = new Subject();
        subject.setId(subjectId);
        Score score = scoreRepository.getScoreByStudentAndSubject(student, subject);
        if (score != null){
            return ScoreConverter.toVo(score);
        }
        return null;
    }

    @Override
    public List<ScoreVo> findScoreList(Long id){
        List<Score> scoreList = scoreRepository.findAllByStudentId(id);
        return ScoreConverter.toVoList(scoreList);
    }
}
