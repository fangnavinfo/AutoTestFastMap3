package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by h on 2018/1/22.
 */

public class Page_Dangerous extends FastMapPage
{
    @FindResource(Id="dangerous_information_icon_a1", ios_xpath = "//XCUIElementTypeButton[@name=\"1105 10201 0\"]")
    public static String ICON_1;

    @FindResource(Id="cancel_button", Text = "取消")
    public static String CANCEL;

    @FindResource(Id="save_button", Text = "保存")
    public static String SAVE;

    public static Page_Dangerous Inst;
    static
    {
        Inst = new Page_Dangerous();
    }
}
