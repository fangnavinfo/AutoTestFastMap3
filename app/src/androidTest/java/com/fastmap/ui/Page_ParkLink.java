package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by zhou on 18/1/19.
 * 停车场出入口
 */

public class Page_ParkLink extends Page_Base_Tips
{
    @FindResource(Id="btn_park_on", Text="地面大型")
    public static String PARK_ON;
    @FindResource(Id="btn_park_down", Text="地下或地面小型")
    public static String PARK_DOWN;

    public static Page_ParkLink Inst;
    static
    {
        Inst = new Page_ParkLink();
    }
}
