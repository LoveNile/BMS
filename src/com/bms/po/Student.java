package com.bms.po;

import java.util.Date;

public class Student {
    private Long studentnumber;

    private String studentname;

    private String studetpassword;

    private Boolean gender;

    private String phone;

    private String email;

    private String college;

    private String speciality;

    private String studentclass;

    private Date studententeryear;

    private String studentadddress;

    private Boolean studentstatus;

    public Long getStudentnumber() {
        return studentnumber;
    }

    public void setStudentnumber(Long studentnumber) {
        this.studentnumber = studentnumber;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname == null ? null : studentname.trim();
    }

    public String getStudetpassword() {
        return studetpassword;
    }

    public void setStudetpassword(String studetpassword) {
        this.studetpassword = studetpassword == null ? null : studetpassword.trim();
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality == null ? null : speciality.trim();
    }

    public String getStudentclass() {
        return studentclass;
    }

    public void setStudentclass(String studentclass) {
        this.studentclass = studentclass == null ? null : studentclass.trim();
    }

    public Date getStudententeryear() {
        return studententeryear;
    }

    public void setStudententeryear(Date studententeryear) {
        this.studententeryear = studententeryear;
    }

    public String getStudentadddress() {
        return studentadddress;
    }

    public void setStudentadddress(String studentadddress) {
        this.studentadddress = studentadddress == null ? null : studentadddress.trim();
    }

    public Boolean getStudentstatus() {
        return studentstatus;
    }

    public void setStudentstatus(Boolean studentstatus) {
        this.studentstatus = studentstatus;
    }
}