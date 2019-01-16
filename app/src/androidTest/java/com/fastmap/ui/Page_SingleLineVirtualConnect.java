package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * 单线虚拟连接
 * Created by h on 2019/1/16.
 */

public class Page_SingleLineVirtualConnect extends Page_Base_Tips
{

    @FindResource(Id="ck_straight_ladder")
    public static String STRAIGHT_LADDER;

    @FindResource(Id="ck_escalator")
    public static String ESCALATER;

    @FindResource(Id="ck_ladder")
    public static String LADDER;

    @FindResource(Id="ck_slope")
    public static String SLOPE;

    @FindResource(Id="ck_either_direction")
    public static String EITHER_DIRECTION;

    @FindResource(Id="ck_direct_motion")
    public static String DIRECT_MOTION;

    @FindResource(Id="ck_retrograde_motion")
    public static String RETROGTADE_MOTION;

    @FindResource(Id="ck_impassable")
    public static String IMPASSABLE;



    public static Page_SingleLineVirtualConnect Inst;
    static
    {
        Inst = new Page_SingleLineVirtualConnect();
    }
}
