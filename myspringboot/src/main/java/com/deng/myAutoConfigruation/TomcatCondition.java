package com.deng.myAutoConfigruation;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Author: Deng.
 * @Description:
 * @Date Created in 2023 -08 -29 20:56
 * @Modified By:
 */
public class TomcatCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        /*
        * 需要判断项目有没有tomcat的依赖
        * 本质：判断项目有没有某个类
        *
        * */

        try {
            Class<?> loadClass = context.getClassLoader().loadClass("org.apache.catalina.startup.Tomcat");//尝试加载Tomcat类，如果加载到了说明有依赖
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }

    }
}
