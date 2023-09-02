package com.deng;

import com.deng.myAutoConfigruation.WebServerAutoConfiguration;
import com.deng.myInterface.WebServer;
import com.deng.myInterface.impl.TomcatWebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * @Author: Deng.
 * @Description:
 * @Date Created in $YEAR -$MONTH -$DAY $TIME
 * @Modified By:
 */

@DengSpringBootApplication

public class MyApplication {



    public static void main(String[] args) {
        DengSpringApplication.run(MyApplication.class);

    }
}