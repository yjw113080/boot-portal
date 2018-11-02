package com.examples.bootportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/device")
public class DeviceController {
    @GetMapping
    public String deviceList () {

        return "device";
    }
}
