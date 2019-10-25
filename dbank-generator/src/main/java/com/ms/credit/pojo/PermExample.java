package com.ms.credit.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PermExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PermExample() {
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

        public Criteria andPermIdIsNull() {
            addCriterion("PERM_ID is null");
            return (Criteria) this;
        }

        public Criteria andPermIdIsNotNull() {
            addCriterion("PERM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPermIdEqualTo(String value) {
            addCriterion("PERM_ID =", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdNotEqualTo(String value) {
            addCriterion("PERM_ID <>", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdGreaterThan(String value) {
            addCriterion("PERM_ID >", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdGreaterThanOrEqualTo(String value) {
            addCriterion("PERM_ID >=", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdLessThan(String value) {
            addCriterion("PERM_ID <", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdLessThanOrEqualTo(String value) {
            addCriterion("PERM_ID <=", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdLike(String value) {
            addCriterion("PERM_ID like", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdNotLike(String value) {
            addCriterion("PERM_ID not like", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdIn(List<String> values) {
            addCriterion("PERM_ID in", values, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdNotIn(List<String> values) {
            addCriterion("PERM_ID not in", values, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdBetween(String value1, String value2) {
            addCriterion("PERM_ID between", value1, value2, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdNotBetween(String value1, String value2) {
            addCriterion("PERM_ID not between", value1, value2, "permId");
            return (Criteria) this;
        }

        public Criteria andPermNameIsNull() {
            addCriterion("PERM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPermNameIsNotNull() {
            addCriterion("PERM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPermNameEqualTo(String value) {
            addCriterion("PERM_NAME =", value, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameNotEqualTo(String value) {
            addCriterion("PERM_NAME <>", value, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameGreaterThan(String value) {
            addCriterion("PERM_NAME >", value, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameGreaterThanOrEqualTo(String value) {
            addCriterion("PERM_NAME >=", value, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameLessThan(String value) {
            addCriterion("PERM_NAME <", value, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameLessThanOrEqualTo(String value) {
            addCriterion("PERM_NAME <=", value, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameLike(String value) {
            addCriterion("PERM_NAME like", value, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameNotLike(String value) {
            addCriterion("PERM_NAME not like", value, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameIn(List<String> values) {
            addCriterion("PERM_NAME in", values, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameNotIn(List<String> values) {
            addCriterion("PERM_NAME not in", values, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameBetween(String value1, String value2) {
            addCriterion("PERM_NAME between", value1, value2, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameNotBetween(String value1, String value2) {
            addCriterion("PERM_NAME not between", value1, value2, "permName");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("DESCRIPTION =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("DESCRIPTION <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("DESCRIPTION >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("DESCRIPTION <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("DESCRIPTION like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("DESCRIPTION not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("DESCRIPTION in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("DESCRIPTION not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("DESCRIPTION between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("DESCRIPTION not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andParentPermIdIsNull() {
            addCriterion("PARENT_PERM_ID is null");
            return (Criteria) this;
        }

        public Criteria andParentPermIdIsNotNull() {
            addCriterion("PARENT_PERM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParentPermIdEqualTo(String value) {
            addCriterion("PARENT_PERM_ID =", value, "parentPermId");
            return (Criteria) this;
        }

        public Criteria andParentPermIdNotEqualTo(String value) {
            addCriterion("PARENT_PERM_ID <>", value, "parentPermId");
            return (Criteria) this;
        }

        public Criteria andParentPermIdGreaterThan(String value) {
            addCriterion("PARENT_PERM_ID >", value, "parentPermId");
            return (Criteria) this;
        }

        public Criteria andParentPermIdGreaterThanOrEqualTo(String value) {
            addCriterion("PARENT_PERM_ID >=", value, "parentPermId");
            return (Criteria) this;
        }

        public Criteria andParentPermIdLessThan(String value) {
            addCriterion("PARENT_PERM_ID <", value, "parentPermId");
            return (Criteria) this;
        }

        public Criteria andParentPermIdLessThanOrEqualTo(String value) {
            addCriterion("PARENT_PERM_ID <=", value, "parentPermId");
            return (Criteria) this;
        }

        public Criteria andParentPermIdLike(String value) {
            addCriterion("PARENT_PERM_ID like", value, "parentPermId");
            return (Criteria) this;
        }

        public Criteria andParentPermIdNotLike(String value) {
            addCriterion("PARENT_PERM_ID not like", value, "parentPermId");
            return (Criteria) this;
        }

        public Criteria andParentPermIdIn(List<String> values) {
            addCriterion("PARENT_PERM_ID in", values, "parentPermId");
            return (Criteria) this;
        }

        public Criteria andParentPermIdNotIn(List<String> values) {
            addCriterion("PARENT_PERM_ID not in", values, "parentPermId");
            return (Criteria) this;
        }

        public Criteria andParentPermIdBetween(String value1, String value2) {
            addCriterion("PARENT_PERM_ID between", value1, value2, "parentPermId");
            return (Criteria) this;
        }

        public Criteria andParentPermIdNotBetween(String value1, String value2) {
            addCriterion("PARENT_PERM_ID not between", value1, value2, "parentPermId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
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