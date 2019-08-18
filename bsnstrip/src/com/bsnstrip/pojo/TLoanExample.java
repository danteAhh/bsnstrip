package com.bsnstrip.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TLoanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TLoanExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andLoanidIsNull() {
            addCriterion("loanId is null");
            return (Criteria) this;
        }

        public Criteria andLoanidIsNotNull() {
            addCriterion("loanId is not null");
            return (Criteria) this;
        }

        public Criteria andLoanidEqualTo(Integer value) {
            addCriterion("loanId =", value, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidNotEqualTo(Integer value) {
            addCriterion("loanId <>", value, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidGreaterThan(Integer value) {
            addCriterion("loanId >", value, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidGreaterThanOrEqualTo(Integer value) {
            addCriterion("loanId >=", value, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidLessThan(Integer value) {
            addCriterion("loanId <", value, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidLessThanOrEqualTo(Integer value) {
            addCriterion("loanId <=", value, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidIn(List<Integer> values) {
            addCriterion("loanId in", values, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidNotIn(List<Integer> values) {
            addCriterion("loanId not in", values, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidBetween(Integer value1, Integer value2) {
            addCriterion("loanId between", value1, value2, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidNotBetween(Integer value1, Integer value2) {
            addCriterion("loanId not between", value1, value2, "loanid");
            return (Criteria) this;
        }

        public Criteria andBsidIsNull() {
            addCriterion("bsId is null");
            return (Criteria) this;
        }

        public Criteria andBsidIsNotNull() {
            addCriterion("bsId is not null");
            return (Criteria) this;
        }

        public Criteria andBsidEqualTo(Integer value) {
            addCriterion("bsId =", value, "bsid");
            return (Criteria) this;
        }

        public Criteria andBsidNotEqualTo(Integer value) {
            addCriterion("bsId <>", value, "bsid");
            return (Criteria) this;
        }

        public Criteria andBsidGreaterThan(Integer value) {
            addCriterion("bsId >", value, "bsid");
            return (Criteria) this;
        }

        public Criteria andBsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("bsId >=", value, "bsid");
            return (Criteria) this;
        }

        public Criteria andBsidLessThan(Integer value) {
            addCriterion("bsId <", value, "bsid");
            return (Criteria) this;
        }

        public Criteria andBsidLessThanOrEqualTo(Integer value) {
            addCriterion("bsId <=", value, "bsid");
            return (Criteria) this;
        }

        public Criteria andBsidIn(List<Integer> values) {
            addCriterion("bsId in", values, "bsid");
            return (Criteria) this;
        }

        public Criteria andBsidNotIn(List<Integer> values) {
            addCriterion("bsId not in", values, "bsid");
            return (Criteria) this;
        }

        public Criteria andBsidBetween(Integer value1, Integer value2) {
            addCriterion("bsId between", value1, value2, "bsid");
            return (Criteria) this;
        }

        public Criteria andBsidNotBetween(Integer value1, Integer value2) {
            addCriterion("bsId not between", value1, value2, "bsid");
            return (Criteria) this;
        }

        public Criteria andLoantitleIsNull() {
            addCriterion("loanTitle is null");
            return (Criteria) this;
        }

        public Criteria andLoantitleIsNotNull() {
            addCriterion("loanTitle is not null");
            return (Criteria) this;
        }

        public Criteria andLoantitleEqualTo(String value) {
            addCriterion("loanTitle =", value, "loantitle");
            return (Criteria) this;
        }

        public Criteria andLoantitleNotEqualTo(String value) {
            addCriterion("loanTitle <>", value, "loantitle");
            return (Criteria) this;
        }

        public Criteria andLoantitleGreaterThan(String value) {
            addCriterion("loanTitle >", value, "loantitle");
            return (Criteria) this;
        }

        public Criteria andLoantitleGreaterThanOrEqualTo(String value) {
            addCriterion("loanTitle >=", value, "loantitle");
            return (Criteria) this;
        }

        public Criteria andLoantitleLessThan(String value) {
            addCriterion("loanTitle <", value, "loantitle");
            return (Criteria) this;
        }

        public Criteria andLoantitleLessThanOrEqualTo(String value) {
            addCriterion("loanTitle <=", value, "loantitle");
            return (Criteria) this;
        }

        public Criteria andLoantitleLike(String value) {
            addCriterion("loanTitle like", value, "loantitle");
            return (Criteria) this;
        }

        public Criteria andLoantitleNotLike(String value) {
            addCriterion("loanTitle not like", value, "loantitle");
            return (Criteria) this;
        }

        public Criteria andLoantitleIn(List<String> values) {
            addCriterion("loanTitle in", values, "loantitle");
            return (Criteria) this;
        }

        public Criteria andLoantitleNotIn(List<String> values) {
            addCriterion("loanTitle not in", values, "loantitle");
            return (Criteria) this;
        }

        public Criteria andLoantitleBetween(String value1, String value2) {
            addCriterion("loanTitle between", value1, value2, "loantitle");
            return (Criteria) this;
        }

        public Criteria andLoantitleNotBetween(String value1, String value2) {
            addCriterion("loanTitle not between", value1, value2, "loantitle");
            return (Criteria) this;
        }

        public Criteria andLoanfeeIsNull() {
            addCriterion("loanFee is null");
            return (Criteria) this;
        }

        public Criteria andLoanfeeIsNotNull() {
            addCriterion("loanFee is not null");
            return (Criteria) this;
        }

        public Criteria andLoanfeeEqualTo(Integer value) {
            addCriterion("loanFee =", value, "loanfee");
            return (Criteria) this;
        }

        public Criteria andLoanfeeNotEqualTo(Integer value) {
            addCriterion("loanFee <>", value, "loanfee");
            return (Criteria) this;
        }

        public Criteria andLoanfeeGreaterThan(Integer value) {
            addCriterion("loanFee >", value, "loanfee");
            return (Criteria) this;
        }

        public Criteria andLoanfeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("loanFee >=", value, "loanfee");
            return (Criteria) this;
        }

        public Criteria andLoanfeeLessThan(Integer value) {
            addCriterion("loanFee <", value, "loanfee");
            return (Criteria) this;
        }

        public Criteria andLoanfeeLessThanOrEqualTo(Integer value) {
            addCriterion("loanFee <=", value, "loanfee");
            return (Criteria) this;
        }

        public Criteria andLoanfeeIn(List<Integer> values) {
            addCriterion("loanFee in", values, "loanfee");
            return (Criteria) this;
        }

        public Criteria andLoanfeeNotIn(List<Integer> values) {
            addCriterion("loanFee not in", values, "loanfee");
            return (Criteria) this;
        }

        public Criteria andLoanfeeBetween(Integer value1, Integer value2) {
            addCriterion("loanFee between", value1, value2, "loanfee");
            return (Criteria) this;
        }

        public Criteria andLoanfeeNotBetween(Integer value1, Integer value2) {
            addCriterion("loanFee not between", value1, value2, "loanfee");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andApplydateIsNull() {
            addCriterion("applyDate is null");
            return (Criteria) this;
        }

        public Criteria andApplydateIsNotNull() {
            addCriterion("applyDate is not null");
            return (Criteria) this;
        }

        public Criteria andApplydateEqualTo(Date value) {
            addCriterion("applyDate =", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateNotEqualTo(Date value) {
            addCriterion("applyDate <>", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateGreaterThan(Date value) {
            addCriterion("applyDate >", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateGreaterThanOrEqualTo(Date value) {
            addCriterion("applyDate >=", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateLessThan(Date value) {
            addCriterion("applyDate <", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateLessThanOrEqualTo(Date value) {
            addCriterion("applyDate <=", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateIn(List<Date> values) {
            addCriterion("applyDate in", values, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateNotIn(List<Date> values) {
            addCriterion("applyDate not in", values, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateBetween(Date value1, Date value2) {
            addCriterion("applyDate between", value1, value2, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateNotBetween(Date value1, Date value2) {
            addCriterion("applyDate not between", value1, value2, "applydate");
            return (Criteria) this;
        }

        public Criteria andDealdateIsNull() {
            addCriterion("dealDate is null");
            return (Criteria) this;
        }

        public Criteria andDealdateIsNotNull() {
            addCriterion("dealDate is not null");
            return (Criteria) this;
        }

        public Criteria andDealdateEqualTo(Date value) {
            addCriterion("dealDate =", value, "dealdate");
            return (Criteria) this;
        }

        public Criteria andDealdateNotEqualTo(Date value) {
            addCriterion("dealDate <>", value, "dealdate");
            return (Criteria) this;
        }

        public Criteria andDealdateGreaterThan(Date value) {
            addCriterion("dealDate >", value, "dealdate");
            return (Criteria) this;
        }

        public Criteria andDealdateGreaterThanOrEqualTo(Date value) {
            addCriterion("dealDate >=", value, "dealdate");
            return (Criteria) this;
        }

        public Criteria andDealdateLessThan(Date value) {
            addCriterion("dealDate <", value, "dealdate");
            return (Criteria) this;
        }

        public Criteria andDealdateLessThanOrEqualTo(Date value) {
            addCriterion("dealDate <=", value, "dealdate");
            return (Criteria) this;
        }

        public Criteria andDealdateIn(List<Date> values) {
            addCriterion("dealDate in", values, "dealdate");
            return (Criteria) this;
        }

        public Criteria andDealdateNotIn(List<Date> values) {
            addCriterion("dealDate not in", values, "dealdate");
            return (Criteria) this;
        }

        public Criteria andDealdateBetween(Date value1, Date value2) {
            addCriterion("dealDate between", value1, value2, "dealdate");
            return (Criteria) this;
        }

        public Criteria andDealdateNotBetween(Date value1, Date value2) {
            addCriterion("dealDate not between", value1, value2, "dealdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateIsNull() {
            addCriterion("checkDate is null");
            return (Criteria) this;
        }

        public Criteria andCheckdateIsNotNull() {
            addCriterion("checkDate is not null");
            return (Criteria) this;
        }

        public Criteria andCheckdateEqualTo(Date value) {
            addCriterion("checkDate =", value, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateNotEqualTo(Date value) {
            addCriterion("checkDate <>", value, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateGreaterThan(Date value) {
            addCriterion("checkDate >", value, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateGreaterThanOrEqualTo(Date value) {
            addCriterion("checkDate >=", value, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateLessThan(Date value) {
            addCriterion("checkDate <", value, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateLessThanOrEqualTo(Date value) {
            addCriterion("checkDate <=", value, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateIn(List<Date> values) {
            addCriterion("checkDate in", values, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateNotIn(List<Date> values) {
            addCriterion("checkDate not in", values, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateBetween(Date value1, Date value2) {
            addCriterion("checkDate between", value1, value2, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateNotBetween(Date value1, Date value2) {
            addCriterion("checkDate not between", value1, value2, "checkdate");
            return (Criteria) this;
        }

        public Criteria andBackIsNull() {
            addCriterion("back is null");
            return (Criteria) this;
        }

        public Criteria andBackIsNotNull() {
            addCriterion("back is not null");
            return (Criteria) this;
        }

        public Criteria andBackEqualTo(String value) {
            addCriterion("back =", value, "back");
            return (Criteria) this;
        }

        public Criteria andBackNotEqualTo(String value) {
            addCriterion("back <>", value, "back");
            return (Criteria) this;
        }

        public Criteria andBackGreaterThan(String value) {
            addCriterion("back >", value, "back");
            return (Criteria) this;
        }

        public Criteria andBackGreaterThanOrEqualTo(String value) {
            addCriterion("back >=", value, "back");
            return (Criteria) this;
        }

        public Criteria andBackLessThan(String value) {
            addCriterion("back <", value, "back");
            return (Criteria) this;
        }

        public Criteria andBackLessThanOrEqualTo(String value) {
            addCriterion("back <=", value, "back");
            return (Criteria) this;
        }

        public Criteria andBackLike(String value) {
            addCriterion("back like", value, "back");
            return (Criteria) this;
        }

        public Criteria andBackNotLike(String value) {
            addCriterion("back not like", value, "back");
            return (Criteria) this;
        }

        public Criteria andBackIn(List<String> values) {
            addCriterion("back in", values, "back");
            return (Criteria) this;
        }

        public Criteria andBackNotIn(List<String> values) {
            addCriterion("back not in", values, "back");
            return (Criteria) this;
        }

        public Criteria andBackBetween(String value1, String value2) {
            addCriterion("back between", value1, value2, "back");
            return (Criteria) this;
        }

        public Criteria andBackNotBetween(String value1, String value2) {
            addCriterion("back not between", value1, value2, "back");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andIsrepayIsNull() {
            addCriterion("isrepay is null");
            return (Criteria) this;
        }

        public Criteria andIsrepayIsNotNull() {
            addCriterion("isrepay is not null");
            return (Criteria) this;
        }

        public Criteria andIsrepayEqualTo(String value) {
            addCriterion("isrepay =", value, "isrepay");
            return (Criteria) this;
        }

        public Criteria andIsrepayNotEqualTo(String value) {
            addCriterion("isrepay <>", value, "isrepay");
            return (Criteria) this;
        }

        public Criteria andIsrepayGreaterThan(String value) {
            addCriterion("isrepay >", value, "isrepay");
            return (Criteria) this;
        }

        public Criteria andIsrepayGreaterThanOrEqualTo(String value) {
            addCriterion("isrepay >=", value, "isrepay");
            return (Criteria) this;
        }

        public Criteria andIsrepayLessThan(String value) {
            addCriterion("isrepay <", value, "isrepay");
            return (Criteria) this;
        }

        public Criteria andIsrepayLessThanOrEqualTo(String value) {
            addCriterion("isrepay <=", value, "isrepay");
            return (Criteria) this;
        }

        public Criteria andIsrepayLike(String value) {
            addCriterion("isrepay like", value, "isrepay");
            return (Criteria) this;
        }

        public Criteria andIsrepayNotLike(String value) {
            addCriterion("isrepay not like", value, "isrepay");
            return (Criteria) this;
        }

        public Criteria andIsrepayIn(List<String> values) {
            addCriterion("isrepay in", values, "isrepay");
            return (Criteria) this;
        }

        public Criteria andIsrepayNotIn(List<String> values) {
            addCriterion("isrepay not in", values, "isrepay");
            return (Criteria) this;
        }

        public Criteria andIsrepayBetween(String value1, String value2) {
            addCriterion("isrepay between", value1, value2, "isrepay");
            return (Criteria) this;
        }

        public Criteria andIsrepayNotBetween(String value1, String value2) {
            addCriterion("isrepay not between", value1, value2, "isrepay");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}