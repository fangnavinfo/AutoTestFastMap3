package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by fang on 18/1/22.
 */
public class Page_InfoPoint extends FastMapPage
{
    @FindResource(Id="et_title", ios_predicate="value MATCHES '^[0-9a-fA-F]{10,}$'")
    public static String GLOBAL_ID;
    
    @FindResource(Id="edt_infor_report_name", ios_xpath="//XCUIElementTypeApplication[@name=\"FastMap-18秋\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextView")
    public static String NAME;

    @FindResource(Id="infor_report_type_poi", ios_name="POI")
    public static String POI_TYPE;

    @FindResource(Id="infor_report_type_road", Text="道路")
    public static String ROAD_TYPE;

    @FindResource(Id="infor_report_level_1", ios_name="一级")
    public static String LEVEL_1;
    
    @FindResource(Id="tv_poiReport_time", Text="单击选择时间")
    public static String TIME;

    @FindResource(Id="btn_fm_confirm", ios_name="确定")
    public static String TIME_CONFIRM;

    @FindResource(Id="camera_button_myselt", ios_name="mediaOperate_photoBtn")
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