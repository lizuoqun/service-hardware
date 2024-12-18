package com.modify;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import oshi.SystemInfo;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;

import java.util.List;

public class OSHITest {
    @Test
    // 用于在方法上自动添加异常处理。它的作用是在方法体中自动捕获并处理异常，将异常转换为非受检异常（Unchecked Exception）并抛出
    @SneakyThrows
    void test1() {
        // 入口从这开始
        SystemInfo info = new SystemInfo();

        // 获取所有的进程信息
        OperatingSystem os = info.getOperatingSystem();

        List<OSProcess> processes = os.getProcesses();

        ObjectMapper mapper = new ObjectMapper();


        for (OSProcess p : processes) {
            // 可以通过ObjectMapper打印格式化之后的json字符串
            System.out.println(p);
            // System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(p));
        }
    }
}
