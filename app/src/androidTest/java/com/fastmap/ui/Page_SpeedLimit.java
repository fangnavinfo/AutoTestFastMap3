package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by h on 2018/1/29.
 */

public class Page_SpeedLimit extends FastMapPage
{
    @FindResource(Id="speed_limit_type_point", ios_xpath = "//XCUIElementTypeButton[@name=\"sl point\"]")
    public static String POINT_LIMIT;

    @FindResource(Id="et_speed_limit_number", ios_xpath = "//XCUIElementTypeApplication[@name=\"FastMap-18夏\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeTextField[1]")
    public static String MAX_SPEED;

    @FindResource(Id="et_speed_limit_number_min", ios_xpath = "//XCUIElementTypeApplication[@name=\"FastMap-18夏\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeTextField[2]")
    public static String MIN_SPEED;

    @FindResource(Id="save_button", Text = "保存")
    public static String SAVE;
    @FindResource(Id="card_speed_limit_type_driveway", ios_xpath = "//XCUIElementTypeButton[@name=\"sl lane\"]")
    public static String ROADLIMIT;

    public static Page_SpeedLimit Inst;
    static
    {
        Inst = new Page_SpeedLimit();
    }
}
