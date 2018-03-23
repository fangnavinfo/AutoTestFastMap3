package com.fastmap.ui;

import com.fang.testAdapter.FastMapPage;
import com.fang.testAdapter.FindResource;

/**
 * Created by zhou on 18/1/24.
 * 检索结果列表
 */
public class Page_SearchResultList extends FastMapPage
{
    @FindResource(Id="ll_my_data_snap_list", ios_xpath="//XCUIElementTypeApplication[@name=\"FastMap-18秋\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell")
    public static String DATA_LIST;


    @FindResource(Id="iv_search_result_list_back", ios_xpath="//XCUIElementTypeButton[@name=\"white arrow\"]")
    public static String BACK;

    @FindResource(Id="right_fragment_layout")
    public static String FRAME;
    public static Page_SearchResultList Inst;
    static
    {
        Inst = new Page_SearchResultList();
    }

}