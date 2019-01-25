package com.deliver.mapbody;

/**
 * Created by pdl on 2018/9/25.
 */
public class DeliverRecordParam {
    private String humanName;
    private Integer accessType;

    private Integer humanType;
    private String beginTime;
    private String endTime;
    private Integer checkResult;

    public String getHumanName() {
        return humanName;
    }

    public void setHumanName(String humanName) {
        this.humanName = humanName;
    }

    public Integer getAccessType() {
        return accessType;
    }

    public void setAccessType(Integer accessType) {
        this.accessType = accessType;
    }

    public Integer getHumanType() {
        return humanType;
    }

    public void setHumanType(Integer humanType) {
        this.humanType = humanType;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(Integer checkResult) {
        this.checkResult = checkResult;
    }
}
