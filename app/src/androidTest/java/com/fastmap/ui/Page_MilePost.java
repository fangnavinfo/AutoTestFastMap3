package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 *  里程桩
 * Created by h on 2018/1/22.
 */

public class Page_MilePost extends Page_Base_Tips
{
    @FindResource(Id="et_milepost_road_name", ios_xpath="//XCUIElementTypeTextView[@name=\"mileage_nameTF\"]")
    public static String NAME;

    @FindResource(Id="image_button_add_one", ios_xpath="//XCUIElementTypeButton[@name=\"mileage_minusBtn\"]")
    public static String INC;

    @FindResource(Id="image_button_decrease_one", ios_xpath="//XCUIElementTypeButton[@name=\"mileage_addBtn\"]")
    public static String DEC;

    @FindResource(Id="milepost_rb", ios_xpath="//XCUIElementTypeButton[@name=\"gridView_mileagePile.png\"]")
    public static String MILEPOST;

    @FindResource(Id="et_milepost_number", ios_xpath="//XCUIElementTypeTextField[@name=\"mileage_markTF\"]")
    public static String MILE_NO;

    @FindResource(Id="mileage_tv_milepost_mile_number", ios_xpath="//XCUIElementTypeTextField[@name=\"mileage_numTF\"]" )
    public static String MILE_EDIT;

    @FindResource(Id="tv_virtualKeyboard_0", ios_xpath="//XCUIElementTypeButton[@name=\"numberPad_0\"]")
    public static String ZERO;
    
    @FindResource(Id="tv_virtualKeyboard_5", ios_xpath="//XCUIElementTypeButton[@name=\"numberPad_5\"]")
    public static String FIVE;

    public static Page_MilePost Inst;
    static
    {
        Inst = new Page_MilePost();
    }
}
