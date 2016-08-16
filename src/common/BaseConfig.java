package common;

import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import controller.HelloWorldController;

/**
 * Created by Xiaofeng on 2016/8/16.
 */
public class BaseConfig extends JFinalConfig {
    @Override
    public void configConstant(Constants me) {
        PropKit.use("config.properties");
        me.setDevMode(PropKit.getBoolean("devMode",false));
        me.setBaseViewPath("WEB-INF");
        me.setReportAfterInvocation(true);
        // 设置渲染方式
        me.setViewType(ViewType.FREE_MARKER);
    }

    @Override
    public void configRoute(Routes me) {
        me.add("/hello", HelloWorldController.class);


    }

    @Override
    public void configPlugin(Plugins me) {
        //配置数据库连接池插件
        C3p0Plugin c3p0Plugin=new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password"));
        //orm映射 配置ActiveRecord插件
        ActiveRecordPlugin arp=new ActiveRecordPlugin(c3p0Plugin);
        arp.setShowSql(PropKit.getBoolean("devMode"));
        arp.setDialect(new MysqlDialect());
        /********在此添加数据库 表-Model 映射*********/
         //arp.addMapping("user", User.class);


        //添加到插件列表中
        me.add(c3p0Plugin);
        me.add(arp);
    }

    @Override
    public void configInterceptor(Interceptors me) {

    }

    @Override
    public void configHandler(Handlers me) {

    }
    public static void main(String[] args) {
        JFinal.start("WebRoot",80,"/",5);
    }
}
