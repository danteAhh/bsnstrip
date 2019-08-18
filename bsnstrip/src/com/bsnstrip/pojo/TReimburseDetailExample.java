package com.bsnstrip.pojo;

import java.util.ArrayList;
import java.util.List;

public class TReimburseDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TReimburseDetailExample() {
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

        public Criteria andRbdidIsNull() {
            addCriterion("rbdId is null");
            return (Criteria) this;
        }

        public Criteria andRbdidIsNotNull() {
            addCriterion("rbdId is not null");
            return (Criteria) this;
        }

        public Criteria andRbdidEqualTo(Integer value) {
            addCriterion("rbdId =", value, "rbdid");
            return (Criteria) this;
        }

        public Criteria andRbdidNotEqualTo(Integer value) {
            addCriterion("rbdId <>", value, "rbdid");
            return (Criteria) this;
        }

        public Criteria andRbdidGreaterThan(Integer value) {
            addCriterion("rbdId >", value, "rbdid");
            return (Criteria) this;
        }

        public Criteria andRbdidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rbdId >=", value, "rbdid");
            return (Criteria) this;
        }

        public Criteria andRbdidLessThan(Integer value) {
            addCriterion("rbdId <", value, "rbdid");
            return (Criteria) this;
        }

        public Criteria andRbdidLessThanOrEqualTo(Integer value) {
            addCriterion("rbdId <=", value, "rbdid");
            return (Criteria) this;
        }

        public Criteria andRbdidIn(List<Integer> values) {
            addCriterion("rbdId in", values, "rbdid");
            return (Criteria) this;
        }

        public Criteria andRbdidNotIn(List<Integer> values) {
            addCriterion("rbdId not in", values, "rbdid");
            return (Criteria) this;
        }

        public Criteria andRbdidBetween(Integer value1, Integer value2) {
            addCriterion("rbdId between", value1, value2, "rbdid");
            return (Criteria) this;
        }

        public Criteria andRbdidNotBetween(Integer value1, Integer value2) {
            addCriterion("rbdId not between", value1, value2, "rbdid");
            return (Criteria) this;
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

        public Criteria andRbditemIsNull() {
            addCriterion("rbdItem is null");
            return (Criteria) this;
        }

        public Criteria andRbditemIsNotNull() {
            addCriterion("rbdItem is not null");
            return (Criteria) this;
        }

        public Criteria andRbditemEqualTo(String value) {
            addCriterion("rbdItem =", value, "rbditem");
            return (Criteria) this;
        }

        public Criteria andRbditemNotEqualTo(String value) {
            addCriterion("rbdItem <>", value, "rbditem");
            return (Criteria) this;
        }

        public Criteria andRbditemGreaterThan(String value) {
            addCriterion("rbdItem >", value, "rbditem");
            return (Criteria) this;
        }

        public Criteria andRbditemGreaterThanOrEqualTo(String value) {
            addCriterion("rbdItem >=", value, "rbditem");
            return (Criteria) this;
        }

        public Criteria andRbditemLessThan(String value) {
            addCriterion("rbdItem <", value, "rbditem");
            return (Criteria) this;
        }

        public Criteria andRbditemLessThanOrEqualTo(String value) {
            addCriterion("rbdItem <=", value, "rbditem");
            return (Criteria) this;
        }

        public Criteria andRbditemLike(String value) {
            addCriterion("rbdItem like", value, "rbditem");
            return (Criteria) this;
        }

        public Criteria andRbditemNotLike(String value) {
            addCriterion("rbdItem not like", value, "rbditem");
            return (Criteria) this;
        }

        public Criteria andRbditemIn(List<String> values) {
            addCriterion("rbdItem in", values, "rbditem");
            return (Criteria) this;
        }

        public Criteria andRbditemNotIn(List<String> values) {
            addCriterion("rbdItem not in", values, "rbditem");
            return (Criteria) this;
        }

        public Criteria andRbditemBetween(String value1, String value2) {
            addCriterion("rbdItem between", value1, value2, "rbditem");
            return (Criteria) this;
        }

        public Criteria andRbditemNotBetween(String value1, String value2) {
            addCriterion("rbdItem not between", value1, value2, "rbditem");
            return (Criteria) this;
        }

        public Criteria andRbdnumIsNull() {
            addCriterion("rbdNum is null");
            return (Criteria) this;
        }

        public Criteria andRbdnumIsNotNull() {
            addCriterion("rbdNum is not null");
            return (Criteria) this;
        }

        public Criteria andRbdnumEqualTo(Integer value) {
            addCriterion("rbdNum =", value, "rbdnum");
            return (Criteria) this;
        }

        public Criteria andRbdnumNotEqualTo(Integer value) {
            addCriterion("rbdNum <>", value, "rbdnum");
            return (Criteria) this;
        }

        public Criteria andRbdnumGreaterThan(Integer value) {
            addCriterion("rbdNum >", value, "rbdnum");
            return (Criteria) this;
        }

        public Criteria andRbdnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("rbdNum >=", value, "rbdnum");
            return (Criteria) this;
        }

        public Criteria andRbdnumLessThan(Integer value) {
            addCriterion("rbdNum <", value, "rbdnum");
            return (Criteria) this;
        }

        public Criteria andRbdnumLessThanOrEqualTo(Integer value) {
            addCriterion("rbdNum <=", value, "rbdnum");
            return (Criteria) this;
        }

        public Criteria andRbdnumIn(List<Integer> values) {
            addCriterion("rbdNum in", values, "rbdnum");
            return (Criteria) this;
        }

        public Criteria andRbdnumNotIn(List<Integer> values) {
            addCriterion("rbdNum not in", values, "rbdnum");
            return (Criteria) this;
        }

        public Criteria andRbdnumBetween(Integer value1, Integer value2) {
            addCriterion("rbdNum between", value1, value2, "rbdnum");
            return (Criteria) this;
        }

        public Criteria andRbdnumNotBetween(Integer value1, Integer value2) {
            addCriterion("rbdNum not between", value1, value2, "rbdnum");
            return (Criteria) this;
        }

        public Criteria andRbdfeeIsNull() {
            addCriterion("rbdfee is null");
            return (Criteria) this;
        }

        public Criteria andRbdfeeIsNotNull() {
            addCriterion("rbdfee is not null");
            return (Criteria) this;
        }

        public Criteria andRbdfeeEqualTo(Integer value) {
            addCriterion("rbdfee =", value, "rbdfee");
            return (Criteria) this;
        }

        public Criteria andRbdfeeNotEqualTo(Integer value) {
            addCriterion("rbdfee <>", value, "rbdfee");
            return (Criteria) this;
        }

        public Criteria andRbdfeeGreaterThan(Integer value) {
            addCriterion("rbdfee >", value, "rbdfee");
            return (Criteria) this;
        }

        public Criteria andRbdfeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("rbdfee >=", value, "rbdfee");
            return (Criteria) this;
        }

        public Criteria andRbdfeeLessThan(Integer value) {
            addCriterion("rbdfee <", value, "rbdfee");
            return (Criteria) this;
        }

        public Criteria andRbdfeeLessThanOrEqualTo(Integer value) {
            addCriterion("rbdfee <=", value, "rbdfee");
            return (Criteria) this;
        }

        public Criteria andRbdfeeIn(List<Integer> values) {
            addCriterion("rbdfee in", values, "rbdfee");
            return (Criteria) this;
        }

        public Criteria andRbdfeeNotIn(List<Integer> values) {
            addCriterion("rbdfee not in", values, "rbdfee");
            return (Criteria) this;
        }

        public Criteria andRbdfeeBetween(Integer value1, Integer value2) {
            addCriterion("rbdfee between", value1, value2, "rbdfee");
            return (Criteria) this;
        }

        public Criteria andRbdfeeNotBetween(Integer value1, Integer value2) {
            addCriterion("rbdfee not between", value1, value2, "rbdfee");
            return (Criteria) this;
        }

        public Criteria andRbdcountIsNull() {
            addCriterion("rbdCount is null");
            return (Criteria) this;
        }

        public Criteria andRbdcountIsNotNull() {
            addCriterion("rbdCount is not null");
            return (Criteria) this;
        }

        public Criteria andRbdcountEqualTo(Integer value) {
            addCriterion("rbdCount =", value, "rbdcount");
            return (Criteria) this;
        }

        public Criteria andRbdcountNotEqualTo(Integer value) {
            addCriterion("rbdCount <>", value, "rbdcount");
            return (Criteria) this;
        }

        public Criteria andRbdcountGreaterThan(Integer value) {
            addCriterion("rbdCount >", value, "rbdcount");
            return (Criteria) this;
        }

        public Criteria andRbdcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("rbdCount >=", value, "rbdcount");
            return (Criteria) this;
        }

        public Criteria andRbdcountLessThan(Integer value) {
            addCriterion("rbdCount <", value, "rbdcount");
            return (Criteria) this;
        }

        public Criteria andRbdcountLessThanOrEqualTo(Integer value) {
            addCriterion("rbdCount <=", value, "rbdcount");
            return (Criteria) this;
        }

        public Criteria andRbdcountIn(List<Integer> values) {
            addCriterion("rbdCount in", values, "rbdcount");
            return (Criteria) this;
        }

        public Criteria andRbdcountNotIn(List<Integer> values) {
            addCriterion("rbdCount not in", values, "rbdcount");
            return (Criteria) this;
        }

        public Criteria andRbdcountBetween(Integer value1, Integer value2) {
            addCriterion("rbdCount between", value1, value2, "rbdcount");
            return (Criteria) this;
        }

        public Criteria andRbdcountNotBetween(Integer value1, Integer value2) {
            addCriterion("rbdCount not between", value1, value2, "rbdcount");
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