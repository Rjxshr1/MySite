package my.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.POST;
import my.interceptor.Login;
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
        boolean success = false;
        switch (result) {
            case LOGIN_OK:
                setSessionAttr("username", username);
                success = true;
                setAttr("message", "登录成功");
                break;
            case INPUT_INVALID:
                setAttr("message", "用户名或密码为空");
                forwardAction("/login");
                break;
            case PASSWORD_WRONG:
                setAttr("message", "用户名或密码错误");
                break;
        }
        setAttr("success", success);
        renderJson();
    }

    @Before(Login.class)
    public void success() {
        renderFreeMarker("success.ftl");
    }

    @Before(Login.class)
    public void main() {
        renderFreeMarker("main.ftl");
    }

    public void logout() {
        //TODO:退出登录
        //提示 (1)使用removeSessionAttr(key)方法从Session中移除登录的username
        //(2)使用 redicrect(url)方法跳转到登录页面

    }

    public void register() {
        //TODO:理解register-ref.ftl页面后  选择renderFreeMarker("register-ref.ftl");
        // 提示：该页面期望获得json格式的注册结果 renderJson()
        renderFreeMarker("register-ref.ftl");
        //renderFreeMarker("register-ref.ftl");
    }

    @Before(POST.class)
    public void doregister() {

        String username = getPara("username", "");
        String password = getPara("password", "");
        UserService.RegisterResult result = userService.register(username, password);
        String message = "";
        boolean success = false;
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

        System.out.println("success is " + success);
        System.out.println("message is " + message);
        // TODO: 注册显示的是register-ref.ftl
        //需要使用renderJson()方法 返回json数据 格式为:
        // ｛success : true或false, message : 返回的消息}

        setAttr("success", success);
        setAttr("message", message);
        renderJson();
    }

    @Before(Login.class)
    public void needlogin() {

        renderText("ok");
    }

    @Before(Login.class)
    public void abc() {

        renderText("abc");
    }
}
