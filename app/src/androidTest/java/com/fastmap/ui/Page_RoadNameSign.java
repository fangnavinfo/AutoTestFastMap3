package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by h on 2018/1/29.
 */

public class Page_RoadNameSign extends Page_Base_Tips
{
    @FindResource(Id="card_road_name_sign_name_edit", Text="请输入道路名称")
    public static String NAME;
    
    @FindResource(Id="card_road_name_sign_radio_yes", Text="是")
    public static String IS_POINT;

    @FindResource(Id="card_road_name_sign_radio_no", Text="否")
    public static String NO_POINT;

    @FindResource(Id="ck_move_point",Text = "显示点位")
    public static String MOVEPOINT;

    @FindResource(Id="ck_move_line",Text = "引导点位")
    public static String MOVELINE;

    @FindResource(Id="ck_move_point_or_line",Text = "显示/引导点位")
    public static String MOVEPOINTLINE;

    @FindResource(Id="btn_fm_confirm", Text="确认")
    public static String CONFIRM;

    public static Page_RoadNameSign Inst;
    static
    {
        Inst = new Page_RoadNameSign();
    }
}
