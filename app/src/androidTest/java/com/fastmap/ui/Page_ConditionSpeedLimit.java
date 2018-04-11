package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * Created by h on 2018/4/11.
 */

public class Page_ConditionSpeedLimit extends Page_Base_Tips
{
    @FindResource(Id="speed_limit_condition_school")
    public static String SCHOOL;

    @FindResource(Id="btn_select_time3")
    public static String TIME;

    @FindResource(Id="et_remark_txt")
    public static String EDIT;
    public static Page_ConditionSpeedLimit Inst;
    static
    {
        Inst = new Page_ConditionSpeedLimit();
    }
}
