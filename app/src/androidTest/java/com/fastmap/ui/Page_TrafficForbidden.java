package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by zhou on 18/1/24.
 * 交限TIPS
 */
public class Page_TrafficForbidden extends Page_Base_Tips
{
    @FindResource(Id="traffic_forbidden_no_pull_into", ios_x=539, ios_y=346)
    public static String NO_PULL_INTO;

    public static Page_TrafficForbidden Inst;
    static
    {
        Inst = new Page_TrafficForbidden();
    }
}