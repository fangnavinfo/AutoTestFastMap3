package com.fastmap.ui;

import com.fang.testAdapter.*;


/**
 * Created by fang on 18/1/22.
 */
public class Page_PAS extends FastMapPage
{
    @FindResource(Id="fm_et_name_pas", ios_xpath="//XCUIElementTypeStaticText[@name=\"请输入道路名称\"]")
    public static String NAME;

    @FindResource(Id="fm_et_address_pas", ios_xpath="//XCUIElementTypeApplication[@name=\"FastMap-18夏\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeTextView")
    public static String ADDRESS;

    @FindResource(Id="ck_odd", ios_xpath="//XCUIElementTypeStaticText[@name=\"奇\"]")
    public static String ODD; //奇

    @FindResource(Id="ck_road", ios_xpath="//XCUIElementTypeStaticText[@name=\"路\"]")
    public static String ROAD_TYPE;

    @FindResource(Id="save_button", ios_xpath="//XCUIElementTypeButton[@name=\"保存\"]")
    public static String SAVE;

    public static Page_PAS Inst;
    static
    {
        Inst = new Page_PAS();
    }
}
