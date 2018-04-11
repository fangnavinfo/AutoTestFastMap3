package com.fastmap.ui;

import com.fang.testAdapter.*;

public class Page_LaneNumber extends Page_Base_Tips 
{
    @FindResource(Id="lane_num_1", ios_name="gridView_lane_num_1.png")
    public static String NUM1;
    
    public static Page_LaneNumber Inst;
    static
    {
        Inst = new Page_LaneNumber();
    }

}
