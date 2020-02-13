package com.hp.studentsushe.vo;

public class DormInfo {
    /**寝室号*/
    private String dormId;
    /**舍长姓名*/
    private String dormMonitor;
    /**每页条数*/
    private Integer size;
    /**当前页码*/
    private Integer pageCurrent;
    /**开始行*/
    private Integer startRow= 0;

    public DormInfo() {
    }

    public DormInfo(String dormId, String dormMonitor, Integer size, Integer pageCurrent, Integer startRow) {
        this.dormId = dormId;
        this.dormMonitor = dormMonitor;
        this.size = size;
        this.pageCurrent = pageCurrent;
        this.startRow = startRow;
    }

    public String getDormId() {
        return dormId;
    }

    public void setDormId(String dormId) {
        this.dormId = dormId;
    }

    public String getDormMonitor() {
        return dormMonitor;
    }

    public void setDormMonitor(String dormMonitor) {
        this.dormMonitor = dormMonitor;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPageCurrent() {
        return pageCurrent;
    }

    public void setPageCurrent(Integer pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    @Override
    public String toString() {
        return "DormInfo{" +
                "dormId='" + dormId + '\'' +
                ", dormMonitor='" + dormMonitor + '\'' +
                ", size=" + size +
                ", pageCurrent=" + pageCurrent +
                ", startRow=" + startRow +
                '}';
    }
}
