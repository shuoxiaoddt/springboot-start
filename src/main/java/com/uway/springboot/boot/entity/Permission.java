package com.uway.springboot.boot.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by uwayxs on 2017/11/7.
 */
@Entity
public class Permission implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long id;//主键

    private String name;//名称

    @Column(columnDefinition="enum('menu','button')")
    private String resourceType;//资源类型，[menu|button]

    private String url;//资源url

    private String permission;//权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view

    private long parentId ;//父编号

    private String parents;//父编号列表

    private Boolean available = Boolean.FALSE;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH,mappedBy = "permissions")
    private List<Role> roles;


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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getParents() {
        return parents;
    }

    public void setParents(String parents) {
        this.parents = parents;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }
}
