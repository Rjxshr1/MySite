package my.service;

import my.model.User;

/**
 * Created by rajab on 17/4/13.
 */

public class UserService {

    public enum RegisterResult {
        REGISTER_OK,
        USER_IS_EXISTED,
        REGISTER_FAIL
    }

    public RegisterResult register(String username, String password) {

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        try {
            //判断用户名是否存在
            user.save();
            return RegisterResult.REGISTER_OK;
        } catch (Exception ex) {

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
        if (username.isEmpty() || password.isEmpty()) {
            return LoginResult.INPUT_INVALID;
        } else if (username.equals("admin") && password.equals("admin")) {
            return LoginResult.LOGIN_OK;
        } else {
            return LoginResult.PASSWORD_WRONG;
        }
    }


    // public abstract User createUser(String username, String password, String role);
}
