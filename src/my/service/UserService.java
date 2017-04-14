package my.service;

/**
 * Created by rajab on 17/4/13.
 */
public interface UserService {
    public enum LoginResult {
        LOGIN_OK,
        INPUT_INVALID,
        PASSWORD_WRONG,
        USER_NOT_EXIST
    }

    LoginResult checkLogin(String username, String password);

    // public abstract User createUser(String username, String password, String role);
}
