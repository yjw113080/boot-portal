package com.examples.bootportal.controller;

import com.examples.bootportal.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/device")
public class DeviceController {
    @Autowired
    DeviceRepository deviceRepository;
    @GetMapping
    public ModelAndView deviceList () {
        ModelAndView device = new ModelAndView();
        device.setViewName("device");
        //device.addObject("deviceList", deviceRepository.getAllByAccountId());
        return device;
    }
}
