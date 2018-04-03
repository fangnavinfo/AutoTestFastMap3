package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by zhou on 18/1/24.
 * 实景图TIPS
 */
public class Page_TrueSence extends Page_Base_Tips
{
    @FindResource(Id="common_load", Text="普通路口")
    public static String COMMON_LOAD;
    @FindResource(Id="highway_load_out", Text="高速出口")
    public static String HIGHWAY_LOAD_OUT;
    @FindResource(Id="highway_load_in", Text="高速入口")
    public static String HIGHWAY_LOAD_IN;
    @FindResource(Id="et_img_number", ios_xpath="//XCUIElementTypeApplication[@name=\"FastMap-18秋\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
    public static String ET_IMG_NUMBER;

    public static Page_TrueSence Inst;
    static
    {
        Inst = new Page_TrueSence();
    }
}