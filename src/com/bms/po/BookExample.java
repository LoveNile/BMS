package com.bms.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookExample() {
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

        public Criteria andBookidIsNull() {
            addCriterion("BookId is null");
            return (Criteria) this;
        }

        public Criteria andBookidIsNotNull() {
            addCriterion("BookId is not null");
            return (Criteria) this;
        }

        public Criteria andBookidEqualTo(Long value) {
            addCriterion("BookId =", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidNotEqualTo(Long value) {
            addCriterion("BookId <>", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidGreaterThan(Long value) {
            addCriterion("BookId >", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidGreaterThanOrEqualTo(Long value) {
            addCriterion("BookId >=", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidLessThan(Long value) {
            addCriterion("BookId <", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidLessThanOrEqualTo(Long value) {
            addCriterion("BookId <=", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidIn(List<Long> values) {
            addCriterion("BookId in", values, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidNotIn(List<Long> values) {
            addCriterion("BookId not in", values, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidBetween(Long value1, Long value2) {
            addCriterion("BookId between", value1, value2, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidNotBetween(Long value1, Long value2) {
            addCriterion("BookId not between", value1, value2, "bookid");
            return (Criteria) this;
        }

        public Criteria andBooknameIsNull() {
            addCriterion("BookName is null");
            return (Criteria) this;
        }

        public Criteria andBooknameIsNotNull() {
            addCriterion("BookName is not null");
            return (Criteria) this;
        }

        public Criteria andBooknameEqualTo(String value) {
            addCriterion("BookName =", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameNotEqualTo(String value) {
            addCriterion("BookName <>", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameGreaterThan(String value) {
            addCriterion("BookName >", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameGreaterThanOrEqualTo(String value) {
            addCriterion("BookName >=", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameLessThan(String value) {
            addCriterion("BookName <", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameLessThanOrEqualTo(String value) {
            addCriterion("BookName <=", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameLike(String value) {
            addCriterion("BookName like", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameNotLike(String value) {
            addCriterion("BookName not like", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameIn(List<String> values) {
            addCriterion("BookName in", values, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameNotIn(List<String> values) {
            addCriterion("BookName not in", values, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameBetween(String value1, String value2) {
            addCriterion("BookName between", value1, value2, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameNotBetween(String value1, String value2) {
            addCriterion("BookName not between", value1, value2, "bookname");
            return (Criteria) this;
        }

        public Criteria andBookauthorIsNull() {
            addCriterion("BookAuthor is null");
            return (Criteria) this;
        }

        public Criteria andBookauthorIsNotNull() {
            addCriterion("BookAuthor is not null");
            return (Criteria) this;
        }

        public Criteria andBookauthorEqualTo(String value) {
            addCriterion("BookAuthor =", value, "bookauthor");
            return (Criteria) this;
        }

        public Criteria andBookauthorNotEqualTo(String value) {
            addCriterion("BookAuthor <>", value, "bookauthor");
            return (Criteria) this;
        }

        public Criteria andBookauthorGreaterThan(String value) {
            addCriterion("BookAuthor >", value, "bookauthor");
            return (Criteria) this;
        }

        public Criteria andBookauthorGreaterThanOrEqualTo(String value) {
            addCriterion("BookAuthor >=", value, "bookauthor");
            return (Criteria) this;
        }

        public Criteria andBookauthorLessThan(String value) {
            addCriterion("BookAuthor <", value, "bookauthor");
            return (Criteria) this;
        }

        public Criteria andBookauthorLessThanOrEqualTo(String value) {
            addCriterion("BookAuthor <=", value, "bookauthor");
            return (Criteria) this;
        }

        public Criteria andBookauthorLike(String value) {
            addCriterion("BookAuthor like", value, "bookauthor");
            return (Criteria) this;
        }

        public Criteria andBookauthorNotLike(String value) {
            addCriterion("BookAuthor not like", value, "bookauthor");
            return (Criteria) this;
        }

        public Criteria andBookauthorIn(List<String> values) {
            addCriterion("BookAuthor in", values, "bookauthor");
            return (Criteria) this;
        }

        public Criteria andBookauthorNotIn(List<String> values) {
            addCriterion("BookAuthor not in", values, "bookauthor");
            return (Criteria) this;
        }

        public Criteria andBookauthorBetween(String value1, String value2) {
            addCriterion("BookAuthor between", value1, value2, "bookauthor");
            return (Criteria) this;
        }

        public Criteria andBookauthorNotBetween(String value1, String value2) {
            addCriterion("BookAuthor not between", value1, value2, "bookauthor");
            return (Criteria) this;
        }

        public Criteria andCategoryidIsNull() {
            addCriterion("CategoryId is null");
            return (Criteria) this;
        }

        public Criteria andCategoryidIsNotNull() {
            addCriterion("CategoryId is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryidEqualTo(Integer value) {
            addCriterion("CategoryId =", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidNotEqualTo(Integer value) {
            addCriterion("CategoryId <>", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidGreaterThan(Integer value) {
            addCriterion("CategoryId >", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CategoryId >=", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidLessThan(Integer value) {
            addCriterion("CategoryId <", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidLessThanOrEqualTo(Integer value) {
            addCriterion("CategoryId <=", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidIn(List<Integer> values) {
            addCriterion("CategoryId in", values, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidNotIn(List<Integer> values) {
            addCriterion("CategoryId not in", values, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidBetween(Integer value1, Integer value2) {
            addCriterion("CategoryId between", value1, value2, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidNotBetween(Integer value1, Integer value2) {
            addCriterion("CategoryId not between", value1, value2, "categoryid");
            return (Criteria) this;
        }

        public Criteria andBookpressIsNull() {
            addCriterion("BookPress is null");
            return (Criteria) this;
        }

        public Criteria andBookpressIsNotNull() {
            addCriterion("BookPress is not null");
            return (Criteria) this;
        }

        public Criteria andBookpressEqualTo(String value) {
            addCriterion("BookPress =", value, "bookpress");
            return (Criteria) this;
        }

        public Criteria andBookpressNotEqualTo(String value) {
            addCriterion("BookPress <>", value, "bookpress");
            return (Criteria) this;
        }

        public Criteria andBookpressGreaterThan(String value) {
            addCriterion("BookPress >", value, "bookpress");
            return (Criteria) this;
        }

        public Criteria andBookpressGreaterThanOrEqualTo(String value) {
            addCriterion("BookPress >=", value, "bookpress");
            return (Criteria) this;
        }

        public Criteria andBookpressLessThan(String value) {
            addCriterion("BookPress <", value, "bookpress");
            return (Criteria) this;
        }

        public Criteria andBookpressLessThanOrEqualTo(String value) {
            addCriterion("BookPress <=", value, "bookpress");
            return (Criteria) this;
        }

        public Criteria andBookpressLike(String value) {
            addCriterion("BookPress like", value, "bookpress");
            return (Criteria) this;
        }

        public Criteria andBookpressNotLike(String value) {
            addCriterion("BookPress not like", value, "bookpress");
            return (Criteria) this;
        }

        public Criteria andBookpressIn(List<String> values) {
            addCriterion("BookPress in", values, "bookpress");
            return (Criteria) this;
        }

        public Criteria andBookpressNotIn(List<String> values) {
            addCriterion("BookPress not in", values, "bookpress");
            return (Criteria) this;
        }

        public Criteria andBookpressBetween(String value1, String value2) {
            addCriterion("BookPress between", value1, value2, "bookpress");
            return (Criteria) this;
        }

        public Criteria andBookpressNotBetween(String value1, String value2) {
            addCriterion("BookPress not between", value1, value2, "bookpress");
            return (Criteria) this;
        }

        public Criteria andPublisheddateIsNull() {
            addCriterion("PublishedDate is null");
            return (Criteria) this;
        }

        public Criteria andPublisheddateIsNotNull() {
            addCriterion("PublishedDate is not null");
            return (Criteria) this;
        }

        public Criteria andPublisheddateEqualTo(Date value) {
            addCriterionForJDBCDate("PublishedDate =", value, "publisheddate");
            return (Criteria) this;
        }

        public Criteria andPublisheddateNotEqualTo(Date value) {
            addCriterionForJDBCDate("PublishedDate <>", value, "publisheddate");
            return (Criteria) this;
        }

        public Criteria andPublisheddateGreaterThan(Date value) {
            addCriterionForJDBCDate("PublishedDate >", value, "publisheddate");
            return (Criteria) this;
        }

        public Criteria andPublisheddateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PublishedDate >=", value, "publisheddate");
            return (Criteria) this;
        }

        public Criteria andPublisheddateLessThan(Date value) {
            addCriterionForJDBCDate("PublishedDate <", value, "publisheddate");
            return (Criteria) this;
        }

        public Criteria andPublisheddateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PublishedDate <=", value, "publisheddate");
            return (Criteria) this;
        }

        public Criteria andPublisheddateIn(List<Date> values) {
            addCriterionForJDBCDate("PublishedDate in", values, "publisheddate");
            return (Criteria) this;
        }

        public Criteria andPublisheddateNotIn(List<Date> values) {
            addCriterionForJDBCDate("PublishedDate not in", values, "publisheddate");
            return (Criteria) this;
        }

        public Criteria andPublisheddateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PublishedDate between", value1, value2, "publisheddate");
            return (Criteria) this;
        }

        public Criteria andPublisheddateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PublishedDate not between", value1, value2, "publisheddate");
            return (Criteria) this;
        }

        public Criteria andBookentertimeIsNull() {
            addCriterion("BookEnterTime is null");
            return (Criteria) this;
        }

        public Criteria andBookentertimeIsNotNull() {
            addCriterion("BookEnterTime is not null");
            return (Criteria) this;
        }

        public Criteria andBookentertimeEqualTo(Date value) {
            addCriterionForJDBCDate("BookEnterTime =", value, "bookentertime");
            return (Criteria) this;
        }

        public Criteria andBookentertimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("BookEnterTime <>", value, "bookentertime");
            return (Criteria) this;
        }

        public Criteria andBookentertimeGreaterThan(Date value) {
            addCriterionForJDBCDate("BookEnterTime >", value, "bookentertime");
            return (Criteria) this;
        }

        public Criteria andBookentertimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BookEnterTime >=", value, "bookentertime");
            return (Criteria) this;
        }

        public Criteria andBookentertimeLessThan(Date value) {
            addCriterionForJDBCDate("BookEnterTime <", value, "bookentertime");
            return (Criteria) this;
        }

        public Criteria andBookentertimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BookEnterTime <=", value, "bookentertime");
            return (Criteria) this;
        }

        public Criteria andBookentertimeIn(List<Date> values) {
            addCriterionForJDBCDate("BookEnterTime in", values, "bookentertime");
            return (Criteria) this;
        }

        public Criteria andBookentertimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("BookEnterTime not in", values, "bookentertime");
            return (Criteria) this;
        }

        public Criteria andBookentertimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BookEnterTime between", value1, value2, "bookentertime");
            return (Criteria) this;
        }

        public Criteria andBookentertimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BookEnterTime not between", value1, value2, "bookentertime");
            return (Criteria) this;
        }

        public Criteria andBookintroductionIsNull() {
            addCriterion("BookIntroduction is null");
            return (Criteria) this;
        }

        public Criteria andBookintroductionIsNotNull() {
            addCriterion("BookIntroduction is not null");
            return (Criteria) this;
        }

        public Criteria andBookintroductionEqualTo(String value) {
            addCriterion("BookIntroduction =", value, "bookintroduction");
            return (Criteria) this;
        }

        public Criteria andBookintroductionNotEqualTo(String value) {
            addCriterion("BookIntroduction <>", value, "bookintroduction");
            return (Criteria) this;
        }

        public Criteria andBookintroductionGreaterThan(String value) {
            addCriterion("BookIntroduction >", value, "bookintroduction");
            return (Criteria) this;
        }

        public Criteria andBookintroductionGreaterThanOrEqualTo(String value) {
            addCriterion("BookIntroduction >=", value, "bookintroduction");
            return (Criteria) this;
        }

        public Criteria andBookintroductionLessThan(String value) {
            addCriterion("BookIntroduction <", value, "bookintroduction");
            return (Criteria) this;
        }

        public Criteria andBookintroductionLessThanOrEqualTo(String value) {
            addCriterion("BookIntroduction <=", value, "bookintroduction");
            return (Criteria) this;
        }

        public Criteria andBookintroductionLike(String value) {
            addCriterion("BookIntroduction like", value, "bookintroduction");
            return (Criteria) this;
        }

        public Criteria andBookintroductionNotLike(String value) {
            addCriterion("BookIntroduction not like", value, "bookintroduction");
            return (Criteria) this;
        }

        public Criteria andBookintroductionIn(List<String> values) {
            addCriterion("BookIntroduction in", values, "bookintroduction");
            return (Criteria) this;
        }

        public Criteria andBookintroductionNotIn(List<String> values) {
            addCriterion("BookIntroduction not in", values, "bookintroduction");
            return (Criteria) this;
        }

        public Criteria andBookintroductionBetween(String value1, String value2) {
            addCriterion("BookIntroduction between", value1, value2, "bookintroduction");
            return (Criteria) this;
        }

        public Criteria andBookintroductionNotBetween(String value1, String value2) {
            addCriterion("BookIntroduction not between", value1, value2, "bookintroduction");
            return (Criteria) this;
        }

        public Criteria andBookaddressIsNull() {
            addCriterion("BookAddress is null");
            return (Criteria) this;
        }

        public Criteria andBookaddressIsNotNull() {
            addCriterion("BookAddress is not null");
            return (Criteria) this;
        }

        public Criteria andBookaddressEqualTo(String value) {
            addCriterion("BookAddress =", value, "bookaddress");
            return (Criteria) this;
        }

        public Criteria andBookaddressNotEqualTo(String value) {
            addCriterion("BookAddress <>", value, "bookaddress");
            return (Criteria) this;
        }

        public Criteria andBookaddressGreaterThan(String value) {
            addCriterion("BookAddress >", value, "bookaddress");
            return (Criteria) this;
        }

        public Criteria andBookaddressGreaterThanOrEqualTo(String value) {
            addCriterion("BookAddress >=", value, "bookaddress");
            return (Criteria) this;
        }

        public Criteria andBookaddressLessThan(String value) {
            addCriterion("BookAddress <", value, "bookaddress");
            return (Criteria) this;
        }

        public Criteria andBookaddressLessThanOrEqualTo(String value) {
            addCriterion("BookAddress <=", value, "bookaddress");
            return (Criteria) this;
        }

        public Criteria andBookaddressLike(String value) {
            addCriterion("BookAddress like", value, "bookaddress");
            return (Criteria) this;
        }

        public Criteria andBookaddressNotLike(String value) {
            addCriterion("BookAddress not like", value, "bookaddress");
            return (Criteria) this;
        }

        public Criteria andBookaddressIn(List<String> values) {
            addCriterion("BookAddress in", values, "bookaddress");
            return (Criteria) this;
        }

        public Criteria andBookaddressNotIn(List<String> values) {
            addCriterion("BookAddress not in", values, "bookaddress");
            return (Criteria) this;
        }

        public Criteria andBookaddressBetween(String value1, String value2) {
            addCriterion("BookAddress between", value1, value2, "bookaddress");
            return (Criteria) this;
        }

        public Criteria andBookaddressNotBetween(String value1, String value2) {
            addCriterion("BookAddress not between", value1, value2, "bookaddress");
            return (Criteria) this;
        }

        public Criteria andBookpicpathIsNull() {
            addCriterion("BookPicPath is null");
            return (Criteria) this;
        }

        public Criteria andBookpicpathIsNotNull() {
            addCriterion("BookPicPath is not null");
            return (Criteria) this;
        }

        public Criteria andBookpicpathEqualTo(String value) {
            addCriterion("BookPicPath =", value, "bookpicpath");
            return (Criteria) this;
        }

        public Criteria andBookpicpathNotEqualTo(String value) {
            addCriterion("BookPicPath <>", value, "bookpicpath");
            return (Criteria) this;
        }

        public Criteria andBookpicpathGreaterThan(String value) {
            addCriterion("BookPicPath >", value, "bookpicpath");
            return (Criteria) this;
        }

        public Criteria andBookpicpathGreaterThanOrEqualTo(String value) {
            addCriterion("BookPicPath >=", value, "bookpicpath");
            return (Criteria) this;
        }

        public Criteria andBookpicpathLessThan(String value) {
            addCriterion("BookPicPath <", value, "bookpicpath");
            return (Criteria) this;
        }

        public Criteria andBookpicpathLessThanOrEqualTo(String value) {
            addCriterion("BookPicPath <=", value, "bookpicpath");
            return (Criteria) this;
        }

        public Criteria andBookpicpathLike(String value) {
            addCriterion("BookPicPath like", value, "bookpicpath");
            return (Criteria) this;
        }

        public Criteria andBookpicpathNotLike(String value) {
            addCriterion("BookPicPath not like", value, "bookpicpath");
            return (Criteria) this;
        }

        public Criteria andBookpicpathIn(List<String> values) {
            addCriterion("BookPicPath in", values, "bookpicpath");
            return (Criteria) this;
        }

        public Criteria andBookpicpathNotIn(List<String> values) {
            addCriterion("BookPicPath not in", values, "bookpicpath");
            return (Criteria) this;
        }

        public Criteria andBookpicpathBetween(String value1, String value2) {
            addCriterion("BookPicPath between", value1, value2, "bookpicpath");
            return (Criteria) this;
        }

        public Criteria andBookpicpathNotBetween(String value1, String value2) {
            addCriterion("BookPicPath not between", value1, value2, "bookpicpath");
            return (Criteria) this;
        }

        public Criteria andDelmakerIsNull() {
            addCriterion("DelMaker is null");
            return (Criteria) this;
        }

        public Criteria andDelmakerIsNotNull() {
            addCriterion("DelMaker is not null");
            return (Criteria) this;
        }

        public Criteria andDelmakerEqualTo(Boolean value) {
            addCriterion("DelMaker =", value, "delmaker");
            return (Criteria) this;
        }

        public Criteria andDelmakerNotEqualTo(Boolean value) {
            addCriterion("DelMaker <>", value, "delmaker");
            return (Criteria) this;
        }

        public Criteria andDelmakerGreaterThan(Boolean value) {
            addCriterion("DelMaker >", value, "delmaker");
            return (Criteria) this;
        }

        public Criteria andDelmakerGreaterThanOrEqualTo(Boolean value) {
            addCriterion("DelMaker >=", value, "delmaker");
            return (Criteria) this;
        }

        public Criteria andDelmakerLessThan(Boolean value) {
            addCriterion("DelMaker <", value, "delmaker");
            return (Criteria) this;
        }

        public Criteria andDelmakerLessThanOrEqualTo(Boolean value) {
            addCriterion("DelMaker <=", value, "delmaker");
            return (Criteria) this;
        }

        public Criteria andDelmakerIn(List<Boolean> values) {
            addCriterion("DelMaker in", values, "delmaker");
            return (Criteria) this;
        }

        public Criteria andDelmakerNotIn(List<Boolean> values) {
            addCriterion("DelMaker not in", values, "delmaker");
            return (Criteria) this;
        }

        public Criteria andDelmakerBetween(Boolean value1, Boolean value2) {
            addCriterion("DelMaker between", value1, value2, "delmaker");
            return (Criteria) this;
        }

        public Criteria andDelmakerNotBetween(Boolean value1, Boolean value2) {
            addCriterion("DelMaker not between", value1, value2, "delmaker");
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