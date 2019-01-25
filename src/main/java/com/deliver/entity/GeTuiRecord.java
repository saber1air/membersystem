package com.deliver.entity;

import com.deliver.model.BaseObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by pdl on 2018/9/13.
 */

@Entity
@Table(name="tc_getui_record")
public class GeTueRecord extends BaseObject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer getuiID;

    @Column(nullable=true)
    private Integer humanID;

    @Column(nullable=true)
    private Date getuiTime;
    @Column(length = 100,nullable=true)
    private String message;

    @Column(columnDefinition="int default 0",nullable=true)
    private Integer deleteFlag=0;
    @Column(nullable=true)
    private String remarks;

    @Column(nullable=true)
    private Integer schoolID;

    public Integer getGetuiID() {
        return getuiID;
    }

    public void setGetuiID(Integer getuiID) {
        this.getuiID = getuiID;
    }

    public Integer getHumanID() {
        return humanID;
    }

    public void setHumanID(Integer humanID) {
        this.humanID = humanID;
    }

    public Date getGetuiTime() {
        return getuiTime;
    }

    public void setGetuiTime(Date getuiTime) {
        this.getuiTime = getuiTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(Integer schoolID) {
        this.schoolID = schoolID;
    }

    @Override
    public String toString() {
        return "GeTueRecord{" +
                "getuiID=" + getuiID +
                ", humanID=" + humanID +
                ", getuiTime=" + getuiTime +
                ", message='" + message + '\'' +
                ", deleteFlag=" + deleteFlag +
                ", remarks='" + remarks + '\'' +
                ", schoolID=" + schoolID +
                '}';
    }
}
