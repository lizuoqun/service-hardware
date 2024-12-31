package com.modify.controller.publicApi;

import cn.hutool.http.HttpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author modify
 */
@RestController
@RequestMapping("/advice")
public class AdviceController {
    private static final String ADVICE_URL = "https://api.adviceslip.com/advice/search/";

    @GetMapping("/search/{desc}")
    public String holidays(@PathVariable String desc) {
        if ("".equals(desc)) {
            return "关键字为空！";
        }

        try {
            return HttpUtil.get(ADVICE_URL + desc);
        } catch (Exception e) {
            return "请求失败: " + e.getMessage();
        }
    }
}
