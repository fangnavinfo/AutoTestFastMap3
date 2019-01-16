package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * 人行过道
 * Created by h on 2019/1/16.
 */

public class Page_UndergroundPedestrian extends Page_Base_Tips
{

    @FindResource(Id="btn_pedestrian_corridor_last")
    public static String PRE_STEP;

    @FindResource(Id="btn_pedestrian_corridor_clear")
    public static String REPAINT;

    @FindResource(Id="btn_pedestrian_corridor_finish")
    public static String FINISH;

    @FindResource(Id="rbtn_pedestrian_corridor_zebra")
    public static String ZEBRA_LINE;

    @FindResource(Id="rbtn_pedestrian_corridor_no_crossing")
    public static String NO_CROSSING;

    @FindResource(Id="rbtn_pedestrian_corridor_paralle")
    public static String PARALLE;

    @FindResource(Id="chk_pedestrian_corridor_no_tricycle")
    public static String NO_TRICICYCLE;

    @FindResource(Id="chk_pedestrian_corridor_no_bike")
    public static String NO_BIKE;


    public static Page_UndergroundPedestrian Inst;
    static
    {
        Inst = new Page_UndergroundPedestrian();
    }
}
