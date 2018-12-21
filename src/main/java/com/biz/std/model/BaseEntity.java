package com.biz.std.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * BaseEntity class
 * @author junzhang
 * @date 2018-12-20
 */

@SuppressWarnings("serial")
@MappedSuperclass
public class BaseEntity implements Serializable{

    @GeneratedValue
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
