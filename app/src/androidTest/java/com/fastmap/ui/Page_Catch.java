package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by fang on 18/3/1.
 */

public class Page_Catch extends FastMapPage
{
    @FindResource(Id="fmdialog_tv_ignore_add")
    public static String IGNORE;

    public static Page_Catch Inst;
    static
    {
        Inst = new Page_Catch();
    }
}