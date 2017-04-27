package my.controller;

import com.anna.config.Ioc.Autowired;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import my.interceptor.LoginInterceptor;
import my.service.UserService;

/**
 * Created by Rajab on 2017/03/30.
 */
public class MainController extends Controller {

    //用户操作服务
    @Autowired
    private static UserService userService;

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

}
