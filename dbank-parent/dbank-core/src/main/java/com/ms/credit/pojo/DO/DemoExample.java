package com.ms.credit.pojo.DO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DemoExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DemoExample() {
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

    protected abstract static class GeneratedCriteria implements Serializable {
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

        public Criteria andDemoIdIsNull() {
            addCriterion("DEMO_ID is null");
            return (Criteria) this;
        }

        public Criteria andDemoIdIsNotNull() {
            addCriterion("DEMO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDemoIdEqualTo(String value) {
            addCriterion("DEMO_ID =", value, "demoId");
            return (Criteria) this;
        }

        public Criteria andDemoIdNotEqualTo(String value) {
            addCriterion("DEMO_ID <>", value, "demoId");
            return (Criteria) this;
        }

        public Criteria andDemoIdGreaterThan(String value) {
            addCriterion("DEMO_ID >", value, "demoId");
            return (Criteria) this;
        }

        public Criteria andDemoIdGreaterThanOrEqualTo(String value) {
            addCriterion("DEMO_ID >=", value, "demoId");
            return (Criteria) this;
        }

        public Criteria andDemoIdLessThan(String value) {
            addCriterion("DEMO_ID <", value, "demoId");
            return (Criteria) this;
        }

        public Criteria andDemoIdLessThanOrEqualTo(String value) {
            addCriterion("DEMO_ID <=", value, "demoId");
            return (Criteria) this;
        }

        public Criteria andDemoIdLike(String value) {
            addCriterion("DEMO_ID like", value, "demoId");
            return (Criteria) this;
        }

        public Criteria andDemoIdNotLike(String value) {
            addCriterion("DEMO_ID not like", value, "demoId");
            return (Criteria) this;
        }

        public Criteria andDemoIdIn(List<String> values) {
            addCriterion("DEMO_ID in", values, "demoId");
            return (Criteria) this;
        }

        public Criteria andDemoIdNotIn(List<String> values) {
            addCriterion("DEMO_ID not in", values, "demoId");
            return (Criteria) this;
        }

        public Criteria andDemoIdBetween(String value1, String value2) {
            addCriterion("DEMO_ID between", value1, value2, "demoId");
            return (Criteria) this;
        }

        public Criteria andDemoIdNotBetween(String value1, String value2) {
            addCriterion("DEMO_ID not between", value1, value2, "demoId");
            return (Criteria) this;
        }

        public Criteria andDemoNameIsNull() {
            addCriterion("DEMO_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDemoNameIsNotNull() {
            addCriterion("DEMO_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDemoNameEqualTo(String value) {
            addCriterion("DEMO_NAME =", value, "demoName");
            return (Criteria) this;
        }

        public Criteria andDemoNameNotEqualTo(String value) {
            addCriterion("DEMO_NAME <>", value, "demoName");
            return (Criteria) this;
        }

        public Criteria andDemoNameGreaterThan(String value) {
            addCriterion("DEMO_NAME >", value, "demoName");
            return (Criteria) this;
        }

        public Criteria andDemoNameGreaterThanOrEqualTo(String value) {
            addCriterion("DEMO_NAME >=", value, "demoName");
            return (Criteria) this;
        }

        public Criteria andDemoNameLessThan(String value) {
            addCriterion("DEMO_NAME <", value, "demoName");
            return (Criteria) this;
        }

        public Criteria andDemoNameLessThanOrEqualTo(String value) {
            addCriterion("DEMO_NAME <=", value, "demoName");
            return (Criteria) this;
        }

        public Criteria andDemoNameLike(String value) {
            addCriterion("DEMO_NAME like", value, "demoName");
            return (Criteria) this;
        }

        public Criteria andDemoNameNotLike(String value) {
            addCriterion("DEMO_NAME not like", value, "demoName");
            return (Criteria) this;
        }

        public Criteria andDemoNameIn(List<String> values) {
            addCriterion("DEMO_NAME in", values, "demoName");
            return (Criteria) this;
        }

        public Criteria andDemoNameNotIn(List<String> values) {
            addCriterion("DEMO_NAME not in", values, "demoName");
            return (Criteria) this;
        }

        public Criteria andDemoNameBetween(String value1, String value2) {
            addCriterion("DEMO_NAME between", value1, value2, "demoName");
            return (Criteria) this;
        }

        public Criteria andDemoNameNotBetween(String value1, String value2) {
            addCriterion("DEMO_NAME not between", value1, value2, "demoName");
            return (Criteria) this;
        }

        public Criteria andDemoMobileIsNull() {
            addCriterion("DEMO_MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andDemoMobileIsNotNull() {
            addCriterion("DEMO_MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andDemoMobileEqualTo(String value) {
            addCriterion("DEMO_MOBILE =", value, "demoMobile");
            return (Criteria) this;
        }

        public Criteria andDemoMobileNotEqualTo(String value) {
            addCriterion("DEMO_MOBILE <>", value, "demoMobile");
            return (Criteria) this;
        }

        public Criteria andDemoMobileGreaterThan(String value) {
            addCriterion("DEMO_MOBILE >", value, "demoMobile");
            return (Criteria) this;
        }

        public Criteria andDemoMobileGreaterThanOrEqualTo(String value) {
            addCriterion("DEMO_MOBILE >=", value, "demoMobile");
            return (Criteria) this;
        }

        public Criteria andDemoMobileLessThan(String value) {
            addCriterion("DEMO_MOBILE <", value, "demoMobile");
            return (Criteria) this;
        }

        public Criteria andDemoMobileLessThanOrEqualTo(String value) {
            addCriterion("DEMO_MOBILE <=", value, "demoMobile");
            return (Criteria) this;
        }

        public Criteria andDemoMobileLike(String value) {
            addCriterion("DEMO_MOBILE like", value, "demoMobile");
            return (Criteria) this;
        }

        public Criteria andDemoMobileNotLike(String value) {
            addCriterion("DEMO_MOBILE not like", value, "demoMobile");
            return (Criteria) this;
        }

        public Criteria andDemoMobileIn(List<String> values) {
            addCriterion("DEMO_MOBILE in", values, "demoMobile");
            return (Criteria) this;
        }

        public Criteria andDemoMobileNotIn(List<String> values) {
            addCriterion("DEMO_MOBILE not in", values, "demoMobile");
            return (Criteria) this;
        }

        public Criteria andDemoMobileBetween(String value1, String value2) {
            addCriterion("DEMO_MOBILE between", value1, value2, "demoMobile");
            return (Criteria) this;
        }

        public Criteria andDemoMobileNotBetween(String value1, String value2) {
            addCriterion("DEMO_MOBILE not between", value1, value2, "demoMobile");
            return (Criteria) this;
        }

        public Criteria andDemoEmailIsNull() {
            addCriterion("DEMO_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andDemoEmailIsNotNull() {
            addCriterion("DEMO_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andDemoEmailEqualTo(String value) {
            addCriterion("DEMO_EMAIL =", value, "demoEmail");
            return (Criteria) this;
        }

        public Criteria andDemoEmailNotEqualTo(String value) {
            addCriterion("DEMO_EMAIL <>", value, "demoEmail");
            return (Criteria) this;
        }

        public Criteria andDemoEmailGreaterThan(String value) {
            addCriterion("DEMO_EMAIL >", value, "demoEmail");
            return (Criteria) this;
        }

        public Criteria andDemoEmailGreaterThanOrEqualTo(String value) {
            addCriterion("DEMO_EMAIL >=", value, "demoEmail");
            return (Criteria) this;
        }

        public Criteria andDemoEmailLessThan(String value) {
            addCriterion("DEMO_EMAIL <", value, "demoEmail");
            return (Criteria) this;
        }

        public Criteria andDemoEmailLessThanOrEqualTo(String value) {
            addCriterion("DEMO_EMAIL <=", value, "demoEmail");
            return (Criteria) this;
        }

        public Criteria andDemoEmailLike(String value) {
            addCriterion("DEMO_EMAIL like", value, "demoEmail");
            return (Criteria) this;
        }

        public Criteria andDemoEmailNotLike(String value) {
            addCriterion("DEMO_EMAIL not like", value, "demoEmail");
            return (Criteria) this;
        }

        public Criteria andDemoEmailIn(List<String> values) {
            addCriterion("DEMO_EMAIL in", values, "demoEmail");
            return (Criteria) this;
        }

        public Criteria andDemoEmailNotIn(List<String> values) {
            addCriterion("DEMO_EMAIL not in", values, "demoEmail");
            return (Criteria) this;
        }

        public Criteria andDemoEmailBetween(String value1, String value2) {
            addCriterion("DEMO_EMAIL between", value1, value2, "demoEmail");
            return (Criteria) this;
        }

        public Criteria andDemoEmailNotBetween(String value1, String value2) {
            addCriterion("DEMO_EMAIL not between", value1, value2, "demoEmail");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
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