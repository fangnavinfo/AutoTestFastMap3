package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * Created by h on 2018/4/11.
 */

public class Page_ConditionSpeedLimit extends Page_Base_Tips
{
    @FindResource(Id="speed_limit_condition_school", ios_name="学校")
    public static String SCHOOL;

    @FindResource(Id="btn_select_time3", ios_xpath="(//XCUIElementTypeButton[@name=\"clock\"])[1]")
    public static String TIME;

    @FindResource(clazz="android.widget.ScrollView")
    public static String SCROLL;

    public static Page_ConditionSpeedLimit Inst;
    static
    {
        Inst = new Page_ConditionSpeedLimit();
    }
}
