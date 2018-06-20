package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * Created by h on 2018/6/7.
 */

public class Page_TruckCondition extends Page_Base_Tips
{
    @FindResource(Id="speed_limit_truck_condition_total_weight")
    public static String TOTALWEIGHT;

    @FindResource(Id="speed_limit_truck_condition_time")
    public static String TIMELIMIT;

    @FindResource(Id="speed_limit_truck_condition_fog")
    public static String FOG;

    public static Page_TruckCondition Inst;
    static
    {
        Inst = new Page_TruckCondition();
    }
}
