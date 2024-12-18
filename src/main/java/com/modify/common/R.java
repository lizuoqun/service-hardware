package com.modify.common;

import lombok.Data;

/**
 * @author modify
 * 统一响应包装类
 */
@Data
public class R {
    public Integer code;
    public String msg;
    public Object data;

    public R(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static R ok(Object data) {
        return new R(200, "操作成功", data);
    }

    public static R fail(Integer code, String msg, Object data) {
        return new R(code, msg, data);
    }
}
