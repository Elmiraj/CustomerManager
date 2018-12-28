package com.biz.std.vo.student;

import com.biz.std.vo.score.ScoreVo;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * StudentVo class
 * @author junzhang
 * @date 2018-12-26
 */
public class StudentVo {

    /**
     * id
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 照片
     */
    private String picture;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 所在地址
     */
    private String gradeName;

    /**
     * 选择货物数
     */
    private Integer subjectCount;

    /**
     * 平均数
     */
    private BigDecimal avgScore;

    /**
     * 总数
     */
    private BigDecimal totalScore;

    /**
     * 是否付款
     */
    private Integer isPaid;

    /**
     * 应付金额
     */
    private BigDecimal totalTotalPrice;

    /**
     * 实付金额
     */
    private BigDecimal paidMoney;

    public Integer getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Integer isPaid) {
        this.isPaid = isPaid;
    }

    /**
     * 地址ID
     */
    private Long gradeId;

    /**
     * 货物及数量等信息集合
     */
    private List<ScoreVo> scoreVoList;

    public void setSubjectCount(Integer subjectCount) {
        this.subjectCount = subjectCount;
    }

    public Integer getSubjectCount() {
        return subjectCount;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public List<ScoreVo> getScoreVoList() {
        return scoreVoList;
    }

    public void setScoreVoList(List<ScoreVo> scoreVoList) {
        this.scoreVoList = scoreVoList;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public BigDecimal getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(BigDecimal avgScore) {
        this.avgScore = avgScore;
    }

    public BigDecimal getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(BigDecimal totalScore) {
        this.totalScore = totalScore;
    }

    public BigDecimal getTotalTotalPrice() {
        return totalTotalPrice;
    }

    public void setTotalTotalPrice(BigDecimal totalTotalPrice) {
        this.totalTotalPrice = totalTotalPrice;
    }

    public BigDecimal getPaidMoney() {
        return paidMoney;
    }

    public void setPaidMoney(BigDecimal paidMoney) {
        this.paidMoney = paidMoney;
    }
}
