package com.modify.service;

import ch.qos.logback.classic.spi.EventArgUtil;
import org.springframework.stereotype.Service;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;

/**
 * @author modify
 */
@Service
public class DeviceService {

    /**
     * 这个是线程安全的，所以可以放在全局变量里面
     * 请看源码，createHardware方法获取cpu，是通过switch case区分不同平台
     * 以windows为例，返回的是一个WindowsHardwareAbstractionLayer类，该类用@ThreadSafe标识
     * @ThreadSafe 表示这个类是线程安全的。具体是否真安全，那要看实现者怎么实现的了，反正打上这个标签只是表示一下。不线程安全的类打上这个注解也没事儿
     *
     */
    SystemInfo SI = new SystemInfo();


    /**
     * 获取CPU使用率
     * */
    public double[] getCpu() {
        HardwareAbstractionLayer hardware = SI.getHardware();
        CentralProcessor processor = hardware.getProcessor();
        double[] processorCpuLoad = processor.getProcessorCpuLoad(1000);
        return processorCpuLoad;
    }
}
