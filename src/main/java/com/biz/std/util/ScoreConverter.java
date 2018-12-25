package com.biz.std.util;

import com.biz.std.model.Score;
import com.biz.std.model.Student;
import com.biz.std.model.Subject;
import com.biz.std.vo.score.ScoreVo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * ScoreConverter class
 * @author junzhang
 * @date 2018-12-25
 */

public class ScoreConverter {

    private ScoreConverter(){
        super();
    }

    /**
     * 分数po转vo
     */
    public static ScoreVo toVo(Score score){
        ScoreVo scoreVo = new ScoreVo();
        scoreVo.setId(score.getId());
        scoreVo.setStudentId(score.getStudent().getId());
        scoreVo.setStudentName(score.getStudent().getName());
        scoreVo.setSubjectId(score.getSubject().getId());
        scoreVo.setSubjectName(score.getSubject().getName());
        scoreVo.setScore(score.getScore());
        scoreVo.setStock(score.getSubject().getStock());
        scoreVo.setPrice(score.getSubject().getPrice());
        if (scoreVo.getPrice() == null){
            scoreVo.setPrice(BigDecimal.ONE);
        }
        scoreVo.setTotalPrice(score.getScore().multiply(scoreVo.getPrice()).setScale(2,BigDecimal.ROUND_HALF_UP));
        return scoreVo;
    }

    /**
     * 分数vo转po
     */
    public static Score toPo(ScoreVo scoreVo){
        Score score = new Score();
        score.setId(scoreVo.getId());
        score.setStock(scoreVo.getStock());
        Student student = new Student();
        student.setId(scoreVo.getStudentId());
        score.setStudent(student);
        Subject subject = new Subject();
        subject.setId(scoreVo.getSubjectId());
        score.setSubject(subject);
        score.setScore(scoreVo.getScore());
        subject.setStock(scoreVo.getStock());
        return score;
    }

    /**
     * 分数vo集合转po集合
     */
    static List<Score> toPoList(List<ScoreVo> scoreVoList){
        List<Score> scoreList = new ArrayList<>();
        if (scoreVoList != null){
            for (ScoreVo scoreVo:scoreVoList) {
                scoreList.add(toPo(scoreVo));
            }
        }
        return scoreList;
    }

    /**
     * 分数po集合转vo集合
     */
    public static List<ScoreVo> toVoList(List<Score> scoreList){
        List<ScoreVo> scoreVoList = new ArrayList<>();
        for (Score score:scoreList) {
            scoreVoList.add(toVo(score));
        }
        return scoreVoList;
    }

}
