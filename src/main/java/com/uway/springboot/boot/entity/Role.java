package com.uway.springboot.boot.entity;


import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.context.annotation.Lazy;

/**
 * Created by uwayxs on 2017/11/7.
 */
@Entity
public class Role implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;

    private String role;

    private String discription;

    private Boolean available = Boolean.FALSE; // 是否可用,如果不可用将不会添加给用户

    @Lazy(false)
    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.REFRESH})
    @JoinTable(name = "RolePermission"
            ,joinColumns = {@JoinColumn(name = "roleId")}
            ,inverseJoinColumns = {@JoinColumn(name = "permissionId")})
    private List<Permission> permissions;


    @ManyToMany
    @JoinTable(name = "UserRoles"
            ,joinColumns = {@JoinColumn(name = "roleId")}
            ,inverseJoinColumns = {@JoinColumn(name = "uid")})
    private List<UserInfo> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<UserInfo> getUsers() {
        return users;
    }

    public void setUsers(List<UserInfo> users) {
        this.users = users;
    }
}
