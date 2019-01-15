package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * 打点
 * Created by fang on 18/3/1.
 */

public class Page_AddPoint extends Page_Base_Tips
{
    @FindResource(Id="obstruction_rb", ios_name="gridView_obstacle.png")
    public static String OBST; //障碍物

    @FindResource(Id="ck_vehicle")
    public static String VEHICLE; //机动车

    @FindResource(Id="ck_manpower_bicycle")
    public static String MANPOWER_BICYCLE; //人力自行车

    @FindResource(Id="ck_tricycle")
    public static String TRICYCLE; //三轮车

    @FindResource(Id="ck_electricBicycle")
    public static String ELECTRIC_BICYCLE; //电动自行车

    @FindResource(Id="ck_pedestrian")
    public static String PEDESTRIAN; //行人

    public static Page_AddPoint Inst;
    static
    {
        Inst = new Page_AddPoint();
    }
}
