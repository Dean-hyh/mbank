package com.ms.credit.pojo.DO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RaffleDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RaffleDetailExample() {
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

        public Criteria andRaffleDetailIdIsNull() {
            addCriterion("raffle_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andRaffleDetailIdIsNotNull() {
            addCriterion("raffle_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andRaffleDetailIdEqualTo(Long value) {
            addCriterion("raffle_detail_id =", value, "raffleDetailId");
            return (Criteria) this;
        }

        public Criteria andRaffleDetailIdNotEqualTo(Long value) {
            addCriterion("raffle_detail_id <>", value, "raffleDetailId");
            return (Criteria) this;
        }

        public Criteria andRaffleDetailIdGreaterThan(Long value) {
            addCriterion("raffle_detail_id >", value, "raffleDetailId");
            return (Criteria) this;
        }

        public Criteria andRaffleDetailIdGreaterThanOrEqualTo(Long value) {
            addCriterion("raffle_detail_id >=", value, "raffleDetailId");
            return (Criteria) this;
        }

        public Criteria andRaffleDetailIdLessThan(Long value) {
            addCriterion("raffle_detail_id <", value, "raffleDetailId");
            return (Criteria) this;
        }

        public Criteria andRaffleDetailIdLessThanOrEqualTo(Long value) {
            addCriterion("raffle_detail_id <=", value, "raffleDetailId");
            return (Criteria) this;
        }

        public Criteria andRaffleDetailIdIn(List<Long> values) {
            addCriterion("raffle_detail_id in", values, "raffleDetailId");
            return (Criteria) this;
        }

        public Criteria andRaffleDetailIdNotIn(List<Long> values) {
            addCriterion("raffle_detail_id not in", values, "raffleDetailId");
            return (Criteria) this;
        }

        public Criteria andRaffleDetailIdBetween(Long value1, Long value2) {
            addCriterion("raffle_detail_id between", value1, value2, "raffleDetailId");
            return (Criteria) this;
        }

        public Criteria andRaffleDetailIdNotBetween(Long value1, Long value2) {
            addCriterion("raffle_detail_id not between", value1, value2, "raffleDetailId");
            return (Criteria) this;
        }

        public Criteria andAwardsNameIsNull() {
            addCriterion("awards_name is null");
            return (Criteria) this;
        }

        public Criteria andAwardsNameIsNotNull() {
            addCriterion("awards_name is not null");
            return (Criteria) this;
        }

        public Criteria andAwardsNameEqualTo(String value) {
            addCriterion("awards_name =", value, "awardsName");
            return (Criteria) this;
        }

        public Criteria andAwardsNameNotEqualTo(String value) {
            addCriterion("awards_name <>", value, "awardsName");
            return (Criteria) this;
        }

        public Criteria andAwardsNameGreaterThan(String value) {
            addCriterion("awards_name >", value, "awardsName");
            return (Criteria) this;
        }

        public Criteria andAwardsNameGreaterThanOrEqualTo(String value) {
            addCriterion("awards_name >=", value, "awardsName");
            return (Criteria) this;
        }

        public Criteria andAwardsNameLessThan(String value) {
            addCriterion("awards_name <", value, "awardsName");
            return (Criteria) this;
        }

        public Criteria andAwardsNameLessThanOrEqualTo(String value) {
            addCriterion("awards_name <=", value, "awardsName");
            return (Criteria) this;
        }

        public Criteria andAwardsNameLike(String value) {
            addCriterion("awards_name like", value, "awardsName");
            return (Criteria) this;
        }

        public Criteria andAwardsNameNotLike(String value) {
            addCriterion("awards_name not like", value, "awardsName");
            return (Criteria) this;
        }

        public Criteria andAwardsNameIn(List<String> values) {
            addCriterion("awards_name in", values, "awardsName");
            return (Criteria) this;
        }

        public Criteria andAwardsNameNotIn(List<String> values) {
            addCriterion("awards_name not in", values, "awardsName");
            return (Criteria) this;
        }

        public Criteria andAwardsNameBetween(String value1, String value2) {
            addCriterion("awards_name between", value1, value2, "awardsName");
            return (Criteria) this;
        }

        public Criteria andAwardsNameNotBetween(String value1, String value2) {
            addCriterion("awards_name not between", value1, value2, "awardsName");
            return (Criteria) this;
        }

        public Criteria andPrizeQuotaIsNull() {
            addCriterion("prize_quota is null");
            return (Criteria) this;
        }

        public Criteria andPrizeQuotaIsNotNull() {
            addCriterion("prize_quota is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeQuotaEqualTo(Integer value) {
            addCriterion("prize_quota =", value, "prizeQuota");
            return (Criteria) this;
        }

        public Criteria andPrizeQuotaNotEqualTo(Integer value) {
            addCriterion("prize_quota <>", value, "prizeQuota");
            return (Criteria) this;
        }

        public Criteria andPrizeQuotaGreaterThan(Integer value) {
            addCriterion("prize_quota >", value, "prizeQuota");
            return (Criteria) this;
        }

        public Criteria andPrizeQuotaGreaterThanOrEqualTo(Integer value) {
            addCriterion("prize_quota >=", value, "prizeQuota");
            return (Criteria) this;
        }

        public Criteria andPrizeQuotaLessThan(Integer value) {
            addCriterion("prize_quota <", value, "prizeQuota");
            return (Criteria) this;
        }

        public Criteria andPrizeQuotaLessThanOrEqualTo(Integer value) {
            addCriterion("prize_quota <=", value, "prizeQuota");
            return (Criteria) this;
        }

        public Criteria andPrizeQuotaIn(List<Integer> values) {
            addCriterion("prize_quota in", values, "prizeQuota");
            return (Criteria) this;
        }

        public Criteria andPrizeQuotaNotIn(List<Integer> values) {
            addCriterion("prize_quota not in", values, "prizeQuota");
            return (Criteria) this;
        }

        public Criteria andPrizeQuotaBetween(Integer value1, Integer value2) {
            addCriterion("prize_quota between", value1, value2, "prizeQuota");
            return (Criteria) this;
        }

        public Criteria andPrizeQuotaNotBetween(Integer value1, Integer value2) {
            addCriterion("prize_quota not between", value1, value2, "prizeQuota");
            return (Criteria) this;
        }

        public Criteria andBetchIsNull() {
            addCriterion("betch is null");
            return (Criteria) this;
        }

        public Criteria andBetchIsNotNull() {
            addCriterion("betch is not null");
            return (Criteria) this;
        }

        public Criteria andBetchEqualTo(Integer value) {
            addCriterion("betch =", value, "betch");
            return (Criteria) this;
        }

        public Criteria andBetchNotEqualTo(Integer value) {
            addCriterion("betch <>", value, "betch");
            return (Criteria) this;
        }

        public Criteria andBetchGreaterThan(Integer value) {
            addCriterion("betch >", value, "betch");
            return (Criteria) this;
        }

        public Criteria andBetchGreaterThanOrEqualTo(Integer value) {
            addCriterion("betch >=", value, "betch");
            return (Criteria) this;
        }

        public Criteria andBetchLessThan(Integer value) {
            addCriterion("betch <", value, "betch");
            return (Criteria) this;
        }

        public Criteria andBetchLessThanOrEqualTo(Integer value) {
            addCriterion("betch <=", value, "betch");
            return (Criteria) this;
        }

        public Criteria andBetchIn(List<Integer> values) {
            addCriterion("betch in", values, "betch");
            return (Criteria) this;
        }

        public Criteria andBetchNotIn(List<Integer> values) {
            addCriterion("betch not in", values, "betch");
            return (Criteria) this;
        }

        public Criteria andBetchBetween(Integer value1, Integer value2) {
            addCriterion("betch between", value1, value2, "betch");
            return (Criteria) this;
        }

        public Criteria andBetchNotBetween(Integer value1, Integer value2) {
            addCriterion("betch not between", value1, value2, "betch");
            return (Criteria) this;
        }

        public Criteria andPrizeNameIsNull() {
            addCriterion("prize_name is null");
            return (Criteria) this;
        }

        public Criteria andPrizeNameIsNotNull() {
            addCriterion("prize_name is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeNameEqualTo(String value) {
            addCriterion("prize_name =", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameNotEqualTo(String value) {
            addCriterion("prize_name <>", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameGreaterThan(String value) {
            addCriterion("prize_name >", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameGreaterThanOrEqualTo(String value) {
            addCriterion("prize_name >=", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameLessThan(String value) {
            addCriterion("prize_name <", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameLessThanOrEqualTo(String value) {
            addCriterion("prize_name <=", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameLike(String value) {
            addCriterion("prize_name like", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameNotLike(String value) {
            addCriterion("prize_name not like", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameIn(List<String> values) {
            addCriterion("prize_name in", values, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameNotIn(List<String> values) {
            addCriterion("prize_name not in", values, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameBetween(String value1, String value2) {
            addCriterion("prize_name between", value1, value2, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameNotBetween(String value1, String value2) {
            addCriterion("prize_name not between", value1, value2, "prizeName");
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

        public Criteria andRaffleRankIsNull() {
            addCriterion("raffle_rank is null");
            return (Criteria) this;
        }

        public Criteria andRaffleRankIsNotNull() {
            addCriterion("raffle_rank is not null");
            return (Criteria) this;
        }

        public Criteria andRaffleRankEqualTo(String value) {
            addCriterion("raffle_rank =", value, "raffleRank");
            return (Criteria) this;
        }

        public Criteria andRaffleRankNotEqualTo(String value) {
            addCriterion("raffle_rank <>", value, "raffleRank");
            return (Criteria) this;
        }

        public Criteria andRaffleRankGreaterThan(String value) {
            addCriterion("raffle_rank >", value, "raffleRank");
            return (Criteria) this;
        }

        public Criteria andRaffleRankGreaterThanOrEqualTo(String value) {
            addCriterion("raffle_rank >=", value, "raffleRank");
            return (Criteria) this;
        }

        public Criteria andRaffleRankLessThan(String value) {
            addCriterion("raffle_rank <", value, "raffleRank");
            return (Criteria) this;
        }

        public Criteria andRaffleRankLessThanOrEqualTo(String value) {
            addCriterion("raffle_rank <=", value, "raffleRank");
            return (Criteria) this;
        }

        public Criteria andRaffleRankLike(String value) {
            addCriterion("raffle_rank like", value, "raffleRank");
            return (Criteria) this;
        }

        public Criteria andRaffleRankNotLike(String value) {
            addCriterion("raffle_rank not like", value, "raffleRank");
            return (Criteria) this;
        }

        public Criteria andRaffleRankIn(List<String> values) {
            addCriterion("raffle_rank in", values, "raffleRank");
            return (Criteria) this;
        }

        public Criteria andRaffleRankNotIn(List<String> values) {
            addCriterion("raffle_rank not in", values, "raffleRank");
            return (Criteria) this;
        }

        public Criteria andRaffleRankBetween(String value1, String value2) {
            addCriterion("raffle_rank between", value1, value2, "raffleRank");
            return (Criteria) this;
        }

        public Criteria andRaffleRankNotBetween(String value1, String value2) {
            addCriterion("raffle_rank not between", value1, value2, "raffleRank");
            return (Criteria) this;
        }

        public Criteria andRaffleDetailStatusIsNull() {
            addCriterion("raffle_detail_status is null");
            return (Criteria) this;
        }

        public Criteria andRaffleDetailStatusIsNotNull() {
            addCriterion("raffle_detail_status is not null");
            return (Criteria) this;
        }

        public Criteria andRaffleDetailStatusEqualTo(Integer value) {
            addCriterion("raffle_detail_status =", value, "raffleDetailStatus");
            return (Criteria) this;
        }

        public Criteria andRaffleDetailStatusNotEqualTo(Integer value) {
            addCriterion("raffle_detail_status <>", value, "raffleDetailStatus");
            return (Criteria) this;
        }

        public Criteria andRaffleDetailStatusGreaterThan(Integer value) {
            addCriterion("raffle_detail_status >", value, "raffleDetailStatus");
            return (Criteria) this;
        }

        public Criteria andRaffleDetailStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("raffle_detail_status >=", value, "raffleDetailStatus");
            return (Criteria) this;
        }

        public Criteria andRaffleDetailStatusLessThan(Integer value) {
            addCriterion("raffle_detail_status <", value, "raffleDetailStatus");
            return (Criteria) this;
        }

        public Criteria andRaffleDetailStatusLessThanOrEqualTo(Integer value) {
            addCriterion("raffle_detail_status <=", value, "raffleDetailStatus");
            return (Criteria) this;
        }

        public Criteria andRaffleDetailStatusIn(List<Integer> values) {
            addCriterion("raffle_detail_status in", values, "raffleDetailStatus");
            return (Criteria) this;
        }

        public Criteria andRaffleDetailStatusNotIn(List<Integer> values) {
            addCriterion("raffle_detail_status not in", values, "raffleDetailStatus");
            return (Criteria) this;
        }

        public Criteria andRaffleDetailStatusBetween(Integer value1, Integer value2) {
            addCriterion("raffle_detail_status between", value1, value2, "raffleDetailStatus");
            return (Criteria) this;
        }

        public Criteria andRaffleDetailStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("raffle_detail_status not between", value1, value2, "raffleDetailStatus");
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