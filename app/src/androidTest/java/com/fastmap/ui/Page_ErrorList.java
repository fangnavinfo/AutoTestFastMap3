package com.fastmap.ui;
import com.fang.testAdapter.*;

/**
 * Created by zhou on 18/1/24.
 * 错误列表
 */

public class Page_ErrorList extends FastMapPage
{
    @FindResource(Id="btn_back")
    public static String BACK;
    @FindResource(Id="rb_error_list")
    public static String ERROR_LIST;
    @FindResource(Id="rb_conflict_list")
    public static String CONFLICT_LIST;
    @FindResource(Text="Tips")
    public static String TIPS;
    @FindResource(Text="Poi")
    public static String POI;
    @FindResource(Id="点门牌")
    public static String PAS;
    @FindResource(Id="情报")
    public static String INFO;
    @FindResource(Id="btn_control_left_layout", Text="错误列表")
    public static String LEFT;

    @FindResource(Id="tv_content", ios_xpath="//XCUIElementTypeApplication[@name=\"FastMap-18夏\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextView")
    public static String ERROR_CONTENT;

    public static Page_ErrorList Inst;
    static
    {
        Inst = new Page_ErrorList();
    }

}
