package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * 草图
 * Created by fang on 18/3/13.
 */
public class Page_Sketch extends Page_Base_Tips
{
    @FindResource(Id="sketch_sketch", ios_name="gridView_sketch_sketch")
    public static String SKETCH;

    @FindResource(Id="sketch_hook_1", ios_name="gridView_sketch_mount1")
    public static String HOOK1;

    @FindResource(Id="sketch_hook_2", ios_name="gridView_sketch_mount2")
    public static String HOOK2;

    @FindResource(Id="connect_icons_2082", ios_xpath="//XCUIElementTypeApplication[@name=\"FastMap-18秋\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeButton[2]")
    public static String G1_R1_C2;

    @FindResource(Id="connect_icons_2113", ios_xpath="//XCUIElementTypeApplication[@name=\"FastMap-18秋\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeButton[1]")
    public static String G2_R1_C1;

    @FindResource(Id="straight_line", ios_name="gridView_line_straightLine.png")
    public static String STRAIGHT; //直线

    @FindResource(Id="curve_line", ios_name="gridView_line_curveLine.png")
    public static String CURVE; //曲线

    @FindResource(Id="poly_line", ios_name="gridView_line_brokenLine.png")
    public static String POLY; //折线

    @FindResource(Id="rect_line", ios_name="gridView_line_rectLine.png")
    public static String RECT; //矩形

    @FindResource(Id="ellipse_line", ios_name="gridView_line_circle.png")
    public static String ELLIPSE; //圆


    @FindResource(Id="circular_point", ios_name="gridView_line_circular.png")
    public static String POINT; //圆点

    @FindResource(Id="greenland_line", ios_name="gridView_line_greenbelt.png")
    public static String GREEN_LAND; //草地

    @FindResource(Id="water_line", ios_name="gridView_line_river.png")
    public static String WATER; //水系

    @FindResource(Id="railway_line", ios_name="gridView_line_railway.png")
    public static String RAILWAY; //铁路

    public static Page_Sketch Inst;
    static
    {
        Inst = new Page_Sketch();
    }
}
