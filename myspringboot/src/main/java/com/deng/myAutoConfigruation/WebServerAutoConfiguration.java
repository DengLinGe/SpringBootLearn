package com.deng.myAutoConfigruation;

import com.deng.myInterface.impl.JettyWebServer;
import com.deng.myInterface.impl.TomcatWebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Deng.
 * @Description:
 * @Date Created in 2023 -08 -29 20:52
 * @Modified By:
 */

/*
@Configuration用于定义配置类，可替换xml配置文件，被注解的类内部包含有一个或多个被@Bean注解的方法，
这些方法将会被AnnotationConfigApplicationContext或AnnotationConfigWebApplicationContext类进行扫描，
并用于构建bean定义，初始化Spring容器。
* */

//  SpringBoot本质上省去了  AutoConfiguration这一步，我们在Spring中确实引入了依赖，但需要我们手动的添加为bean。
//   但在SpringBoot中，添加为bean这一步框架帮我们做了

@Configuration
public class WebServerAutoConfiguration {

    @Bean
//    @Conditional(TomcatCondition.class)//spring提供的机制，当这个bean要生效，就要先符合TomcatCondition的条件
    @DengConditionOnClass("org.apache.catalina.startup.Tomcat")
    public TomcatWebServer tomcatWebServer(){
        return new TomcatWebServer();
    }
    @Bean
//    @Conditional(JettyCondition.class)
    @DengConditionOnClass("org.eclipse.jetty.server.Server")
    public JettyWebServer jettyWebServer(){
        return new JettyWebServer();
    }

}
