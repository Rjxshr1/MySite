package my.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;
import my.interceptor.Login;
import my.model.Message;
import my.model.User;
import my.service.MessageService;
import my.service.UserService;
import java.util.List;

/**
 * Created by Administrator on 2017/4/13 0013.
 */
public class MessageController extends Controller {

    MessageService messageService = new MessageService();
    private static UserService userService = new UserService();

    public void index() {
        //list();
        //renderFreeMarker("create.ftl");
        renderFreeMarker("delete.ftl");
    }

    public void list() {
        List<Record> messages = messageService.getAllMessageDetailRecord();
        setAttr("messages", messages);
        renderFreeMarker("list.ftl");
    }
    //@Before(Login.class)
    public void save() {
        //TODO:保存留言 要求登录后访问


        Message message = new Message();
        String name = getPara("message.author","");
        String content = getPara("message.content", "");
        String title = getPara("message.title","");
        //根据用户名获取用户ID
        User user = userService.findUserByUsername(name);
        System.out.println(user.getId());
        message.setContent(content);
        message.setUserId(user.getId());
        message.setTitle(title);
        message.save();
       /* try {
            renderHtml("<h>保存成功！3秒后返回留言列表</h>");
            Thread.sleep(3000);
            list();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        list();
    }


    public void delete() {
        //TODO:删除留言
        Message message = new Message();
        String get_id = getPara("message.id");
        int id = Integer.valueOf(get_id);
        messageService.deleteMessageById(id);
        renderFreeMarker("list.ftl");
        //提示 获取留言id，删除  ymet
    }


    //@Before(Login.class)
    public void create() {
        //TODO:显示发表留言页面 要求登录后才能留言
        // 提示 @Before(Login.class) 使用拦截器
        renderFreeMarker("create.ftl");
    }


}
