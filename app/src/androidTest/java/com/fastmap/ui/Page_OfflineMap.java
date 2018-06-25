package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * Created by h on 2018/6/21.
 */

public class Page_OfflineMap extends Page_Base_Tips
{
    @FindResource(Id="rb_city_list", ios_name = "城市列表")
    public static String CITY_LIST;

    @FindResource(Id="filter_edit")
    public static String FILTER_EDIT;

    @FindResource(Id="rb_manager")
    public static String MANAGER;

    @FindResource(Id="tv_gdb_size")
    public static String GDB_SIZE;

    @FindResource(Id="btn_back")
    public static String BACK;
    public static Page_OfflineMap Inst;
    static
    {
        Inst = new Page_OfflineMap();
    }
}
