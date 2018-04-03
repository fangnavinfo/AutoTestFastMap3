package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by h on 2018/1/22.
 */

public class Page_Dangerous extends Page_Base_Tips
{
    @FindResource(Id="dangerous_information_icon_a1", ios_xpath = "//XCUIElementTypeButton[@name=\"gridView_1105_10201_0\"]")
    public static String ICON_1;

    @FindResource(Id="dangerous_information_icon_a1", ios_xpath = "//XCUIElementTypeButton[@name=\"gridView_1105_10201_0\"]")
    public static String ICON_2;

    @FindResource(Id="dangerous_information_history_a1")
    public static String HISTORY1;

    @FindResource(Id="dangerous_information_delete_view_button_stop")
    public static String ICONDEL;

    @FindResource(Id="dangerous_info_effective_distance")
    public static String EFFECTIVEDIS;

    @FindResource(Id="dangerous_info_warning_distance")
    public static String WARNINGDIS;

    @FindResource(Id="danger_card_desc")
    public static String DESC;

    @FindResource(Id="dangerous_information_icon_stop")
    public static String ICONSTOP;

    @FindResource(Id="stop_satellite_information_button")
    public static String SHOWINFO;
    public static Page_Dangerous Inst;
    static
    {
        Inst = new Page_Dangerous();
    }
}
