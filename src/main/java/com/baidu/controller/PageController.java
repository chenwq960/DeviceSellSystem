package com.baidu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 静态页面跳转类
 * 
 * @author chenwq
 * @createTime 2020-01-18 21:30:46
 */
@Controller
@RequestMapping("/page")
public class PageController {

    private static Logger logger = LoggerFactory.getLogger(PageController.class);

    @RequestMapping("/{path}")
    public String goPath1(@PathVariable("path") String path) {
        logger.info("一级路径跳转：/page/{}", path);
        return path;
    }

    @RequestMapping("/{path1}/{path2}")
    public String goPath2(@PathVariable("path1") String path1, @PathVariable("path2") String path2) {
        logger.info("二级路径跳转：/page/{}/{}", path1, path2);
        return path1 + "/" + path2;
    }

}
