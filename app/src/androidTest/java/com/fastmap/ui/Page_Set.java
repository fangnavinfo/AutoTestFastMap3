package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by h on 2018/2/6.
 */

public class Page_Set extends FastMapPage
{
    @FindResource(Id = "btn_back", ios_xpath="(//XCUIElementTypeButton[@name=\"返回\"])[2]")
    public static String BACK;

    @FindResource(Id = "checkBox_camera_fullView", ios_name="采集产品全貌照片")
    public static String FULLVIEW;

    public static Page_Set Inst;
    static {
        Inst = new Page_Set();
    }
}
