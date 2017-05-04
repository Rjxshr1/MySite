package my.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.POST;
import my.interceptor.LoginInterceptor;
import my.service.UserService;

/**
 * Created by Rajab on 2017/03/30.
 */
public class MainController extends Controller {

    private static UserService userService = new UserService();

    public void index() {
        renderHtml("<h1>hello!</h1>");
    }

    public void login() {
        renderFreeMarker("login-new.ftl");
    }

    public void loginCheck() {
        String username = getPara("username", "");
        String password = getPara("password", "");
        UserService.LoginResult result = userService.checkLogin(username, password);
        switch (result) {
            case LOGIN_OK:
                setSessionAttr("username", username);
                redirect("/success");
                break;
            case INPUT_INVALID:
                setAttr("errMsg", "用户名或密码为空");
                forwardAction("/login");
                break;
            case PASSWORD_WRONG:
                setAttr("errMsg", "用户名或密码错误");
                forwardAction("/login");
                break;
        }

    }

    @Before(LoginInterceptor.class)
    public void success() {
        renderFreeMarker("success.ftl");
    }

    public void main() {
        renderFreeMarker("main.ftl");
    }

    public void logout() {

    }

    public void register() {
        renderFreeMarker("register.ftl");
    }

    @Before(POST.class)
    public void doregister() {

        String username = getPara("username");
        String password = getPara("password");
        UserService.RegisterResult result = userService.register(username, password);
        boolean success = false;
        String message = "";
        switch (result) {
            case REGISTER_OK:
                success = true;
                message = "注册成功";
                break;
            case REGISTER_FAIL:
                message = "注册失败";
                break;
            case USER_IS_EXISTED:
                message = "用户名存在";
                break;
        }

        setAttr("success", success);
        setAttr("message", message);
        renderJson();
        // renderFreeMarker("register.ftl");
    }

}
