package my.test;

import com.jfinal.ext.test.ControllerTestCase;
import my.config.MainConfig;
import org.junit.BeforeClass;

/**
 * Created by Administrator on 2017/4/13 0013.
 */
public class MessageTestCase extends ControllerTestCase<MainConfig> {
    //初始化JFINAL配置
    @BeforeClass
    public static void initConfig() {
        try {
            start(MainConfig.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //@Test
    public void testMessageCreate() {
        //添加测试代码
    }

}
