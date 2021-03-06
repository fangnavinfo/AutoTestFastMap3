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

    @FindResource(Id="speed_limit_type_variable", ios_name="gridView_sl_variable.png")
    public static String VARIABLELIMIT;

    @FindResource(Id="speed_limit_type_condition", ios_name="gridView_sl_condition.png")
    public static String CONDITIONLIMIT;

    @FindResource(Id="card_speed_limit_type_truck")
    public static String TRUCKLIMIT;

    @FindResource(Id="speed_limit_type_truck_condition")
    public static String TRUCKCONDITION;

    @FindResource(Id="speed_limit_number_30")
    public static String SPEED_30;
    @FindResource(Id="speed_limit_number_40")
    public static String SPEED_40;
    @FindResource(Id="speed_limit_number_50")
    public static String SPEED_50;
    @FindResource(Id="speed_limit_number_60")
    public static String SPEED_60;
    @FindResource(Id="speed_limit_number_70")
    public static String SPEED_70;
    @FindResource(Id="speed_limit_number_80")
    public static String SPEED_80;
    @FindResource(Id="speed_limit_number_90")
    public static String SPEED_90;
    @FindResource(Id="speed_limit_number_100")
    public static String SPEED_100;
    @FindResource(Id="speed_limit_number_110")
    public static String SPEED_110;
    @FindResource(Id="speed_limit_number_120")
    public static String SPEED_120;




    public static Page_SpeedLimit Inst;
    static
    {
        Inst = new Page_SpeedLimit();
    }
}
