package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther 旷彬
 * @Date 2021/3/6
 */
@Controller
@RequestMapping("/api")
public class URLController {
    @RequestMapping("/redirect")
    public String redirect(String url){
        return "redirect:"+url;
    }
}
