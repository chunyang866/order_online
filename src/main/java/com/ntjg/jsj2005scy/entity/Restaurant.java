package com.ntjg.jsj2005scy.entity;

public class Restaurant {
    private int resNo;
    private String resName;
    private String resPhone;
    private String resAddress;

    public int getResNo() {
        return resNo;
    }

    public void setResNo(int resNo) {
        this.resNo = resNo;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getResPhone() {
        return resPhone;
    }

    public void setResPhone(String resPhone) {
        this.resPhone = resPhone;
    }

    public String getResAddress() {
        return resAddress;
    }

    public void setResAddress(String resAdress) {
        this.resAddress = resAdress;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "resNo=" + resNo +
                ", resName='" + resName + '\'' +
                ", resPhone='" + resPhone + '\'' +
                ", resAdress='" + resAddress + '\'' +
                '}';
    }
}
