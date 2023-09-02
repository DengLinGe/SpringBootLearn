package com.deng.springlearn01;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @Author: Deng.
 * @Description:
 * @Date Created in 2023 -08 -14 22:35
 * @Modified By:
 */
public class DengApplicationListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("deng@@@@@@@@@@@@@@@@@@"+event);
    }
}
