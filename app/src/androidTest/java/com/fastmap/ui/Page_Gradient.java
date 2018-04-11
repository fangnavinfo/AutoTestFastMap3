package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * Created by h on 2018/4/11.
 */

public class Page_Gradient extends Page_Base_Tips
{
    @FindResource(Id="et_remark_txt")
    public static String EDIT;//备注

    public static Page_Gradient Inst;
    static
    {
        Inst = new Page_Gradient();
    }
}
