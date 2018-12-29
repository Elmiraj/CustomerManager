package com.biz.std.repository;

import com.biz.std.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * GradeRepository class
 * @author junzhang
 * @date 2018-12-29
 */

public interface GradeRepository extends JpaRepository<Grade,Long>,JpaSpecificationExecutor<Grade> {

    /**
     * 通过班级名查找班级信息
     */
    Grade getGradeByName(String name);

    Grade findGradeById(Long id);

}
