package com.bsnstrip.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TBsnstrip {
    private Integer bsid;

    private Integer userid;

    private String bstitle;

    private String status;

    private String back;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date applydate;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dealdate;

    private String isloan;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date begindate;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date enddate;

    private String address;

    private String bscontent;

    public Integer getBsid() {
        return bsid;
    }

    public void setBsid(Integer bsid) {
        this.bsid = bsid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getBstitle() {
        return bstitle;
    }

    public void setBstitle(String bstitle) {
        this.bstitle = bstitle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    public Date getDealdate() {
        return dealdate;
    }

    public void setDealdate(Date dealdate) {
        this.dealdate = dealdate;
    }

    public String getIsloan() {
        return isloan;
    }

    public void setIsloan(String isloan) {
        this.isloan = isloan;
    }

    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBscontent() {
        return bscontent;
    }

    public void setBscontent(String bscontent) {
        this.bscontent = bscontent;
    }
}