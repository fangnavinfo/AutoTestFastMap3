package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by zhou on 18/1/19.
 * 匝道
 */

public class Page_Ramp extends Page_Base_Tips
{
    @FindResource(Id="btn_ramp", Text="匝道", ios_xpath="//XCUIElementTypeOther[@name=\"匝道\"]")
    public static String RAMP;
    @FindResource(Id="btn_not_ramp", Text="非匝道")
    public static String NOT_RAMP;

    public static Page_Ramp Inst;
    static
    {
        Inst = new Page_Ramp();
    }
}
