package com.deng.springlearn01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;

@SpringBootApplication
//判断是不是某个应用，如JAVA版本、Web项目，核心思想是加载某些特定的类，如果加载到了就是
public class SpringLearn01Application {
    /*
    * 1.实例化一个springApplication对象。
    *   0.run方法传入进来的类赋值给primarySources
        1.推测应用的类型
        2.从spring.factories文件中去获取ApplicationContextInitializer的实现类，赋值给initializers
        3.从spring.factories文件中去获取ApplicationListener的实现类,赋值给initializers
        4.找到main方法所在的类
      2.调用SpringApplication对象的run()
        1.获取SpringBoot应用的运行监听器SpringApplicationRunListener
        2.调用对应监听器的starting方法->即发布相关事件
        3.准备environment对象,例如spring启动参数、解析properties配置文件->prepareEnvironment
        4.打印banner
        5.创建 一个spring容器->createApplicationContext
        6.执行容器初始化器->applyInitializers
        7.像spring从其添加配置类（即run方法传进来的类）->  this.load(context, sources.toArray(new Object[0]))
        8.启动spring容器，扫描bean->refreshContext()
        9.afterRefresh()->模板方法，给子类实现想增加的逻辑
        10.执行完后->started->callRunners->handleRunFailure->ready
    *
    * */
    public static void main(String[] args) {

        SpringApplication.run(SpringLearn01Application.class, args);
    }

}
