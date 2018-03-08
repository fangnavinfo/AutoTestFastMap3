package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by fang on 18/1/22.
 */
public class Page_InfoPoint extends FastMapPage
{
    @FindResource(Id="et_title", ios_predicate="value MATCHES '^[0-9a-fA-F]{10,}$'")
    public static String GLOBAL_ID;
    
    @FindResource(Id="edt_infor_report_name", ios_xpath="//XCUIElementTypeApplication[@name=\"FastMap-18夏\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextView")
    public static String NAME;

    @FindResource(Id="infor_report_type_poi", ios_xpath="//XCUIElementTypeButton[@name=\"POI\"]")
    public static String POI_TYPE;

    @FindResource(Id="infor_report_level_1", ios_xpath="//XCUIElementTypeButton[@name=\"一级\"]")
    public static String LEVEL_1;
    
    @FindResource(Id="tv_poiReport_time", ios_xpath="//XCUIElementTypeApplication[@name=\"FastMap-18夏\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[5]/XCUIElementTypeTextField")
    public static String TIME;

    @FindResource(Id="btn_fm_confirm", ios_xpath="//XCUIElementTypeButton[@name=\"确定\"]")
    public static String TIME_CONFIRM;

    @FindResource(Id="camera_button", ios_xpath="//XCUIElementTypeButton[@name=\"photo icon\"]")
    public static String CAMERA;

    @FindResource(Id="save_button", Text="保存")
    public static String SAVE;
    
    @FindResource(Id="cancel_button", Text="取消")
    public static String CANCEL;
    

    public static Page_InfoPoint Inst;
    static
    {
        Inst = new Page_InfoPoint();
    }

}