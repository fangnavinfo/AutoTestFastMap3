package com.fastmap.ui;

import com.fang.testAdapter.*;


/**
 * Created by fang on 18/1/22.
 */
public class Page_InfoLine extends FastMapPage
{
    @FindResource(Id="draw_line_over", ios_xpath="//XCUIElementTypeStaticText[@name=\"完成\"]")
    public static String DRAW_FINISH;

    @FindResource(Id="edt_infor_report_name", ios_xpath="//XCUIElementTypeApplication[@name=\"FastMap-18秋\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeTextView")
    public static String NAME;

    @FindResource(Id="infor_report_type_poi", ios_xpath="//XCUIElementTypeButton[@name=\"POI\"]")
    public static String POI_TYPE;

    @FindResource(Id="infor_report_type_road", Text="道路")
    public static String ROAD_TYPE;
    
    @FindResource(Id="infor_report_level_1", Text="一级")
    public static String LEVEL_1;
    
    @FindResource(Id="tv_poiReport_time", Text="单击选择时间")
    public static String TIME;

    @FindResource(Id="btn_fm_confirm", ios_xpath="//XCUIElementTypeButton[@name=\"确定\"]")
    public static String TIME_CONFIRM;

    @FindResource(Id="camera_button", ios_xpath="//XCUIElementTypeButton[@name=\"photo icon\"]")
    public static String CAMERA;

    @FindResource(Id="save_button", Text="保存")
    public static String SAVE;

    public static Page_InfoLine Inst;
    static
    {
        Inst = new Page_InfoLine();
    }
}
