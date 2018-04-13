package com.fastmap.ui;

import com.fang.testAdapter.FastMapPage;
import com.fang.testAdapter.FindResource;

/**
 * Created by h on 2018/3/19.
 */

public class Page_Note extends Page_Base_Tips
{
    @FindResource(Id="sketch_eraser", ios_name = "eraser eraser")
    public static String ERASER;

    @FindResource(Id="sketch_back", ios_name = "gridView_revoke.png")
    public static String BACK;

    @FindResource(Id="sketch_forward", ios_name = "gridView_next.png")
    public static String FORWARD;

    @FindResource(Id="sketch_clear", ios_name = "gridView_(null).png")
    public static String CLEAR;

    public static Page_Note Inst;
    static
    {
        Inst = new Page_Note();
    }
}
