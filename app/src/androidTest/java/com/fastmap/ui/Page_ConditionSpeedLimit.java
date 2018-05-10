package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * Created by h on 2018/4/11.
 */

public class Page_ConditionSpeedLimit extends Page_Base_Tips
{
    @FindResource(Id="speed_limit_condition_school", ios_name="学校")
    public static String SCHOOL;

    @FindResource(Id="btn_select_time3", ios_name="conditionSL_clock1")
    public static String TIME;

    @FindResource(Id="et_speed_limit_number")
    public static String LIMIT_NUM;

    @FindResource(clazz="android.widget.ScrollView")
    public static String SCROLL;

    @FindResource(Id="speed_limit_condition_snow", ios_name="雪")
    public static String SNOW;

    @FindResource(Id="speed_limit_condition_fog", ios_name="雾")
    public static String FOG;

    public static Page_ConditionSpeedLimit Inst;
    static
    {
        Inst = new Page_ConditionSpeedLimit();
    }
}
