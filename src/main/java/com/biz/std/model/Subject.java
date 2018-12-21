package com.biz.std.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Subject class
 * @author junzhang
 * @date 2018-12-20
 */
@Entity
@Table(name = "subject",indexes = {@Index(columnList = "id",unique = true)})
public class Subject extends BaseEntity{

    /**
     * 学科名
     */
    @Column(length = 20,nullable = false)
    private String name;

//    /**
//     * 选修该学科的学生
//     */
//    @ManyToMany(mappedBy = "subjects",cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
//    private List<Student> students = new ArrayList<>();

    /**
     * 分数
     */
    @OneToMany(mappedBy = "subject",cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    private List<Score> scores = new ArrayList<>();

    /**
     * 单价
     */
    @Column(length = 20)
    private BigDecimal price;

    @Column(length = 20)
    private BigDecimal stock;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }
}
