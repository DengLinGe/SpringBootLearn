package com.deng;

import com.deng.myInterface.WebServer;
import org.apache.catalina.Host;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Server;
import org.apache.catalina.Service;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Map;

/**
 * @Author: Deng.
 * @Description:
 * @Date Created in 2023 -08 -29 19:57
 * @Modified By:
 */
public class DengSpringApplication {

    public static void run(Class clazz){

        // 创建一个spring容器，并注册相关的bean
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();


        /*
        * bug提示：
        * DengSpringApplication只会扫描启动类所在的包，也就是用户项目所在的包，但并不会扫描myspringboot这个项目的类
        * 当我们想让WebServerAutoConfiguration变成bean时无法做到
        * 所以需要想办法，把myspringboot项目中需要加载成bean的类放到容器中去->使用@Import
        * */
        applicationContext.register(clazz);//传入启动类（配置类），解析类上的注解
        applicationContext.refresh();

        // 启动tomcat,传入spring容器，写死了就启动tomcat，但此时耦合度很高，至少要写个判断，判断用户要启动什么容器
//        startTomcat(applicationContext);

        // 判断当前用户需要用什么，如果没有配置，就自动配置
        WebServer webServer = getWebServer(applicationContext);
        webServer.start();

    }
    //现在的问题就在于怎么根据用户的配置把类给注册成bean，所以此时就用到了自动配置类
    private static WebServer getWebServer(WebApplicationContext webApplicationContext) {
        Map<String, WebServer> beansOfType = webApplicationContext.getBeansOfType(WebServer.class);//拿到所有的webserver的bean，并进行判断是哪一个
        if (beansOfType.size()==0){
            // 0个bean，用户没有配置,也可以默认设置为某个web
            throw new NullPointerException();
        }
        if (beansOfType.size() >1){
            //多个bean，不知道配哪一个
            throw new IllegalStateException();
        }



        return beansOfType.values().stream().findFirst().get();

    }

    private static void startTomcat(WebApplicationContext webApplicationContext) {
        // 用java代码启动tomcat，模拟tomcat脚本
        Tomcat tomcat = new Tomcat();
        Server server = tomcat.getServer();
        Service service = server.findService("Tomcat");

        Connector connector = new Connector();
        connector.setPort(8081);

        StandardEngine engine = new StandardEngine();
        engine.setDefaultHost("localhost");

        String contextPath = "";
        StandardContext context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.FixContextListener());

        Host host = new StandardHost();
        host.setName("localhost");

        host.addChild(context);
        engine.addChild(host);

        service.setContainer(engine);
        service.addConnector(connector);

        tomcat.addServlet(contextPath, "dispatcher", new DispatcherServlet(webApplicationContext));  // 向tomcat配置了一个spring的servlet，该servlet向自动寻找容器中的bean，并进行路径的匹配
        context.addServletMappingDecoded("/*", "dispatcher"); // 配置一个映射，什么请求去什么servlet
        try {
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }

    }
}
