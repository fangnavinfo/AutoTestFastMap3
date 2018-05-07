package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by fang on 18/4/19.
 */
public class Page_NoParkingTruck extends Page_Base_Tips
{
    @FindResource(Id="no_parking_desc", ios_name="NPHead_descInput")
    public static String DESC;

    public static Page_NoParkingTruck Inst;
    static
    {
        Inst = new Page_NoParkingTruck();
    }
}
