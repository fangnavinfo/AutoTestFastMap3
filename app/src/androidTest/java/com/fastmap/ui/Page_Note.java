package com.fastmap.ui;

import com.fang.testAdapter.FastMapPage;
import com.fang.testAdapter.FindResource;

/**
 * Created by h on 2018/3/19.
 */

public class Page_Note extends FastMapPage{
    @FindResource(Id="save_button")
    public static String SAVE;

    @FindResource(Id="cancel_button")
    public static String CANCEL;

    @FindResource(Id="sketch_eraser")
    public static String ERASER;

    @FindResource(Id="sketch_back")
    public static String BACK;

    @FindResource(Id="sketch_forward")
    public static String FORWARD;

    @FindResource(Id="sketch_clear")
    public static String CLEAR;

    @FindResource(Id="et_remark_txt")
    public static String TXT;

    public static Page_Note Inst;
    static
    {
        Inst = new Page_Note();
    }
}
