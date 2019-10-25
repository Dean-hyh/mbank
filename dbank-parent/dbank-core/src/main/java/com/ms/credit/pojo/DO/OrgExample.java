package com.ms.credit.pojo.DO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrgExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrgExample() {
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

        public Criteria andOrgIdIsNull() {
            addCriterion("ORG_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("ORG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(String value) {
            addCriterion("ORG_ID =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(String value) {
            addCriterion("ORG_ID <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(String value) {
            addCriterion("ORG_ID >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_ID >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(String value) {
            addCriterion("ORG_ID <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(String value) {
            addCriterion("ORG_ID <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLike(String value) {
            addCriterion("ORG_ID like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotLike(String value) {
            addCriterion("ORG_ID not like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<String> values) {
            addCriterion("ORG_ID in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<String> values) {
            addCriterion("ORG_ID not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(String value1, String value2) {
            addCriterion("ORG_ID between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(String value1, String value2) {
            addCriterion("ORG_ID not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andParentOrgIdIsNull() {
            addCriterion("PARENT_ORG_ID is null");
            return (Criteria) this;
        }

        public Criteria andParentOrgIdIsNotNull() {
            addCriterion("PARENT_ORG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParentOrgIdEqualTo(String value) {
            addCriterion("PARENT_ORG_ID =", value, "parentOrgId");
            return (Criteria) this;
        }

        public Criteria andParentOrgIdNotEqualTo(String value) {
            addCriterion("PARENT_ORG_ID <>", value, "parentOrgId");
            return (Criteria) this;
        }

        public Criteria andParentOrgIdGreaterThan(String value) {
            addCriterion("PARENT_ORG_ID >", value, "parentOrgId");
            return (Criteria) this;
        }

        public Criteria andParentOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("PARENT_ORG_ID >=", value, "parentOrgId");
            return (Criteria) this;
        }

        public Criteria andParentOrgIdLessThan(String value) {
            addCriterion("PARENT_ORG_ID <", value, "parentOrgId");
            return (Criteria) this;
        }

        public Criteria andParentOrgIdLessThanOrEqualTo(String value) {
            addCriterion("PARENT_ORG_ID <=", value, "parentOrgId");
            return (Criteria) this;
        }

        public Criteria andParentOrgIdLike(String value) {
            addCriterion("PARENT_ORG_ID like", value, "parentOrgId");
            return (Criteria) this;
        }

        public Criteria andParentOrgIdNotLike(String value) {
            addCriterion("PARENT_ORG_ID not like", value, "parentOrgId");
            return (Criteria) this;
        }

        public Criteria andParentOrgIdIn(List<String> values) {
            addCriterion("PARENT_ORG_ID in", values, "parentOrgId");
            return (Criteria) this;
        }

        public Criteria andParentOrgIdNotIn(List<String> values) {
            addCriterion("PARENT_ORG_ID not in", values, "parentOrgId");
            return (Criteria) this;
        }

        public Criteria andParentOrgIdBetween(String value1, String value2) {
            addCriterion("PARENT_ORG_ID between", value1, value2, "parentOrgId");
            return (Criteria) this;
        }

        public Criteria andParentOrgIdNotBetween(String value1, String value2) {
            addCriterion("PARENT_ORG_ID not between", value1, value2, "parentOrgId");
            return (Criteria) this;
        }

        public Criteria andRealOrgIdIsNull() {
            addCriterion("REAL_ORG_ID is null");
            return (Criteria) this;
        }

        public Criteria andRealOrgIdIsNotNull() {
            addCriterion("REAL_ORG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRealOrgIdEqualTo(String value) {
            addCriterion("REAL_ORG_ID =", value, "realOrgId");
            return (Criteria) this;
        }

        public Criteria andRealOrgIdNotEqualTo(String value) {
            addCriterion("REAL_ORG_ID <>", value, "realOrgId");
            return (Criteria) this;
        }

        public Criteria andRealOrgIdGreaterThan(String value) {
            addCriterion("REAL_ORG_ID >", value, "realOrgId");
            return (Criteria) this;
        }

        public Criteria andRealOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("REAL_ORG_ID >=", value, "realOrgId");
            return (Criteria) this;
        }

        public Criteria andRealOrgIdLessThan(String value) {
            addCriterion("REAL_ORG_ID <", value, "realOrgId");
            return (Criteria) this;
        }

        public Criteria andRealOrgIdLessThanOrEqualTo(String value) {
            addCriterion("REAL_ORG_ID <=", value, "realOrgId");
            return (Criteria) this;
        }

        public Criteria andRealOrgIdLike(String value) {
            addCriterion("REAL_ORG_ID like", value, "realOrgId");
            return (Criteria) this;
        }

        public Criteria andRealOrgIdNotLike(String value) {
            addCriterion("REAL_ORG_ID not like", value, "realOrgId");
            return (Criteria) this;
        }

        public Criteria andRealOrgIdIn(List<String> values) {
            addCriterion("REAL_ORG_ID in", values, "realOrgId");
            return (Criteria) this;
        }

        public Criteria andRealOrgIdNotIn(List<String> values) {
            addCriterion("REAL_ORG_ID not in", values, "realOrgId");
            return (Criteria) this;
        }

        public Criteria andRealOrgIdBetween(String value1, String value2) {
            addCriterion("REAL_ORG_ID between", value1, value2, "realOrgId");
            return (Criteria) this;
        }

        public Criteria andRealOrgIdNotBetween(String value1, String value2) {
            addCriterion("REAL_ORG_ID not between", value1, value2, "realOrgId");
            return (Criteria) this;
        }

        public Criteria andRealLevelIsNull() {
            addCriterion("REAL_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andRealLevelIsNotNull() {
            addCriterion("REAL_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andRealLevelEqualTo(String value) {
            addCriterion("REAL_LEVEL =", value, "realLevel");
            return (Criteria) this;
        }

        public Criteria andRealLevelNotEqualTo(String value) {
            addCriterion("REAL_LEVEL <>", value, "realLevel");
            return (Criteria) this;
        }

        public Criteria andRealLevelGreaterThan(String value) {
            addCriterion("REAL_LEVEL >", value, "realLevel");
            return (Criteria) this;
        }

        public Criteria andRealLevelGreaterThanOrEqualTo(String value) {
            addCriterion("REAL_LEVEL >=", value, "realLevel");
            return (Criteria) this;
        }

        public Criteria andRealLevelLessThan(String value) {
            addCriterion("REAL_LEVEL <", value, "realLevel");
            return (Criteria) this;
        }

        public Criteria andRealLevelLessThanOrEqualTo(String value) {
            addCriterion("REAL_LEVEL <=", value, "realLevel");
            return (Criteria) this;
        }

        public Criteria andRealLevelLike(String value) {
            addCriterion("REAL_LEVEL like", value, "realLevel");
            return (Criteria) this;
        }

        public Criteria andRealLevelNotLike(String value) {
            addCriterion("REAL_LEVEL not like", value, "realLevel");
            return (Criteria) this;
        }

        public Criteria andRealLevelIn(List<String> values) {
            addCriterion("REAL_LEVEL in", values, "realLevel");
            return (Criteria) this;
        }

        public Criteria andRealLevelNotIn(List<String> values) {
            addCriterion("REAL_LEVEL not in", values, "realLevel");
            return (Criteria) this;
        }

        public Criteria andRealLevelBetween(String value1, String value2) {
            addCriterion("REAL_LEVEL between", value1, value2, "realLevel");
            return (Criteria) this;
        }

        public Criteria andRealLevelNotBetween(String value1, String value2) {
            addCriterion("REAL_LEVEL not between", value1, value2, "realLevel");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNull() {
            addCriterion("SHORT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNotNull() {
            addCriterion("SHORT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andShortNameEqualTo(String value) {
            addCriterion("SHORT_NAME =", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotEqualTo(String value) {
            addCriterion("SHORT_NAME <>", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThan(String value) {
            addCriterion("SHORT_NAME >", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("SHORT_NAME >=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThan(String value) {
            addCriterion("SHORT_NAME <", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThanOrEqualTo(String value) {
            addCriterion("SHORT_NAME <=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLike(String value) {
            addCriterion("SHORT_NAME like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotLike(String value) {
            addCriterion("SHORT_NAME not like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameIn(List<String> values) {
            addCriterion("SHORT_NAME in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotIn(List<String> values) {
            addCriterion("SHORT_NAME not in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameBetween(String value1, String value2) {
            addCriterion("SHORT_NAME between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotBetween(String value1, String value2) {
            addCriterion("SHORT_NAME not between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIsNull() {
            addCriterion("CREATOR_ID is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIsNotNull() {
            addCriterion("CREATOR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdEqualTo(String value) {
            addCriterion("CREATOR_ID =", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotEqualTo(String value) {
            addCriterion("CREATOR_ID <>", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThan(String value) {
            addCriterion("CREATOR_ID >", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThanOrEqualTo(String value) {
            addCriterion("CREATOR_ID >=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThan(String value) {
            addCriterion("CREATOR_ID <", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThanOrEqualTo(String value) {
            addCriterion("CREATOR_ID <=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLike(String value) {
            addCriterion("CREATOR_ID like", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotLike(String value) {
            addCriterion("CREATOR_ID not like", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIn(List<String> values) {
            addCriterion("CREATOR_ID in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotIn(List<String> values) {
            addCriterion("CREATOR_ID not in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdBetween(String value1, String value2) {
            addCriterion("CREATOR_ID between", value1, value2, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotBetween(String value1, String value2) {
            addCriterion("CREATOR_ID not between", value1, value2, "creatorId");
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

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSysSyncTimeIsNull() {
            addCriterion("SYS_SYNC_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSysSyncTimeIsNotNull() {
            addCriterion("SYS_SYNC_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSysSyncTimeEqualTo(Date value) {
            addCriterion("SYS_SYNC_TIME =", value, "sysSyncTime");
            return (Criteria) this;
        }

        public Criteria andSysSyncTimeNotEqualTo(Date value) {
            addCriterion("SYS_SYNC_TIME <>", value, "sysSyncTime");
            return (Criteria) this;
        }

        public Criteria andSysSyncTimeGreaterThan(Date value) {
            addCriterion("SYS_SYNC_TIME >", value, "sysSyncTime");
            return (Criteria) this;
        }

        public Criteria andSysSyncTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SYS_SYNC_TIME >=", value, "sysSyncTime");
            return (Criteria) this;
        }

        public Criteria andSysSyncTimeLessThan(Date value) {
            addCriterion("SYS_SYNC_TIME <", value, "sysSyncTime");
            return (Criteria) this;
        }

        public Criteria andSysSyncTimeLessThanOrEqualTo(Date value) {
            addCriterion("SYS_SYNC_TIME <=", value, "sysSyncTime");
            return (Criteria) this;
        }

        public Criteria andSysSyncTimeIn(List<Date> values) {
            addCriterion("SYS_SYNC_TIME in", values, "sysSyncTime");
            return (Criteria) this;
        }

        public Criteria andSysSyncTimeNotIn(List<Date> values) {
            addCriterion("SYS_SYNC_TIME not in", values, "sysSyncTime");
            return (Criteria) this;
        }

        public Criteria andSysSyncTimeBetween(Date value1, Date value2) {
            addCriterion("SYS_SYNC_TIME between", value1, value2, "sysSyncTime");
            return (Criteria) this;
        }

        public Criteria andSysSyncTimeNotBetween(Date value1, Date value2) {
            addCriterion("SYS_SYNC_TIME not between", value1, value2, "sysSyncTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable{

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