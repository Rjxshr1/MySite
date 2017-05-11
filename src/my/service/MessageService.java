package my.service;

import com.jfinal.plugin.activerecord.Record;
import my.model.Message;
import my.model.User;

import java.util.List;

/**
 * Created by Administrator on 2017/4/20 0020.
 */

public class MessageService {

    public void createMessage(Message message) {
        //TODO:创建留言
        throw new RuntimeException("未完成");
    }

    public void editMessage(Message message) {
        //TODO:编辑留言
        throw new RuntimeException("未完成");
    }


    public void deleteMessageById(int id) {
        //TODO:删除留言
        throw new RuntimeException("未完成");
    }

    public List<Message> getAllMessage() {
        //TODO:获得所有留言表记录
        throw new RuntimeException("未完成");
    }

    public List<Record> getAllMessageDetailRecord() {
        //TODO:获得所有留言详情 使用

        throw new RuntimeException("未完成");
    }

    public List<Message> getAllMessageDetail() {
        //TODO:获得所有留言详情 使用视图

        throw new RuntimeException("未完成");
    }


    public List<Message> getMessageByAuthor(User u) {
        //TODO:根据作者获得所有留言
        throw new RuntimeException("未完成");
    }


}
