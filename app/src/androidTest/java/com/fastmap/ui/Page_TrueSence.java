package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by zhou on 18/1/24.
 * 实景图TIPS
 */
public class Page_TrueSence extends FastMapPage
{
    @FindResource(Id="et_title", ios_xpath="//XCUIElementTypeApplication[@name=\"FastMap-18夏\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeTextView")
    public static String ROWKEY;
    @FindResource(Id="common_load", Text="普通路口")
    public static String COMMON_LOAD;
    @FindResource(Id="highway_load_out", Text="高速出口")
    public static String HIGHWAY_LOAD_OUT;
    @FindResource(Id="highway_load_in", Text="高速入口")
    public static String HIGHWAY_LOAD_IN;
    @FindResource(Id="et_img_number", ios_xpath="//XCUIElementTypeApplication[@name=\"FastMap-18夏\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
    public static String ET_IMG_NUMBER;
    @FindResource(Id="camera_button", ios_predicate="name == 'photo icon'")
    public static String CAMERA_BUTTON;

    @FindResource(Id="cancel_button", Text="取消")
    public static String CANCEL;
    @FindResource(Id="save_button", Text="保存")
    public static String SAVE;

    public static Page_TrueSence Inst;
    static
    {
        Inst = new Page_TrueSence();
    }
}