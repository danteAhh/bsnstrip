package com.bsnstrip.pojo;

import java.util.Date;

public class TRepay {
    private Integer repayid;

    private Integer userid;

    private Integer loanid;

    private String repaytitle;

    private Integer repayfee;

    private String status;

    private String back;

    private Date applydate;

    private Date checkdate;

    private Date dealdate;

    private String repayway;

    private String repaycontent;

    public Integer getRepayid() {
        return repayid;
    }

    public void setRepayid(Integer repayid) {
        this.repayid = repayid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getLoanid() {
        return loanid;
    }

    public void setLoanid(Integer loanid) {
        this.loanid = loanid;
    }

    public String getRepaytitle() {
        return repaytitle;
    }

    public void setRepaytitle(String repaytitle) {
        this.repaytitle = repaytitle;
    }

    public Integer getRepayfee() {
        return repayfee;
    }

    public void setRepayfee(Integer repayfee) {
        this.repayfee = repayfee;
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

    public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }

    public Date getDealdate() {
        return dealdate;
    }

    public void setDealdate(Date dealdate) {
        this.dealdate = dealdate;
    }

    public String getRepayway() {
        return repayway;
    }

    public void setRepayway(String repayway) {
        this.repayway = repayway;
    }

    public String getRepaycontent() {
        return repaycontent;
    }

    public void setRepaycontent(String repaycontent) {
        this.repaycontent = repaycontent;
    }
}