package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by h on 2018/1/22.
 */

public class Page_Dangerous extends Page_Base_Tips
{
    @FindResource(Id="dangerous_information_icon_a1", ios_name="gridView_1105_10201_0")
    public static String ICON_1;

    @FindResource(Id="dangerous_information_icon_a2", ios_name="gridView_1105_10202_0")
    public static String ICON_2;

    @FindResource(Id="dangerous_information_history_a1", ios_x=789, ios_y=195)
    public static String HISTORY1;

    @FindResource(Id="dangerous_information_delete_view_button_stop", ios_name="close blue 1")
    public static String ICONDEL;

    @FindResource(Id="dangerous_info_effective_distance", ios_name="dangerinfo_effectTF")
    public static String EFFECTIVEDIS;

    @FindResource(Id="dangerous_info_warning_distance", ios_name="dangerinfo_advanceTF")
    public static String WARNINGDIS;

    @FindResource(Id="danger_card_desc", ios_name="dangerinfo_descTF")
    public static String DESC;

    @FindResource(Id="dangerous_information_icon_stop", ios_x = 784, ios_y = 133)
    public static String ICONSTOP;

    @FindResource(Id="stop_satellite_information_button", ios_name="展开附属信息")
    public static String SHOWINFO;

    @FindResource(Id="dangerous_information_icon_a43", ios_name="gridView_1105_14401_0")
    public static String CONFLUENCE_LEFT;

    @FindResource(Id="dangerous_information_icon_a44", ios_name="gridView_1105_14402_0")
    public static String CONFLUENCE_RIGHT;

    public static Page_Dangerous Inst;
    static
    {
        Inst = new Page_Dangerous();
    }
}
