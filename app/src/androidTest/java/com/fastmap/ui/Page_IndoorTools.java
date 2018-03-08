package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by fang on 18/1/22.
 */
public class Page_IndoorTools extends FastMapPage
{
    @FindResource(Id="tv_my_data", ios_x=67, ios_y=271)
    public static String MYDATA;

    @FindResource(Id="sync_photos_back", ios_x=32, ios_y=101)
    public static String BACK;

    public static Page_IndoorTools Inst;
    static
    {
        Inst = new Page_IndoorTools();
    }
}
