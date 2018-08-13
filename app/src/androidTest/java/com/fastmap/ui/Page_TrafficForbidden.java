package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by zhou on 18/1/24.
 * 交限TIPS
 */
public class Page_TrafficForbidden extends Page_Base_Tips
{
    @FindResource(Id="traffic_forbidden_no_pull_into", ios_x=539, ios_y=346)
    public static String NO_PULL_INTO;
    @FindResource(Id="traffic_forbidden_icon_a2")
    public static String ICON_A2;//禁止左转
    @FindResource(Id="traffic_forbidden_icon_b4")
    public static String ICON_B4;//禁止掉头
    @FindResource(Id="traffic_forbidden_icon_a5")
    public static String ICON_A5;//禁止左转
    @FindResource(Id="traffic_forbidden_icon_a6")
    public static String ICON_A6;//禁止掉头
    @FindResource(Id="add_time_button")
    public static String TIME_BUTTON;

    public static Page_TrafficForbidden Inst;
    static
    {
        Inst = new Page_TrafficForbidden();
    }
}