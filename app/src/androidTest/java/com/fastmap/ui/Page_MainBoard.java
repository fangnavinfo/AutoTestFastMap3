package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by fang on 18/1/19.
 */
public class Page_MainBoard extends FastMapPage
{
    @FindResource(Id="back", ios_name="main user")
    public static String BACK;
    @FindResource(Id="head_icon", ios_name="main user")
    public static String MAIN_MENU;

    @FindResource(Id="img_search", ios_name="search")
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

    @FindResource(Id="btn_mode", ios_name="scene integrated")
    public static String MODE; //场景设置
    @FindResource(Id="btn_close_pop", ios_name="gray close")
    public static String CLOSE;
    @FindResource(Id="cb_refinement_layer", ios_xpath = "//XCUIElementTypeApplication[@name=\"FastMap-18秋\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[8]/XCUIElementTypeSwitch")
    public static String REFINEMENT; //精细化图层
    
    @FindResource(Id="btn_distance_measure", ios_name="measure")
    public static String DISTANCE_MEASURE;	//测量距离
    @FindResource(Id="btn_distance_measure_left_top")
    public static String DISTANCE_MEASURE_LEFT_TOP;

    @FindResource(Id="iv_zoom_out")
    public static String ZOOM_OUT;
    @FindResource(Id="iv_zoom_in")
    public static String ZOOM_IN;

    @FindResource(Id="btn_indoor_data_check_open", ios_name="quality control")
    public static String QC_TASK;

    @FindResource(Id="btn_infor_report", ios_name="up report")
    public static String REPORT;

    @FindResource(Id="info_pop_add_point", ios_name="点情报")
    public static String POINT_INFO;

    @FindResource(Id="info_pop_add_line", ios_name="线情报")
    public static String LINE_INFO;

    @FindResource(Id="info_pop_add_frame", ios_name="面情报")
    public static String FRAME_INFO;

    public static Page_MainBoard Inst;
    static
    {
        Inst = new Page_MainBoard();
    }

    public void Trigger(String tips) throws Exception
    {
    	testadapter.TriggeInMainBoard(tips);
    	Thread.sleep(2000);
    }

    //等待进入主界面
    public boolean WaitEnter(int time) throws NoSuchFieldException
    {
        return isExist(MAIN_MENU, time);
    }
}