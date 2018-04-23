package com.tuyue.webModel.comment.bean;

import java.util.List;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/1/9.
 */
public class LeaveWordBean {
    private int id;
    private String fromName;
    private String toName;
    private String userHead;
    private String time;
    private String content;
    private int userType;
    private  int num;//回复条数
    private Integer proveType;//是否认证
    private Integer aid;
    private List<LeaveWordBean> childList;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Integer getProveType() {
        return proveType;
    }

    public void setProveType(Integer proveType) {
        this.proveType = proveType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<LeaveWordBean> getChildList() {
        return childList;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public void setChildList(List<LeaveWordBean> childList) {
        this.childList = childList;
    }
}
