package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * Created by h on 2018/5/29.
 */

public class Page_TruckLimitLane extends Page_Base_Tips
{
    @FindResource(Id="speed_limit_number_40")
    public static String NUM40;

    @FindResource(Id="et_speed_limit_desc")
    public static String EDIT;

    public static Page_TruckLimitLane Inst;
    static
    {
        Inst = new Page_TruckLimitLane();
    }
}
