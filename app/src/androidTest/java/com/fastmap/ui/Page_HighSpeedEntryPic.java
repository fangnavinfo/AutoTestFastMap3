package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by fang on 18/3/13.
 */
public class Page_HighSpeedEntryPic extends FastMapPage
{
    @FindResource(Id = "save_button", Text="保存")
    public static String SAVE;

    public static Page_HighSpeedEntryPic Inst;
    static
    {
        Inst = new Page_HighSpeedEntryPic();
    }
}
