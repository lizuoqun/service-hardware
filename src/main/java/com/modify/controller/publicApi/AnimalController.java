package com.modify.controller.publicApi;

import cn.hutool.http.HttpUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * 公共获取Animals类的接口
 *
 * @author modify
 */
@RequestMapping("/animal")
@RestController
public class AnimalController {
    private static final String RANDOM_CAT__URL = "https://api.thecatapi.com/v1/images/search?limit=";

    private static final String VTUBER_URL = "https://api.nekosia.cat/api/v1/images/vtuber";

    private static final String RANDOM_CAT_IMAGE_TYPE = "https://cataas.com/cat/orange,cute";
    private static final String RANDOM_CAT_GIF_TYPE = "https://cataas.com/cat/gif";

    private static final String IMAGE_TYPE = "image";
    private static final String GIF_TYPE = "gif";

    @GetMapping("/cat/{limit}")
    public String holidays(@PathVariable Integer limit) {
        if (limit == null) {
            return "limit不能为空";
        }

        if (limit < 1 || limit > 100) {
            return "limit有效值在1-100之间";
        }

        try {
            return HttpUtil.get(RANDOM_CAT__URL + limit);
        } catch (Exception e) {
            return "请求失败: " + e.getMessage();
        }
    }

    @GetMapping("/vtuber")
    public String getVtuber() {
        try {
            return HttpUtil.get(VTUBER_URL);
        } catch (Exception e) {
            return "请求失败: " + e.getMessage();
        }
    }

    // 这个接口不用封装，在前端直接用
    @GetMapping("/catType/{type}")
    public void getRandomCatByType(@PathVariable String type, HttpServletResponse response) {

        // 为了优化而优化？ 混合的三目运算，理解成type分别为image和gif的取值
        String url = (IMAGE_TYPE.equals(type)) ? RANDOM_CAT_IMAGE_TYPE : (GIF_TYPE.equals(type)) ? RANDOM_CAT_GIF_TYPE : "";

        if ("".equals(url)) {
            throw new RuntimeException("参数不对，请传入image或gif！你传的参数是：" + type);
        }

        byte[] pngBytes = HttpUtil.createGet(url)
                .contentType("application/json")
                .execute().bodyBytes();

        response.setContentType("image/png");
        try {
            response.getOutputStream().write(pngBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
