package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * Created by h on 2018/8/7.
 */

public class Page_HighSpeedDivider extends Page_Base_Tips
{
    @FindResource(Id="tv_hint", ios_name="其他模式图")
    public static String TV_HINT;

    @FindResource(Id="extraLane_L")
    public static String EXTRLANE_L;
    @FindResource(Id="extraLane_R")
    public static String EXTRALANE_R;
    @FindResource(Id="crossLane_L")
    public static String CROSSLANE_L;
    @FindResource(Id="crossLane_M")
    public static String CROSSLANE_M;
    @FindResource(Id="crossLane_R")
    public static String CROSSLANE_R;
    @FindResource(Id="generateCode")
    public static String GERNERATECODE;
    @FindResource(Id="et_img_number")
    public static String IMAG_NUM;
    @FindResource(Id="delete_iv_card")
    public static String DELETE_CARD;
    @FindResource(Id="high_speed_divider_road_name")
    public static String ROAD_NAME;
    @FindResource(Id="high_speed_divider_road_num")
    public static String ROAD_NUM;
    public static Page_HighSpeedDivider Inst;
    static
    {
        Inst = new Page_HighSpeedDivider();
    }
}
