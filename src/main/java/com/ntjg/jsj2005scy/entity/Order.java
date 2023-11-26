package com.ntjg.jsj2005scy.entity;

public class Order {
    private int orderNo;
    private int userNo;
    private String menuList;
    private String time;
    private float totalPrice;
    private int resNo;
    private String state;

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getMenuList() {
        return menuList;
    }

    public void setMenuList(String menuList) {
        this.menuList = menuList;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getResNo() {
        return resNo;
    }

    public void setResNo(int resNo) {
        this.resNo = resNo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNo=" + orderNo +
                ", userNo=" + userNo +
                ", menuList='" + menuList + '\'' +
                ", time='" + time + '\'' +
                ", totalPrice=" + totalPrice +
                ", resNo=" + resNo +
                ", state='" + state + '\'' +
                '}';
    }
}
