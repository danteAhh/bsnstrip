package com.bsnstrip.pojo;

import java.util.Date;

public class TLoan {
    private Integer loanid;

    private Integer bsid;

    private String loantitle;

    private Integer loanfee;

    private String status;

    private Date applydate;

    private Date dealdate;

    private Date checkdate;

    private String back;

    private Integer userid;

    private String isrepay;

    private String loancontent;

    public Integer getLoanid() {
        return loanid;
    }

    public void setLoanid(Integer loanid) {
        this.loanid = loanid;
    }

    public Integer getBsid() {
        return bsid;
    }

    public void setBsid(Integer bsid) {
        this.bsid = bsid;
    }

    public String getLoantitle() {
        return loantitle;
    }

    public void setLoantitle(String loantitle) {
        this.loantitle = loantitle;
    }

    public Integer getLoanfee() {
        return loanfee;
    }

    public void setLoanfee(Integer loanfee) {
        this.loanfee = loanfee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getIsrepay() {
        return isrepay;
    }

    public void setIsrepay(String isrepay) {
        this.isrepay = isrepay;
    }

    public String getLoancontent() {
        return loancontent;
    }

    public void setLoancontent(String loancontent) {
        this.loancontent = loancontent;
    }
}