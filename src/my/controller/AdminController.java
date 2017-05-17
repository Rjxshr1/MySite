package my.controller;

import com.jfinal.core.Controller;
import com.sun.org.apache.xpath.internal.operations.String;
import my.model.User;
import java.lang.*;
import java.util.List;

/**
 * Created by rajab on 2017/4/20.
 */
/*
        String likeStr = "select * from post_user where user_name like '%宝%'";
19         List<User> userList = User.user.find(likeStr);
20         String renderStr = "";
21         for (User user2 : userList) {
22             renderStr += user2.getStr("user_name");
23             renderStr += "---";
24         }
         */
public class AdminController extends Controller {
    public void index(){
            renderHtml("<h>hello!<h>");
            /*User user1 = new User();
            java.lang.String test = "Select password from user ";
            List<User> userList = user1.find(test);
            for(User user2 : userList){
                System.out.println(user2.getPassword());
            }*/
            //User user2 = user1.findById(1);
            //System.out.println(user2.getUsername());
            User user1 = new User();
            user1.setUsername("dafsdfsd");
            user1.setPassword("123456");
            user1.save();
    }
}
