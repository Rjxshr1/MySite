package my.test;

import com.jfinal.ext.test.ControllerTestCase;
import my.config.MainConfig;
import my.service.UserService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Administrator on 2017/4/13 0013.
 */
public class UserTestCase extends ControllerTestCase<MainConfig> {

    private static final UserService userService = new UserService();
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
    public void testUserRegister() {
        UserService.RegisterResult result = userService.register("test", "test");
        Assert.assertEquals(result, UserService.RegisterResult.REGISTER_OK);
        result = userService.register("test", "test");
        Assert.assertEquals(result, UserService.RegisterResult.USER_IS_EXISTED);
    }

}
