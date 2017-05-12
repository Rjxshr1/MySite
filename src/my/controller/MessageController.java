package my.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;
import my.interceptor.Login;
import my.service.MessageService;

import java.util.List;

/**
 * Created by Administrator on 2017/4/13 0013.
 */
public class MessageController extends Controller {

    MessageService messageService = new MessageService();
    public void index() {
        list();

    }

    public void list() {
        List<Record> messages = messageService.getAllMessageDetailRecord();
        setAttr("messages", messages);
        renderFreeMarker("list.ftl");
    }

    public void save() {
        //TODO:保存留言 要求登录后访问
    }


    public void delete() {
        //TODO:删除留言

        //提示 获取留言id，删除  ymet
    }


    @Before(Login.class)
    public void create() {
        //TODO:显示发表留言页面 要求登录后才能留言
        // 提示 @Before(Login.class) 使用拦截器
        renderFreeMarker("create.ftl");
    }
}
