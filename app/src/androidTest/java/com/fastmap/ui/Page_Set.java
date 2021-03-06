package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by h on 2018/2/6.
 */

public class Page_Set extends FastMapPage
{
    @FindResource(Id = "btn_back", ios_xpath="//XCUIElementTypeButton[@name=\"返回\"]")
    public static String BACK;

    @FindResource(Id = "checkBox_camera_fullView", ios_xpath="//XCUIElementTypeSwitch[@name=\"采集产品全貌照片\"]")
    public static String FULLVIEW;

    @FindResource(Id = "checkBox_power_saving")
    public static String POWER_SAVE;

    @FindResource(Id = "main_pas_default_style")
    public static String PAS_DEFAULT_SET;


    public static Page_Set Inst;
    static {
        Inst = new Page_Set();
    }
}
