package com.fastmap.ui;

import com.fang.testAdapter.*;


/**
 * 主菜单
 * Created by fang on 18/1/19.
 */
public class Page_MainMenu extends FastMapPage
{
    @FindResource(Id="fmcard_tv_user_data", ios_name="我的数据")
    public static String MY_DATA; //我的数据
    @FindResource(Id="fmcard_tv_grid_manager", ios_name="Grid管理")
    public static String GRID_MANAGER;
    @FindResource(Id="fmcard_tv_error_seem")
    public static String ERROR_LIST; //错误列表
    @FindResource(Id="fmcard_tv_sync_photos", ios_name="室内整理工具")
    public static String INDOOR_TOOL; //室内整理工具

    @FindResource(Id="iv_road_name_back", ios_name="white arrow")
    public static String  ROADNAME_BACK; //退出道路名连线
    
    @FindResource(Id="fmcard_ibtn_back", ios_name="pop_arrow")
    public static String BACK;

    @FindResource(Id="fmcard_tv_user_settings", clazz = "android.widget.TextView", Text="设置")
    public static String SET;
    @FindResource(Id="fmcard_btn_user_exit",Text="退出登录", clazz="android.widget.Button")
    public static String EXIT;

    @FindResource(clazz="android.widget.ScrollView")
    public static String SCROLL;

    public static Page_MainMenu Inst;
    static
    {
        Inst = new Page_MainMenu();
    }
}
