package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by h on 2018/1/30.
 * 搜索
 */

public class Page_Search extends FastMapPage
{
    @FindResource(Text = "Link")
    public static String TYPE_LINK;

    @FindResource(Id = "edt_search_link_input", Text="请输入Link的pid")
    public static String EDITLINK;

    @FindResource(Id = "tv_search_link_btn", Text="搜 索")
    public static String SEARCH_START_LINK;

    @FindResource(Id = "tv_search_location_btn", ios_name="搜 索")
    public static String SEARCH_START_LOCATION; //按照经纬度搜索

    @FindResource(Id = "edt_search_location_longitude", ios_name="longitude_search")
    public static String LNG;//经度

    @FindResource(Id = "edt_search_location_latitude", ios_name="latitude_search")
    public static String LAT;//维度

    @FindResource(Id="edt_search_tips_input", ios_name="Tips_search")
    public static String TIPS_ROWKEY;
    @FindResource(Id="tv_search_tips_btn", Text="搜 索")
    public static String SEARCH_START_TIPS;



    @FindResource(Id = "tv_search_link_btn", Text="搜 索")
    public static String LINKSEARCH;

    @FindResource(Id = "edt_search_poi_input")
    public static String EDITPOI;

    @FindResource(Id="rbtn_search_poi_name", Text = "name")
    public static String NAME;
    @FindResource(Id="rbtn_search_poi_pid", Text = "pid")
    public static String PID;
    @FindResource(Id="rbtn_search_poi_fid", Text = "fid")
    public static String FID;

    @FindResource(Id = "edt_search_pas_input")
    public static String EDITPAS;

    @FindResource(Id = "tv_search_pas_btn")
    public static String SEARCH_PAS;

    @FindResource(Id = "edt_search_info_input", ios_name="Info_search")
    public static String EDITINFO;

    @FindResource(Id="tv_search_info_btn",  Text="搜 索")
    public static String SEARCH_START_INFO;

    @FindResource(Id="tv_search_poi_btn",  Text="搜 索")
    public static String SEARCH_START_POI;

    @FindResource(Text = "精确匹配")
    public static String EXACT_FIND;

    @FindResource(Id="rbtn_search_link_exact", Text = "精确匹配")
    public static String EXACT_FIND_LINK;

    @FindResource(Id="rbtn_search_link_blurry", Text = "模糊匹配")
    public static String BLURRY_FIND_LINK;

    @FindResource(Id="btn_search_range_link")
    public static String SEARCH_RANGE;
    @FindResource(Id="tv_item")
    public static String HISTORY;

    @FindResource(Id="rbtn_search_info_infoId")
    public static String GLOBALID_INFO;

    @FindResource(Id="rbtn_search_info_infoName")
    public static String NAME_INFO;

    @FindResource(Id="btn_search_range_tips")
    public static String RANGE;


    public static Page_Search Inst;
    static{
        Inst = new Page_Search();
    }

//    public void ClickTips(String tips) throws Exception
//    {
//        mDevice.findObject(By.text(tips)).click();
//    }
}
