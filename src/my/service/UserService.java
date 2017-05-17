package my.service;

import java.lang.String;
import my.model.User;

import java.util.List;

/**
 * Created by rajab on 17/4/13.
 */

public class UserService {

    public enum RegisterResult {
        REGISTER_OK,  //注册成功
        USER_IS_EXISTED, //用户存在
        REGISTER_FAIL // 注册失败
    }

    public RegisterResult register(String username, String password) {

        //TODO:完成注册
        //首先判用户是否存在，不存在则new User，并save
        int judge = 0;//0 代表注册成功；1代表用户存在；2代表注册失败
        User user_register = new User();
        String test1 = "Select username from user";
        List<User> userList = user_register.find(test1);
        int i = userList.size();
        String[] usernames = new String[i];
        int j = 0;
        for (User user_register2 : userList){
            usernames[j] = user_register2.getUsername();
            j++;
        }
        for (int k = 0;k < j;k++){
            if(username.equals(usernames[k])){
                judge = 1;
                return RegisterResult.USER_IS_EXISTED;
            }
        }
        if(judge == 0){
           // User user_register2 = new User();
            user_register.setUsername(username);
            user_register.setPassword(password);
            user_register.save();
            return RegisterResult.REGISTER_OK;
        }
        return RegisterResult.REGISTER_FAIL;
    }


    public enum LoginResult {
        LOGIN_OK,
        INPUT_INVALID,
        PASSWORD_WRONG,
        USER_NOT_EXIST
    }

    public LoginResult checkLogin(String username, String password) {

        User user1 = findUserByUsername(username);
        System.out.println(user1);
        String test1 = user1.getPassword();
       /*String test = "Select password from user where username = '" + username +"'";
        List<User> userList = user1.find(test);
        String test1 = "";
        for(User user2 : userList){

               test1 += user2.getPassword();

       }
*/

        if (username.isEmpty() || password.isEmpty()) {
            return LoginResult.INPUT_INVALID;
        }



        //FIXME:修改为从数据库判断
        if (password.equals(test1)) {
            return LoginResult.LOGIN_OK;
        } else {
            return LoginResult.PASSWORD_WRONG;
        }
    }


    // public abstract User createUser(String username, String password, String role);

    public User findUserByUsername(String username) {
        //TODO:根据用户名查找用户
        User user3 = new User();
        String test2 = "Select * from user where username = '" + username +"'";
        List<User> userList = user3.find(test2);
        for(User user2 : userList){
            return user2;
        }
        throw new RuntimeException("未完成");
    }
}
