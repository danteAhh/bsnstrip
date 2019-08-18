package com.bsnstrip.pojo;

import java.util.ArrayList;
import java.util.List;

public class TEmployeeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TEmployeeExample() {
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

        public Criteria andEmpidIsNull() {
            addCriterion("empId is null");
            return (Criteria) this;
        }

        public Criteria andEmpidIsNotNull() {
            addCriterion("empId is not null");
            return (Criteria) this;
        }

        public Criteria andEmpidEqualTo(Integer value) {
            addCriterion("empId =", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotEqualTo(Integer value) {
            addCriterion("empId <>", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidGreaterThan(Integer value) {
            addCriterion("empId >", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidGreaterThanOrEqualTo(Integer value) {
            addCriterion("empId >=", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidLessThan(Integer value) {
            addCriterion("empId <", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidLessThanOrEqualTo(Integer value) {
            addCriterion("empId <=", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidIn(List<Integer> values) {
            addCriterion("empId in", values, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotIn(List<Integer> values) {
            addCriterion("empId not in", values, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidBetween(Integer value1, Integer value2) {
            addCriterion("empId between", value1, value2, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotBetween(Integer value1, Integer value2) {
            addCriterion("empId not between", value1, value2, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpnameIsNull() {
            addCriterion("empName is null");
            return (Criteria) this;
        }

        public Criteria andEmpnameIsNotNull() {
            addCriterion("empName is not null");
            return (Criteria) this;
        }

        public Criteria andEmpnameEqualTo(String value) {
            addCriterion("empName =", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameNotEqualTo(String value) {
            addCriterion("empName <>", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameGreaterThan(String value) {
            addCriterion("empName >", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameGreaterThanOrEqualTo(String value) {
            addCriterion("empName >=", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameLessThan(String value) {
            addCriterion("empName <", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameLessThanOrEqualTo(String value) {
            addCriterion("empName <=", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameLike(String value) {
            addCriterion("empName like", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameNotLike(String value) {
            addCriterion("empName not like", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameIn(List<String> values) {
            addCriterion("empName in", values, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameNotIn(List<String> values) {
            addCriterion("empName not in", values, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameBetween(String value1, String value2) {
            addCriterion("empName between", value1, value2, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameNotBetween(String value1, String value2) {
            addCriterion("empName not between", value1, value2, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpageIsNull() {
            addCriterion("empAge is null");
            return (Criteria) this;
        }

        public Criteria andEmpageIsNotNull() {
            addCriterion("empAge is not null");
            return (Criteria) this;
        }

        public Criteria andEmpageEqualTo(String value) {
            addCriterion("empAge =", value, "empage");
            return (Criteria) this;
        }

        public Criteria andEmpageNotEqualTo(String value) {
            addCriterion("empAge <>", value, "empage");
            return (Criteria) this;
        }

        public Criteria andEmpageGreaterThan(String value) {
            addCriterion("empAge >", value, "empage");
            return (Criteria) this;
        }

        public Criteria andEmpageGreaterThanOrEqualTo(String value) {
            addCriterion("empAge >=", value, "empage");
            return (Criteria) this;
        }

        public Criteria andEmpageLessThan(String value) {
            addCriterion("empAge <", value, "empage");
            return (Criteria) this;
        }

        public Criteria andEmpageLessThanOrEqualTo(String value) {
            addCriterion("empAge <=", value, "empage");
            return (Criteria) this;
        }

        public Criteria andEmpageLike(String value) {
            addCriterion("empAge like", value, "empage");
            return (Criteria) this;
        }

        public Criteria andEmpageNotLike(String value) {
            addCriterion("empAge not like", value, "empage");
            return (Criteria) this;
        }

        public Criteria andEmpageIn(List<String> values) {
            addCriterion("empAge in", values, "empage");
            return (Criteria) this;
        }

        public Criteria andEmpageNotIn(List<String> values) {
            addCriterion("empAge not in", values, "empage");
            return (Criteria) this;
        }

        public Criteria andEmpageBetween(String value1, String value2) {
            addCriterion("empAge between", value1, value2, "empage");
            return (Criteria) this;
        }

        public Criteria andEmpageNotBetween(String value1, String value2) {
            addCriterion("empAge not between", value1, value2, "empage");
            return (Criteria) this;
        }

        public Criteria andEmpsexIsNull() {
            addCriterion("empSex is null");
            return (Criteria) this;
        }

        public Criteria andEmpsexIsNotNull() {
            addCriterion("empSex is not null");
            return (Criteria) this;
        }

        public Criteria andEmpsexEqualTo(String value) {
            addCriterion("empSex =", value, "empsex");
            return (Criteria) this;
        }

        public Criteria andEmpsexNotEqualTo(String value) {
            addCriterion("empSex <>", value, "empsex");
            return (Criteria) this;
        }

        public Criteria andEmpsexGreaterThan(String value) {
            addCriterion("empSex >", value, "empsex");
            return (Criteria) this;
        }

        public Criteria andEmpsexGreaterThanOrEqualTo(String value) {
            addCriterion("empSex >=", value, "empsex");
            return (Criteria) this;
        }

        public Criteria andEmpsexLessThan(String value) {
            addCriterion("empSex <", value, "empsex");
            return (Criteria) this;
        }

        public Criteria andEmpsexLessThanOrEqualTo(String value) {
            addCriterion("empSex <=", value, "empsex");
            return (Criteria) this;
        }

        public Criteria andEmpsexLike(String value) {
            addCriterion("empSex like", value, "empsex");
            return (Criteria) this;
        }

        public Criteria andEmpsexNotLike(String value) {
            addCriterion("empSex not like", value, "empsex");
            return (Criteria) this;
        }

        public Criteria andEmpsexIn(List<String> values) {
            addCriterion("empSex in", values, "empsex");
            return (Criteria) this;
        }

        public Criteria andEmpsexNotIn(List<String> values) {
            addCriterion("empSex not in", values, "empsex");
            return (Criteria) this;
        }

        public Criteria andEmpsexBetween(String value1, String value2) {
            addCriterion("empSex between", value1, value2, "empsex");
            return (Criteria) this;
        }

        public Criteria andEmpsexNotBetween(String value1, String value2) {
            addCriterion("empSex not between", value1, value2, "empsex");
            return (Criteria) this;
        }

        public Criteria andEmpphoneIsNull() {
            addCriterion("empPhone is null");
            return (Criteria) this;
        }

        public Criteria andEmpphoneIsNotNull() {
            addCriterion("empPhone is not null");
            return (Criteria) this;
        }

        public Criteria andEmpphoneEqualTo(String value) {
            addCriterion("empPhone =", value, "empphone");
            return (Criteria) this;
        }

        public Criteria andEmpphoneNotEqualTo(String value) {
            addCriterion("empPhone <>", value, "empphone");
            return (Criteria) this;
        }

        public Criteria andEmpphoneGreaterThan(String value) {
            addCriterion("empPhone >", value, "empphone");
            return (Criteria) this;
        }

        public Criteria andEmpphoneGreaterThanOrEqualTo(String value) {
            addCriterion("empPhone >=", value, "empphone");
            return (Criteria) this;
        }

        public Criteria andEmpphoneLessThan(String value) {
            addCriterion("empPhone <", value, "empphone");
            return (Criteria) this;
        }

        public Criteria andEmpphoneLessThanOrEqualTo(String value) {
            addCriterion("empPhone <=", value, "empphone");
            return (Criteria) this;
        }

        public Criteria andEmpphoneLike(String value) {
            addCriterion("empPhone like", value, "empphone");
            return (Criteria) this;
        }

        public Criteria andEmpphoneNotLike(String value) {
            addCriterion("empPhone not like", value, "empphone");
            return (Criteria) this;
        }

        public Criteria andEmpphoneIn(List<String> values) {
            addCriterion("empPhone in", values, "empphone");
            return (Criteria) this;
        }

        public Criteria andEmpphoneNotIn(List<String> values) {
            addCriterion("empPhone not in", values, "empphone");
            return (Criteria) this;
        }

        public Criteria andEmpphoneBetween(String value1, String value2) {
            addCriterion("empPhone between", value1, value2, "empphone");
            return (Criteria) this;
        }

        public Criteria andEmpphoneNotBetween(String value1, String value2) {
            addCriterion("empPhone not between", value1, value2, "empphone");
            return (Criteria) this;
        }

        public Criteria andEmpplaceIsNull() {
            addCriterion("empPlace is null");
            return (Criteria) this;
        }

        public Criteria andEmpplaceIsNotNull() {
            addCriterion("empPlace is not null");
            return (Criteria) this;
        }

        public Criteria andEmpplaceEqualTo(String value) {
            addCriterion("empPlace =", value, "empplace");
            return (Criteria) this;
        }

        public Criteria andEmpplaceNotEqualTo(String value) {
            addCriterion("empPlace <>", value, "empplace");
            return (Criteria) this;
        }

        public Criteria andEmpplaceGreaterThan(String value) {
            addCriterion("empPlace >", value, "empplace");
            return (Criteria) this;
        }

        public Criteria andEmpplaceGreaterThanOrEqualTo(String value) {
            addCriterion("empPlace >=", value, "empplace");
            return (Criteria) this;
        }

        public Criteria andEmpplaceLessThan(String value) {
            addCriterion("empPlace <", value, "empplace");
            return (Criteria) this;
        }

        public Criteria andEmpplaceLessThanOrEqualTo(String value) {
            addCriterion("empPlace <=", value, "empplace");
            return (Criteria) this;
        }

        public Criteria andEmpplaceLike(String value) {
            addCriterion("empPlace like", value, "empplace");
            return (Criteria) this;
        }

        public Criteria andEmpplaceNotLike(String value) {
            addCriterion("empPlace not like", value, "empplace");
            return (Criteria) this;
        }

        public Criteria andEmpplaceIn(List<String> values) {
            addCriterion("empPlace in", values, "empplace");
            return (Criteria) this;
        }

        public Criteria andEmpplaceNotIn(List<String> values) {
            addCriterion("empPlace not in", values, "empplace");
            return (Criteria) this;
        }

        public Criteria andEmpplaceBetween(String value1, String value2) {
            addCriterion("empPlace between", value1, value2, "empplace");
            return (Criteria) this;
        }

        public Criteria andEmpplaceNotBetween(String value1, String value2) {
            addCriterion("empPlace not between", value1, value2, "empplace");
            return (Criteria) this;
        }

        public Criteria andEmpcodeIsNull() {
            addCriterion("empCode is null");
            return (Criteria) this;
        }

        public Criteria andEmpcodeIsNotNull() {
            addCriterion("empCode is not null");
            return (Criteria) this;
        }

        public Criteria andEmpcodeEqualTo(String value) {
            addCriterion("empCode =", value, "empcode");
            return (Criteria) this;
        }

        public Criteria andEmpcodeNotEqualTo(String value) {
            addCriterion("empCode <>", value, "empcode");
            return (Criteria) this;
        }

        public Criteria andEmpcodeGreaterThan(String value) {
            addCriterion("empCode >", value, "empcode");
            return (Criteria) this;
        }

        public Criteria andEmpcodeGreaterThanOrEqualTo(String value) {
            addCriterion("empCode >=", value, "empcode");
            return (Criteria) this;
        }

        public Criteria andEmpcodeLessThan(String value) {
            addCriterion("empCode <", value, "empcode");
            return (Criteria) this;
        }

        public Criteria andEmpcodeLessThanOrEqualTo(String value) {
            addCriterion("empCode <=", value, "empcode");
            return (Criteria) this;
        }

        public Criteria andEmpcodeLike(String value) {
            addCriterion("empCode like", value, "empcode");
            return (Criteria) this;
        }

        public Criteria andEmpcodeNotLike(String value) {
            addCriterion("empCode not like", value, "empcode");
            return (Criteria) this;
        }

        public Criteria andEmpcodeIn(List<String> values) {
            addCriterion("empCode in", values, "empcode");
            return (Criteria) this;
        }

        public Criteria andEmpcodeNotIn(List<String> values) {
            addCriterion("empCode not in", values, "empcode");
            return (Criteria) this;
        }

        public Criteria andEmpcodeBetween(String value1, String value2) {
            addCriterion("empCode between", value1, value2, "empcode");
            return (Criteria) this;
        }

        public Criteria andEmpcodeNotBetween(String value1, String value2) {
            addCriterion("empCode not between", value1, value2, "empcode");
            return (Criteria) this;
        }

        public Criteria andEmpdegreeIsNull() {
            addCriterion("empDegree is null");
            return (Criteria) this;
        }

        public Criteria andEmpdegreeIsNotNull() {
            addCriterion("empDegree is not null");
            return (Criteria) this;
        }

        public Criteria andEmpdegreeEqualTo(String value) {
            addCriterion("empDegree =", value, "empdegree");
            return (Criteria) this;
        }

        public Criteria andEmpdegreeNotEqualTo(String value) {
            addCriterion("empDegree <>", value, "empdegree");
            return (Criteria) this;
        }

        public Criteria andEmpdegreeGreaterThan(String value) {
            addCriterion("empDegree >", value, "empdegree");
            return (Criteria) this;
        }

        public Criteria andEmpdegreeGreaterThanOrEqualTo(String value) {
            addCriterion("empDegree >=", value, "empdegree");
            return (Criteria) this;
        }

        public Criteria andEmpdegreeLessThan(String value) {
            addCriterion("empDegree <", value, "empdegree");
            return (Criteria) this;
        }

        public Criteria andEmpdegreeLessThanOrEqualTo(String value) {
            addCriterion("empDegree <=", value, "empdegree");
            return (Criteria) this;
        }

        public Criteria andEmpdegreeLike(String value) {
            addCriterion("empDegree like", value, "empdegree");
            return (Criteria) this;
        }

        public Criteria andEmpdegreeNotLike(String value) {
            addCriterion("empDegree not like", value, "empdegree");
            return (Criteria) this;
        }

        public Criteria andEmpdegreeIn(List<String> values) {
            addCriterion("empDegree in", values, "empdegree");
            return (Criteria) this;
        }

        public Criteria andEmpdegreeNotIn(List<String> values) {
            addCriterion("empDegree not in", values, "empdegree");
            return (Criteria) this;
        }

        public Criteria andEmpdegreeBetween(String value1, String value2) {
            addCriterion("empDegree between", value1, value2, "empdegree");
            return (Criteria) this;
        }

        public Criteria andEmpdegreeNotBetween(String value1, String value2) {
            addCriterion("empDegree not between", value1, value2, "empdegree");
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