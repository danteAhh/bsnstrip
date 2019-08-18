package com.bsnstrip.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TRepayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TRepayExample() {
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

        public Criteria andRepayidIsNull() {
            addCriterion("repayId is null");
            return (Criteria) this;
        }

        public Criteria andRepayidIsNotNull() {
            addCriterion("repayId is not null");
            return (Criteria) this;
        }

        public Criteria andRepayidEqualTo(Integer value) {
            addCriterion("repayId =", value, "repayid");
            return (Criteria) this;
        }

        public Criteria andRepayidNotEqualTo(Integer value) {
            addCriterion("repayId <>", value, "repayid");
            return (Criteria) this;
        }

        public Criteria andRepayidGreaterThan(Integer value) {
            addCriterion("repayId >", value, "repayid");
            return (Criteria) this;
        }

        public Criteria andRepayidGreaterThanOrEqualTo(Integer value) {
            addCriterion("repayId >=", value, "repayid");
            return (Criteria) this;
        }

        public Criteria andRepayidLessThan(Integer value) {
            addCriterion("repayId <", value, "repayid");
            return (Criteria) this;
        }

        public Criteria andRepayidLessThanOrEqualTo(Integer value) {
            addCriterion("repayId <=", value, "repayid");
            return (Criteria) this;
        }

        public Criteria andRepayidIn(List<Integer> values) {
            addCriterion("repayId in", values, "repayid");
            return (Criteria) this;
        }

        public Criteria andRepayidNotIn(List<Integer> values) {
            addCriterion("repayId not in", values, "repayid");
            return (Criteria) this;
        }

        public Criteria andRepayidBetween(Integer value1, Integer value2) {
            addCriterion("repayId between", value1, value2, "repayid");
            return (Criteria) this;
        }

        public Criteria andRepayidNotBetween(Integer value1, Integer value2) {
            addCriterion("repayId not between", value1, value2, "repayid");
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

        public Criteria andRepaytitleIsNull() {
            addCriterion("repayTitle is null");
            return (Criteria) this;
        }

        public Criteria andRepaytitleIsNotNull() {
            addCriterion("repayTitle is not null");
            return (Criteria) this;
        }

        public Criteria andRepaytitleEqualTo(String value) {
            addCriterion("repayTitle =", value, "repaytitle");
            return (Criteria) this;
        }

        public Criteria andRepaytitleNotEqualTo(String value) {
            addCriterion("repayTitle <>", value, "repaytitle");
            return (Criteria) this;
        }

        public Criteria andRepaytitleGreaterThan(String value) {
            addCriterion("repayTitle >", value, "repaytitle");
            return (Criteria) this;
        }

        public Criteria andRepaytitleGreaterThanOrEqualTo(String value) {
            addCriterion("repayTitle >=", value, "repaytitle");
            return (Criteria) this;
        }

        public Criteria andRepaytitleLessThan(String value) {
            addCriterion("repayTitle <", value, "repaytitle");
            return (Criteria) this;
        }

        public Criteria andRepaytitleLessThanOrEqualTo(String value) {
            addCriterion("repayTitle <=", value, "repaytitle");
            return (Criteria) this;
        }

        public Criteria andRepaytitleLike(String value) {
            addCriterion("repayTitle like", value, "repaytitle");
            return (Criteria) this;
        }

        public Criteria andRepaytitleNotLike(String value) {
            addCriterion("repayTitle not like", value, "repaytitle");
            return (Criteria) this;
        }

        public Criteria andRepaytitleIn(List<String> values) {
            addCriterion("repayTitle in", values, "repaytitle");
            return (Criteria) this;
        }

        public Criteria andRepaytitleNotIn(List<String> values) {
            addCriterion("repayTitle not in", values, "repaytitle");
            return (Criteria) this;
        }

        public Criteria andRepaytitleBetween(String value1, String value2) {
            addCriterion("repayTitle between", value1, value2, "repaytitle");
            return (Criteria) this;
        }

        public Criteria andRepaytitleNotBetween(String value1, String value2) {
            addCriterion("repayTitle not between", value1, value2, "repaytitle");
            return (Criteria) this;
        }

        public Criteria andRepayfeeIsNull() {
            addCriterion("repayFee is null");
            return (Criteria) this;
        }

        public Criteria andRepayfeeIsNotNull() {
            addCriterion("repayFee is not null");
            return (Criteria) this;
        }

        public Criteria andRepayfeeEqualTo(Integer value) {
            addCriterion("repayFee =", value, "repayfee");
            return (Criteria) this;
        }

        public Criteria andRepayfeeNotEqualTo(Integer value) {
            addCriterion("repayFee <>", value, "repayfee");
            return (Criteria) this;
        }

        public Criteria andRepayfeeGreaterThan(Integer value) {
            addCriterion("repayFee >", value, "repayfee");
            return (Criteria) this;
        }

        public Criteria andRepayfeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("repayFee >=", value, "repayfee");
            return (Criteria) this;
        }

        public Criteria andRepayfeeLessThan(Integer value) {
            addCriterion("repayFee <", value, "repayfee");
            return (Criteria) this;
        }

        public Criteria andRepayfeeLessThanOrEqualTo(Integer value) {
            addCriterion("repayFee <=", value, "repayfee");
            return (Criteria) this;
        }

        public Criteria andRepayfeeIn(List<Integer> values) {
            addCriterion("repayFee in", values, "repayfee");
            return (Criteria) this;
        }

        public Criteria andRepayfeeNotIn(List<Integer> values) {
            addCriterion("repayFee not in", values, "repayfee");
            return (Criteria) this;
        }

        public Criteria andRepayfeeBetween(Integer value1, Integer value2) {
            addCriterion("repayFee between", value1, value2, "repayfee");
            return (Criteria) this;
        }

        public Criteria andRepayfeeNotBetween(Integer value1, Integer value2) {
            addCriterion("repayFee not between", value1, value2, "repayfee");
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

        public Criteria andRepaywayIsNull() {
            addCriterion("repayWay is null");
            return (Criteria) this;
        }

        public Criteria andRepaywayIsNotNull() {
            addCriterion("repayWay is not null");
            return (Criteria) this;
        }

        public Criteria andRepaywayEqualTo(String value) {
            addCriterion("repayWay =", value, "repayway");
            return (Criteria) this;
        }

        public Criteria andRepaywayNotEqualTo(String value) {
            addCriterion("repayWay <>", value, "repayway");
            return (Criteria) this;
        }

        public Criteria andRepaywayGreaterThan(String value) {
            addCriterion("repayWay >", value, "repayway");
            return (Criteria) this;
        }

        public Criteria andRepaywayGreaterThanOrEqualTo(String value) {
            addCriterion("repayWay >=", value, "repayway");
            return (Criteria) this;
        }

        public Criteria andRepaywayLessThan(String value) {
            addCriterion("repayWay <", value, "repayway");
            return (Criteria) this;
        }

        public Criteria andRepaywayLessThanOrEqualTo(String value) {
            addCriterion("repayWay <=", value, "repayway");
            return (Criteria) this;
        }

        public Criteria andRepaywayLike(String value) {
            addCriterion("repayWay like", value, "repayway");
            return (Criteria) this;
        }

        public Criteria andRepaywayNotLike(String value) {
            addCriterion("repayWay not like", value, "repayway");
            return (Criteria) this;
        }

        public Criteria andRepaywayIn(List<String> values) {
            addCriterion("repayWay in", values, "repayway");
            return (Criteria) this;
        }

        public Criteria andRepaywayNotIn(List<String> values) {
            addCriterion("repayWay not in", values, "repayway");
            return (Criteria) this;
        }

        public Criteria andRepaywayBetween(String value1, String value2) {
            addCriterion("repayWay between", value1, value2, "repayway");
            return (Criteria) this;
        }

        public Criteria andRepaywayNotBetween(String value1, String value2) {
            addCriterion("repayWay not between", value1, value2, "repayway");
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