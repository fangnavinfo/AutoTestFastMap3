package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by h on 2018/3/21.
 */

public class Page_SpeedLimitLane extends Page_Base_Tips
{
    @FindResource(Id="seek_view_container")
    public static String CTROL;

    @FindResource(Id="speed_limit_number_90")
    public static String NUM90;

    @FindResource(Id="speed_limit_number_110")
    public static String NUM110;

    @FindResource(Id="card_speed_limit_type_driveway")
    public static String ROADLIMIT;

    @FindResource(Id="speed_limit_type_point")
    public static String POINTLIMIT;
    @FindResource(Id="et_speed_limit_number")
    public static String MAXNUM;
    @FindResource(Id="speed_limit_number_40")
    public static String NUM40;
    @FindResource(Id="et_speed_limit_number_min")
    public static String MINNUM;
    @FindResource(Id="speed_limit_number_30")
    public static String NUM30;

    @FindResource(clazz="android.widget.TextView")
    public static String LIMIT_EDIT;

    public static Page_SpeedLimitLane Inst;
    static
    {
        Inst = new Page_SpeedLimitLane();
    }
}
