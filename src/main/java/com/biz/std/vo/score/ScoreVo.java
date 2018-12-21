package com.biz.std.vo.score;

import java.math.BigDecimal;

/**
 * 分数VO
 */
public class ScoreVo {

    /**
     * 数据源ID
     */
    private Long id;

    /**
     * 客户ID
     */
    private Long studentId;

    /**
     * 客户姓名
     */
    private String studentName;

    /**
     * 货物ID
     */
    private Long subjectId;

    /**
     * 货物名
     */
    private String subjectName;

    /**
     * 数量
     */
    private BigDecimal score;

    /**
     * 客户订货时货物的选中状态
     */
    private boolean checked;

    /**
     * 总数
     */
    private BigDecimal totalScore;

    /**
     * 货物单价
     */
    private BigDecimal price;

    /**
     * 货物总价
     */
    private BigDecimal totalPrice;

    /**
     * 所有货物的总价
     */
    private BigDecimal totalTotalPrice;

    /**
     * 库存
     */
    private BigDecimal stock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
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

    public BigDecimal getTotalTotalPrice() {
        return totalTotalPrice;
    }

    public void setTotalTotalPrice(BigDecimal totalTotalPrice) {
        this.totalTotalPrice = totalTotalPrice;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }
}
