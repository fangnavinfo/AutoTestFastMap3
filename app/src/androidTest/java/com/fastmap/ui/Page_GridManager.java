package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by zhou on 18/1/24.
 * GRID管理
 */
public class Page_GridManager extends FastMapPage
{
    @FindResource(Id="rb_poi_update", ios_xpath="//XCUIElementTypeButton[@name=\"POI数据\"]")
    public static String POI_UPDATE;
    @FindResource(Id="rb_tips_update", ios_xpath="//XCUIElementTypeButton[@name=\"Tips数据\"]")
    public static String TIPS_UPDATE;
    @FindResource(Id="rb_integrate_update")
    public static String INTEGRATE_UPDATE;
    @FindResource(Id="rb_info_update", ios_xpath="//XCUIElementTypeButton[@name=\"情报数据\"]")
    public static String INFO_UPDATE;
    @FindResource(Id="synchronous_button", ios_xpath="//XCUIElementTypeButton[@name=\"同步数据\"]")
    public static String SYNCHRONOUS_BUTTON;

    @FindResource(Id="grid_project_button", ios_xpath="//XCUIElementTypeStaticText[@name=\"任 务 列 表\"]")
    public static String PROJECT_BUTTON;


    @FindResource(Id="back", ios_xpath="//XCUIElementTypeButton[@name=\"blue arrow\"]")
    public static String BACK;
    @FindResource(Id="btn_fm_confirm", ios_xpath="//XCUIElementTypeButton[@name=\"确定\"]")
    public static String NO_TASK_CONFIRM;
    @FindResource(Id="btn_fm_confirm", ios_xpath="//XCUIElementTypeButton[@name=\"同步\"]")
    public static String STATIS_CONFIRM;
    @FindResource(Id="btn_fm_confirm", ios_xpath="//XCUIElementTypeButton[@name=\"取消\"]")
    public static String UPDATA_RSLT_CONFIRM;
    @FindResource(Id="btn_fm_cancel")
    public static String CANCEL;
    @FindResource(Id="grid_sync_btn_positive", ios_xpath="//XCUIElementTypeButton[@name=\"确认\"]")
    public static String GRID_SYNC_BTN_POSITIVE;

    public static Page_GridManager Inst;
    static
    {
        Inst = new Page_GridManager();
    }
}