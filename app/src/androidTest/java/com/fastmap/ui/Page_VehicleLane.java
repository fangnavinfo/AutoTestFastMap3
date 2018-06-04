package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * Created by h on 2018/5/30.
 */

public class Page_VehicleLane extends Page_Base_Tips
{
    @FindResource(clazz="android.widget.TextView")
    public static String LIMIT_EDIT;

    @FindResource(Id="tv_virtualKeyboard_6")
    public static String NUM6;

    @FindResource(Id="tv_virtualKeyboard_7")
    public static String NUM7;

    public static Page_VehicleLane Inst;
    static
    {
        Inst = new Page_VehicleLane();
    }
}
