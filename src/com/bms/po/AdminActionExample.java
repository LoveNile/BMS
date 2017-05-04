package com.bms.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminActionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminActionExample() {
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

        public Criteria andAdminactionidIsNull() {
            addCriterion("AdminActionId is null");
            return (Criteria) this;
        }

        public Criteria andAdminactionidIsNotNull() {
            addCriterion("AdminActionId is not null");
            return (Criteria) this;
        }

        public Criteria andAdminactionidEqualTo(Integer value) {
            addCriterion("AdminActionId =", value, "adminactionid");
            return (Criteria) this;
        }

        public Criteria andAdminactionidNotEqualTo(Integer value) {
            addCriterion("AdminActionId <>", value, "adminactionid");
            return (Criteria) this;
        }

        public Criteria andAdminactionidGreaterThan(Integer value) {
            addCriterion("AdminActionId >", value, "adminactionid");
            return (Criteria) this;
        }

        public Criteria andAdminactionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("AdminActionId >=", value, "adminactionid");
            return (Criteria) this;
        }

        public Criteria andAdminactionidLessThan(Integer value) {
            addCriterion("AdminActionId <", value, "adminactionid");
            return (Criteria) this;
        }

        public Criteria andAdminactionidLessThanOrEqualTo(Integer value) {
            addCriterion("AdminActionId <=", value, "adminactionid");
            return (Criteria) this;
        }

        public Criteria andAdminactionidIn(List<Integer> values) {
            addCriterion("AdminActionId in", values, "adminactionid");
            return (Criteria) this;
        }

        public Criteria andAdminactionidNotIn(List<Integer> values) {
            addCriterion("AdminActionId not in", values, "adminactionid");
            return (Criteria) this;
        }

        public Criteria andAdminactionidBetween(Integer value1, Integer value2) {
            addCriterion("AdminActionId between", value1, value2, "adminactionid");
            return (Criteria) this;
        }

        public Criteria andAdminactionidNotBetween(Integer value1, Integer value2) {
            addCriterion("AdminActionId not between", value1, value2, "adminactionid");
            return (Criteria) this;
        }

        public Criteria andAdminidIsNull() {
            addCriterion("AdminId is null");
            return (Criteria) this;
        }

        public Criteria andAdminidIsNotNull() {
            addCriterion("AdminId is not null");
            return (Criteria) this;
        }

        public Criteria andAdminidEqualTo(Integer value) {
            addCriterion("AdminId =", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidNotEqualTo(Integer value) {
            addCriterion("AdminId <>", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidGreaterThan(Integer value) {
            addCriterion("AdminId >", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidGreaterThanOrEqualTo(Integer value) {
            addCriterion("AdminId >=", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidLessThan(Integer value) {
            addCriterion("AdminId <", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidLessThanOrEqualTo(Integer value) {
            addCriterion("AdminId <=", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidIn(List<Integer> values) {
            addCriterion("AdminId in", values, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidNotIn(List<Integer> values) {
            addCriterion("AdminId not in", values, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidBetween(Integer value1, Integer value2) {
            addCriterion("AdminId between", value1, value2, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidNotBetween(Integer value1, Integer value2) {
            addCriterion("AdminId not between", value1, value2, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminactiontypeIsNull() {
            addCriterion("AdminActionType is null");
            return (Criteria) this;
        }

        public Criteria andAdminactiontypeIsNotNull() {
            addCriterion("AdminActionType is not null");
            return (Criteria) this;
        }

        public Criteria andAdminactiontypeEqualTo(String value) {
            addCriterion("AdminActionType =", value, "adminactiontype");
            return (Criteria) this;
        }

        public Criteria andAdminactiontypeNotEqualTo(String value) {
            addCriterion("AdminActionType <>", value, "adminactiontype");
            return (Criteria) this;
        }

        public Criteria andAdminactiontypeGreaterThan(String value) {
            addCriterion("AdminActionType >", value, "adminactiontype");
            return (Criteria) this;
        }

        public Criteria andAdminactiontypeGreaterThanOrEqualTo(String value) {
            addCriterion("AdminActionType >=", value, "adminactiontype");
            return (Criteria) this;
        }

        public Criteria andAdminactiontypeLessThan(String value) {
            addCriterion("AdminActionType <", value, "adminactiontype");
            return (Criteria) this;
        }

        public Criteria andAdminactiontypeLessThanOrEqualTo(String value) {
            addCriterion("AdminActionType <=", value, "adminactiontype");
            return (Criteria) this;
        }

        public Criteria andAdminactiontypeLike(String value) {
            addCriterion("AdminActionType like", value, "adminactiontype");
            return (Criteria) this;
        }

        public Criteria andAdminactiontypeNotLike(String value) {
            addCriterion("AdminActionType not like", value, "adminactiontype");
            return (Criteria) this;
        }

        public Criteria andAdminactiontypeIn(List<String> values) {
            addCriterion("AdminActionType in", values, "adminactiontype");
            return (Criteria) this;
        }

        public Criteria andAdminactiontypeNotIn(List<String> values) {
            addCriterion("AdminActionType not in", values, "adminactiontype");
            return (Criteria) this;
        }

        public Criteria andAdminactiontypeBetween(String value1, String value2) {
            addCriterion("AdminActionType between", value1, value2, "adminactiontype");
            return (Criteria) this;
        }

        public Criteria andAdminactiontypeNotBetween(String value1, String value2) {
            addCriterion("AdminActionType not between", value1, value2, "adminactiontype");
            return (Criteria) this;
        }

        public Criteria andAdminactiontimeIsNull() {
            addCriterion("AdminActionTime is null");
            return (Criteria) this;
        }

        public Criteria andAdminactiontimeIsNotNull() {
            addCriterion("AdminActionTime is not null");
            return (Criteria) this;
        }

        public Criteria andAdminactiontimeEqualTo(Date value) {
            addCriterion("AdminActionTime =", value, "adminactiontime");
            return (Criteria) this;
        }

        public Criteria andAdminactiontimeNotEqualTo(Date value) {
            addCriterion("AdminActionTime <>", value, "adminactiontime");
            return (Criteria) this;
        }

        public Criteria andAdminactiontimeGreaterThan(Date value) {
            addCriterion("AdminActionTime >", value, "adminactiontime");
            return (Criteria) this;
        }

        public Criteria andAdminactiontimeGreaterThanOrEqualTo(Date value) {
            addCriterion("AdminActionTime >=", value, "adminactiontime");
            return (Criteria) this;
        }

        public Criteria andAdminactiontimeLessThan(Date value) {
            addCriterion("AdminActionTime <", value, "adminactiontime");
            return (Criteria) this;
        }

        public Criteria andAdminactiontimeLessThanOrEqualTo(Date value) {
            addCriterion("AdminActionTime <=", value, "adminactiontime");
            return (Criteria) this;
        }

        public Criteria andAdminactiontimeIn(List<Date> values) {
            addCriterion("AdminActionTime in", values, "adminactiontime");
            return (Criteria) this;
        }

        public Criteria andAdminactiontimeNotIn(List<Date> values) {
            addCriterion("AdminActionTime not in", values, "adminactiontime");
            return (Criteria) this;
        }

        public Criteria andAdminactiontimeBetween(Date value1, Date value2) {
            addCriterion("AdminActionTime between", value1, value2, "adminactiontime");
            return (Criteria) this;
        }

        public Criteria andAdminactiontimeNotBetween(Date value1, Date value2) {
            addCriterion("AdminActionTime not between", value1, value2, "adminactiontime");
            return (Criteria) this;
        }

        public Criteria andAdminactiontoIsNull() {
            addCriterion("AdminActionTo is null");
            return (Criteria) this;
        }

        public Criteria andAdminactiontoIsNotNull() {
            addCriterion("AdminActionTo is not null");
            return (Criteria) this;
        }

        public Criteria andAdminactiontoEqualTo(String value) {
            addCriterion("AdminActionTo =", value, "adminactionto");
            return (Criteria) this;
        }

        public Criteria andAdminactiontoNotEqualTo(String value) {
            addCriterion("AdminActionTo <>", value, "adminactionto");
            return (Criteria) this;
        }

        public Criteria andAdminactiontoGreaterThan(String value) {
            addCriterion("AdminActionTo >", value, "adminactionto");
            return (Criteria) this;
        }

        public Criteria andAdminactiontoGreaterThanOrEqualTo(String value) {
            addCriterion("AdminActionTo >=", value, "adminactionto");
            return (Criteria) this;
        }

        public Criteria andAdminactiontoLessThan(String value) {
            addCriterion("AdminActionTo <", value, "adminactionto");
            return (Criteria) this;
        }

        public Criteria andAdminactiontoLessThanOrEqualTo(String value) {
            addCriterion("AdminActionTo <=", value, "adminactionto");
            return (Criteria) this;
        }

        public Criteria andAdminactiontoLike(String value) {
            addCriterion("AdminActionTo like", value, "adminactionto");
            return (Criteria) this;
        }

        public Criteria andAdminactiontoNotLike(String value) {
            addCriterion("AdminActionTo not like", value, "adminactionto");
            return (Criteria) this;
        }

        public Criteria andAdminactiontoIn(List<String> values) {
            addCriterion("AdminActionTo in", values, "adminactionto");
            return (Criteria) this;
        }

        public Criteria andAdminactiontoNotIn(List<String> values) {
            addCriterion("AdminActionTo not in", values, "adminactionto");
            return (Criteria) this;
        }

        public Criteria andAdminactiontoBetween(String value1, String value2) {
            addCriterion("AdminActionTo between", value1, value2, "adminactionto");
            return (Criteria) this;
        }

        public Criteria andAdminactiontoNotBetween(String value1, String value2) {
            addCriterion("AdminActionTo not between", value1, value2, "adminactionto");
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