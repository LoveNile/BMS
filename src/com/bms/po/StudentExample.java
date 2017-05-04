package com.bms.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentExample() {
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

        public Criteria andStudentnumberIsNull() {
            addCriterion("StudentNumber is null");
            return (Criteria) this;
        }

        public Criteria andStudentnumberIsNotNull() {
            addCriterion("StudentNumber is not null");
            return (Criteria) this;
        }

        public Criteria andStudentnumberEqualTo(Long value) {
            addCriterion("StudentNumber =", value, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberNotEqualTo(Long value) {
            addCriterion("StudentNumber <>", value, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberGreaterThan(Long value) {
            addCriterion("StudentNumber >", value, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberGreaterThanOrEqualTo(Long value) {
            addCriterion("StudentNumber >=", value, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberLessThan(Long value) {
            addCriterion("StudentNumber <", value, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberLessThanOrEqualTo(Long value) {
            addCriterion("StudentNumber <=", value, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberIn(List<Long> values) {
            addCriterion("StudentNumber in", values, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberNotIn(List<Long> values) {
            addCriterion("StudentNumber not in", values, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberBetween(Long value1, Long value2) {
            addCriterion("StudentNumber between", value1, value2, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberNotBetween(Long value1, Long value2) {
            addCriterion("StudentNumber not between", value1, value2, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnameIsNull() {
            addCriterion("StudentName is null");
            return (Criteria) this;
        }

        public Criteria andStudentnameIsNotNull() {
            addCriterion("StudentName is not null");
            return (Criteria) this;
        }

        public Criteria andStudentnameEqualTo(String value) {
            addCriterion("StudentName =", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotEqualTo(String value) {
            addCriterion("StudentName <>", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameGreaterThan(String value) {
            addCriterion("StudentName >", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameGreaterThanOrEqualTo(String value) {
            addCriterion("StudentName >=", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameLessThan(String value) {
            addCriterion("StudentName <", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameLessThanOrEqualTo(String value) {
            addCriterion("StudentName <=", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameLike(String value) {
            addCriterion("StudentName like", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotLike(String value) {
            addCriterion("StudentName not like", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameIn(List<String> values) {
            addCriterion("StudentName in", values, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotIn(List<String> values) {
            addCriterion("StudentName not in", values, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameBetween(String value1, String value2) {
            addCriterion("StudentName between", value1, value2, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotBetween(String value1, String value2) {
            addCriterion("StudentName not between", value1, value2, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudetpasswordIsNull() {
            addCriterion("StudetPassword is null");
            return (Criteria) this;
        }

        public Criteria andStudetpasswordIsNotNull() {
            addCriterion("StudetPassword is not null");
            return (Criteria) this;
        }

        public Criteria andStudetpasswordEqualTo(String value) {
            addCriterion("StudetPassword =", value, "studetpassword");
            return (Criteria) this;
        }

        public Criteria andStudetpasswordNotEqualTo(String value) {
            addCriterion("StudetPassword <>", value, "studetpassword");
            return (Criteria) this;
        }

        public Criteria andStudetpasswordGreaterThan(String value) {
            addCriterion("StudetPassword >", value, "studetpassword");
            return (Criteria) this;
        }

        public Criteria andStudetpasswordGreaterThanOrEqualTo(String value) {
            addCriterion("StudetPassword >=", value, "studetpassword");
            return (Criteria) this;
        }

        public Criteria andStudetpasswordLessThan(String value) {
            addCriterion("StudetPassword <", value, "studetpassword");
            return (Criteria) this;
        }

        public Criteria andStudetpasswordLessThanOrEqualTo(String value) {
            addCriterion("StudetPassword <=", value, "studetpassword");
            return (Criteria) this;
        }

        public Criteria andStudetpasswordLike(String value) {
            addCriterion("StudetPassword like", value, "studetpassword");
            return (Criteria) this;
        }

        public Criteria andStudetpasswordNotLike(String value) {
            addCriterion("StudetPassword not like", value, "studetpassword");
            return (Criteria) this;
        }

        public Criteria andStudetpasswordIn(List<String> values) {
            addCriterion("StudetPassword in", values, "studetpassword");
            return (Criteria) this;
        }

        public Criteria andStudetpasswordNotIn(List<String> values) {
            addCriterion("StudetPassword not in", values, "studetpassword");
            return (Criteria) this;
        }

        public Criteria andStudetpasswordBetween(String value1, String value2) {
            addCriterion("StudetPassword between", value1, value2, "studetpassword");
            return (Criteria) this;
        }

        public Criteria andStudetpasswordNotBetween(String value1, String value2) {
            addCriterion("StudetPassword not between", value1, value2, "studetpassword");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("Gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("Gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Boolean value) {
            addCriterion("Gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Boolean value) {
            addCriterion("Gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Boolean value) {
            addCriterion("Gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Boolean value) {
            addCriterion("Gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Boolean value) {
            addCriterion("Gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Boolean value) {
            addCriterion("Gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Boolean> values) {
            addCriterion("Gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Boolean> values) {
            addCriterion("Gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Boolean value1, Boolean value2) {
            addCriterion("Gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Boolean value1, Boolean value2) {
            addCriterion("Gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("Phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("Phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("Phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("Phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("Phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("Phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("Phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("Phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("Phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("Phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("Phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("Phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("Phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("Phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("Email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("Email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("Email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("Email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("Email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("Email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("Email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("Email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("Email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("Email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("Email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("Email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("Email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("Email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andCollegeIsNull() {
            addCriterion("College is null");
            return (Criteria) this;
        }

        public Criteria andCollegeIsNotNull() {
            addCriterion("College is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeEqualTo(String value) {
            addCriterion("College =", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotEqualTo(String value) {
            addCriterion("College <>", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeGreaterThan(String value) {
            addCriterion("College >", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeGreaterThanOrEqualTo(String value) {
            addCriterion("College >=", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLessThan(String value) {
            addCriterion("College <", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLessThanOrEqualTo(String value) {
            addCriterion("College <=", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLike(String value) {
            addCriterion("College like", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotLike(String value) {
            addCriterion("College not like", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeIn(List<String> values) {
            addCriterion("College in", values, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotIn(List<String> values) {
            addCriterion("College not in", values, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeBetween(String value1, String value2) {
            addCriterion("College between", value1, value2, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotBetween(String value1, String value2) {
            addCriterion("College not between", value1, value2, "college");
            return (Criteria) this;
        }

        public Criteria andSpecialityIsNull() {
            addCriterion("Speciality is null");
            return (Criteria) this;
        }

        public Criteria andSpecialityIsNotNull() {
            addCriterion("Speciality is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialityEqualTo(String value) {
            addCriterion("Speciality =", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityNotEqualTo(String value) {
            addCriterion("Speciality <>", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityGreaterThan(String value) {
            addCriterion("Speciality >", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityGreaterThanOrEqualTo(String value) {
            addCriterion("Speciality >=", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityLessThan(String value) {
            addCriterion("Speciality <", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityLessThanOrEqualTo(String value) {
            addCriterion("Speciality <=", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityLike(String value) {
            addCriterion("Speciality like", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityNotLike(String value) {
            addCriterion("Speciality not like", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityIn(List<String> values) {
            addCriterion("Speciality in", values, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityNotIn(List<String> values) {
            addCriterion("Speciality not in", values, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityBetween(String value1, String value2) {
            addCriterion("Speciality between", value1, value2, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityNotBetween(String value1, String value2) {
            addCriterion("Speciality not between", value1, value2, "speciality");
            return (Criteria) this;
        }

        public Criteria andStudentclassIsNull() {
            addCriterion("StudentClass is null");
            return (Criteria) this;
        }

        public Criteria andStudentclassIsNotNull() {
            addCriterion("StudentClass is not null");
            return (Criteria) this;
        }

        public Criteria andStudentclassEqualTo(String value) {
            addCriterion("StudentClass =", value, "studentclass");
            return (Criteria) this;
        }

        public Criteria andStudentclassNotEqualTo(String value) {
            addCriterion("StudentClass <>", value, "studentclass");
            return (Criteria) this;
        }

        public Criteria andStudentclassGreaterThan(String value) {
            addCriterion("StudentClass >", value, "studentclass");
            return (Criteria) this;
        }

        public Criteria andStudentclassGreaterThanOrEqualTo(String value) {
            addCriterion("StudentClass >=", value, "studentclass");
            return (Criteria) this;
        }

        public Criteria andStudentclassLessThan(String value) {
            addCriterion("StudentClass <", value, "studentclass");
            return (Criteria) this;
        }

        public Criteria andStudentclassLessThanOrEqualTo(String value) {
            addCriterion("StudentClass <=", value, "studentclass");
            return (Criteria) this;
        }

        public Criteria andStudentclassLike(String value) {
            addCriterion("StudentClass like", value, "studentclass");
            return (Criteria) this;
        }

        public Criteria andStudentclassNotLike(String value) {
            addCriterion("StudentClass not like", value, "studentclass");
            return (Criteria) this;
        }

        public Criteria andStudentclassIn(List<String> values) {
            addCriterion("StudentClass in", values, "studentclass");
            return (Criteria) this;
        }

        public Criteria andStudentclassNotIn(List<String> values) {
            addCriterion("StudentClass not in", values, "studentclass");
            return (Criteria) this;
        }

        public Criteria andStudentclassBetween(String value1, String value2) {
            addCriterion("StudentClass between", value1, value2, "studentclass");
            return (Criteria) this;
        }

        public Criteria andStudentclassNotBetween(String value1, String value2) {
            addCriterion("StudentClass not between", value1, value2, "studentclass");
            return (Criteria) this;
        }

        public Criteria andStudententeryearIsNull() {
            addCriterion("StudentEnterYear is null");
            return (Criteria) this;
        }

        public Criteria andStudententeryearIsNotNull() {
            addCriterion("StudentEnterYear is not null");
            return (Criteria) this;
        }

        public Criteria andStudententeryearEqualTo(Date value) {
            addCriterionForJDBCDate("StudentEnterYear =", value, "studententeryear");
            return (Criteria) this;
        }

        public Criteria andStudententeryearNotEqualTo(Date value) {
            addCriterionForJDBCDate("StudentEnterYear <>", value, "studententeryear");
            return (Criteria) this;
        }

        public Criteria andStudententeryearGreaterThan(Date value) {
            addCriterionForJDBCDate("StudentEnterYear >", value, "studententeryear");
            return (Criteria) this;
        }

        public Criteria andStudententeryearGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("StudentEnterYear >=", value, "studententeryear");
            return (Criteria) this;
        }

        public Criteria andStudententeryearLessThan(Date value) {
            addCriterionForJDBCDate("StudentEnterYear <", value, "studententeryear");
            return (Criteria) this;
        }

        public Criteria andStudententeryearLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("StudentEnterYear <=", value, "studententeryear");
            return (Criteria) this;
        }

        public Criteria andStudententeryearIn(List<Date> values) {
            addCriterionForJDBCDate("StudentEnterYear in", values, "studententeryear");
            return (Criteria) this;
        }

        public Criteria andStudententeryearNotIn(List<Date> values) {
            addCriterionForJDBCDate("StudentEnterYear not in", values, "studententeryear");
            return (Criteria) this;
        }

        public Criteria andStudententeryearBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("StudentEnterYear between", value1, value2, "studententeryear");
            return (Criteria) this;
        }

        public Criteria andStudententeryearNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("StudentEnterYear not between", value1, value2, "studententeryear");
            return (Criteria) this;
        }

        public Criteria andStudentadddressIsNull() {
            addCriterion("StudentAdddress is null");
            return (Criteria) this;
        }

        public Criteria andStudentadddressIsNotNull() {
            addCriterion("StudentAdddress is not null");
            return (Criteria) this;
        }

        public Criteria andStudentadddressEqualTo(String value) {
            addCriterion("StudentAdddress =", value, "studentadddress");
            return (Criteria) this;
        }

        public Criteria andStudentadddressNotEqualTo(String value) {
            addCriterion("StudentAdddress <>", value, "studentadddress");
            return (Criteria) this;
        }

        public Criteria andStudentadddressGreaterThan(String value) {
            addCriterion("StudentAdddress >", value, "studentadddress");
            return (Criteria) this;
        }

        public Criteria andStudentadddressGreaterThanOrEqualTo(String value) {
            addCriterion("StudentAdddress >=", value, "studentadddress");
            return (Criteria) this;
        }

        public Criteria andStudentadddressLessThan(String value) {
            addCriterion("StudentAdddress <", value, "studentadddress");
            return (Criteria) this;
        }

        public Criteria andStudentadddressLessThanOrEqualTo(String value) {
            addCriterion("StudentAdddress <=", value, "studentadddress");
            return (Criteria) this;
        }

        public Criteria andStudentadddressLike(String value) {
            addCriterion("StudentAdddress like", value, "studentadddress");
            return (Criteria) this;
        }

        public Criteria andStudentadddressNotLike(String value) {
            addCriterion("StudentAdddress not like", value, "studentadddress");
            return (Criteria) this;
        }

        public Criteria andStudentadddressIn(List<String> values) {
            addCriterion("StudentAdddress in", values, "studentadddress");
            return (Criteria) this;
        }

        public Criteria andStudentadddressNotIn(List<String> values) {
            addCriterion("StudentAdddress not in", values, "studentadddress");
            return (Criteria) this;
        }

        public Criteria andStudentadddressBetween(String value1, String value2) {
            addCriterion("StudentAdddress between", value1, value2, "studentadddress");
            return (Criteria) this;
        }

        public Criteria andStudentadddressNotBetween(String value1, String value2) {
            addCriterion("StudentAdddress not between", value1, value2, "studentadddress");
            return (Criteria) this;
        }

        public Criteria andStudentstatusIsNull() {
            addCriterion("StudentStatus is null");
            return (Criteria) this;
        }

        public Criteria andStudentstatusIsNotNull() {
            addCriterion("StudentStatus is not null");
            return (Criteria) this;
        }

        public Criteria andStudentstatusEqualTo(Integer value) {
            addCriterion("StudentStatus =", value, "studentstatus");
            return (Criteria) this;
        }

        public Criteria andStudentstatusNotEqualTo(Integer value) {
            addCriterion("StudentStatus <>", value, "studentstatus");
            return (Criteria) this;
        }

        public Criteria andStudentstatusGreaterThan(Integer value) {
            addCriterion("StudentStatus >", value, "studentstatus");
            return (Criteria) this;
        }

        public Criteria andStudentstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("StudentStatus >=", value, "studentstatus");
            return (Criteria) this;
        }

        public Criteria andStudentstatusLessThan(Integer value) {
            addCriterion("StudentStatus <", value, "studentstatus");
            return (Criteria) this;
        }

        public Criteria andStudentstatusLessThanOrEqualTo(Integer value) {
            addCriterion("StudentStatus <=", value, "studentstatus");
            return (Criteria) this;
        }

        public Criteria andStudentstatusIn(List<Integer> values) {
            addCriterion("StudentStatus in", values, "studentstatus");
            return (Criteria) this;
        }

        public Criteria andStudentstatusNotIn(List<Integer> values) {
            addCriterion("StudentStatus not in", values, "studentstatus");
            return (Criteria) this;
        }

        public Criteria andStudentstatusBetween(Integer value1, Integer value2) {
            addCriterion("StudentStatus between", value1, value2, "studentstatus");
            return (Criteria) this;
        }

        public Criteria andStudentstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("StudentStatus not between", value1, value2, "studentstatus");
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