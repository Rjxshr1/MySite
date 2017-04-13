package my.service.impl;

import my.service.UserService;

/**
 * Created by rajab on 17/4/13.
 */
public class UserServiceImpl extends UserService {
    @Override
    public LoginResult checkLogin(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            return LoginResult.INPUT_INVALID;
        } else if (username.equals("admin") && password.equals("admin")) {
            return LoginResult.LOGIN_OK;
        } else {
            return LoginResult.PASSWORD_WRONG;
        }
    }

   /* @Override
    public User createUser(String username, String password, String role) throws ActiveRecordException {
        User user = new User();
        user.setUsername(username);
        user.setPassword(DigestUtils.md5Hex("password"));
        user.setRole("admin");
        boolean success = user.save();
        return success ? user : null;
    }*/
}
