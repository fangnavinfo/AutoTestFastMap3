package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by h on 2018/1/29.
 */

public class Page_SpeedLimit extends Page_Base_Tips
{
    @FindResource(Id="speed_limit_type_point", ios_name="gridView_sl_point.png")
    public static String POINT_LIMIT;

    @FindResource(Id="et_speed_limit_number", ios_xpath = "//XCUIElementTypeApplication[@name=\"FastMap-18秋\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeTextField[1]")
    public static String MAX_SPEED;

    @FindResource(Id="et_speed_limit_number_min", ios_xpath = "//XCUIElementTypeApplication[@name=\"FastMap-18秋\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeTextField[2]")
    public static String MIN_SPEED;

    @FindResource(Id="card_speed_limit_type_driveway", ios_xpath = "//XCUIElementTypeButton[@name\"gridView_sl_lane.png\"]")
    public static String ROADLIMIT;

    @FindResource(Id="speed_limit_type_variable")
    public static String VARIABLELIMIT;

    @FindResource(Id="speed_limit_type_condition", ios_name="gridView_sl_condition.png")
    public static String CONDITIONLIMIT;

    public static Page_SpeedLimit Inst;
    static
    {
        Inst = new Page_SpeedLimit();
    }
}
