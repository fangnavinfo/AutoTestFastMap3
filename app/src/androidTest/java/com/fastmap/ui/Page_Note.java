package com.fastmap.ui;

import com.fang.testAdapter.FastMapPage;
import com.fang.testAdapter.FindResource;

/**
 * Created by h on 2018/3/19.
 */

public class Page_Note extends Page_Base_Tips
{
    @FindResource(Id="sketch_eraser", ios_xpath = "//XCUIElementTypeButton[@name=\"eraser eraser\"]")
    public static String ERASER;

    @FindResource(Id="sketch_back", ios_xpath = "//XCUIElementTypeButton[@name=\"gridView_revoke.png\"]")
    public static String BACK;

    @FindResource(Id="sketch_forward", ios_xpath = "//XCUIElementTypeButton[@name=\"gridView_next.png\"]")
    public static String FORWARD;

    @FindResource(Id="sketch_clear", Text = "重绘")
    public static String CLEAR;

    @FindResource(Id="et_remark_txt", ios_xpath = "//XCUIElementTypeTextView[@name=\"page_multiTextCard\"]")
    public static String TXT;

    public static Page_Note Inst;
    static
    {
        Inst = new Page_Note();
    }
}
