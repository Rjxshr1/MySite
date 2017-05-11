package my.test;

import com.jfinal.ext.test.ControllerTestCase;
import my.config.MainConfig;
import my.service.MessageService;
import org.junit.BeforeClass;
import org.junit.Test;

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

    }

    @Test
    public void testMessageUser() {

    }

}
