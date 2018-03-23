package com.fastmap.ui;

import com.fang.testAdapter.FastMapPage;
import com.fang.testAdapter.FindResource;

/**
 * Created by h on 2018/3/19.
 */

public class Page_Note extends FastMapPage
{
    @FindResource(Id="save_button", Text="保存")
    public static String SAVE;

    @FindResource(Id="cancel_button", Text="取消")
    public static String CANCEL;

    @FindResource(Id="sketch_eraser", ios_xpath = "//XCUIElementTypeButton[@name=\"eraser eraser\"]")
    public static String ERASER;

    @FindResource(Id="sketch_back", ios_xpath = "//XCUIElementTypeButton[@name=\"revoke\"]")
    public static String BACK;

    @FindResource(Id="sketch_forward", ios_xpath = "//XCUIElementTypeButton[@name=\"next\"]")
    public static String FORWARD;

    @FindResource(Id="sketch_clear", Text = "重绘")
    public static String CLEAR;

    @FindResource(Id="et_remark_txt", ios_xpath = "//XCUIElementTypeApplication[@name=\"FastMap-18秋\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeTextView")
    public static String TXT;

    public static Page_Note Inst;
    static
    {
        Inst = new Page_Note();
    }
}
