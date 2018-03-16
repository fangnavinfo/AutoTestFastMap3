package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * 收费站
 * Created by fang on 18/3/13.
 */

public class Page_TollGate extends FastMapPage
{
    @FindResource(Id="save_button", Text="保存")
    public static String SAVE;

    public static Page_TollGate Inst;
    static
    {
        Inst = new Page_TollGate();
    }
}
