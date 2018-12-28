package com.biz.std.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * 客户po
 * Student class
 * @author junzhang
 * @date 2018-12-20
 */
@Entity
@Table(name = "student",indexes = {@Index(columnList = "id", unique = true)})
public class Student extends BaseEntity implements Serializable{

    /**
     * 姓名
     */
    @Column(length = 20,nullable = false)
    private String name;

    /**
     * 照片
     */
    @Column()
    private String picture;

    /**
     * 性别
     */
    @Column(length = 1)
    private Integer sex;

    /**
     * 生日
     */
    @Column()
    private Date birthday;

    /**
     * 所在班级
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gradeId",nullable = false)
    private Grade grade;

//    /**
//     * 选修科目
//     */
//    @ManyToMany(cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
//    @JoinTable(name = "std_sub",
//            joinColumns = {@JoinColumn(name = "studentId",referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "subjectId",referencedColumnName = "id")},
//            uniqueConstraints = {@UniqueConstraint(columnNames = {"studentId","subjectId"})})
//    private List<Subject> subjects = new ArrayList<>();

    /**
     * 分数
     */
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Score> scores = new ArrayList<>();

    private Integer isPaid;

    /**
     * 应付金额
     */
    private BigDecimal totalTotalPrice;

    private BigDecimal paidMoney;

    public Integer getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Integer isPaid) {
        this.isPaid = isPaid;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
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
