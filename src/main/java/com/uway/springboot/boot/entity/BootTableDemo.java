package com.uway.springboot.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by uwayxs on 2017/11/1.
 */
@Entity
public class BootTableDemo {
    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BootTableDemo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
