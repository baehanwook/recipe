package com.recipe.common;

import org.springframework.mobile.device.Device;

public class Util {

    /**
     * モバイル判断してエンドポイントを返却する
     *
     * @param device
     * @param url
     * @return deviceよるurl
     */
    public static String deviceCheck(Device device, String url) {
        if (device.isMobile()) {
            return Constants.MOBILE + url;
        }
        return Constants.PC + url;
    }
}
