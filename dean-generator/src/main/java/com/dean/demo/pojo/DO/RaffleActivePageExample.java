package com.dean.demo.pojo.DO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RaffleActivePageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RaffleActivePageExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andRaffleActiveIdIsNull() {
            addCriterion("raffle_active_id is null");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveIdIsNotNull() {
            addCriterion("raffle_active_id is not null");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveIdEqualTo(Long value) {
            addCriterion("raffle_active_id =", value, "raffleActiveId");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveIdNotEqualTo(Long value) {
            addCriterion("raffle_active_id <>", value, "raffleActiveId");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveIdGreaterThan(Long value) {
            addCriterion("raffle_active_id >", value, "raffleActiveId");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveIdGreaterThanOrEqualTo(Long value) {
            addCriterion("raffle_active_id >=", value, "raffleActiveId");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveIdLessThan(Long value) {
            addCriterion("raffle_active_id <", value, "raffleActiveId");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveIdLessThanOrEqualTo(Long value) {
            addCriterion("raffle_active_id <=", value, "raffleActiveId");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveIdIn(List<Long> values) {
            addCriterion("raffle_active_id in", values, "raffleActiveId");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveIdNotIn(List<Long> values) {
            addCriterion("raffle_active_id not in", values, "raffleActiveId");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveIdBetween(Long value1, Long value2) {
            addCriterion("raffle_active_id between", value1, value2, "raffleActiveId");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveIdNotBetween(Long value1, Long value2) {
            addCriterion("raffle_active_id not between", value1, value2, "raffleActiveId");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveNameIsNull() {
            addCriterion("raffle_active_name is null");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveNameIsNotNull() {
            addCriterion("raffle_active_name is not null");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveNameEqualTo(String value) {
            addCriterion("raffle_active_name =", value, "raffleActiveName");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveNameNotEqualTo(String value) {
            addCriterion("raffle_active_name <>", value, "raffleActiveName");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveNameGreaterThan(String value) {
            addCriterion("raffle_active_name >", value, "raffleActiveName");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveNameGreaterThanOrEqualTo(String value) {
            addCriterion("raffle_active_name >=", value, "raffleActiveName");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveNameLessThan(String value) {
            addCriterion("raffle_active_name <", value, "raffleActiveName");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveNameLessThanOrEqualTo(String value) {
            addCriterion("raffle_active_name <=", value, "raffleActiveName");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveNameLike(String value) {
            addCriterion("raffle_active_name like", value, "raffleActiveName");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveNameNotLike(String value) {
            addCriterion("raffle_active_name not like", value, "raffleActiveName");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveNameIn(List<String> values) {
            addCriterion("raffle_active_name in", values, "raffleActiveName");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveNameNotIn(List<String> values) {
            addCriterion("raffle_active_name not in", values, "raffleActiveName");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveNameBetween(String value1, String value2) {
            addCriterion("raffle_active_name between", value1, value2, "raffleActiveName");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveNameNotBetween(String value1, String value2) {
            addCriterion("raffle_active_name not between", value1, value2, "raffleActiveName");
            return (Criteria) this;
        }

        public Criteria andAwardsIsNull() {
            addCriterion("awards is null");
            return (Criteria) this;
        }

        public Criteria andAwardsIsNotNull() {
            addCriterion("awards is not null");
            return (Criteria) this;
        }

        public Criteria andAwardsEqualTo(Integer value) {
            addCriterion("awards =", value, "awards");
            return (Criteria) this;
        }

        public Criteria andAwardsNotEqualTo(Integer value) {
            addCriterion("awards <>", value, "awards");
            return (Criteria) this;
        }

        public Criteria andAwardsGreaterThan(Integer value) {
            addCriterion("awards >", value, "awards");
            return (Criteria) this;
        }

        public Criteria andAwardsGreaterThanOrEqualTo(Integer value) {
            addCriterion("awards >=", value, "awards");
            return (Criteria) this;
        }

        public Criteria andAwardsLessThan(Integer value) {
            addCriterion("awards <", value, "awards");
            return (Criteria) this;
        }

        public Criteria andAwardsLessThanOrEqualTo(Integer value) {
            addCriterion("awards <=", value, "awards");
            return (Criteria) this;
        }

        public Criteria andAwardsIn(List<Integer> values) {
            addCriterion("awards in", values, "awards");
            return (Criteria) this;
        }

        public Criteria andAwardsNotIn(List<Integer> values) {
            addCriterion("awards not in", values, "awards");
            return (Criteria) this;
        }

        public Criteria andAwardsBetween(Integer value1, Integer value2) {
            addCriterion("awards between", value1, value2, "awards");
            return (Criteria) this;
        }

        public Criteria andAwardsNotBetween(Integer value1, Integer value2) {
            addCriterion("awards not between", value1, value2, "awards");
            return (Criteria) this;
        }

        public Criteria andIsAllowedDuplicatesIsNull() {
            addCriterion("is_allowed_duplicates is null");
            return (Criteria) this;
        }

        public Criteria andIsAllowedDuplicatesIsNotNull() {
            addCriterion("is_allowed_duplicates is not null");
            return (Criteria) this;
        }

        public Criteria andIsAllowedDuplicatesEqualTo(Boolean value) {
            addCriterion("is_allowed_duplicates =", value, "isAllowedDuplicates");
            return (Criteria) this;
        }

        public Criteria andIsAllowedDuplicatesNotEqualTo(Boolean value) {
            addCriterion("is_allowed_duplicates <>", value, "isAllowedDuplicates");
            return (Criteria) this;
        }

        public Criteria andIsAllowedDuplicatesGreaterThan(Boolean value) {
            addCriterion("is_allowed_duplicates >", value, "isAllowedDuplicates");
            return (Criteria) this;
        }

        public Criteria andIsAllowedDuplicatesGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_allowed_duplicates >=", value, "isAllowedDuplicates");
            return (Criteria) this;
        }

        public Criteria andIsAllowedDuplicatesLessThan(Boolean value) {
            addCriterion("is_allowed_duplicates <", value, "isAllowedDuplicates");
            return (Criteria) this;
        }

        public Criteria andIsAllowedDuplicatesLessThanOrEqualTo(Boolean value) {
            addCriterion("is_allowed_duplicates <=", value, "isAllowedDuplicates");
            return (Criteria) this;
        }

        public Criteria andIsAllowedDuplicatesIn(List<Boolean> values) {
            addCriterion("is_allowed_duplicates in", values, "isAllowedDuplicates");
            return (Criteria) this;
        }

        public Criteria andIsAllowedDuplicatesNotIn(List<Boolean> values) {
            addCriterion("is_allowed_duplicates not in", values, "isAllowedDuplicates");
            return (Criteria) this;
        }

        public Criteria andIsAllowedDuplicatesBetween(Boolean value1, Boolean value2) {
            addCriterion("is_allowed_duplicates between", value1, value2, "isAllowedDuplicates");
            return (Criteria) this;
        }

        public Criteria andIsAllowedDuplicatesNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_allowed_duplicates not between", value1, value2, "isAllowedDuplicates");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveTimeIsNull() {
            addCriterion("raffle_active_time is null");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveTimeIsNotNull() {
            addCriterion("raffle_active_time is not null");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveTimeEqualTo(Date value) {
            addCriterionForJDBCDate("raffle_active_time =", value, "raffleActiveTime");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("raffle_active_time <>", value, "raffleActiveTime");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("raffle_active_time >", value, "raffleActiveTime");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("raffle_active_time >=", value, "raffleActiveTime");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveTimeLessThan(Date value) {
            addCriterionForJDBCDate("raffle_active_time <", value, "raffleActiveTime");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("raffle_active_time <=", value, "raffleActiveTime");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveTimeIn(List<Date> values) {
            addCriterionForJDBCDate("raffle_active_time in", values, "raffleActiveTime");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("raffle_active_time not in", values, "raffleActiveTime");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("raffle_active_time between", value1, value2, "raffleActiveTime");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("raffle_active_time not between", value1, value2, "raffleActiveTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterionForJDBCDate("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andBackgroundImgUrlIsNull() {
            addCriterion("background_img_url is null");
            return (Criteria) this;
        }

        public Criteria andBackgroundImgUrlIsNotNull() {
            addCriterion("background_img_url is not null");
            return (Criteria) this;
        }

        public Criteria andBackgroundImgUrlEqualTo(String value) {
            addCriterion("background_img_url =", value, "backgroundImgUrl");
            return (Criteria) this;
        }

        public Criteria andBackgroundImgUrlNotEqualTo(String value) {
            addCriterion("background_img_url <>", value, "backgroundImgUrl");
            return (Criteria) this;
        }

        public Criteria andBackgroundImgUrlGreaterThan(String value) {
            addCriterion("background_img_url >", value, "backgroundImgUrl");
            return (Criteria) this;
        }

        public Criteria andBackgroundImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("background_img_url >=", value, "backgroundImgUrl");
            return (Criteria) this;
        }

        public Criteria andBackgroundImgUrlLessThan(String value) {
            addCriterion("background_img_url <", value, "backgroundImgUrl");
            return (Criteria) this;
        }

        public Criteria andBackgroundImgUrlLessThanOrEqualTo(String value) {
            addCriterion("background_img_url <=", value, "backgroundImgUrl");
            return (Criteria) this;
        }

        public Criteria andBackgroundImgUrlLike(String value) {
            addCriterion("background_img_url like", value, "backgroundImgUrl");
            return (Criteria) this;
        }

        public Criteria andBackgroundImgUrlNotLike(String value) {
            addCriterion("background_img_url not like", value, "backgroundImgUrl");
            return (Criteria) this;
        }

        public Criteria andBackgroundImgUrlIn(List<String> values) {
            addCriterion("background_img_url in", values, "backgroundImgUrl");
            return (Criteria) this;
        }

        public Criteria andBackgroundImgUrlNotIn(List<String> values) {
            addCriterion("background_img_url not in", values, "backgroundImgUrl");
            return (Criteria) this;
        }

        public Criteria andBackgroundImgUrlBetween(String value1, String value2) {
            addCriterion("background_img_url between", value1, value2, "backgroundImgUrl");
            return (Criteria) this;
        }

        public Criteria andBackgroundImgUrlNotBetween(String value1, String value2) {
            addCriterion("background_img_url not between", value1, value2, "backgroundImgUrl");
            return (Criteria) this;
        }

        public Criteria andNamelistKeyIsNull() {
            addCriterion("namelist_key is null");
            return (Criteria) this;
        }

        public Criteria andNamelistKeyIsNotNull() {
            addCriterion("namelist_key is not null");
            return (Criteria) this;
        }

        public Criteria andNamelistKeyEqualTo(String value) {
            addCriterion("namelist_key =", value, "namelistKey");
            return (Criteria) this;
        }

        public Criteria andNamelistKeyNotEqualTo(String value) {
            addCriterion("namelist_key <>", value, "namelistKey");
            return (Criteria) this;
        }

        public Criteria andNamelistKeyGreaterThan(String value) {
            addCriterion("namelist_key >", value, "namelistKey");
            return (Criteria) this;
        }

        public Criteria andNamelistKeyGreaterThanOrEqualTo(String value) {
            addCriterion("namelist_key >=", value, "namelistKey");
            return (Criteria) this;
        }

        public Criteria andNamelistKeyLessThan(String value) {
            addCriterion("namelist_key <", value, "namelistKey");
            return (Criteria) this;
        }

        public Criteria andNamelistKeyLessThanOrEqualTo(String value) {
            addCriterion("namelist_key <=", value, "namelistKey");
            return (Criteria) this;
        }

        public Criteria andNamelistKeyLike(String value) {
            addCriterion("namelist_key like", value, "namelistKey");
            return (Criteria) this;
        }

        public Criteria andNamelistKeyNotLike(String value) {
            addCriterion("namelist_key not like", value, "namelistKey");
            return (Criteria) this;
        }

        public Criteria andNamelistKeyIn(List<String> values) {
            addCriterion("namelist_key in", values, "namelistKey");
            return (Criteria) this;
        }

        public Criteria andNamelistKeyNotIn(List<String> values) {
            addCriterion("namelist_key not in", values, "namelistKey");
            return (Criteria) this;
        }

        public Criteria andNamelistKeyBetween(String value1, String value2) {
            addCriterion("namelist_key between", value1, value2, "namelistKey");
            return (Criteria) this;
        }

        public Criteria andNamelistKeyNotBetween(String value1, String value2) {
            addCriterion("namelist_key not between", value1, value2, "namelistKey");
            return (Criteria) this;
        }

        public Criteria andRaffleStatusIsNull() {
            addCriterion("raffle_status is null");
            return (Criteria) this;
        }

        public Criteria andRaffleStatusIsNotNull() {
            addCriterion("raffle_status is not null");
            return (Criteria) this;
        }

        public Criteria andRaffleStatusEqualTo(Integer value) {
            addCriterion("raffle_status =", value, "raffleStatus");
            return (Criteria) this;
        }

        public Criteria andRaffleStatusNotEqualTo(Integer value) {
            addCriterion("raffle_status <>", value, "raffleStatus");
            return (Criteria) this;
        }

        public Criteria andRaffleStatusGreaterThan(Integer value) {
            addCriterion("raffle_status >", value, "raffleStatus");
            return (Criteria) this;
        }

        public Criteria andRaffleStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("raffle_status >=", value, "raffleStatus");
            return (Criteria) this;
        }

        public Criteria andRaffleStatusLessThan(Integer value) {
            addCriterion("raffle_status <", value, "raffleStatus");
            return (Criteria) this;
        }

        public Criteria andRaffleStatusLessThanOrEqualTo(Integer value) {
            addCriterion("raffle_status <=", value, "raffleStatus");
            return (Criteria) this;
        }

        public Criteria andRaffleStatusIn(List<Integer> values) {
            addCriterion("raffle_status in", values, "raffleStatus");
            return (Criteria) this;
        }

        public Criteria andRaffleStatusNotIn(List<Integer> values) {
            addCriterion("raffle_status not in", values, "raffleStatus");
            return (Criteria) this;
        }

        public Criteria andRaffleStatusBetween(Integer value1, Integer value2) {
            addCriterion("raffle_status between", value1, value2, "raffleStatus");
            return (Criteria) this;
        }

        public Criteria andRaffleStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("raffle_status not between", value1, value2, "raffleStatus");
            return (Criteria) this;
        }

        public Criteria andTotalPrizeQuotaIsNull() {
            addCriterion("total_prize_quota is null");
            return (Criteria) this;
        }

        public Criteria andTotalPrizeQuotaIsNotNull() {
            addCriterion("total_prize_quota is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPrizeQuotaEqualTo(Integer value) {
            addCriterion("total_prize_quota =", value, "totalPrizeQuota");
            return (Criteria) this;
        }

        public Criteria andTotalPrizeQuotaNotEqualTo(Integer value) {
            addCriterion("total_prize_quota <>", value, "totalPrizeQuota");
            return (Criteria) this;
        }

        public Criteria andTotalPrizeQuotaGreaterThan(Integer value) {
            addCriterion("total_prize_quota >", value, "totalPrizeQuota");
            return (Criteria) this;
        }

        public Criteria andTotalPrizeQuotaGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_prize_quota >=", value, "totalPrizeQuota");
            return (Criteria) this;
        }

        public Criteria andTotalPrizeQuotaLessThan(Integer value) {
            addCriterion("total_prize_quota <", value, "totalPrizeQuota");
            return (Criteria) this;
        }

        public Criteria andTotalPrizeQuotaLessThanOrEqualTo(Integer value) {
            addCriterion("total_prize_quota <=", value, "totalPrizeQuota");
            return (Criteria) this;
        }

        public Criteria andTotalPrizeQuotaIn(List<Integer> values) {
            addCriterion("total_prize_quota in", values, "totalPrizeQuota");
            return (Criteria) this;
        }

        public Criteria andTotalPrizeQuotaNotIn(List<Integer> values) {
            addCriterion("total_prize_quota not in", values, "totalPrizeQuota");
            return (Criteria) this;
        }

        public Criteria andTotalPrizeQuotaBetween(Integer value1, Integer value2) {
            addCriterion("total_prize_quota between", value1, value2, "totalPrizeQuota");
            return (Criteria) this;
        }

        public Criteria andTotalPrizeQuotaNotBetween(Integer value1, Integer value2) {
            addCriterion("total_prize_quota not between", value1, value2, "totalPrizeQuota");
            return (Criteria) this;
        }

        public Criteria andTotalBatchIsNull() {
            addCriterion("total_batch is null");
            return (Criteria) this;
        }

        public Criteria andTotalBatchIsNotNull() {
            addCriterion("total_batch is not null");
            return (Criteria) this;
        }

        public Criteria andTotalBatchEqualTo(Integer value) {
            addCriterion("total_batch =", value, "totalBatch");
            return (Criteria) this;
        }

        public Criteria andTotalBatchNotEqualTo(Integer value) {
            addCriterion("total_batch <>", value, "totalBatch");
            return (Criteria) this;
        }

        public Criteria andTotalBatchGreaterThan(Integer value) {
            addCriterion("total_batch >", value, "totalBatch");
            return (Criteria) this;
        }

        public Criteria andTotalBatchGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_batch >=", value, "totalBatch");
            return (Criteria) this;
        }

        public Criteria andTotalBatchLessThan(Integer value) {
            addCriterion("total_batch <", value, "totalBatch");
            return (Criteria) this;
        }

        public Criteria andTotalBatchLessThanOrEqualTo(Integer value) {
            addCriterion("total_batch <=", value, "totalBatch");
            return (Criteria) this;
        }

        public Criteria andTotalBatchIn(List<Integer> values) {
            addCriterion("total_batch in", values, "totalBatch");
            return (Criteria) this;
        }

        public Criteria andTotalBatchNotIn(List<Integer> values) {
            addCriterion("total_batch not in", values, "totalBatch");
            return (Criteria) this;
        }

        public Criteria andTotalBatchBetween(Integer value1, Integer value2) {
            addCriterion("total_batch between", value1, value2, "totalBatch");
            return (Criteria) this;
        }

        public Criteria andTotalBatchNotBetween(Integer value1, Integer value2) {
            addCriterion("total_batch not between", value1, value2, "totalBatch");
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