package com.uway.springboot.boot.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by uwayxs on 2017/11/10.
 */
@Component
@ConfigurationProperties(prefix = "com.uway.info")
public class PropEntity {
    private String name;//博客作者

    private String title;//博客标题

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "PropEntity{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
