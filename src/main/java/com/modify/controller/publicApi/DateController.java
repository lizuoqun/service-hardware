package com.modify.controller.publicApi;

import cn.hutool.http.HttpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import java.time.Year;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * 公共获取日期的接口
 *
 * @author modify
 */
@RequestMapping("/date")
@RestController
public class DateController {

    private static final String API_URL = "https://api.jiejiariapi.com/v1/holidays/";
    private static final Pattern YEAR_PATTERN = Pattern.compile("^\\d{4}$");

    @GetMapping("/holidays/{year}")
    public String holidays(@PathVariable String year) {
        if ("".equals(year)) {
            // 获取当前年份作为默认值
            String currentYear = Year.now().toString();
            year = Optional.ofNullable(year).orElse(currentYear);
        }

        // 验证年份格式
        if (!YEAR_PATTERN.matcher(year).matches()) {
            return "年份格式异常，请检查！";
        }
        try {
            String result = HttpUtil.get(API_URL + year);
            return HtmlUtils.htmlEscape(result);
        } catch (Exception e) {
            return "请求失败: " + e.getMessage();
        }
    }
}
