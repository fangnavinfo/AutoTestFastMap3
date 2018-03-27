package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by h on 2018/1/29.
 */

public class Page_RoadNameSign extends FastMapPage
{
    @FindResource(Id="card_road_name_sign_name_edit", Text="请输入道路名称")
    public static String NAME;

    @FindResource(Id="save_button", Text = "保存")
    public static String SAVE;

    @FindResource(Id="cancel_button", Text="取消")
    public static String CANCEL;

    @FindResource(Id="card_road_name_sign_radio_yes", Text="是")
    public static String IS_POINT;

    @FindResource(Id="card_road_name_sign_radio_no", Text="否")
    public static String NO_POINT;
    
    @FindResource(Id="camera_button", ios_xpath="//XCUIElementTypeButton[@name=\"photo icon\"]")
    public static String CAMERA;

    @FindResource(Id="ck_move_point",Text = "显示点位")
    public static String MOVEPOINT;

    @FindResource(Id="ck_move_line",Text = "引导点位")
    public static String MOVELINE;

    @FindResource(Id="ck_move_point_or_line",Text = "显示/引导点位")
    public static String MOVEPOINTLINE;

    @FindResource(Id="delete_button", Text="删除")
    public static String DELETE;

    @FindResource(Id="btn_fm_confirm", Text="确认")
    public static String CONFIRM;

    @FindResource(Id="et_title", ios_predicate="value MATCHES '^[0-9a-fA-F]{10,}$'")
    public static String ROWKEY;
    public static Page_RoadNameSign Inst;
    static
    {
        Inst = new Page_RoadNameSign();
    }
}
