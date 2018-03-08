package com.fastmap.ui;

import com.fang.testAdapter.*;


/**
 * 主菜单
 * Created by fang on 18/1/19.
 */
public class Page_MainMenu extends FastMapPage
{
    @FindResource(Id="fmcard_tv_user_data", ios_xpath="//XCUIElementTypeStaticText[@name=\"我的数据\"]")
    public static String MY_DATA; //我的数据
    @FindResource(Id="fmcard_tv_grid_manager", ios_xpath="//XCUIElementTypeStaticText[@name=\"Grid管理\"]")
    public static String GRID_MANAGER;
    @FindResource(Id="fmcard_tv_error_seem")
    public static String ERROR_LIST; //错误列表
    @FindResource(Id="fmcard_tv_sync_photos", ios_xpath="//XCUIElementTypeStaticText[@name=\"室内整理工具\"]")
    public static String INDOOR_TOOL; //室内整理工具

    @FindResource(Id="fmcard_ibtn_back", ios_x=512, ios_y=384)
    public static String BACK;

    @FindResource(Id="fmcard_tv_user_settings")
    public static String SET;

    public static Page_MainMenu Inst;
    static
    {
        Inst = new Page_MainMenu();
    }
}
