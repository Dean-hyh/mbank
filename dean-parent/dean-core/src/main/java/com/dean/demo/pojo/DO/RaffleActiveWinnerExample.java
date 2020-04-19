package com.dean.demo.pojo.DO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RaffleActiveWinnerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RaffleActiveWinnerExample() {
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

        public Criteria andActiveWinnerIdIsNull() {
            addCriterion("active_winner_id is null");
            return (Criteria) this;
        }

        public Criteria andActiveWinnerIdIsNotNull() {
            addCriterion("active_winner_id is not null");
            return (Criteria) this;
        }

        public Criteria andActiveWinnerIdEqualTo(Long value) {
            addCriterion("active_winner_id =", value, "activeWinnerId");
            return (Criteria) this;
        }

        public Criteria andActiveWinnerIdNotEqualTo(Long value) {
            addCriterion("active_winner_id <>", value, "activeWinnerId");
            return (Criteria) this;
        }

        public Criteria andActiveWinnerIdGreaterThan(Long value) {
            addCriterion("active_winner_id >", value, "activeWinnerId");
            return (Criteria) this;
        }

        public Criteria andActiveWinnerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("active_winner_id >=", value, "activeWinnerId");
            return (Criteria) this;
        }

        public Criteria andActiveWinnerIdLessThan(Long value) {
            addCriterion("active_winner_id <", value, "activeWinnerId");
            return (Criteria) this;
        }

        public Criteria andActiveWinnerIdLessThanOrEqualTo(Long value) {
            addCriterion("active_winner_id <=", value, "activeWinnerId");
            return (Criteria) this;
        }

        public Criteria andActiveWinnerIdIn(List<Long> values) {
            addCriterion("active_winner_id in", values, "activeWinnerId");
            return (Criteria) this;
        }

        public Criteria andActiveWinnerIdNotIn(List<Long> values) {
            addCriterion("active_winner_id not in", values, "activeWinnerId");
            return (Criteria) this;
        }

        public Criteria andActiveWinnerIdBetween(Long value1, Long value2) {
            addCriterion("active_winner_id between", value1, value2, "activeWinnerId");
            return (Criteria) this;
        }

        public Criteria andActiveWinnerIdNotBetween(Long value1, Long value2) {
            addCriterion("active_winner_id not between", value1, value2, "activeWinnerId");
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

        public Criteria andCustNoIsNull() {
            addCriterion("cust_no is null");
            return (Criteria) this;
        }

        public Criteria andCustNoIsNotNull() {
            addCriterion("cust_no is not null");
            return (Criteria) this;
        }

        public Criteria andCustNoEqualTo(String value) {
            addCriterion("cust_no =", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoNotEqualTo(String value) {
            addCriterion("cust_no <>", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoGreaterThan(String value) {
            addCriterion("cust_no >", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoGreaterThanOrEqualTo(String value) {
            addCriterion("cust_no >=", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoLessThan(String value) {
            addCriterion("cust_no <", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoLessThanOrEqualTo(String value) {
            addCriterion("cust_no <=", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoLike(String value) {
            addCriterion("cust_no like", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoNotLike(String value) {
            addCriterion("cust_no not like", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoIn(List<String> values) {
            addCriterion("cust_no in", values, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoNotIn(List<String> values) {
            addCriterion("cust_no not in", values, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoBetween(String value1, String value2) {
            addCriterion("cust_no between", value1, value2, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoNotBetween(String value1, String value2) {
            addCriterion("cust_no not between", value1, value2, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNull() {
            addCriterion("cust_name is null");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNotNull() {
            addCriterion("cust_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustNameEqualTo(String value) {
            addCriterion("cust_name =", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotEqualTo(String value) {
            addCriterion("cust_name <>", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThan(String value) {
            addCriterion("cust_name >", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThanOrEqualTo(String value) {
            addCriterion("cust_name >=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThan(String value) {
            addCriterion("cust_name <", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThanOrEqualTo(String value) {
            addCriterion("cust_name <=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLike(String value) {
            addCriterion("cust_name like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotLike(String value) {
            addCriterion("cust_name not like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameIn(List<String> values) {
            addCriterion("cust_name in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotIn(List<String> values) {
            addCriterion("cust_name not in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameBetween(String value1, String value2) {
            addCriterion("cust_name between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotBetween(String value1, String value2) {
            addCriterion("cust_name not between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustTelIsNull() {
            addCriterion("cust_tel is null");
            return (Criteria) this;
        }

        public Criteria andCustTelIsNotNull() {
            addCriterion("cust_tel is not null");
            return (Criteria) this;
        }

        public Criteria andCustTelEqualTo(String value) {
            addCriterion("cust_tel =", value, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustTelNotEqualTo(String value) {
            addCriterion("cust_tel <>", value, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustTelGreaterThan(String value) {
            addCriterion("cust_tel >", value, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustTelGreaterThanOrEqualTo(String value) {
            addCriterion("cust_tel >=", value, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustTelLessThan(String value) {
            addCriterion("cust_tel <", value, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustTelLessThanOrEqualTo(String value) {
            addCriterion("cust_tel <=", value, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustTelLike(String value) {
            addCriterion("cust_tel like", value, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustTelNotLike(String value) {
            addCriterion("cust_tel not like", value, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustTelIn(List<String> values) {
            addCriterion("cust_tel in", values, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustTelNotIn(List<String> values) {
            addCriterion("cust_tel not in", values, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustTelBetween(String value1, String value2) {
            addCriterion("cust_tel between", value1, value2, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustTelNotBetween(String value1, String value2) {
            addCriterion("cust_tel not between", value1, value2, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNull() {
            addCriterion("cust_id is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("cust_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(String value) {
            addCriterion("cust_id =", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(String value) {
            addCriterion("cust_id <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(String value) {
            addCriterion("cust_id >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(String value) {
            addCriterion("cust_id >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(String value) {
            addCriterion("cust_id <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(String value) {
            addCriterion("cust_id <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLike(String value) {
            addCriterion("cust_id like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotLike(String value) {
            addCriterion("cust_id not like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<String> values) {
            addCriterion("cust_id in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<String> values) {
            addCriterion("cust_id not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(String value1, String value2) {
            addCriterion("cust_id between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(String value1, String value2) {
            addCriterion("cust_id not between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustDescIsNull() {
            addCriterion("cust_desc is null");
            return (Criteria) this;
        }

        public Criteria andCustDescIsNotNull() {
            addCriterion("cust_desc is not null");
            return (Criteria) this;
        }

        public Criteria andCustDescEqualTo(String value) {
            addCriterion("cust_desc =", value, "custDesc");
            return (Criteria) this;
        }

        public Criteria andCustDescNotEqualTo(String value) {
            addCriterion("cust_desc <>", value, "custDesc");
            return (Criteria) this;
        }

        public Criteria andCustDescGreaterThan(String value) {
            addCriterion("cust_desc >", value, "custDesc");
            return (Criteria) this;
        }

        public Criteria andCustDescGreaterThanOrEqualTo(String value) {
            addCriterion("cust_desc >=", value, "custDesc");
            return (Criteria) this;
        }

        public Criteria andCustDescLessThan(String value) {
            addCriterion("cust_desc <", value, "custDesc");
            return (Criteria) this;
        }

        public Criteria andCustDescLessThanOrEqualTo(String value) {
            addCriterion("cust_desc <=", value, "custDesc");
            return (Criteria) this;
        }

        public Criteria andCustDescLike(String value) {
            addCriterion("cust_desc like", value, "custDesc");
            return (Criteria) this;
        }

        public Criteria andCustDescNotLike(String value) {
            addCriterion("cust_desc not like", value, "custDesc");
            return (Criteria) this;
        }

        public Criteria andCustDescIn(List<String> values) {
            addCriterion("cust_desc in", values, "custDesc");
            return (Criteria) this;
        }

        public Criteria andCustDescNotIn(List<String> values) {
            addCriterion("cust_desc not in", values, "custDesc");
            return (Criteria) this;
        }

        public Criteria andCustDescBetween(String value1, String value2) {
            addCriterion("cust_desc between", value1, value2, "custDesc");
            return (Criteria) this;
        }

        public Criteria andCustDescNotBetween(String value1, String value2) {
            addCriterion("cust_desc not between", value1, value2, "custDesc");
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

        public Criteria andRaffleActiveTimeIsNull() {
            addCriterion("raffle_active_time is null");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveTimeIsNotNull() {
            addCriterion("raffle_active_time is not null");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveTimeEqualTo(Date value) {
            addCriterion("raffle_active_time =", value, "raffleActiveTime");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveTimeNotEqualTo(Date value) {
            addCriterion("raffle_active_time <>", value, "raffleActiveTime");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveTimeGreaterThan(Date value) {
            addCriterion("raffle_active_time >", value, "raffleActiveTime");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("raffle_active_time >=", value, "raffleActiveTime");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveTimeLessThan(Date value) {
            addCriterion("raffle_active_time <", value, "raffleActiveTime");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveTimeLessThanOrEqualTo(Date value) {
            addCriterion("raffle_active_time <=", value, "raffleActiveTime");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveTimeIn(List<Date> values) {
            addCriterion("raffle_active_time in", values, "raffleActiveTime");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveTimeNotIn(List<Date> values) {
            addCriterion("raffle_active_time not in", values, "raffleActiveTime");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveTimeBetween(Date value1, Date value2) {
            addCriterion("raffle_active_time between", value1, value2, "raffleActiveTime");
            return (Criteria) this;
        }

        public Criteria andRaffleActiveTimeNotBetween(Date value1, Date value2) {
            addCriterion("raffle_active_time not between", value1, value2, "raffleActiveTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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