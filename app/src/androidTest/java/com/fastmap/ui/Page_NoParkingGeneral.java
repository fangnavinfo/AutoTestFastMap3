package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by fang on 18/4/19.
 */
public class Page_NoParkingGeneral extends Page_Base_Tips
{
    @FindResource(Id="no_parking_desc")
    public static String DESC;

    public static Page_NoParkingGeneral Inst;
    static
    {
        Inst = new Page_NoParkingGeneral();
    }
}
