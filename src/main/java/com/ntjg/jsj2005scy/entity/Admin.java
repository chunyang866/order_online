package com.ntjg.jsj2005scy.entity;

public class Admin {
    private int adminNo;
    private String adminName;
    private String password;
    private Integer resNo;

    public int getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(int adminNo) {
        this.adminNo = adminNo;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getResNo() {
        return resNo;
    }

    public void setResNo(Integer resNo) {
        this.resNo = resNo;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminNo=" + adminNo +
                ", adminName='" + adminName + '\'' +
                ", password='" + password + '\'' +
                ", resNo='" + resNo + '\'' +
                '}';
    }
}
