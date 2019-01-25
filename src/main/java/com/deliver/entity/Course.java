package com.deliver.entity;

import com.deliver.model.BaseObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by pdl on 2018/9/13.
 */

@Entity
@Table(name="tc_human_info")
public class HumanInfo extends BaseObject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer humanID;

    @Column(length = 20,nullable=true)
    private String humanName;

    @Column(nullable=true)
    private Date createTime;
    @Column(columnDefinition="int default 0",nullable=true)
    private Integer exitFlag=0;
    @Column(length = 20,nullable=true)
    private String tel;
    @Column(columnDefinition="int default 0",nullable=true)
    private Integer deleteFlag=0;
    @Column(nullable=true)
    private Date updateTime;
    @Column(nullable=true)
    private Integer humanType=-1;
    @Column(nullable=true)
    private Integer schoolID;
    @Column(nullable=true)
    private String remarks;
    @Column(columnDefinition="int default 0",nullable=true)
    private Integer online=0;
    @Column(length = 40,nullable=true)
    private String password;

    @Column(length = 40,nullable=true)
    private String token;
    @Column(length = 40,nullable=true)
    private String clientID;

    @Override
    public String toString() {
        return "HumanInfo{" +
                "humanID=" + humanID +
                ", humanName='" + humanName + '\'' +
                ", createTime=" + createTime +
                ", exitFlag=" + exitFlag +
                ", tel='" + tel + '\'' +
                ", deleteFlag=" + deleteFlag +
                ", updateTime=" + updateTime +
                ", humanType=" + humanType +
                ", schoolID=" + schoolID +
                ", remarks='" + remarks + '\'' +
                ", online=" + online +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                ", clientID='" + clientID + '\'' +
                '}';
    }

    public Integer getHumanID() {
        return humanID;
    }

    public void setHumanID(Integer humanID) {
        this.humanID = humanID;
    }

    public String getHumanName() {
        return humanName;
    }

    public void setHumanName(String humanName) {
        this.humanName = humanName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getExitFlag() {
        return exitFlag;
    }

    public void setExitFlag(Integer exitFlag) {
        this.exitFlag = exitFlag;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getHumanType() {
        return humanType;
    }

    public void setHumanType(Integer humanType) {
        this.humanType = humanType;
    }

    public Integer getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(Integer schoolID) {
        this.schoolID = schoolID;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }
}
