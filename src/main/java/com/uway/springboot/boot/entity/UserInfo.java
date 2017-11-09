package com.uway.springboot.boot.entity;

import com.uway.springboot.boot.validate.CustomerUserInfoValidate;
import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.springframework.context.annotation.Lazy;

/**
 * Created by uwayxs on 2017/11/7.
 */
@Entity
@CustomerUserInfoValidate
public class UserInfo implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @NotNull
    private long uid;   //uid

    @Column(unique = true)
    private String username;    //账号

    private String name;    //姓名
    private String passpwd; //密码
    private String salt;    //盐
    private byte state; //状态

    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.REFRESH},mappedBy = "users")
    private List<Role> roles;


    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasspwd() {
        return passpwd;
    }

    public void setPasspwd(String passpwd) {
        this.passpwd = passpwd;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    /**
     * 密码盐.
     * @return
     */
    public String getCredentialsSalt(){
        return this.username+this.salt;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", passpwd='" + passpwd + '\'' +
                ", salt='" + salt + '\'' +
                ", state=" + state +
                ", roles=" + roles +
                '}';
    }
}
