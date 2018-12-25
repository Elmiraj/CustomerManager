package com.biz.std.service;

import com.biz.std.vo.score.ScoreVo;

import java.util.List;

/**
 * 对分数进行操作的服务类
 */
public interface ScoreService {

    /**
     * getScore
     * 获取指定学生指定科目的分数
     * @param studentId Long
     * @param subjectId Long
     * @return ScoreVo
     */
    ScoreVo getScore(Long studentId,Long subjectId);

    /**
     * 查询订货数量列表
     * @param id Long
     * @return List<Score>
     */
    List<ScoreVo> findScoreList(Long id);
}
