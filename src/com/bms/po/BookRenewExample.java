package com.bms.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookRenewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookRenewExample() {
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

        public Criteria andBookrenewidIsNull() {
            addCriterion("BookRenewId is null");
            return (Criteria) this;
        }

        public Criteria andBookrenewidIsNotNull() {
            addCriterion("BookRenewId is not null");
            return (Criteria) this;
        }

        public Criteria andBookrenewidEqualTo(Integer value) {
            addCriterion("BookRenewId =", value, "bookrenewid");
            return (Criteria) this;
        }

        public Criteria andBookrenewidNotEqualTo(Integer value) {
            addCriterion("BookRenewId <>", value, "bookrenewid");
            return (Criteria) this;
        }

        public Criteria andBookrenewidGreaterThan(Integer value) {
            addCriterion("BookRenewId >", value, "bookrenewid");
            return (Criteria) this;
        }

        public Criteria andBookrenewidGreaterThanOrEqualTo(Integer value) {
            addCriterion("BookRenewId >=", value, "bookrenewid");
            return (Criteria) this;
        }

        public Criteria andBookrenewidLessThan(Integer value) {
            addCriterion("BookRenewId <", value, "bookrenewid");
            return (Criteria) this;
        }

        public Criteria andBookrenewidLessThanOrEqualTo(Integer value) {
            addCriterion("BookRenewId <=", value, "bookrenewid");
            return (Criteria) this;
        }

        public Criteria andBookrenewidIn(List<Integer> values) {
            addCriterion("BookRenewId in", values, "bookrenewid");
            return (Criteria) this;
        }

        public Criteria andBookrenewidNotIn(List<Integer> values) {
            addCriterion("BookRenewId not in", values, "bookrenewid");
            return (Criteria) this;
        }

        public Criteria andBookrenewidBetween(Integer value1, Integer value2) {
            addCriterion("BookRenewId between", value1, value2, "bookrenewid");
            return (Criteria) this;
        }

        public Criteria andBookrenewidNotBetween(Integer value1, Integer value2) {
            addCriterion("BookRenewId not between", value1, value2, "bookrenewid");
            return (Criteria) this;
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

        public Criteria andRenewdayIsNull() {
            addCriterion("RenewDay is null");
            return (Criteria) this;
        }

        public Criteria andRenewdayIsNotNull() {
            addCriterion("RenewDay is not null");
            return (Criteria) this;
        }

        public Criteria andRenewdayEqualTo(Integer value) {
            addCriterion("RenewDay =", value, "renewday");
            return (Criteria) this;
        }

        public Criteria andRenewdayNotEqualTo(Integer value) {
            addCriterion("RenewDay <>", value, "renewday");
            return (Criteria) this;
        }

        public Criteria andRenewdayGreaterThan(Integer value) {
            addCriterion("RenewDay >", value, "renewday");
            return (Criteria) this;
        }

        public Criteria andRenewdayGreaterThanOrEqualTo(Integer value) {
            addCriterion("RenewDay >=", value, "renewday");
            return (Criteria) this;
        }

        public Criteria andRenewdayLessThan(Integer value) {
            addCriterion("RenewDay <", value, "renewday");
            return (Criteria) this;
        }

        public Criteria andRenewdayLessThanOrEqualTo(Integer value) {
            addCriterion("RenewDay <=", value, "renewday");
            return (Criteria) this;
        }

        public Criteria andRenewdayIn(List<Integer> values) {
            addCriterion("RenewDay in", values, "renewday");
            return (Criteria) this;
        }

        public Criteria andRenewdayNotIn(List<Integer> values) {
            addCriterion("RenewDay not in", values, "renewday");
            return (Criteria) this;
        }

        public Criteria andRenewdayBetween(Integer value1, Integer value2) {
            addCriterion("RenewDay between", value1, value2, "renewday");
            return (Criteria) this;
        }

        public Criteria andRenewdayNotBetween(Integer value1, Integer value2) {
            addCriterion("RenewDay not between", value1, value2, "renewday");
            return (Criteria) this;
        }

        public Criteria andRenewdateIsNull() {
            addCriterion("RenewDate is null");
            return (Criteria) this;
        }

        public Criteria andRenewdateIsNotNull() {
            addCriterion("RenewDate is not null");
            return (Criteria) this;
        }

        public Criteria andRenewdateEqualTo(Date value) {
            addCriterion("RenewDate =", value, "renewdate");
            return (Criteria) this;
        }

        public Criteria andRenewdateNotEqualTo(Date value) {
            addCriterion("RenewDate <>", value, "renewdate");
            return (Criteria) this;
        }

        public Criteria andRenewdateGreaterThan(Date value) {
            addCriterion("RenewDate >", value, "renewdate");
            return (Criteria) this;
        }

        public Criteria andRenewdateGreaterThanOrEqualTo(Date value) {
            addCriterion("RenewDate >=", value, "renewdate");
            return (Criteria) this;
        }

        public Criteria andRenewdateLessThan(Date value) {
            addCriterion("RenewDate <", value, "renewdate");
            return (Criteria) this;
        }

        public Criteria andRenewdateLessThanOrEqualTo(Date value) {
            addCriterion("RenewDate <=", value, "renewdate");
            return (Criteria) this;
        }

        public Criteria andRenewdateIn(List<Date> values) {
            addCriterion("RenewDate in", values, "renewdate");
            return (Criteria) this;
        }

        public Criteria andRenewdateNotIn(List<Date> values) {
            addCriterion("RenewDate not in", values, "renewdate");
            return (Criteria) this;
        }

        public Criteria andRenewdateBetween(Date value1, Date value2) {
            addCriterion("RenewDate between", value1, value2, "renewdate");
            return (Criteria) this;
        }

        public Criteria andRenewdateNotBetween(Date value1, Date value2) {
            addCriterion("RenewDate not between", value1, value2, "renewdate");
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