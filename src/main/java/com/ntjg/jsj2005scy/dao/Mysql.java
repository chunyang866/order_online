package com.ntjg.jsj2005scy.dao;

import com.ntjg.jsj2005scy.entity.*;

import java.util.List;

public interface Mysql {
    List<User> getAllUser();//获取所有普通用户信息
    User getUserByUserName(String userName);//获取普通用户信息
    Admin getUserByAdminName(String AdminName);//获取管理员信息
    List<Admin> getAllAdminUser();//获取所有管理员信息
    List<Restaurant> getAllRestaurant();//获取所有餐厅信息
    List<Order> getAllOrder();//获取所有订单信息
    List<Order> getOrderByUserNO(Integer userNo);//通过用户no获取所有订单信息
    List<Order> getOrderByResNo(Integer resNo);//通过餐厅no获取所有订单信息
    List<Menu> getAllMenu();//获取所有菜单信息
    List<Menu> getAllMenuByResNo(Integer resNo);//通过餐馆no获取菜单信息
    Integer addUser(User user);//添加用户
    Integer addOrder(Order order);//添加订单
    List<Order> getOrderByUserNo(Integer userNo);//获取用户订单
    Integer updateOrderByOrderNo(Order order,Integer orderNo);//普通用户修改订单
    Integer updateOrderByOrderNo(Integer orderNo);//管理员修改订单派送
    Integer deleteOrderByorderNo(Integer orderNo);//删除订单
    Integer addMenu(Menu menu);//添加菜品
    Integer updateMenu(Menu menu,Integer menuNo);//修改菜品
    Integer deleteMenu(Integer menuNo);//删除菜品
}
