package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * Created by h on 2018/4/13.
 * 禁停
 */

public class Page_NoParking extends Page_Base_Tips
{
    @FindResource(Id="no_parking_time_button", ios_name="openTime")
    public static String TIME;

    @FindResource(Id="no_parking_desc", ios_xpath="//XCUIElementTypeApplication[@name=\"FastMap-18秋\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[4]/XCUIElementTypeTextView")
    public static String DESC;

    @FindResource(Id="elec_eye_adapter_checkbox", ios_name="login checkbox")
    public static String CHECKBOX;

    @FindResource(Id="btn_fm_confirm")
    public static String DELETE_CONFIRM;

    @FindResource(Id="no_parking_virt_yes", ios_name="是")
    public static String IS_VIRTUAL;
    
    @FindResource(Id="no_parking_virt_no", ios_name="否")
    public static String NOT_VIRTUAL;
    
    public static Page_NoParking Inst;
    static
    {
        Inst = new Page_NoParking();
    }
}
