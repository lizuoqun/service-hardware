package com.modify.controller;

import com.modify.common.R;
import com.modify.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author modify
 */

@RequestMapping("/device")
@RestController
@CrossOrigin
public class deviceController {

    @Autowired
    DeviceService deviceService;

    @GetMapping("/cpu")
    public R getCpu() {
        return R.ok(deviceService.getCpu());
    }
}