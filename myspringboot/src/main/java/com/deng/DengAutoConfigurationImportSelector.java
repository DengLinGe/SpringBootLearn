package com.deng;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: Deng.
 * @Description:
 * @Date Created in 2023 -08 -30 13:55
 * @Modified By:
 */
public class DengAutoConfigurationImportSelector  implements DeferredImportSelector {

    //
    /*
    * 1. 需要导入的是一个数组，这个数组就是所有的自动配置类的地方
    * 2. 怎么找到所有自动配置类的名字，需要一个规范：spi机制
    * */

    // 寻找jar包->找到META-INF文件夹->找到spring.factories文件
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[0];
    }
}
