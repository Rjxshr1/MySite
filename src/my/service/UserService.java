package my.service;

import my.model.User;

/**
 * Created by rajab on 17/4/13.
 */

public class UserService {

    public enum RegisterResult {
        REGISTER_OK,  //注册成功
        USER_IS_EXISTED, //用户存在
        REGISTER_FAIL // 注册成败
    }

    public RegisterResult register(String username, String password) {

        //TODO:完成注册
        //首先判用户是否存在，不存在则new User，并save

        return RegisterResult.USER_IS_EXISTED;
    }


    public enum LoginResult {
        LOGIN_OK,
        INPUT_INVALID,
        PASSWORD_WRONG,
        USER_NOT_EXIST
    }

    public LoginResult checkLogin(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            return LoginResult.INPUT_INVALID;
        }
        //FIXME:修改为从数据库判断
        else if (username.equals("admin") && password.equals("admin")) {
            return LoginResult.LOGIN_OK;
        } else {
            return LoginResult.PASSWORD_WRONG;
        }
    }


    // public abstract User createUser(String username, String password, String role);

    public User findUserByUsername(String username) {
        //TODO:根据用户名查找用户
               
        throw new RuntimeException("未完成");
    }
}
