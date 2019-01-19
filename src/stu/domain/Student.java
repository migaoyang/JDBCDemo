package stu.domain;

import java.util.Date;

public class Student {
    private Integer sid;
    private String gender;
    private String phone;
    private String hobby;
    private String info;
    private Date birthday;

    private String sname;

    public Student(String gender, String phone, String hobby, String info, Date birthday, String sname) {
        this.gender = gender;
        this.phone = phone;
        this.hobby = hobby;
        this.info = info;
        this.birthday = birthday;
        this.sname = sname;
    }

    public Student(Integer sid , String gender, String phone, String hobby, String info, Date birthday, String sname) {
        this.sid = sid;
        this.gender = gender;
        this.phone = phone;
        this.hobby = hobby;
        this.info = info;
        this.birthday = birthday;
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", hobby='" + hobby + '\'' +
                ", info='" + info + '\'' +
                ", birthday=" + birthday +
                ", sname='" + sname + '\'' +
                '}';
    }

    public Student(){

    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }



    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


}
