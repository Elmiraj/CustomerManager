package com.biz.std.service.impl;

import com.biz.std.model.Subject;
import com.biz.std.repository.SubjectRepository;
import com.biz.std.service.SubjectService;
import com.biz.std.util.SubjectConverter;
import com.biz.std.util.Utils;
import com.biz.std.vo.PageReqVo;
import com.biz.std.vo.PageVo;
import com.biz.std.vo.subject.SubjectListVo;
import com.biz.std.vo.subject.SubjectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学科信息操作的实现类
 * SubjectServiceImpl class
 * @author junzhang
 * @date 2018-12-21
 */

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<SubjectVo> findSubjectList() {
        List<Subject> subjectList = subjectRepository.findAllByOrderByName();
        return SubjectConverter.toVoList(subjectList);
    }

    @Override
    public SubjectListVo findSubjectList(PageReqVo reqVo) {
        Page<Subject> subjects = subjectRepository.findAll((Specification<Subject>) (root, query, cb) -> null,
                PageRequest.of(reqVo.getPageIndex()-1,reqVo.getPageSize()));
        List<Subject> subject = subjectRepository.findAllByOrderByName();
        List<SubjectVo> subjectVoList = SubjectConverter.toVoList(subject);
        PageVo pageVo = Utils.getPageVo(reqVo,subjects);
        return new SubjectListVo(pageVo,subjectVoList);
    }

    @Override
    public void saveSubject(SubjectVo subjectVo) {
        subjectRepository.save(SubjectConverter.toPo(subjectVo));
    }

    @Override
    public SubjectVo getSubject(String name) {
        Subject subject = subjectRepository.getSubjectByName(name);
        if (subject != null){
            return SubjectConverter.toVo(subject);
        }
        return null;
    }

    @Override
    public SubjectVo getSubject(Long id) {
        Subject subject = subjectRepository.findSubjectById(id);
        if (subject != null){
            return SubjectConverter.toVo(subject);
        }
        return null;
    }

    @Override
    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }
}
