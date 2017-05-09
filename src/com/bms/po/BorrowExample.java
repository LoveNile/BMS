package com.bms.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BorrowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BorrowExample() {
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

        public Criteria andBorrowidIsNull() {
            addCriterion("BorrowId is null");
            return (Criteria) this;
        }

        public Criteria andBorrowidIsNotNull() {
            addCriterion("BorrowId is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowidEqualTo(Integer value) {
            addCriterion("BorrowId =", value, "borrowid");
            return (Criteria) this;
        }

        public Criteria andBorrowidNotEqualTo(Integer value) {
            addCriterion("BorrowId <>", value, "borrowid");
            return (Criteria) this;
        }

        public Criteria andBorrowidGreaterThan(Integer value) {
            addCriterion("BorrowId >", value, "borrowid");
            return (Criteria) this;
        }

        public Criteria andBorrowidGreaterThanOrEqualTo(Integer value) {
            addCriterion("BorrowId >=", value, "borrowid");
            return (Criteria) this;
        }

        public Criteria andBorrowidLessThan(Integer value) {
            addCriterion("BorrowId <", value, "borrowid");
            return (Criteria) this;
        }

        public Criteria andBorrowidLessThanOrEqualTo(Integer value) {
            addCriterion("BorrowId <=", value, "borrowid");
            return (Criteria) this;
        }

        public Criteria andBorrowidIn(List<Integer> values) {
            addCriterion("BorrowId in", values, "borrowid");
            return (Criteria) this;
        }

        public Criteria andBorrowidNotIn(List<Integer> values) {
            addCriterion("BorrowId not in", values, "borrowid");
            return (Criteria) this;
        }

        public Criteria andBorrowidBetween(Integer value1, Integer value2) {
            addCriterion("BorrowId between", value1, value2, "borrowid");
            return (Criteria) this;
        }

        public Criteria andBorrowidNotBetween(Integer value1, Integer value2) {
            addCriterion("BorrowId not between", value1, value2, "borrowid");
            return (Criteria) this;
        }

        public Criteria andBookidIsNull() {
            addCriterion("BookId is null");
            return (Criteria) this;
        }

        public Criteria andBookidIsNotNull() {
            addCriterion("BookId is not null");
            return (Criteria) this;
        }

        public Criteria andBookidEqualTo(Integer value) {
            addCriterion("BookId =", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidNotEqualTo(Integer value) {
            addCriterion("BookId <>", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidGreaterThan(Integer value) {
            addCriterion("BookId >", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidGreaterThanOrEqualTo(Integer value) {
            addCriterion("BookId >=", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidLessThan(Integer value) {
            addCriterion("BookId <", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidLessThanOrEqualTo(Integer value) {
            addCriterion("BookId <=", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidIn(List<Integer> values) {
            addCriterion("BookId in", values, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidNotIn(List<Integer> values) {
            addCriterion("BookId not in", values, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidBetween(Integer value1, Integer value2) {
            addCriterion("BookId between", value1, value2, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidNotBetween(Integer value1, Integer value2) {
            addCriterion("BookId not between", value1, value2, "bookid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("UserId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("UserId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("UserId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("UserId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("UserId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("UserId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("UserId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("UserId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("UserId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("UserId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("UserId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("UserId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andBorrowdateIsNull() {
            addCriterion("BorrowDate is null");
            return (Criteria) this;
        }

        public Criteria andBorrowdateIsNotNull() {
            addCriterion("BorrowDate is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowdateEqualTo(Date value) {
            addCriterion("BorrowDate =", value, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateNotEqualTo(Date value) {
            addCriterion("BorrowDate <>", value, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateGreaterThan(Date value) {
            addCriterion("BorrowDate >", value, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateGreaterThanOrEqualTo(Date value) {
            addCriterion("BorrowDate >=", value, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateLessThan(Date value) {
            addCriterion("BorrowDate <", value, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateLessThanOrEqualTo(Date value) {
            addCriterion("BorrowDate <=", value, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateIn(List<Date> values) {
            addCriterion("BorrowDate in", values, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateNotIn(List<Date> values) {
            addCriterion("BorrowDate not in", values, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateBetween(Date value1, Date value2) {
            addCriterion("BorrowDate between", value1, value2, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateNotBetween(Date value1, Date value2) {
            addCriterion("BorrowDate not between", value1, value2, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdayIsNull() {
            addCriterion("BorrowDay is null");
            return (Criteria) this;
        }

        public Criteria andBorrowdayIsNotNull() {
            addCriterion("BorrowDay is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowdayEqualTo(Integer value) {
            addCriterion("BorrowDay =", value, "borrowday");
            return (Criteria) this;
        }

        public Criteria andBorrowdayNotEqualTo(Integer value) {
            addCriterion("BorrowDay <>", value, "borrowday");
            return (Criteria) this;
        }

        public Criteria andBorrowdayGreaterThan(Integer value) {
            addCriterion("BorrowDay >", value, "borrowday");
            return (Criteria) this;
        }

        public Criteria andBorrowdayGreaterThanOrEqualTo(Integer value) {
            addCriterion("BorrowDay >=", value, "borrowday");
            return (Criteria) this;
        }

        public Criteria andBorrowdayLessThan(Integer value) {
            addCriterion("BorrowDay <", value, "borrowday");
            return (Criteria) this;
        }

        public Criteria andBorrowdayLessThanOrEqualTo(Integer value) {
            addCriterion("BorrowDay <=", value, "borrowday");
            return (Criteria) this;
        }

        public Criteria andBorrowdayIn(List<Integer> values) {
            addCriterion("BorrowDay in", values, "borrowday");
            return (Criteria) this;
        }

        public Criteria andBorrowdayNotIn(List<Integer> values) {
            addCriterion("BorrowDay not in", values, "borrowday");
            return (Criteria) this;
        }

        public Criteria andBorrowdayBetween(Integer value1, Integer value2) {
            addCriterion("BorrowDay between", value1, value2, "borrowday");
            return (Criteria) this;
        }

        public Criteria andBorrowdayNotBetween(Integer value1, Integer value2) {
            addCriterion("BorrowDay not between", value1, value2, "borrowday");
            return (Criteria) this;
        }

        public Criteria andIsreturnIsNull() {
            addCriterion("IsReturn is null");
            return (Criteria) this;
        }

        public Criteria andIsreturnIsNotNull() {
            addCriterion("IsReturn is not null");
            return (Criteria) this;
        }

        public Criteria andIsreturnEqualTo(Boolean value) {
            addCriterion("IsReturn =", value, "isreturn");
            return (Criteria) this;
        }

        public Criteria andIsreturnNotEqualTo(Boolean value) {
            addCriterion("IsReturn <>", value, "isreturn");
            return (Criteria) this;
        }

        public Criteria andIsreturnGreaterThan(Boolean value) {
            addCriterion("IsReturn >", value, "isreturn");
            return (Criteria) this;
        }

        public Criteria andIsreturnGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IsReturn >=", value, "isreturn");
            return (Criteria) this;
        }

        public Criteria andIsreturnLessThan(Boolean value) {
            addCriterion("IsReturn <", value, "isreturn");
            return (Criteria) this;
        }

        public Criteria andIsreturnLessThanOrEqualTo(Boolean value) {
            addCriterion("IsReturn <=", value, "isreturn");
            return (Criteria) this;
        }

        public Criteria andIsreturnIn(List<Boolean> values) {
            addCriterion("IsReturn in", values, "isreturn");
            return (Criteria) this;
        }

        public Criteria andIsreturnNotIn(List<Boolean> values) {
            addCriterion("IsReturn not in", values, "isreturn");
            return (Criteria) this;
        }

        public Criteria andIsreturnBetween(Boolean value1, Boolean value2) {
            addCriterion("IsReturn between", value1, value2, "isreturn");
            return (Criteria) this;
        }

        public Criteria andIsreturnNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IsReturn not between", value1, value2, "isreturn");
            return (Criteria) this;
        }

        public Criteria andReturntimeIsNull() {
            addCriterion("ReturnTime is null");
            return (Criteria) this;
        }

        public Criteria andReturntimeIsNotNull() {
            addCriterion("ReturnTime is not null");
            return (Criteria) this;
        }

        public Criteria andReturntimeEqualTo(Date value) {
            addCriterion("ReturnTime =", value, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeNotEqualTo(Date value) {
            addCriterion("ReturnTime <>", value, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeGreaterThan(Date value) {
            addCriterion("ReturnTime >", value, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ReturnTime >=", value, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeLessThan(Date value) {
            addCriterion("ReturnTime <", value, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeLessThanOrEqualTo(Date value) {
            addCriterion("ReturnTime <=", value, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeIn(List<Date> values) {
            addCriterion("ReturnTime in", values, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeNotIn(List<Date> values) {
            addCriterion("ReturnTime not in", values, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeBetween(Date value1, Date value2) {
            addCriterion("ReturnTime between", value1, value2, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeNotBetween(Date value1, Date value2) {
            addCriterion("ReturnTime not between", value1, value2, "returntime");
            return (Criteria) this;
        }

        public Criteria andIsrenewIsNull() {
            addCriterion("IsRenew is null");
            return (Criteria) this;
        }

        public Criteria andIsrenewIsNotNull() {
            addCriterion("IsRenew is not null");
            return (Criteria) this;
        }

        public Criteria andIsrenewEqualTo(Boolean value) {
            addCriterion("IsRenew =", value, "isrenew");
            return (Criteria) this;
        }

        public Criteria andIsrenewNotEqualTo(Boolean value) {
            addCriterion("IsRenew <>", value, "isrenew");
            return (Criteria) this;
        }

        public Criteria andIsrenewGreaterThan(Boolean value) {
            addCriterion("IsRenew >", value, "isrenew");
            return (Criteria) this;
        }

        public Criteria andIsrenewGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IsRenew >=", value, "isrenew");
            return (Criteria) this;
        }

        public Criteria andIsrenewLessThan(Boolean value) {
            addCriterion("IsRenew <", value, "isrenew");
            return (Criteria) this;
        }

        public Criteria andIsrenewLessThanOrEqualTo(Boolean value) {
            addCriterion("IsRenew <=", value, "isrenew");
            return (Criteria) this;
        }

        public Criteria andIsrenewIn(List<Boolean> values) {
            addCriterion("IsRenew in", values, "isrenew");
            return (Criteria) this;
        }

        public Criteria andIsrenewNotIn(List<Boolean> values) {
            addCriterion("IsRenew not in", values, "isrenew");
            return (Criteria) this;
        }

        public Criteria andIsrenewBetween(Boolean value1, Boolean value2) {
            addCriterion("IsRenew between", value1, value2, "isrenew");
            return (Criteria) this;
        }

        public Criteria andIsrenewNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IsRenew not between", value1, value2, "isrenew");
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