package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by h on 2018/1/22.
 */

public class Page_Dangerous extends Page_Base_Tips
{
    @FindResource(Id="dangerous_information_icon_a1", ios_xpath = "//XCUIElementTypeButton[@name=\"gridView_1105_10201_0\"]")
    public static String ICON_1;

    public static Page_Dangerous Inst;
    static
    {
        Inst = new Page_Dangerous();
    }
}
