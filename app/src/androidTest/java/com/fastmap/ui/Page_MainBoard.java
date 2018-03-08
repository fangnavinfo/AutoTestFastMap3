package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by fang on 18/1/19.
 */
public class Page_MainBoard extends FastMapPage
{
    @FindResource(Id="back", ios_xpath="//XCUIElementTypeButton[@name=\"main user\"]")
    public static String BACK;
    @FindResource(Id="head_icon", ios_xpath="//XCUIElementTypeButton[@name=\"main user\"]")
    public static String MAIN_MENU;

    @FindResource(Id="img_search", ios_xpath="//XCUIElementTypeButton[@name=\"search\"]")
    public static String SEARCH;

    @FindResource(Text="POI")
    public static String SEARCH_POI;
    @FindResource(Id="edt_search_poi_input")
    public static String SEARCH_POI_INPUT;
    @FindResource(Id="tv_search_poi_btn")
    public static String SEARCH_POI_BTN;
    @FindResource(Text="点门牌")
    public static String SEARCH_PAS;
    @FindResource(Id="edt_search_pas_input")
    public static String SEARCH_PAS_INPUT;
    @FindResource(Id="tv_search_pas_btn")
    public static String SEARCH_PAS_BTN;
    @FindResource(Text="情报")
    public static String SEARCH_INFO;
    @FindResource(Id="edt_search_info_input")
    public static String SEARCH_INFO_INPUT;
    @FindResource(Id="tv_search_info_btn")
    public static String SEARCH_INFO_BTN;
    @FindResource(Text="Link")
    public static String SEARCH_LINK;
    @FindResource(Id="edt_search_link_input")
    public static String SEARCH_LINK_INPUT;
    @FindResource(Id="tv_search_link_btn")
    public static String SEARCH_LINK_BTN;
    
    @FindResource(Id="btn_distance_measure", ios_xpath="//XCUIElementTypeButton[@name=\"measure\"]")
    public static String DISTANCE_MEASURE;	//测量距离

    @FindResource(Id="iv_zoom_out")
    public static String ZOOM_OUT;
    @FindResource(Id="iv_zoom_in")
    public static String ZOOM_IN;

    @FindResource(Id="btn_indoor_data_check_open", ios_xpath="//XCUIElementTypeButton[@name=\"quality control\"]")
    public static String QC_TASK;

    @FindResource(Id="btn_infor_report", ios_xpath="//XCUIElementTypeButton[@name=\"up report\"]")
    public static String REPORT;

    @FindResource(Id="info_pop_add_point", ios_xpath="//XCUIElementTypeButton[@name=\"点情报\"]")
    public static String POINT_INFO;

    @FindResource(Id="info_pop_add_line", ios_xpath="//XCUIElementTypeButton[@name=\"线情报\"]")
    public static String LINE_INFO;

    @FindResource(Id="info_pop_add_frame", ios_xpath="//XCUIElementTypeButton[@name=\"面情报\"]")
    public static String FRAME_INFO;

    public static Page_MainBoard Inst;
    static
    {
        Inst = new Page_MainBoard();
    }

    public void Trigger(String tips) throws Exception
    {
    	testadapter.TriggeInMainBoard(tips);
    }

    //等待进入主界面
    public boolean WaitEnter(int time) throws NoSuchFieldException
    {
        return isExist(MAIN_MENU, time);
    }
}