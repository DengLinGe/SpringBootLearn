package com.deng.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Deng.
 * @Description:
 * @Date Created in 2023 -08 -29 19:54
 * @Modified By:
 */

@RestController
public class UserController {

    @GetMapping("/test")
    public String test(){
        return "Lin123456789";
    }

}
