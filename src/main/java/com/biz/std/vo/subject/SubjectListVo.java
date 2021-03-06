package com.biz.std.vo.subject;

import com.biz.std.vo.PageVo;

import java.util.List;

/**
 * 学科页面信息VO
 * SubjectListVo class
 * @author junzhang
 * @date 2018-12-18
 */

public class SubjectListVo {

    /**
     * 分页信息VO
     */
    private PageVo pageVo;

    /**
     * 学科信息列表VO
     */
    private List<SubjectVo> subjectVoList;

    private SubjectListVo(){
        super();
    }

    public SubjectListVo(PageVo pageVo, List<SubjectVo> subjectVoList) {
        this();
        this.pageVo = pageVo;
        this.subjectVoList = subjectVoList;
    }

    public PageVo getPageVo() {
        return pageVo;
    }

    public void setPageVo(PageVo pageVo) {
        this.pageVo = pageVo;
    }

    public List<SubjectVo> getSubjectVoList() {
        return subjectVoList;
    }

    public void setSubjectVoList(List<SubjectVo> studentVoList) {
        this.subjectVoList = studentVoList;
    }
}
