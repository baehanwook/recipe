package com.recipe.controller;

import com.recipe.common.Constants;
import org.springframework.http.HttpRequest;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BaseController {
    public void deviceCheck(HttpServletRequest request, HttpServletResponse response) {
        Device device = DeviceUtils.getCurrentDevice(request);
        System.out.println("device ====== " + device);
    }
}
