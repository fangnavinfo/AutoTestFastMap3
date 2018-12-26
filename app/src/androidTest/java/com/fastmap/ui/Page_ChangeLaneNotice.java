package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * Created by zhou on 18/12/26.
 * 变道提示
 */
public class Page_ChangeLaneNotice extends Page_Base_Tips
{
    @FindResource(Id="change_lane_notice_1")
    public static String LANE_LEFT;
    @FindResource(Id="change_lane_notice_2")
    public static String LANE_CENTER;
    @FindResource(Id="change_lane_notice_3")
    public static String LANE_RIGHT;



    public static Page_ChangeLaneNotice Inst;
    static
    {
        Inst = new Page_ChangeLaneNotice();
    }
}