package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * Created by zhou on 18/3/14.
 * 功能面
 */

public class Page_FunctionalArea extends Page_Base_Tips
{
    @FindResource(clazz="android.widget.ScrollView")
    public static String SCROLL;

    @FindResource(Id="btn_last_step", Text="上一步")
    public static String LAST_STEP;
    @FindResource(Id="btn_repaint", Text="重绘")
    public static String REPAINT;
    @FindResource(Id="btn_complete", Text="完成")
    public static String COMPLETE;

    @FindResource(Id="rbtn_university", ios_name="gridView_function_university.png")
    public static String UNIVERSITY;
    @FindResource(Id="rbtn_shopping", ios_name="gridView_function_shopping.png")
    public static String SHOPPING;
    @FindResource(Id="rbtn_hospital", ios_name="gridView_function_hospital.png")
    public static String HOSPITAL;
    @FindResource(Id="rbtn_stadium", ios_name="gridView_function_stadium.png")
    public static String STADIUM;
    @FindResource(Id="rbtn_airport", ios_name="gridView_function_airport.png")
    public static String AIRPORT;
    @FindResource(Id="rbtn_hotel")
    public static String HOTEL;
    @FindResource(Id="rbtn_logistics_park")
    public static String PARK;

    @FindResource(Id="edit_name", Text="请输入名称")
    public static String NAME;
    @FindResource(clazz="android.widget.TextView", Text="名称")
    public static String NAME_STATIC;
    @FindResource(Id="tv_complete")
    public static String MODIFY_SAVE;
    @FindResource(Id="btn_functional_surface_height_poi_relatePoi")
    public static String RELATIEPOI;
    @FindResource(Id="fmdialog_tv_title")
    public static String TITLE;
    @FindResource(Id="fmdialog_tv_text")
    public static String TEXT;
    @FindResource(Id="fmdialog_tv_snap_point_add")
    public static String REBUILDREL;
    @FindResource(Id="fmdialog_tv_copy_info_add")
    public static String DELELEREL;
    @FindResource(Id="fmdialog_tv_ignore_add")
    public static String CANCLEADDREL;
    @FindResource(Id="tv_title")
    public static String TVTITLE;
    @FindResource(Id="tv_snap_check_list_done")
    public static String LIST_SAVE;
    @FindResource(Id="tv_marquee_frame_complete")
    public static String FRAME_COMPLETE;
    @FindResource(Id="cb_snap_check_list_item")
    public static String LIST_ITEM;
    @FindResource(Id="tv_poi_father")
    public static String POI_FATHER;
    public static Page_FunctionalArea Inst;
    static
    {
        Inst = new Page_FunctionalArea();
    }
}
