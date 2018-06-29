package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by h on 2018/1/31.
 */

public class Page_InfoAccept extends FastMapPage
{
    @FindResource(Id = "other_button",Text = "部分采纳")
    public static String PART_ACCEPT;

    @FindResource(Id = "",Text = "确定")
    public static String CONFRIM;

    @FindResource(Id = "save_button",Text = "采纳")
    public static String ACCEPT;
    public static Page_InfoAccept Inst;
    static
    {
        Inst = new Page_InfoAccept();
    }
}
