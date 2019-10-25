package com.ms.credit.pojo.DO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SeqConfExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SeqConfExample() {
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

    protected abstract static class GeneratedCriteria implements Serializable{
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

        public Criteria andSeqIdIsNull() {
            addCriterion("SEQ_ID is null");
            return (Criteria) this;
        }

        public Criteria andSeqIdIsNotNull() {
            addCriterion("SEQ_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSeqIdEqualTo(String value) {
            addCriterion("SEQ_ID =", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotEqualTo(String value) {
            addCriterion("SEQ_ID <>", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdGreaterThan(String value) {
            addCriterion("SEQ_ID >", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdGreaterThanOrEqualTo(String value) {
            addCriterion("SEQ_ID >=", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdLessThan(String value) {
            addCriterion("SEQ_ID <", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdLessThanOrEqualTo(String value) {
            addCriterion("SEQ_ID <=", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdLike(String value) {
            addCriterion("SEQ_ID like", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotLike(String value) {
            addCriterion("SEQ_ID not like", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdIn(List<String> values) {
            addCriterion("SEQ_ID in", values, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotIn(List<String> values) {
            addCriterion("SEQ_ID not in", values, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdBetween(String value1, String value2) {
            addCriterion("SEQ_ID between", value1, value2, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotBetween(String value1, String value2) {
            addCriterion("SEQ_ID not between", value1, value2, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqCurrentIsNull() {
            addCriterion("SEQ_CURRENT is null");
            return (Criteria) this;
        }

        public Criteria andSeqCurrentIsNotNull() {
            addCriterion("SEQ_CURRENT is not null");
            return (Criteria) this;
        }

        public Criteria andSeqCurrentEqualTo(Short value) {
            addCriterion("SEQ_CURRENT =", value, "seqCurrent");
            return (Criteria) this;
        }

        public Criteria andSeqCurrentNotEqualTo(Short value) {
            addCriterion("SEQ_CURRENT <>", value, "seqCurrent");
            return (Criteria) this;
        }

        public Criteria andSeqCurrentGreaterThan(Short value) {
            addCriterion("SEQ_CURRENT >", value, "seqCurrent");
            return (Criteria) this;
        }

        public Criteria andSeqCurrentGreaterThanOrEqualTo(Short value) {
            addCriterion("SEQ_CURRENT >=", value, "seqCurrent");
            return (Criteria) this;
        }

        public Criteria andSeqCurrentLessThan(Short value) {
            addCriterion("SEQ_CURRENT <", value, "seqCurrent");
            return (Criteria) this;
        }

        public Criteria andSeqCurrentLessThanOrEqualTo(Short value) {
            addCriterion("SEQ_CURRENT <=", value, "seqCurrent");
            return (Criteria) this;
        }

        public Criteria andSeqCurrentIn(List<Short> values) {
            addCriterion("SEQ_CURRENT in", values, "seqCurrent");
            return (Criteria) this;
        }

        public Criteria andSeqCurrentNotIn(List<Short> values) {
            addCriterion("SEQ_CURRENT not in", values, "seqCurrent");
            return (Criteria) this;
        }

        public Criteria andSeqCurrentBetween(Short value1, Short value2) {
            addCriterion("SEQ_CURRENT between", value1, value2, "seqCurrent");
            return (Criteria) this;
        }

        public Criteria andSeqCurrentNotBetween(Short value1, Short value2) {
            addCriterion("SEQ_CURRENT not between", value1, value2, "seqCurrent");
            return (Criteria) this;
        }

        public Criteria andSeqMaximumIsNull() {
            addCriterion("SEQ_MAXIMUM is null");
            return (Criteria) this;
        }

        public Criteria andSeqMaximumIsNotNull() {
            addCriterion("SEQ_MAXIMUM is not null");
            return (Criteria) this;
        }

        public Criteria andSeqMaximumEqualTo(Short value) {
            addCriterion("SEQ_MAXIMUM =", value, "seqMaximum");
            return (Criteria) this;
        }

        public Criteria andSeqMaximumNotEqualTo(Short value) {
            addCriterion("SEQ_MAXIMUM <>", value, "seqMaximum");
            return (Criteria) this;
        }

        public Criteria andSeqMaximumGreaterThan(Short value) {
            addCriterion("SEQ_MAXIMUM >", value, "seqMaximum");
            return (Criteria) this;
        }

        public Criteria andSeqMaximumGreaterThanOrEqualTo(Short value) {
            addCriterion("SEQ_MAXIMUM >=", value, "seqMaximum");
            return (Criteria) this;
        }

        public Criteria andSeqMaximumLessThan(Short value) {
            addCriterion("SEQ_MAXIMUM <", value, "seqMaximum");
            return (Criteria) this;
        }

        public Criteria andSeqMaximumLessThanOrEqualTo(Short value) {
            addCriterion("SEQ_MAXIMUM <=", value, "seqMaximum");
            return (Criteria) this;
        }

        public Criteria andSeqMaximumIn(List<Short> values) {
            addCriterion("SEQ_MAXIMUM in", values, "seqMaximum");
            return (Criteria) this;
        }

        public Criteria andSeqMaximumNotIn(List<Short> values) {
            addCriterion("SEQ_MAXIMUM not in", values, "seqMaximum");
            return (Criteria) this;
        }

        public Criteria andSeqMaximumBetween(Short value1, Short value2) {
            addCriterion("SEQ_MAXIMUM between", value1, value2, "seqMaximum");
            return (Criteria) this;
        }

        public Criteria andSeqMaximumNotBetween(Short value1, Short value2) {
            addCriterion("SEQ_MAXIMUM not between", value1, value2, "seqMaximum");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable{
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