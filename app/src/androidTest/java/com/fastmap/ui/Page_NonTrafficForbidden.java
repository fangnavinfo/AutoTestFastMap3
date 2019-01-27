package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * Created by zhou on 18/1/24.
 * 非机动车交限TIPS
 */
public class Page_NonTrafficForbidden extends Page_Base_Tips
{

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

    @FindResource(Id="et_traffic_time_txt")
    public static String TIME;
    @FindResource(Id="add_time_button")
    public static String ADD_TIME;

    @FindResource(Id="non_motor_type_0")
    public static String BYCICLE;
    @FindResource(Id="non_motor_type_1")
    public static String TRI_BYCICLE;
    @FindResource(Id="non_motor_type_2")
    public static String ELEC_BYCICLE;
    @FindResource(Id="non_motor_type_3")
    public static String MAN;

    public static Page_NonTrafficForbidden Inst;
    static
    {
        Inst = new Page_NonTrafficForbidden();
    }
}