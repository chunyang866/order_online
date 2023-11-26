package com.ntjg.jsj2005scy.dao;

import com.ntjg.jsj2005scy.entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectMysql implements Mysql{
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/orderOnline?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "123456";

    /**
     * 获取所有普通用户信息
     * @return
     */
    public List<User> getAllUser(){
        List<User> list = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT userNo, userName, password,phone,userAddress FROM userInfo";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                User user = new User();
                user.setUserNo(rs.getInt("userNo"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setUserAddress(rs.getString("userAddress"));
                list.add(user);
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException | ClassNotFoundException se){
            se.printStackTrace();
        }
        return list;
    }

    /**
     * 通过账户名获取用户信息
     * @param userName
     * @return
     */
    @Override
    public User getUserByUserName(String userName) {
        User user = new User();
        Connection conn = null;
        PreparedStatement ps = null;
        Integer a = -1;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql;
            sql = "select * from userInfo where userName = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,userName);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                user.setUserNo(rs.getInt("userNo"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setUserAddress(rs.getString("userAddress"));
            }
            ps.close();
            conn.close();
        }catch(SQLException | ClassNotFoundException se){
            se.printStackTrace();
        }
        return user;
    }

    @Override
    public Admin getUserByAdminName(String adminName) {
        Admin admin = new Admin();
        Connection conn = null;
        PreparedStatement ps = null;
        Integer a = -1;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql;
            sql = "select * from adminInfo where adminName = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,adminName);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                admin.setAdminNo(rs.getInt("adminNo"));
                admin.setAdminName(rs.getString("adminName"));
                admin.setPassword(rs.getString("password"));
                admin.setResNo(rs.getInt("resNo"));
            }
            ps.close();
            conn.close();
        }catch(SQLException | ClassNotFoundException se){
            se.printStackTrace();
        }
        return admin;
    }

    /**
     * 获取所有管理员用户信息
     * @return
     */
    public List<Admin> getAllAdminUser(){
        List<Admin> list = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT adminNo, adminName, password,resNo FROM adminInfo";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Admin admin = new Admin();
                admin.setAdminNo(rs.getInt("adminNo"));
                admin.setAdminName(rs.getString("adminName"));
                admin.setPassword(rs.getString("password"));
                admin.setResNo(rs.getInt("resNo"));
                list.add(admin);
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException | ClassNotFoundException se){
            se.printStackTrace();
        }
        return list;
    }

    /**
     * 获取所有餐厅信息
     * @return
     */
    public List<Restaurant> getAllRestaurant(){
        List<Restaurant> list = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT resNo, resName, resPhone,resAddress FROM restaurantInfo";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Restaurant restaurant = new Restaurant();
                restaurant.setResNo(rs.getInt("resNo"));
                restaurant.setResName(rs.getString("resName"));
                restaurant.setResPhone(rs.getString("resPhone"));
                restaurant.setResAddress(rs.getString("resAddress"));
                list.add(restaurant);
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException | ClassNotFoundException se){
            se.printStackTrace();
        }
        return list;
    }

    /**
     * 获取所有订单信息
     * @return
     */
    public List<Order> getAllOrder(){
        List<Order> list = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT orderNo, userNo, menuList,time,totalPrice, resNo,state FROM orderInfo";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Order order = new Order();
                order.setOrderNo(rs.getInt("orderNo"));
                order.setUserNo(rs.getInt("userNo"));
                order.setMenuList(rs.getString("menuList"));
                order.setTime(rs.getString("time"));
                order.setTotalPrice(rs.getFloat("totalPrice"));
                order.setResNo(rs.getInt("resNo"));
                order.setState(rs.getString("state"));
                list.add(order);
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException | ClassNotFoundException se){
            se.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Order> getOrderByUserNO(Integer userNo) {
        List<Order> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        Integer a = -1;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql;
            sql = "select * from orderInfo where userNo = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,userNo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Order order = new Order();
                order.setOrderNo(rs.getInt("orderNo"));
                order.setUserNo(rs.getInt("userNo"));
                order.setMenuList(rs.getString("menuList"));
                order.setTime(rs.getString("time"));
                order.setTotalPrice(rs.getFloat("totalPrice"));
                order.setResNo(rs.getInt("resNo"));
                order.setState(rs.getString("state"));
                list.add(order);
            }
            ps.close();
            conn.close();
        }catch(SQLException | ClassNotFoundException se){
            se.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Order> getOrderByResNo(Integer resNo) {
        List<Order> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        Integer a = -1;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql;
            sql = "select * from orderInfo where resNo = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,resNo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Order order = new Order();
                order.setOrderNo(rs.getInt("orderNo"));
                order.setUserNo(rs.getInt("userNo"));
                order.setMenuList(rs.getString("menuList"));
                order.setTime(rs.getString("time"));
                order.setTotalPrice(rs.getFloat("totalPrice"));
                order.setResNo(rs.getInt("resNo"));
                order.setState(rs.getString("state"));
                list.add(order);
            }
            ps.close();
            conn.close();
        }catch(SQLException | ClassNotFoundException se){
            se.printStackTrace();
        }
        return list;
    }

    /**
     * 获取所有菜单信息
     * @return
     */
    @Override
    public List<Menu> getAllMenu() {
        List<Menu> list = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT menuNo, menuName, price,resNo FROM menuInfo";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Menu menu = new Menu();
                menu.setMenuNo(rs.getInt("menuNo"));
                menu.setMenuName(rs.getString("menuName"));
                menu.setPrice(rs.getFloat("price"));
                menu.setResNo(rs.getInt("resNo"));
                list.add(menu);
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException | ClassNotFoundException se){
            se.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Menu> getAllMenuByResNo(Integer resNo) {
        List<Menu> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        Integer a = -1;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql;
            sql = "select * from menuInfo where resNo = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,resNo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Menu menu = new Menu();
                menu.setMenuNo(rs.getInt("menuNo"));
                menu.setMenuName(rs.getString("menuName"));
                menu.setPrice(rs.getFloat("price"));
                menu.setResNo(rs.getInt("resNo"));
                list.add(menu);
            }
            ps.close();
            conn.close();
        }catch(SQLException | ClassNotFoundException se){
            se.printStackTrace();
        }
        return list;
    }

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    @Override
    public Integer addUser(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer a = -1;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql;
            sql = "insert into userInfo (userName,password,phone,userAddress)values(?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getPhone());
            ps.setString(4,user.getUserAddress());
            a = ps.executeUpdate();

            ps.close();
            conn.close();
        }catch(SQLException | ClassNotFoundException se){
            se.printStackTrace();
        }
        return a;
    }


    /**
     * 增加订单信息
     * @param order
     * @return
     */
    @Override
    public Integer addOrder(Order order) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer a = -1;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql;
            sql = "insert into orderInfo (userNo,menuList,time,totalPrice,resNo)values(?,?,now(),?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,order.getUserNo());
            ps.setString(2,order.getMenuList());
            ps.setFloat(3,order.getTotalPrice());
            ps.setInt(4,order.getResNo());

            a = ps.executeUpdate();

            ps.close();
            conn.close();
        }catch(SQLException | ClassNotFoundException se){
            se.printStackTrace();
        }
        return a;
    }

    @Override
    public List<Order> getOrderByUserNo(Integer userNo) {
        List<Order> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql;
            sql = "SELECT orderNo, userNo, menuList,time,totalPrice, resNo,state FROM orderInfo where userNo = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,userNo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Order order = new Order();
                order.setOrderNo(rs.getInt("orderNo"));
                order.setUserNo(rs.getInt("userNo"));
                order.setMenuList(rs.getString("menuList"));
                order.setTime(rs.getString("time"));
                order.setTotalPrice(rs.getFloat("totalPrice"));
                order.setResNo(rs.getInt("resNo"));
                order.setState(rs.getString("state"));
                list.add(order);
            }
            rs.close();
            ps.close();
            conn.close();
        }catch(SQLException | ClassNotFoundException se){
            se.printStackTrace();
        }
        return list;
    }

    /**
     * 普通用户修改订单信息
     * @param order
     * @param orderNo
     * @return
     */
    @Override
    public Integer updateOrderByOrderNo(Order order, Integer orderNo) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer a = -1;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql;
            sql = "update orderInfo set menuList = ?,totalPrice = ? where orderNo = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,order.getMenuList());
            ps.setFloat(2,order.getTotalPrice());
            ps.setInt(3, orderNo);
            a = ps.executeUpdate();

            ps.close();
            conn.close();
        }catch(SQLException | ClassNotFoundException se){
            se.printStackTrace();
        }
        return a;
    }

    @Override
    public Integer updateOrderByOrderNo(Integer orderNo) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer a = -1;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql;
            sql = "update orderInfo set state = ? where orderNo = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"已配送");
            ps.setFloat(2,orderNo);
            a = ps.executeUpdate();

            ps.close();
            conn.close();
        }catch(SQLException | ClassNotFoundException se){
            se.printStackTrace();
        }
        return a;
    }

    @Override
    public Integer deleteOrderByorderNo(Integer orderNo) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer a = -1;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql;
            sql = "delete from orderInfo where orderNo = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, orderNo);
            a = ps.executeUpdate();
            ps.close();
            conn.close();
        }catch(SQLException | ClassNotFoundException se){
            se.printStackTrace();
        }
        return a;
    }

    @Override
    public Integer addMenu(Menu menu) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer a = -1;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql;
            sql = "insert into menuInfo (menuName,price,resNo)values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,menu.getMenuName());
            ps.setFloat(2,menu.getPrice());
            ps.setInt(3,menu.getResNo());
            a = ps.executeUpdate();

            ps.close();
            conn.close();
        }catch(SQLException | ClassNotFoundException se){
            se.printStackTrace();
        }
        return a;
    }

    @Override
    public Integer updateMenu(Menu menu, Integer menuNo) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer a = -1;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql;
            sql = "update menuInfo set menuName = ?,price = ? where menuNo = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,menu.getMenuName());
            ps.setFloat(2, menu.getPrice());
            ps.setFloat(3,menuNo);
            a = ps.executeUpdate();

            ps.close();
            conn.close();
        }catch(SQLException | ClassNotFoundException se){
            se.printStackTrace();
        }
        return a;
    }

    /**
     * 删除菜品信息
     * @param menuNo
     * @return
     */
    @Override
    public Integer deleteMenu(Integer menuNo) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer a = -1;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql;
            sql = "delete from menuInfo where menuNo = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, menuNo);
            a = ps.executeUpdate();
            ps.close();
            conn.close();
        }catch(SQLException | ClassNotFoundException se){
            se.printStackTrace();
        }
        return a;
    }

}
