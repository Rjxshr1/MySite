package my.test;

import com.jfinal.ext.test.ControllerTestCase;
import com.jfinal.plugin.activerecord.Record;
import my.config.MainConfig;
import my.model.Message;
import my.model.User;
import my.service.MessageService;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2017/4/13 0013.
 */
public class MessageTestCase extends ControllerTestCase<MainConfig> {
    private MessageService messageService = new MessageService();

    //初始化JFINAL配置
    @BeforeClass
    public static void initConfig() {
        try {
            start(MainConfig.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMessageCreate() {
    }

    @Test
    public void testGetAllMessageDetailRecord() {

    }

    @Test
    public void testGetAllMessageDetail() {
        List<Record> records = messageService.getAllMessageDetailRecord();
        for (Record record : records) {
            System.out.println(record);
        }
    }

    @Test
    public void testMessageUser() {
        User user = User.dao.findById(1);
        List<Message> myMessages = user.getMyMessages();
        for (Message myMessage : myMessages) {
            System.out.println(myMessage);
        }
    }

}
