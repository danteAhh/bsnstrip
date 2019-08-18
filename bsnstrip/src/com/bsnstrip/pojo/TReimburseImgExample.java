package com.bsnstrip.pojo;

import java.util.ArrayList;
import java.util.List;

public class TReimburseImgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TReimburseImgExample() {
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

        public Criteria andRbimgidIsNull() {
            addCriterion("rbImgId is null");
            return (Criteria) this;
        }

        public Criteria andRbimgidIsNotNull() {
            addCriterion("rbImgId is not null");
            return (Criteria) this;
        }

        public Criteria andRbimgidEqualTo(Integer value) {
            addCriterion("rbImgId =", value, "rbimgid");
            return (Criteria) this;
        }

        public Criteria andRbimgidNotEqualTo(Integer value) {
            addCriterion("rbImgId <>", value, "rbimgid");
            return (Criteria) this;
        }

        public Criteria andRbimgidGreaterThan(Integer value) {
            addCriterion("rbImgId >", value, "rbimgid");
            return (Criteria) this;
        }

        public Criteria andRbimgidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rbImgId >=", value, "rbimgid");
            return (Criteria) this;
        }

        public Criteria andRbimgidLessThan(Integer value) {
            addCriterion("rbImgId <", value, "rbimgid");
            return (Criteria) this;
        }

        public Criteria andRbimgidLessThanOrEqualTo(Integer value) {
            addCriterion("rbImgId <=", value, "rbimgid");
            return (Criteria) this;
        }

        public Criteria andRbimgidIn(List<Integer> values) {
            addCriterion("rbImgId in", values, "rbimgid");
            return (Criteria) this;
        }

        public Criteria andRbimgidNotIn(List<Integer> values) {
            addCriterion("rbImgId not in", values, "rbimgid");
            return (Criteria) this;
        }

        public Criteria andRbimgidBetween(Integer value1, Integer value2) {
            addCriterion("rbImgId between", value1, value2, "rbimgid");
            return (Criteria) this;
        }

        public Criteria andRbimgidNotBetween(Integer value1, Integer value2) {
            addCriterion("rbImgId not between", value1, value2, "rbimgid");
            return (Criteria) this;
        }

        public Criteria andRbimgpathIsNull() {
            addCriterion("rbImgPath is null");
            return (Criteria) this;
        }

        public Criteria andRbimgpathIsNotNull() {
            addCriterion("rbImgPath is not null");
            return (Criteria) this;
        }

        public Criteria andRbimgpathEqualTo(String value) {
            addCriterion("rbImgPath =", value, "rbimgpath");
            return (Criteria) this;
        }

        public Criteria andRbimgpathNotEqualTo(String value) {
            addCriterion("rbImgPath <>", value, "rbimgpath");
            return (Criteria) this;
        }

        public Criteria andRbimgpathGreaterThan(String value) {
            addCriterion("rbImgPath >", value, "rbimgpath");
            return (Criteria) this;
        }

        public Criteria andRbimgpathGreaterThanOrEqualTo(String value) {
            addCriterion("rbImgPath >=", value, "rbimgpath");
            return (Criteria) this;
        }

        public Criteria andRbimgpathLessThan(String value) {
            addCriterion("rbImgPath <", value, "rbimgpath");
            return (Criteria) this;
        }

        public Criteria andRbimgpathLessThanOrEqualTo(String value) {
            addCriterion("rbImgPath <=", value, "rbimgpath");
            return (Criteria) this;
        }

        public Criteria andRbimgpathLike(String value) {
            addCriterion("rbImgPath like", value, "rbimgpath");
            return (Criteria) this;
        }

        public Criteria andRbimgpathNotLike(String value) {
            addCriterion("rbImgPath not like", value, "rbimgpath");
            return (Criteria) this;
        }

        public Criteria andRbimgpathIn(List<String> values) {
            addCriterion("rbImgPath in", values, "rbimgpath");
            return (Criteria) this;
        }

        public Criteria andRbimgpathNotIn(List<String> values) {
            addCriterion("rbImgPath not in", values, "rbimgpath");
            return (Criteria) this;
        }

        public Criteria andRbimgpathBetween(String value1, String value2) {
            addCriterion("rbImgPath between", value1, value2, "rbimgpath");
            return (Criteria) this;
        }

        public Criteria andRbimgpathNotBetween(String value1, String value2) {
            addCriterion("rbImgPath not between", value1, value2, "rbimgpath");
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