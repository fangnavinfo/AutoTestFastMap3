package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * 收费站
 * Created by fang on 18/3/13.
 */

public class Page_TollGate extends Page_Base_Tips
{
    @FindResource(Id="tollgate_name_edit")
    public static String EDIT;

    public static Page_TollGate Inst;
    static
    {
        Inst = new Page_TollGate();
    }
}
