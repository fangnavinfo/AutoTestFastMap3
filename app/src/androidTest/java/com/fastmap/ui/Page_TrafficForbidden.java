package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by zhou on 18/1/24.
 * 交限TIPS
 */
public class Page_TrafficForbidden extends FastMapPage
{
    @FindResource(Id="traffic_forbidden_no_pull_into", ios_x=539, ios_y=346)
    public static String NO_PULL_INTO;


    @FindResource(Id="save_button", Text="保存")
    public static String SAVE;

    public static Page_TrafficForbidden Inst;
    static
    {
        Inst = new Page_TrafficForbidden();
    }
}