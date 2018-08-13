package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by fang on 18/4/19.
 */
public class Page_NoParkingTruck extends Page_Base_Tips
{
    @FindResource(Id="no_parking_desc", ios_name="NPHead_descInput")
    public static String DESC;

    @FindResource(Id="no_parking_time_button", ios_name="NPHead_timeBtn")
    public static String TIME;

    @FindResource(Id="all_sections_quick_input")
    public static String ALL_SECTION;

    public static Page_NoParkingTruck Inst;
    static
    {
        Inst = new Page_NoParkingTruck();
    }
}
