package com.biz.std.vo.subject;

import com.biz.std.model.Subject;
import com.biz.std.vo.score.ScoreVo;

import java.math.BigDecimal;
import java.util.List;

/**
 * 学科类
 * SubjectVo class
 * @author junzhang
 * @date 2018-12-18
 */
@SuppressWarnings("unused")
public class SubjectVo {

    /**
     * 科目ID
     */
    private Long id;

    /**
     * 学科名
     */
    private String name;

    /**
     * 选修该课程的人数
     */
    private Integer count;

    /**
     * 订货数
     */
    private BigDecimal score;

    /**
     * 平均分
     */
    private BigDecimal avgScore;

    /**
     * 货物总数
     */
    private BigDecimal totalScore;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 总价
     */
    private BigDecimal totalPrice;

    /**
     * 库存
     */
    private BigDecimal stock;

    public SubjectVo(){
        super();
    }

    public SubjectVo(Subject subject){
        this();
        this.id = subject.getId();
        this.name = subject.getName();
    }

    /**
     * 客户信息列表
     */
    private List<ScoreVo> scoreVoList;

    public void setCount(Integer count) {
        this.count = count;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public List<ScoreVo> getScoreVoList() {
        return scoreVoList;
    }

    public void setScoreVoList(List<ScoreVo> scoreVoList) {
        this.scoreVoList = scoreVoList;
    }
}
