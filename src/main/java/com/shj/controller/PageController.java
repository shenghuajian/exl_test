package com.shj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/{page}")
    public String Page(@PathVariable String page) {
        System.out.println(page);
        return page;
    }

    @RequestMapping("/manager/1")
    public String Page2(@PathVariable String page) {
        System.out.println(page);
        page += "manage/";
        return page;
    }
}
