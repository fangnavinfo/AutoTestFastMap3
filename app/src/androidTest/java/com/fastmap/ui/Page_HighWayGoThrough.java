package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * 地下通道/过街天桥
 * Created by h on 2019/1/16.
 */

public class Page_HighWayGoThrough extends Page_Base_Tips
{

    @FindResource(Id="tv_highway_line_button")
    public static String CHOOSE_END;


    @FindResource(Id="no_pedestrian_crossing")
    public static String NO_PED_CROSSING;

    @FindResource(Id="no_bicycle_crossing")
    public static String NO_BICYCLE_CROSSING;

    @FindResource(Id="no_tricycle_crossing")
    public static String NO_TRICYCLE_CROSSING;

    @FindResource(Id="no_electric_bicycle_crossing")
    public static String NO_ELEC_BICYCLE_CROSSING;

    public static Page_HighWayGoThrough Inst;
    static
    {
        Inst = new Page_HighWayGoThrough();
    }
}
