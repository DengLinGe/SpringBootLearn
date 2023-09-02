package com.deng.myAutoConfigruation;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: Deng.
 * @Description: 自己实现的条件注解
 * @Date Created in 2023 -08 -30 13:27
 * @Modified By:
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Conditional(DengCondition.class)
public @interface DengConditionOnClass {
    // 想达到的条件是：判断某些类是否加载，如果加载就返回true，取代了各个具体的xxxCondition的作用
    String value();
}
