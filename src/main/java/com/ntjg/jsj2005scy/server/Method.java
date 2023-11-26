package com.ntjg.jsj2005scy.server;

public interface Method {
    public abstract boolean userLogin();//用户登录
    public abstract boolean adminLogin();//管理员登录
    public abstract boolean register();//普通用户注册
    public abstract boolean createOrder();//用户创建订单
    public abstract boolean updateOrder();//用户修改订单
    public abstract boolean deleteOrder();//用户删除订单
    public abstract boolean addMenu();//增加菜品
    public abstract boolean updateMenu();//修改菜品
    public abstract boolean deleteMenu();//删除菜品
    public abstract boolean deliveryOrder();//配送订单
    public abstract void getAllRestaurant();//获取所有餐馆信息
    public abstract void getMenu(Integer resNo);//通过餐馆no获取菜品
    public abstract void getOrderByUserNo();//通过用户no获取订单
    public abstract void getAllOrderByResNo();//通过餐馆no获取所有订单
}
