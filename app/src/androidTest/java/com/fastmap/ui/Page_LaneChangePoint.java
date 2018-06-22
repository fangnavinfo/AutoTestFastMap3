package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * Created by h on 2018/5/30.
 */

public class Page_LaneChangePoint extends Page_Base_Tips
{
    @FindResource(Id="et_entry_lane_num")
    public static String ENTRYNUM;

    @FindResource(Id="et_back_lane_num")
    public static String BACKNUM;

    @FindResource(Id="et_remark_txt")
    public static String REMARK;

    @FindResource(Id="lane_number_one")
    public static String NUM1;

    @FindResource(Id="lane_number_tow")
    public static String NUM2;

    @FindResource(Id="lane_number_three")
    public static String NUM3;

    @FindResource(Id="lane_number_four")
    public static String NUM4;

    @FindResource(Id="lane_number_five")
    public static String NUM5;

    @FindResource(Id="lane_number_six")
    public static String NUM6;

    @FindResource(Id="lane_number_seven")
    public static String NUM7;

    @FindResource(Id="et_left_change_num")
    public static String LEFTCHANGE;

    @FindResource(Id="et_right_change_num")
    public static String RIGHTHANGE;

    public static Page_LaneChangePoint Inst;
    static
    {
        Inst = new Page_LaneChangePoint();
    }
}
