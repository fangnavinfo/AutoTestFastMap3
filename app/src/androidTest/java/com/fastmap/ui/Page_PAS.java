package com.fastmap.ui;

import com.fang.testAdapter.*;


/**
 * Created by fang on 18/1/22.
 */
public class Page_PAS extends Page_Base_Tips
{
    @FindResource(Id="fm_et_name_pas", ios_name="pas_TFName")
    public static String NAME;

    @FindResource(Id="fm_et_address_pas", ios_name="pas_TFNumber")
    public static String ADDRESS;

    @FindResource(Id="ck_odd", ios_name="奇")
    public static String ODD; //奇

    @FindResource(Id="ck_road", ios_name="路")
    public static String ROAD_TYPE;

    @FindResource(Id="fm_rb_building_house", ios_name="楼栋门牌")
    public static String BUILDING_PAS;
    @FindResource(Id="fm_rb_door_card", ios_name="楼门门牌")
    public static String DOOR_PAS;
    @FindResource(Id="fm_rb_address_card", ios_name="地址门牌")
    public static String ADDRESS_PAS;

    // 框选点门牌按钮
    @FindResource(Id="tv_marquee_frame_repaint", ios_name="last pen")
    public static String RE_PAINT;
    @FindResource(Id="tv_marquee_frame_last_paint", ios_name="redraw")
    public static String LAST_PAINT;
    @FindResource(Id="tv_marquee_frame_complete", ios_name="complec")
    public static String COMPLETE;

    @FindResource(Id="move_points", ios_name="box move")
    public static String MOVE_POINTS;
    @FindResource(Id="auto_link", ios_name="box auto")
    public static String AUTO_LINK;
    @FindResource(Id="tv_pas_father")
    public static String PAS_FATHER;
    @FindResource(Id="tv_poi_fid_hd")
    public static String FID;
    public static Page_PAS Inst;
    static
    {
        Inst = new Page_PAS();
    }
}
