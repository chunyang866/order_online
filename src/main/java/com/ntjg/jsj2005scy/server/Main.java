package com.ntjg.jsj2005scy.server;

import com.ntjg.jsj2005scy.dao.ConnectMysql;
import com.ntjg.jsj2005scy.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main implements Method {
    public static Scanner scanner = new Scanner(System.in);
    public static Main main = new Main();
    public static ConnectMysql mysql = new ConnectMysql();
    User user = new User();
    Admin admin = new Admin();

    public static void main(String[] args) {
        main.start();
    }

    public void userStart(){
        int num;
        boolean b;
        System.out.println("****欢迎" + user.getUserName() + "****");
        System.out.println("1 选择餐厅点餐");
        System.out.println("2 查看所有订单");
        System.out.println("3 退出登录");
        System.out.println("请选择");
        num = scanner.nextInt();
        while(true){
            if(num == 1 || num == 2 || num == 3){
                break;
            }else{
                System.out.println("您输入有误请重新输入");
                num = scanner.nextInt();
            }
        }
        switch (num){
            case 1:
                getAllRestaurant();
                b = createOrder();
                if(b){
                    System.out.println("点餐成功");
                    System.out.println("输入任意键回车继续");
                    scanner.next();
                    System.out.println();
                }
                userStart();
                break;
            case 2:
                getOrderByUserNo();
                System.out.println("1 修改订单");
                System.out.println("2 删除订单");
                System.out.println("请选择");
                num = scanner.nextInt();
                while(true){
                    if(num == 1 || num == 2){
                        break;
                    }else{
                        System.out.println("您输入有误请重新输入");
                        num = scanner.nextInt();
                    }
                }
                switch (num){
                    case 1:
                        b = updateOrder();
                        if(b){
                            System.out.println("订单修改成功");
                            System.out.println();
                            userStart();
                        }else{
                            System.out.println("订单修改失败");
                            System.out.println();
                            userStart();
                        }
                        break;
                    case 2:
                        b = deleteOrder();
                        if(b){
                            System.out.println("订单删除成功");
                            System.out.println();
                            userStart();
                        }else{
                            System.out.println("订单删除失败");
                            System.out.println();
                            userStart();
                        }
                        break;
                }
                break;
            case 3:
                start();
                break;
        }
        System.out.println();

    }

    public void adminStart(){
        int num;
        boolean b;
        System.out.println("****欢迎" + admin.getAdminName() + "****");
        System.out.println("1 查看菜品");
        System.out.println("2 查看所有订单");
        System.out.println("3 退出登录");
        System.out.println("请选择");
        num = scanner.nextInt();
        while(true){
            if(num == 1 || num == 2 || num == 3){
                break;
            }else{
                System.out.println("您输入有误请重新输入");
                num = scanner.nextInt();
            }
        }
        switch (num){
            case 1:
                getMenu(admin.getResNo());
                System.out.println("1 增加菜品");
                System.out.println("2 修改菜品");
                System.out.println("3 删除菜品");
                System.out.println("请选择");
                num = scanner.nextInt();
                System.out.println();
                switch (num){
                    case 1:
                        b = addMenu();
                        while(!b){
                            System.out.println("请重新输入");
                            b = addMenu();
                        }
                        adminStart();
                        break;
                    case 2:
                        b = updateMenu();
                        while(!b){
                            System.out.println("请重新输入");
                            b = updateMenu();
                        }
                        adminStart();
                        break;
                    case 3:
                        b = deleteMenu();
                        while(!b){
                            System.out.println("请重新输入");
                            b = deleteMenu();
                        }
                        adminStart();
                        break;
                }
                adminStart();
                break;
            case 2:
                getAllOrderByResNo();
                System.out.println("1 派送订单");
                System.out.println("请选择");
                num = scanner.nextInt();
                while(true){
                    if(num == 1){
                        break;
                    }else{
                        System.out.println("您输入有误请重新输入");
                        num = scanner.nextInt();
                    }
                }
                switch (num){
                    case 1:
                        b = deliveryOrder();
                        if(b){
                            System.out.println("****订单派送成功****");
                            System.out.println();
                            adminStart();
                        }else{
                            System.out.println("****订单派送失败****");
                            System.out.println();
                            adminStart();
                        }
                        break;
                }
                break;
            case 3:
                start();
                break;
        }
        System.out.println();

    }

    /**
     * 程序开始
     */
    public void start(){
        int num = 0;
        boolean b = false;
        System.out.println("*************");
        System.out.println("*在线订餐系统*");
        System.out.println("*************");
        System.out.println("欢迎使用本在线订餐系统请先登录");
        System.out.println("1 普通用户登录");
        System.out.println("2 管理员登录");
        System.out.println("3 注册");
        System.out.println("4 退出程序");
        System.out.println("请选择");
        num = scanner.nextInt();
        while(true){
            if(num == 1 || num == 2 || num == 3 || num == 4){
                break;
            }else{
                System.out.println("您输入有误请重新输入");
                num = scanner.nextInt();
            }
        }
        System.out.println();
        switch (num){
            case 1:
                b = userLogin();
                while(!b){
                    System.out.println("您输入的账号或密码有误请重新输入");
                    b = userLogin();
                }
                userStart();
                break;
            case 2:
                b = adminLogin( );
                while(!b){
                    System.out.println("您输入的账号或密码有误请重新输入");
                    b = adminLogin();
                }
                adminStart();
                break;
            case 3:
                b = register();
                while(!b){
                    System.out.println("注册失败，重新注册");
                    b = register();
                }
                System.out.println("输入任意键回车继续");
                scanner.next();
                if(b){
                    start();
                }
                break;
            case 4:
                break;
        }
    }

    /**
     * 普通用户登录
     * @return
     */
    @Override
    public boolean userLogin() {
        String userName,password;
        System.out.println("请输入账号密码");
        userName = scanner.next();
        password = scanner.next();
        user = mysql.getUserByUserName(userName);
        if(user == null){
            return false;
        }else if(password.equals(user.getPassword())){
            return true;
        }
        return false;
    }

    @Override
    public boolean adminLogin() {
        String adminName,password;
        System.out.println("请输入账号密码");
        adminName = scanner.next();
        password = scanner.next();
        admin = mysql.getUserByAdminName(adminName);
        if(admin == null){
            return false;
        }else if(password.equals(admin.getPassword())){
            return true;
        }
        return false;
    }

    @Override
    public boolean register() {
        int i;
        User user = new User();
        System.out.println("请输入登录账户名、密码、电话、收获地址");
        user.setUserName(scanner.next());
        user.setPassword(scanner.next());
        user.setPhone(scanner.next());
        user.setUserAddress(scanner.next());
        i = mysql.addUser(user);
        if(i == 1){
            System.out.println("****注册成功！****");
            return true;
        }
        return false;
    }

    /**
     * 创建订单
     * @return
     */
    @Override
    public boolean createOrder() {
        int num,a;
        Order order = new Order();
        System.out.println("请选择");
        num = scanner.nextInt();
        getMenu(num);
        System.out.println("输入订单信息（菜品列表、总价）");
        order.setUserNo(user.getUserNo());
        order.setMenuList(scanner.next());
        order.setTotalPrice(scanner.nextFloat());
        order.setResNo(num);
        a = mysql.addOrder(order);
        if(a == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateOrder() {
        Order order = new Order();
        int num,a;
        System.out.println("输入要修改的订单序号和餐厅序号");
        num = scanner.nextInt();
        a = scanner.nextInt();
        getMenu(a);
        System.out.println("输入修改后的数据（菜品列表、总价）");
        order.setMenuList(scanner.next());
        order.setTotalPrice(scanner.nextFloat());
        a = mysql.updateOrderByOrderNo(order, num);
        if(a == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteOrder() {
        int num,a;
        System.out.println("输入要删除的订单序号");
        num = scanner.nextInt();
        a = mysql.deleteOrderByorderNo(num);
        if(a == 1){
            return true;
        }
        return false;
    }

    /**
     * 增加菜品
     * @return
     */
    @Override
    public boolean addMenu() {
        int i;
        Menu menu = new Menu();
        System.out.println("请输入菜品名、价格");
        menu.setMenuName(scanner.next());
        menu.setPrice(scanner.nextFloat());
        menu.setResNo(admin.getResNo());
        i = mysql.addMenu(menu);
        if(i == 1){
            System.out.println("****增加成功！****");
            System.out.println();
            return true;
        }
        System.out.println("****增加失败！****");
        System.out.println();
        return false;
    }

    @Override
    public boolean updateMenu() {
        Menu menu = new Menu();
        int num,a;
        System.out.println("输入要修改的菜品序号");
        num = scanner.nextInt();
        System.out.println("输入修改后的数据（菜品名、总价）");
        menu.setMenuName(scanner.next());
        menu.setPrice(scanner.nextFloat());
        a = mysql.updateMenu(menu, num);
        if(a == 1){
            System.out.println("****修改成功！****");
            System.out.println();
            return true;
        }
        System.out.println("****修改失败！****");
        System.out.println();
        return false;
    }

    @Override
    public boolean deleteMenu() {
        int num,a;
        System.out.println("输入要删除的菜单序号");
        num = scanner.nextInt();
        a = mysql.deleteMenu(num);
        if(a == 1){
            System.out.println("****删除成功！****");
            System.out.println();
            return true;
        }
        System.out.println("****删除失败！****");
        System.out.println();
        return false;
    }

    @Override
    public boolean deliveryOrder() {
        int num,a;
        System.out.println("输入要派送的订单序号");
        num = scanner.nextInt();
        System.out.println();
        a = mysql.updateOrderByOrderNo(num);
        if(a == 1){
            return true;
        }
        return false;
    }

    @Override
    public void getAllRestaurant() {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants = mysql.getAllRestaurant();
        for(int i = 0; i < restaurants.size(); i++){
            System.out.print(restaurants.get(i).getResNo() + " ");
            System.out.print(restaurants.get(i).getResName() + " ");
            System.out.print(restaurants.get(i).getResPhone() + " ");
            System.out.print(restaurants.get(i).getResAddress() + " ");
            System.out.println();
        }
    }

    @Override
    public void getMenu(Integer resNo) {
        List<Menu> menu = mysql.getAllMenuByResNo(resNo);
        for(int i = 0; i < menu.size(); i++){
            System.out.print(menu.get(i).getMenuNo() + " ");
            System.out.print(menu.get(i).getMenuName() + " ");
            System.out.print(menu.get(i).getPrice() + " ");
            System.out.println();
        }
        System.out.println();
    }

    /**
     * 通过用户编号获取订单信息
     */
    @Override
    public void getOrderByUserNo() {
        List<Order> orders = mysql.getOrderByUserNO(user.getUserNo());
        for(int i = 0; i < orders.size(); i++){
            System.out.print(orders.get(i).getOrderNo() + " ");
            System.out.print(orders.get(i).getMenuList() + " ");
            System.out.print(orders.get(i).getTime() + " ");
            System.out.print(orders.get(i).getTotalPrice() + " ");
            System.out.print(orders.get(i).getResNo() + " ");
            System.out.print(orders.get(i).getState() + " ");
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void getAllOrderByResNo() {
        List<Order> orders = mysql.getOrderByResNo(admin.getResNo());
        for(int i = 0; i < orders.size(); i++){
            System.out.print(orders.get(i).getOrderNo() + " ");
            System.out.print(orders.get(i).getMenuList() + " ");
            System.out.print(orders.get(i).getTime() + " ");
            System.out.print(orders.get(i).getTotalPrice() + " ");
            System.out.print(orders.get(i).getResNo() + " ");
            System.out.print(orders.get(i).getState() + " ");
            System.out.println();
        }
        System.out.println();
    }
}
