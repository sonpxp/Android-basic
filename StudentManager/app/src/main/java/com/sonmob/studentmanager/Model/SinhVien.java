package com.sonmob.studentmanager.Model;

public class SinhVien {
    private String maSv;
    private String tenSv;
    private String email;
    private String maLop;

    public SinhVien() {
    }

    public SinhVien(String maSv, String tenSv, String email, String maLop) {
        this.maSv = maSv;
        this.tenSv = tenSv;
        this.email = email;
        this.maLop = maLop;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getTenSv() {
        return tenSv;
    }

    public void setTenSv(String tenSv) {
        this.tenSv = tenSv;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }
}
