package my.controller;

import com.jfinal.core.Controller;
import my.service.MessageService;

/**
 * Created by Administrator on 2017/4/13 0013.
 */
public class MessageController extends Controller {

    MessageService messageService = new MessageService();
    public void index() {
        list();

    }

    public void list() {
        //TODO:显示所有留言页面

    }

    public void save() {
        //TODO:保存留言 要求登录后访问
    }


    public void delete() {
        //TODO:删除留言

        //提示 获取留言id，删除  ymet
    }


    public void create() {
        //TODO:显示发表留言页面 要求登录后才能留言
        // 提示 @Before(Login.class) 使用拦截器
        renderFreeMarker("create.ftl");
    }
}
