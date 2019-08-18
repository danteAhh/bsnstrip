package com.bsnstrip.pojo;

import java.util.Date;

public class TReimburse {
    private Integer rbid;

    private Integer userid;

    private String rbtitle;

    private Integer rbfee;

    private String rbtype;

    private String status;

    private String back;

    private Date applydate;

    private Date deaeldate;

    private Date checkdate;

    private Integer bsid;

    private String rbcontent;

    public Integer getRbid() {
        return rbid;
    }

    public void setRbid(Integer rbid) {
        this.rbid = rbid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getRbtitle() {
        return rbtitle;
    }

    public void setRbtitle(String rbtitle) {
        this.rbtitle = rbtitle;
    }

    public Integer getRbfee() {
        return rbfee;
    }

    public void setRbfee(Integer rbfee) {
        this.rbfee = rbfee;
    }

    public String getRbtype() {
        return rbtype;
    }

    public void setRbtype(String rbtype) {
        this.rbtype = rbtype;
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

    public Date getDeaeldate() {
        return deaeldate;
    }

    public void setDeaeldate(Date deaeldate) {
        this.deaeldate = deaeldate;
    }

    public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }

    public Integer getBsid() {
        return bsid;
    }

    public void setBsid(Integer bsid) {
        this.bsid = bsid;
    }

    public String getRbcontent() {
        return rbcontent;
    }

    public void setRbcontent(String rbcontent) {
        this.rbcontent = rbcontent;
    }
}