package com.bsnstrip.pojo;

import java.util.ArrayList;
import java.util.List;

public class TPermissionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPermissionExample() {
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

        public Criteria andPermsidIsNull() {
            addCriterion("permsId is null");
            return (Criteria) this;
        }

        public Criteria andPermsidIsNotNull() {
            addCriterion("permsId is not null");
            return (Criteria) this;
        }

        public Criteria andPermsidEqualTo(Integer value) {
            addCriterion("permsId =", value, "permsid");
            return (Criteria) this;
        }

        public Criteria andPermsidNotEqualTo(Integer value) {
            addCriterion("permsId <>", value, "permsid");
            return (Criteria) this;
        }

        public Criteria andPermsidGreaterThan(Integer value) {
            addCriterion("permsId >", value, "permsid");
            return (Criteria) this;
        }

        public Criteria andPermsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("permsId >=", value, "permsid");
            return (Criteria) this;
        }

        public Criteria andPermsidLessThan(Integer value) {
            addCriterion("permsId <", value, "permsid");
            return (Criteria) this;
        }

        public Criteria andPermsidLessThanOrEqualTo(Integer value) {
            addCriterion("permsId <=", value, "permsid");
            return (Criteria) this;
        }

        public Criteria andPermsidIn(List<Integer> values) {
            addCriterion("permsId in", values, "permsid");
            return (Criteria) this;
        }

        public Criteria andPermsidNotIn(List<Integer> values) {
            addCriterion("permsId not in", values, "permsid");
            return (Criteria) this;
        }

        public Criteria andPermsidBetween(Integer value1, Integer value2) {
            addCriterion("permsId between", value1, value2, "permsid");
            return (Criteria) this;
        }

        public Criteria andPermsidNotBetween(Integer value1, Integer value2) {
            addCriterion("permsId not between", value1, value2, "permsid");
            return (Criteria) this;
        }

        public Criteria andPermstypeIsNull() {
            addCriterion("permsType is null");
            return (Criteria) this;
        }

        public Criteria andPermstypeIsNotNull() {
            addCriterion("permsType is not null");
            return (Criteria) this;
        }

        public Criteria andPermstypeEqualTo(String value) {
            addCriterion("permsType =", value, "permstype");
            return (Criteria) this;
        }

        public Criteria andPermstypeNotEqualTo(String value) {
            addCriterion("permsType <>", value, "permstype");
            return (Criteria) this;
        }

        public Criteria andPermstypeGreaterThan(String value) {
            addCriterion("permsType >", value, "permstype");
            return (Criteria) this;
        }

        public Criteria andPermstypeGreaterThanOrEqualTo(String value) {
            addCriterion("permsType >=", value, "permstype");
            return (Criteria) this;
        }

        public Criteria andPermstypeLessThan(String value) {
            addCriterion("permsType <", value, "permstype");
            return (Criteria) this;
        }

        public Criteria andPermstypeLessThanOrEqualTo(String value) {
            addCriterion("permsType <=", value, "permstype");
            return (Criteria) this;
        }

        public Criteria andPermstypeLike(String value) {
            addCriterion("permsType like", value, "permstype");
            return (Criteria) this;
        }

        public Criteria andPermstypeNotLike(String value) {
            addCriterion("permsType not like", value, "permstype");
            return (Criteria) this;
        }

        public Criteria andPermstypeIn(List<String> values) {
            addCriterion("permsType in", values, "permstype");
            return (Criteria) this;
        }

        public Criteria andPermstypeNotIn(List<String> values) {
            addCriterion("permsType not in", values, "permstype");
            return (Criteria) this;
        }

        public Criteria andPermstypeBetween(String value1, String value2) {
            addCriterion("permsType between", value1, value2, "permstype");
            return (Criteria) this;
        }

        public Criteria andPermstypeNotBetween(String value1, String value2) {
            addCriterion("permsType not between", value1, value2, "permstype");
            return (Criteria) this;
        }

        public Criteria andPermsnameIsNull() {
            addCriterion("permsName is null");
            return (Criteria) this;
        }

        public Criteria andPermsnameIsNotNull() {
            addCriterion("permsName is not null");
            return (Criteria) this;
        }

        public Criteria andPermsnameEqualTo(String value) {
            addCriterion("permsName =", value, "permsname");
            return (Criteria) this;
        }

        public Criteria andPermsnameNotEqualTo(String value) {
            addCriterion("permsName <>", value, "permsname");
            return (Criteria) this;
        }

        public Criteria andPermsnameGreaterThan(String value) {
            addCriterion("permsName >", value, "permsname");
            return (Criteria) this;
        }

        public Criteria andPermsnameGreaterThanOrEqualTo(String value) {
            addCriterion("permsName >=", value, "permsname");
            return (Criteria) this;
        }

        public Criteria andPermsnameLessThan(String value) {
            addCriterion("permsName <", value, "permsname");
            return (Criteria) this;
        }

        public Criteria andPermsnameLessThanOrEqualTo(String value) {
            addCriterion("permsName <=", value, "permsname");
            return (Criteria) this;
        }

        public Criteria andPermsnameLike(String value) {
            addCriterion("permsName like", value, "permsname");
            return (Criteria) this;
        }

        public Criteria andPermsnameNotLike(String value) {
            addCriterion("permsName not like", value, "permsname");
            return (Criteria) this;
        }

        public Criteria andPermsnameIn(List<String> values) {
            addCriterion("permsName in", values, "permsname");
            return (Criteria) this;
        }

        public Criteria andPermsnameNotIn(List<String> values) {
            addCriterion("permsName not in", values, "permsname");
            return (Criteria) this;
        }

        public Criteria andPermsnameBetween(String value1, String value2) {
            addCriterion("permsName between", value1, value2, "permsname");
            return (Criteria) this;
        }

        public Criteria andPermsnameNotBetween(String value1, String value2) {
            addCriterion("permsName not between", value1, value2, "permsname");
            return (Criteria) this;
        }

        public Criteria andPermsurlIsNull() {
            addCriterion("permsURL is null");
            return (Criteria) this;
        }

        public Criteria andPermsurlIsNotNull() {
            addCriterion("permsURL is not null");
            return (Criteria) this;
        }

        public Criteria andPermsurlEqualTo(String value) {
            addCriterion("permsURL =", value, "permsurl");
            return (Criteria) this;
        }

        public Criteria andPermsurlNotEqualTo(String value) {
            addCriterion("permsURL <>", value, "permsurl");
            return (Criteria) this;
        }

        public Criteria andPermsurlGreaterThan(String value) {
            addCriterion("permsURL >", value, "permsurl");
            return (Criteria) this;
        }

        public Criteria andPermsurlGreaterThanOrEqualTo(String value) {
            addCriterion("permsURL >=", value, "permsurl");
            return (Criteria) this;
        }

        public Criteria andPermsurlLessThan(String value) {
            addCriterion("permsURL <", value, "permsurl");
            return (Criteria) this;
        }

        public Criteria andPermsurlLessThanOrEqualTo(String value) {
            addCriterion("permsURL <=", value, "permsurl");
            return (Criteria) this;
        }

        public Criteria andPermsurlLike(String value) {
            addCriterion("permsURL like", value, "permsurl");
            return (Criteria) this;
        }

        public Criteria andPermsurlNotLike(String value) {
            addCriterion("permsURL not like", value, "permsurl");
            return (Criteria) this;
        }

        public Criteria andPermsurlIn(List<String> values) {
            addCriterion("permsURL in", values, "permsurl");
            return (Criteria) this;
        }

        public Criteria andPermsurlNotIn(List<String> values) {
            addCriterion("permsURL not in", values, "permsurl");
            return (Criteria) this;
        }

        public Criteria andPermsurlBetween(String value1, String value2) {
            addCriterion("permsURL between", value1, value2, "permsurl");
            return (Criteria) this;
        }

        public Criteria andPermsurlNotBetween(String value1, String value2) {
            addCriterion("permsURL not between", value1, value2, "permsurl");
            return (Criteria) this;
        }

        public Criteria andPermscodeIsNull() {
            addCriterion("permsCode is null");
            return (Criteria) this;
        }

        public Criteria andPermscodeIsNotNull() {
            addCriterion("permsCode is not null");
            return (Criteria) this;
        }

        public Criteria andPermscodeEqualTo(String value) {
            addCriterion("permsCode =", value, "permscode");
            return (Criteria) this;
        }

        public Criteria andPermscodeNotEqualTo(String value) {
            addCriterion("permsCode <>", value, "permscode");
            return (Criteria) this;
        }

        public Criteria andPermscodeGreaterThan(String value) {
            addCriterion("permsCode >", value, "permscode");
            return (Criteria) this;
        }

        public Criteria andPermscodeGreaterThanOrEqualTo(String value) {
            addCriterion("permsCode >=", value, "permscode");
            return (Criteria) this;
        }

        public Criteria andPermscodeLessThan(String value) {
            addCriterion("permsCode <", value, "permscode");
            return (Criteria) this;
        }

        public Criteria andPermscodeLessThanOrEqualTo(String value) {
            addCriterion("permsCode <=", value, "permscode");
            return (Criteria) this;
        }

        public Criteria andPermscodeLike(String value) {
            addCriterion("permsCode like", value, "permscode");
            return (Criteria) this;
        }

        public Criteria andPermscodeNotLike(String value) {
            addCriterion("permsCode not like", value, "permscode");
            return (Criteria) this;
        }

        public Criteria andPermscodeIn(List<String> values) {
            addCriterion("permsCode in", values, "permscode");
            return (Criteria) this;
        }

        public Criteria andPermscodeNotIn(List<String> values) {
            addCriterion("permsCode not in", values, "permscode");
            return (Criteria) this;
        }

        public Criteria andPermscodeBetween(String value1, String value2) {
            addCriterion("permsCode between", value1, value2, "permscode");
            return (Criteria) this;
        }

        public Criteria andPermscodeNotBetween(String value1, String value2) {
            addCriterion("permsCode not between", value1, value2, "permscode");
            return (Criteria) this;
        }

        public Criteria andPermspidIsNull() {
            addCriterion("permsPID is null");
            return (Criteria) this;
        }

        public Criteria andPermspidIsNotNull() {
            addCriterion("permsPID is not null");
            return (Criteria) this;
        }

        public Criteria andPermspidEqualTo(String value) {
            addCriterion("permsPID =", value, "permspid");
            return (Criteria) this;
        }

        public Criteria andPermspidNotEqualTo(String value) {
            addCriterion("permsPID <>", value, "permspid");
            return (Criteria) this;
        }

        public Criteria andPermspidGreaterThan(String value) {
            addCriterion("permsPID >", value, "permspid");
            return (Criteria) this;
        }

        public Criteria andPermspidGreaterThanOrEqualTo(String value) {
            addCriterion("permsPID >=", value, "permspid");
            return (Criteria) this;
        }

        public Criteria andPermspidLessThan(String value) {
            addCriterion("permsPID <", value, "permspid");
            return (Criteria) this;
        }

        public Criteria andPermspidLessThanOrEqualTo(String value) {
            addCriterion("permsPID <=", value, "permspid");
            return (Criteria) this;
        }

        public Criteria andPermspidLike(String value) {
            addCriterion("permsPID like", value, "permspid");
            return (Criteria) this;
        }

        public Criteria andPermspidNotLike(String value) {
            addCriterion("permsPID not like", value, "permspid");
            return (Criteria) this;
        }

        public Criteria andPermspidIn(List<String> values) {
            addCriterion("permsPID in", values, "permspid");
            return (Criteria) this;
        }

        public Criteria andPermspidNotIn(List<String> values) {
            addCriterion("permsPID not in", values, "permspid");
            return (Criteria) this;
        }

        public Criteria andPermspidBetween(String value1, String value2) {
            addCriterion("permsPID between", value1, value2, "permspid");
            return (Criteria) this;
        }

        public Criteria andPermspidNotBetween(String value1, String value2) {
            addCriterion("permsPID not between", value1, value2, "permspid");
            return (Criteria) this;
        }

        public Criteria andPermsseqIsNull() {
            addCriterion("permsSEQ is null");
            return (Criteria) this;
        }

        public Criteria andPermsseqIsNotNull() {
            addCriterion("permsSEQ is not null");
            return (Criteria) this;
        }

        public Criteria andPermsseqEqualTo(Long value) {
            addCriterion("permsSEQ =", value, "permsseq");
            return (Criteria) this;
        }

        public Criteria andPermsseqNotEqualTo(Long value) {
            addCriterion("permsSEQ <>", value, "permsseq");
            return (Criteria) this;
        }

        public Criteria andPermsseqGreaterThan(Long value) {
            addCriterion("permsSEQ >", value, "permsseq");
            return (Criteria) this;
        }

        public Criteria andPermsseqGreaterThanOrEqualTo(Long value) {
            addCriterion("permsSEQ >=", value, "permsseq");
            return (Criteria) this;
        }

        public Criteria andPermsseqLessThan(Long value) {
            addCriterion("permsSEQ <", value, "permsseq");
            return (Criteria) this;
        }

        public Criteria andPermsseqLessThanOrEqualTo(Long value) {
            addCriterion("permsSEQ <=", value, "permsseq");
            return (Criteria) this;
        }

        public Criteria andPermsseqIn(List<Long> values) {
            addCriterion("permsSEQ in", values, "permsseq");
            return (Criteria) this;
        }

        public Criteria andPermsseqNotIn(List<Long> values) {
            addCriterion("permsSEQ not in", values, "permsseq");
            return (Criteria) this;
        }

        public Criteria andPermsseqBetween(Long value1, Long value2) {
            addCriterion("permsSEQ between", value1, value2, "permsseq");
            return (Criteria) this;
        }

        public Criteria andPermsseqNotBetween(Long value1, Long value2) {
            addCriterion("permsSEQ not between", value1, value2, "permsseq");
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