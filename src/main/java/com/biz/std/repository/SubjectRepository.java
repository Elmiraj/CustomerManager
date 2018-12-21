package com.biz.std.repository;

import com.biz.std.model.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.Nullable;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject,Long>,JpaSpecificationExecutor<Subject> {


    /**
     * 通过学科名查找班级信息
     */
    Subject getSubjectByName(String name);

    Subject findSubjectById(Long id);

    List<Subject> findAllByOrderByName();

    Page<Subject> findAllByOrderByName(@Nullable Specification<Subject> var1, Pageable var2);
    // Page<Subject> findAllByOrderByName(Specification<Subject> subjectSpecification, PageRequest pageRequest);
}
