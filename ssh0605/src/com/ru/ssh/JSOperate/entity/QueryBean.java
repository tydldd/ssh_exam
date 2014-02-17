package com.ru.ssh.JSOperate.entity;

/**
 * Description: 这是一个日志查询bean
 * User: NanChengRu
 * Date: 13-11-22
 * Time: 上午11:10
 * JDK: 1.6
 * version: 1.0
 */
public class QueryBean {
    private int id;
    private String taskName;
    private String status;
    private String level;
    private String desr;
    private String beginTime;
    private String endTime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDesr() {
        return desr;
    }

    public void setDesr(String desr) {
        this.desr = desr;
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
}
