package com.biz.std.repository;

import com.biz.std.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject,Long>,JpaSpecificationExecutor<Subject> {


    /**
     * 通过学科名查找班级信息
     */
    Subject getSubjectByName(String name);

    Subject findSubjectById(Long id);

    List<Subject> findAllByOrderByName();
}
