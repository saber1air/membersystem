package com.deliver.entity;

import com.deliver.model.BaseObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by pdl on 2018/9/13.
 */

@Entity
@Table(name="tc_course_plan")
public class CoursePlan extends BaseObject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer planID;

    @Column(nullable=true)
    private Integer courseID;
    @Column(nullable=true)
    private Date courseTime;
    @Column(columnDefinition="int default 0",nullable=true)
    private Integer finishFlag=0;
    @Column(columnDefinition="int default 0",nullable=true)
    private Integer deleteFlag=0;
    @Column(nullable=true)
    private String remarks;

    @Column(nullable=true)
    private Integer schoolID;

    public Integer getPlanID() {
        return planID;
    }

    public void setPlanID(Integer planID) {
        this.planID = planID;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public Date getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(Date courseTime) {
        this.courseTime = courseTime;
    }

    public Integer getFinishFlag() {
        return finishFlag;
    }

    public void setFinishFlag(Integer finishFlag) {
        this.finishFlag = finishFlag;
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
        return "CoursePlan{" +
                "planID=" + planID +
                ", courseID=" + courseID +
                ", courseTime=" + courseTime +
                ", finishFlag=" + finishFlag +
                ", deleteFlag=" + deleteFlag +
                ", remarks='" + remarks + '\'' +
                ", schoolID=" + schoolID +
                '}';
    }
}
