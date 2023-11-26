package com.ntjg.jsj2005scy.entity;

public class Menu {
    private int menuNo;
    private String menuName;
    private float price;
    private int resNo;

    public int getMenuNo() {
        return menuNo;
    }

    public void setMenuNo(int menuNo) {
        this.menuNo = menuNo;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getResNo() {
        return resNo;
    }

    public void setResNo(int resNo) {
        this.resNo = resNo;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuNo=" + menuNo +
                ", menuName='" + menuName + '\'' +
                ", price=" + price +
                ", resNo='" + resNo + '\'' +
                '}';
    }
}
