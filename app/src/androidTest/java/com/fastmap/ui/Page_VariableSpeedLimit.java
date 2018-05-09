package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * Created by h on 2018/5/9.
 */

public class Page_VariableSpeedLimit extends Page_Base_Tips
{
    @FindResource(Id="et_remark_txt")
    public static String REMARK;

    public static Page_VariableSpeedLimit Inst;
    static
    {
        Inst = new Page_VariableSpeedLimit();
    }
}
