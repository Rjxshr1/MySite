package my.config;

import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.ext.interceptor.SessionInViewInterceptor;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.template.Engine;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import jfinal.ext.freemarker.FreemarkerHelper;
import my.controller.MainController;
import my.model._MappingKit;

import javax.sql.DataSource;

/**
 * Created by Rajab on 2017/03/30.
 */
public class MainConfig extends JFinalConfig {
    @Override
    public void configConstant(Constants me) {
        Prop prop = PropKit.use("myconfig.properties");
        //开启Jfinal的开发模式
        me.setDevMode(PropKit.getBoolean("devMode", true));
        //设置500错误页面
        me.setError500View("/pages/error.html");
        //设置404错误页面
        me.setError404View("/pages/error.html");
        FreemarkerHelper.registerExtensionTag();
    }

    @Override
    public void configRoute(Routes me) {

        //设置视图的默认目录
        me.setBaseViewPath("/pages");
        //   http://localhost/xxx ->  MainController.xxx()
        me.add("/", MainController.class);
        //me.add("/message", MessageController.class);
        //  me.add("/admin", AdminController.class);
        //  me.add("/admin/category", CategoryController.class, "admin");
    }

    @Override
    public void configEngine(Engine me) {

    }

    @Override
    public void configPlugin(Plugins me) {
        //配置数据库插件
        ActiveRecordPlugin arp = new ActiveRecordPlugin(getDataSource());
        arp.setDialect(new MysqlDialect());
        arp.setDevMode(PropKit.getBoolean("devMode", true));
        arp.setShowSql(PropKit.getBoolean("showSql", true));
        _MappingKit.mapping(arp);
        me.add(arp);


    }

    @Override
    public void configInterceptor(Interceptors me) {
        //允许在页面中访问session变量
        me.add(new SessionInViewInterceptor());
    }

    @Override
    public void configHandler(Handlers me) {
        //设置上下文路径 可以在页面使用base来获取
        me.add(new ContextPathHandler("base"));
    }

    public static void main(String[] args) {
        JFinal.start("web", 8080, "/");
    }

    public static DataSource getDataSource() {
        //获取数据源
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setUrl(PropKit.get("jdbcurl"));
        mysqlDataSource.setUser(PropKit.get("user"));
        mysqlDataSource.setPassword(PropKit.get("password"));
        return mysqlDataSource;
    }


}

