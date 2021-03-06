package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by zhou on 18/1/24.
 * GRID管理
 */
public class Page_GridManager extends FastMapPage
{
    @FindResource(Id="rb_poi_update", ios_name="POI数据")
    public static String POI_UPDATE;
    @FindResource(Id="rb_tips_update", ios_name="Tips数据")
    public static String TIPS_UPDATE;
    @FindResource(Id="rb_pas_update", ios_name="点门牌数据")
    public static String PAS_UPDATE;
    @FindResource(Id="rb_integrate_update")
    public static String INTEGRATE_UPDATE;
    @FindResource(Id="rb_info_update", ios_name="情报数据")
    public static String INFO_UPDATE;
    @FindResource(Id="synchronous_button", ios_name="同步数据")
    public static String SYNCHRONOUS_BUTTON;

    @FindResource(Id="grid_project_button", ios_x=700, ios_y=349)
    public static String PROJECT_BUTTON;


    @FindResource(Id="back", ios_name="blue arrow")
    public static String BACK;
    @FindResource(Id="btn_fm_confirm", ios_name="确定")
    public static String NO_TASK_CONFIRM;
    @FindResource(Id="btn_fm_confirm", ios_name="同步")
    public static String STATIS_CONFIRM;
    @FindResource(Id="btn_fm_confirm", ios_name="取消")
    public static String UPDATA_RSLT_CONFIRM;
    @FindResource(Id="btn_fm_cancel")
    public static String CANCEL;
    @FindResource(Id="grid_sync_btn_positive", ios_name="确认")
    public static String GRID_SYNC_BTN_POSITIVE;
    @FindResource(Id="grid_project_name")
    public static String GRID_PRO_NAME;
    @FindResource(Id="grid_project_sync_button")
    public static String GRID_PRO_SYNC;
    @FindResource(Id="grid_project_down_button")
    public static String GRID_PRO_DOWN;
    @FindResource(Id="grid_project_sync_satellite")
    public static String GRID_PRO_SATELLITE;
    @FindResource(Id="dialog_unit_info_id_edit")
    public static String INFO_ID;
    @FindResource(Id="btn_fm_cancel")
    public static String OK;
    @FindResource(Id="tv_data_count")
    public static String SHOWDATA;
    public static Page_GridManager Inst;
    static
    {
        Inst = new Page_GridManager();
    }
}