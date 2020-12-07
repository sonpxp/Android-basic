package com.sonmob.sqlitedemo.model;

public class Student {
    private String maSV;
    private String nameSV;
    private String emailSV;
    private int phoneSV;

    public Student() {
    }

    public Student(String maSV, String nameSV, String emailSV, int phoneSV) {
        this.maSV = maSV;
        this.nameSV = nameSV;
        this.emailSV = emailSV;
        this.phoneSV = phoneSV;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getNameSV() {
        return nameSV;
    }

    public void setNameSV(String nameSV) {
        this.nameSV = nameSV;
    }

    public String getEmailSV() {
        return emailSV;
    }

    public void setEmailSV(String emailSV) {
        this.emailSV = emailSV;
    }

    public int getPhoneSV() {
        return phoneSV;
    }

    public void setPhoneSV(int phoneSV) {
        this.phoneSV = phoneSV;
    }

    @Override
    public String toString() {

        return
                "Mã:      " + maSV + "\n" +
                "Tên:     " + nameSV + "\n" +
                "Email:   " + emailSV + "\n" +
                "Sdt:     " + phoneSV ;

//        return "Student{" +
//                "maSV='" + maSV + '\'' +
//                ", nameSV='" + nameSV + '\'' +
//                ", emailSV='" + emailSV + '\'' +
//                ", phoneSV=" + phoneSV +
//                '}';
    }
}
