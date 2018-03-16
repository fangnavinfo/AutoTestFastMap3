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

    @FindResource(Id = "tv_search_location_btn", ios_xpath="//XCUIElementTypeButton[@name=\"搜 索\"]")
    public static String SEARCH_START_LOCATION; //按照经纬度搜索

    @FindResource(Id = "edt_search_location_longitude", ios_xpath="//XCUIElementTypeApplication[@name=\"FastMap-18夏\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeTextField[1]")
    public static String LNG;//经度

    @FindResource(Id = "edt_search_location_latitude", ios_xpath="//XCUIElementTypeApplication[@name=\"FastMap-18夏\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeTextField[2]")
    public static String LAT;//维度

    @FindResource(Id="edt_search_tips_input", ios_xpath="//XCUIElementTypeApplication[@name=\"FastMap-18夏\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeTextField")
    public static String TIPS_ROWKEY;
    @FindResource(Id="tv_search_tips_btn", Text="搜 索")
    public static String SEARCH_START_TIPS;



    @FindResource(Id = "tv_search_link_btn", Text="搜 索")
    public static String LINKSEARCH;

    @FindResource(Id = "edt_search_info_input", ios_xpath="//XCUIElementTypeApplication[@name=\"FastMap-18夏\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeTextField")
    public static String EDITINFO;

    @FindResource(Id="tv_search_info_btn",  Text="搜 索")
    public static String SEARCH_START_INFO;

    @FindResource(Text = "精确匹配")
    public static String EXACT_FIND;

    @FindResource(Id="rbtn_search_link_exact", Text = "精确匹配")
    public static String EXACT_FIND_LINK;


    public static Page_Search Inst;
    static{
        Inst = new Page_Search();
    }

//    public void ClickTips(String tips) throws Exception
//    {
//        mDevice.findObject(By.text(tips)).click();
//    }
}
