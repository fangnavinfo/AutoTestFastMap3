package com.fastmap.ui;

import com.fang.testAdapter.*;

public class Page_LaneNumber extends FastMapPage 
{
    @FindResource(Id="lane_num_1", ios_xpath="//XCUIElementTypeButton[@name=\"lane num 1\"]")
    public static String NUM1;
    
    public static Page_LaneNumber Inst;
    static
    {
        Inst = new Page_LaneNumber();
    }

}
