package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 *  里程桩
 * Created by h on 2018/1/22.
 */

public class Page_MilePost extends FastMapPage
{
    @FindResource(Id="et_milepost_road_name", ios_xpath="//XCUIElementTypeApplication[@name=\"FastMap-18秋\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeTextView")
    public static String NAME;

    @FindResource(Id="tv_virtualKeyboard_0", Text="0")
    public static String ZERO;

    @FindResource(Id="save_button" ,Text = "保存")
    public static String SAVE;

    @FindResource(Id="image_button_add_one", ios_xpath="//XCUIElementTypeButton[@name=\"plus blue\"]")
    public static String INC;

    @FindResource(Id="image_button_decrease_one", ios_xpath="//XCUIElementTypeButton[@name=\"minus blue\"]")
    public static String DEC;

    @FindResource(Id="milepost_rb", ios_xpath="//XCUIElementTypeButton[@name=\"mileagePile\"]")
    public static String MILEPOST;

    @FindResource(Id="et_milepost_number", ios_xpath="//XCUIElementTypeApplication[@name=\"FastMap-18秋\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeTextField")
    public static String MILE_NO;

    @FindResource(Id="mileage_tv_milepost_mile_number", ios_xpath="//XCUIElementTypeApplication[@name=\"FastMap-18秋\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeTextField" )
    public static String MILE_EDIT;

    @FindResource(Id="tv_virtualKeyboard_5", Text="5")
    public static String FIVE;

    @FindResource(Id="tv_milepost_road_name_one")
    public static String ROADNAME;

    public static Page_MilePost Inst;
    static
    {
        Inst = new Page_MilePost();
    }
}
