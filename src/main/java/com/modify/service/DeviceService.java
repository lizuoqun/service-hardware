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

    SystemInfo SI = new SystemInfo();

    public double[] getCpu() {
        HardwareAbstractionLayer hardware = SI.getHardware();
        CentralProcessor processor = hardware.getProcessor();
        double[] processorCpuLoad = processor.getProcessorCpuLoad(1000);
        return processorCpuLoad;
    }
}
