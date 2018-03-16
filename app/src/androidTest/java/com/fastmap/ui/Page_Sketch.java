package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * 草图
 * Created by fang on 18/3/13.
 */
public class Page_Sketch extends FastMapPage
{
    @FindResource(Id="sketch_sketch", Text = "草图")
    public static String SKETCH;

    @FindResource(Id="sketch_hook_1", Text = "挂接1")
    public static String HOOK1;

    @FindResource(Id="sketch_hook_2", Text = "挂接2")
    public static String HOOK2;

    @FindResource(Id="connect_icons_2082", ios_xpath = "//XCUIElementTypeApplication[@name=\"FastMap-18夏\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeButton[2]")
    public static String G1_R1_C2;

    @FindResource(Id="connect_icons_2113", ios_xpath = "//XCUIElementTypeApplication[@name=\"FastMap-18夏\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeButton[1]")
    public static String G2_R1_C1;

    @FindResource(Id="save_button", Text = "保存")
    public static String SAVE;

    @FindResource(Id="straight_line", ios_xpath = "//XCUIElementTypeButton[@name=\"line straightLine\"]")
    public static String STRAIGHT; //直线

    @FindResource(Id="curve_line", ios_xpath = "//XCUIElementTypeButton[@name=\"line curveLine\"]")
    public static String CURVE; //曲线

    @FindResource(Id="poly_line", ios_xpath = "//XCUIElementTypeButton[@name=\"line brokenLine\"]")
    public static String POLY; //折线

    @FindResource(Id="rect_line", ios_xpath = "//XCUIElementTypeButton[@name=\"line rectLine\"]")
    public static String RECT; //矩形

    @FindResource(Id="ellipse_line", ios_xpath = "//XCUIElementTypeButton[@name=\"line circle\"]")
    public static String ELLIPSE; //圆


    @FindResource(Id="circular_point", ios_xpath = "//XCUIElementTypeButton[@name=\"line circular\"]")
    public static String POINT; //圆点

    @FindResource(Id="greenland_line", ios_xpath = "//XCUIElementTypeButton[@name=\"line greenbelt\"]")
    public static String GREEN_LAND; //草地

    @FindResource(Id="water_line", ios_xpath = "//XCUIElementTypeButton[@name=\"line river\"]")
    public static String WATER; //水系

    @FindResource(Id="railway_line", ios_xpath = "//XCUIElementTypeButton[@name=\"line railway\"]")
    public static String RAILWAY; //铁路

    public static Page_Sketch Inst;
    static
    {
        Inst = new Page_Sketch();
    }
}
