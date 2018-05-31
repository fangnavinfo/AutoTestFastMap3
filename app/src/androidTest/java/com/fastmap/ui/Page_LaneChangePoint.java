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

    @FindResource(Id="lane_number_six")
    public static String NUM6;

    @FindResource(Id="lane_number_seven")
    public static String NUM7;
    public static Page_LaneChangePoint Inst;
    static
    {
        Inst = new Page_LaneChangePoint();
    }
}
