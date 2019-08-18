package com.bsnstrip.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TReimburseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TReimburseExample() {
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

        public Criteria andRbidIsNull() {
            addCriterion("rbId is null");
            return (Criteria) this;
        }

        public Criteria andRbidIsNotNull() {
            addCriterion("rbId is not null");
            return (Criteria) this;
        }

        public Criteria andRbidEqualTo(Integer value) {
            addCriterion("rbId =", value, "rbid");
            return (Criteria) this;
        }

        public Criteria andRbidNotEqualTo(Integer value) {
            addCriterion("rbId <>", value, "rbid");
            return (Criteria) this;
        }

        public Criteria andRbidGreaterThan(Integer value) {
            addCriterion("rbId >", value, "rbid");
            return (Criteria) this;
        }

        public Criteria andRbidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rbId >=", value, "rbid");
            return (Criteria) this;
        }

        public Criteria andRbidLessThan(Integer value) {
            addCriterion("rbId <", value, "rbid");
            return (Criteria) this;
        }

        public Criteria andRbidLessThanOrEqualTo(Integer value) {
            addCriterion("rbId <=", value, "rbid");
            return (Criteria) this;
        }

        public Criteria andRbidIn(List<Integer> values) {
            addCriterion("rbId in", values, "rbid");
            return (Criteria) this;
        }

        public Criteria andRbidNotIn(List<Integer> values) {
            addCriterion("rbId not in", values, "rbid");
            return (Criteria) this;
        }

        public Criteria andRbidBetween(Integer value1, Integer value2) {
            addCriterion("rbId between", value1, value2, "rbid");
            return (Criteria) this;
        }

        public Criteria andRbidNotBetween(Integer value1, Integer value2) {
            addCriterion("rbId not between", value1, value2, "rbid");
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

        public Criteria andRbtitleIsNull() {
            addCriterion("rbTitle is null");
            return (Criteria) this;
        }

        public Criteria andRbtitleIsNotNull() {
            addCriterion("rbTitle is not null");
            return (Criteria) this;
        }

        public Criteria andRbtitleEqualTo(String value) {
            addCriterion("rbTitle =", value, "rbtitle");
            return (Criteria) this;
        }

        public Criteria andRbtitleNotEqualTo(String value) {
            addCriterion("rbTitle <>", value, "rbtitle");
            return (Criteria) this;
        }

        public Criteria andRbtitleGreaterThan(String value) {
            addCriterion("rbTitle >", value, "rbtitle");
            return (Criteria) this;
        }

        public Criteria andRbtitleGreaterThanOrEqualTo(String value) {
            addCriterion("rbTitle >=", value, "rbtitle");
            return (Criteria) this;
        }

        public Criteria andRbtitleLessThan(String value) {
            addCriterion("rbTitle <", value, "rbtitle");
            return (Criteria) this;
        }

        public Criteria andRbtitleLessThanOrEqualTo(String value) {
            addCriterion("rbTitle <=", value, "rbtitle");
            return (Criteria) this;
        }

        public Criteria andRbtitleLike(String value) {
            addCriterion("rbTitle like", value, "rbtitle");
            return (Criteria) this;
        }

        public Criteria andRbtitleNotLike(String value) {
            addCriterion("rbTitle not like", value, "rbtitle");
            return (Criteria) this;
        }

        public Criteria andRbtitleIn(List<String> values) {
            addCriterion("rbTitle in", values, "rbtitle");
            return (Criteria) this;
        }

        public Criteria andRbtitleNotIn(List<String> values) {
            addCriterion("rbTitle not in", values, "rbtitle");
            return (Criteria) this;
        }

        public Criteria andRbtitleBetween(String value1, String value2) {
            addCriterion("rbTitle between", value1, value2, "rbtitle");
            return (Criteria) this;
        }

        public Criteria andRbtitleNotBetween(String value1, String value2) {
            addCriterion("rbTitle not between", value1, value2, "rbtitle");
            return (Criteria) this;
        }

        public Criteria andRbfeeIsNull() {
            addCriterion("rbFee is null");
            return (Criteria) this;
        }

        public Criteria andRbfeeIsNotNull() {
            addCriterion("rbFee is not null");
            return (Criteria) this;
        }

        public Criteria andRbfeeEqualTo(Integer value) {
            addCriterion("rbFee =", value, "rbfee");
            return (Criteria) this;
        }

        public Criteria andRbfeeNotEqualTo(Integer value) {
            addCriterion("rbFee <>", value, "rbfee");
            return (Criteria) this;
        }

        public Criteria andRbfeeGreaterThan(Integer value) {
            addCriterion("rbFee >", value, "rbfee");
            return (Criteria) this;
        }

        public Criteria andRbfeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("rbFee >=", value, "rbfee");
            return (Criteria) this;
        }

        public Criteria andRbfeeLessThan(Integer value) {
            addCriterion("rbFee <", value, "rbfee");
            return (Criteria) this;
        }

        public Criteria andRbfeeLessThanOrEqualTo(Integer value) {
            addCriterion("rbFee <=", value, "rbfee");
            return (Criteria) this;
        }

        public Criteria andRbfeeIn(List<Integer> values) {
            addCriterion("rbFee in", values, "rbfee");
            return (Criteria) this;
        }

        public Criteria andRbfeeNotIn(List<Integer> values) {
            addCriterion("rbFee not in", values, "rbfee");
            return (Criteria) this;
        }

        public Criteria andRbfeeBetween(Integer value1, Integer value2) {
            addCriterion("rbFee between", value1, value2, "rbfee");
            return (Criteria) this;
        }

        public Criteria andRbfeeNotBetween(Integer value1, Integer value2) {
            addCriterion("rbFee not between", value1, value2, "rbfee");
            return (Criteria) this;
        }

        public Criteria andRbtypeIsNull() {
            addCriterion("rbType is null");
            return (Criteria) this;
        }

        public Criteria andRbtypeIsNotNull() {
            addCriterion("rbType is not null");
            return (Criteria) this;
        }

        public Criteria andRbtypeEqualTo(String value) {
            addCriterion("rbType =", value, "rbtype");
            return (Criteria) this;
        }

        public Criteria andRbtypeNotEqualTo(String value) {
            addCriterion("rbType <>", value, "rbtype");
            return (Criteria) this;
        }

        public Criteria andRbtypeGreaterThan(String value) {
            addCriterion("rbType >", value, "rbtype");
            return (Criteria) this;
        }

        public Criteria andRbtypeGreaterThanOrEqualTo(String value) {
            addCriterion("rbType >=", value, "rbtype");
            return (Criteria) this;
        }

        public Criteria andRbtypeLessThan(String value) {
            addCriterion("rbType <", value, "rbtype");
            return (Criteria) this;
        }

        public Criteria andRbtypeLessThanOrEqualTo(String value) {
            addCriterion("rbType <=", value, "rbtype");
            return (Criteria) this;
        }

        public Criteria andRbtypeLike(String value) {
            addCriterion("rbType like", value, "rbtype");
            return (Criteria) this;
        }

        public Criteria andRbtypeNotLike(String value) {
            addCriterion("rbType not like", value, "rbtype");
            return (Criteria) this;
        }

        public Criteria andRbtypeIn(List<String> values) {
            addCriterion("rbType in", values, "rbtype");
            return (Criteria) this;
        }

        public Criteria andRbtypeNotIn(List<String> values) {
            addCriterion("rbType not in", values, "rbtype");
            return (Criteria) this;
        }

        public Criteria andRbtypeBetween(String value1, String value2) {
            addCriterion("rbType between", value1, value2, "rbtype");
            return (Criteria) this;
        }

        public Criteria andRbtypeNotBetween(String value1, String value2) {
            addCriterion("rbType not between", value1, value2, "rbtype");
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

        public Criteria andDeaeldateIsNull() {
            addCriterion("deaelDate is null");
            return (Criteria) this;
        }

        public Criteria andDeaeldateIsNotNull() {
            addCriterion("deaelDate is not null");
            return (Criteria) this;
        }

        public Criteria andDeaeldateEqualTo(Date value) {
            addCriterion("deaelDate =", value, "deaeldate");
            return (Criteria) this;
        }

        public Criteria andDeaeldateNotEqualTo(Date value) {
            addCriterion("deaelDate <>", value, "deaeldate");
            return (Criteria) this;
        }

        public Criteria andDeaeldateGreaterThan(Date value) {
            addCriterion("deaelDate >", value, "deaeldate");
            return (Criteria) this;
        }

        public Criteria andDeaeldateGreaterThanOrEqualTo(Date value) {
            addCriterion("deaelDate >=", value, "deaeldate");
            return (Criteria) this;
        }

        public Criteria andDeaeldateLessThan(Date value) {
            addCriterion("deaelDate <", value, "deaeldate");
            return (Criteria) this;
        }

        public Criteria andDeaeldateLessThanOrEqualTo(Date value) {
            addCriterion("deaelDate <=", value, "deaeldate");
            return (Criteria) this;
        }

        public Criteria andDeaeldateIn(List<Date> values) {
            addCriterion("deaelDate in", values, "deaeldate");
            return (Criteria) this;
        }

        public Criteria andDeaeldateNotIn(List<Date> values) {
            addCriterion("deaelDate not in", values, "deaeldate");
            return (Criteria) this;
        }

        public Criteria andDeaeldateBetween(Date value1, Date value2) {
            addCriterion("deaelDate between", value1, value2, "deaeldate");
            return (Criteria) this;
        }

        public Criteria andDeaeldateNotBetween(Date value1, Date value2) {
            addCriterion("deaelDate not between", value1, value2, "deaeldate");
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