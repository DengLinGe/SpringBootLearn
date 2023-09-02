package com.deng.myAutoConfigruation;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @Author: Deng.
 * @Description:
 * @Date Created in 2023 -08 -30 13:32
 * @Modified By:
 */
public class DengCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(DengConditionOnClass.class.getName());
        String value = (String)annotationAttributes.get("value");

        try {
            Class<?> loadClass = context.getClassLoader().loadClass(value);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }



    }
}
