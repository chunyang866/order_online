import com.ntjg.jsj2005scy.dao.ConnectMysql;
import com.ntjg.jsj2005scy.entity.*;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

public class Test {
    public static void main(String[] args)  {
        ConnectMysql cm = new ConnectMysql();
       /* List<User> user = new ArrayList<>();

        user = cm.getAllUser();
        for(int i = 0; i < user.size(); i++){
            System.out.println(user.get(i).getUserNo());
            System.out.println(user.get(i).getUserName());
            System.out.println(user.get(i).getPassword());
            System.out.println(user.get(i).getPhone());
            System.out.println(user.get(i).getUserAddress());
        }*/
        /*List<Admin> admin = null;
        admin = cm.getAllAdminUser();
        for(int i = 0; i < admin.size(); i++) {
            System.out.println(admin.get(i).getAdminNo());
            System.out.println(admin.get(i).getAdminName());
            System.out.println(admin.get(i).getPassword());
            System.out.println(admin.get(i).getResNo());
        }*/

        /*List<Restaurant> restaurants = null;
        restaurants = cm.getAllRestaurant();
        for(int i = 0; i < restaurants.size(); i++) {
            System.out.println(restaurants.get(i).getResNo());
            System.out.println(restaurants.get(i).getResName());
            System.out.println(restaurants.get(i).getResPhone());
            System.out.println(restaurants.get(i).getResAddress());
        }
*/
        /*List<Order> orders = null;
        orders = cm.getAllOrder();
        for(int i = 0; i < orders.size(); i++) {
            System.out.println(orders.get(i).getOrderNo());
            System.out.println(orders.get(i).getUserNo());
            System.out.println(orders.get(i).getMenuList());
            System.out.println(orders.get(i).getTime());
            System.out.println(orders.get(i).getTotalPrice());
            System.out.println(orders.get(i).getResNo());
            System.out.println(orders.get(i).getState());
        }*/

        /*List<Menu> menus = null;
        menus = cm.getAllMenu();
        for(int i = 0; i < menus.size(); i++) {
            System.out.println(menus.get(i).getMenuNo());
            System.out.println(menus.get(i).getMenuName());
            System.out.println(menus.get(i).getPrice());
            System.out.println(menus.get(i).getResNo());
        }*/

//        Order order = new Order();
//        order.setUserNo(1);
//        order.setMenuList("麻婆豆腐");
//        order.setTime("2022-12-19 13:52:36");
//        order.setTotalPrice(44);
//        order.setResNo(1);
//        cm.addOrder(order);

        /*List<Order> orders = null;
        orders = cm.getOrderByUserNo(1);
        for(int i = 0; i < orders.size(); i++) {
            System.out.println(orders.get(i).getOrderNo());
            System.out.println(orders.get(i).getUserNo());
            System.out.println(orders.get(i).getMenuList());
            System.out.println(orders.get(i).getTime());
            System.out.println(orders.get(i).getTotalPrice());
            System.out.println(orders.get(i).getResNo());
            System.out.println(orders.get(i).getState());
        }*/

        /*Order order = new Order();
        order.setMenuList("酸辣土豆丝");
        order.setTotalPrice(22);
        int a = cm.updateOrderByOrderNo(order,2);*/

        //cm.deleteOrderByorderNo(3);

        /*Menu menu = new Menu();
        menu.setMenuName("北京烤鸭");
        menu.setPrice(55);
        menu.setResNo(1);
        cm.addMenu(menu);*/

        FileReader fileReader = null;

        try {
            String string = Thread.currentThread().getContextClassLoader().getResource("mysql.properties").getPath();
            fileReader = new FileReader("src/main/resources/mysql.properties");
            Properties properties = new Properties();
            properties.load(fileReader);
            String str = properties.getProperty("className");
            fileReader.close();
            System.out.println(string);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ResourceBundle resourceBundle = ResourceBundle.getBundle("mysql");
        String string = resourceBundle.getString("className");
        System.out.println(string);
    }
}
