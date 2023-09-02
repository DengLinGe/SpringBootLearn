package com.deng.myInterface.impl;

import com.deng.myInterface.WebServer;

/**
 * @Author: Deng.
 * @Description:
 * @Date Created in 2023 -08 -29 20:35
 * @Modified By:
 */
public class JettyWebServer implements WebServer {
    @Override
    public void start() {
        System.out.println("启动jetty的代码");
    }
}
