package com.deng;

import com.deng.myAutoConfigruation.WebServerAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Author: Deng.
 * @Description:
 * @Date Created in 2023 -08 -29 19:55
 * @Modified By:
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@ComponentScan// spring容器检测到这个注解，就会去扫描该注解所在类的所在包下的所有东西


/*
* 但需要每写一个自动配置类都需要@Import(一次会非常麻烦，所以引入了批量导入，利用spring的ImportSelector类
* */
//@Import(WebServerAutoConfiguration.class) //去将自动配置类中的所有类注册成bean，然后通过依赖排除通过@Condition排除掉某些bean
@Import(DengAutoConfigurationImportSelector.class)
public @interface DengSpringBootApplication {
}
