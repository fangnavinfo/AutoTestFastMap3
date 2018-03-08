package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by zhou on 18/1/24.
 * 时间选择
 */
public class Page_SelectTime extends FastMapPage
{
    @FindResource(Id="btn_fm_cancel", Text="取消")
    public static String CANCEL;

    @FindResource(Id="btn_fm_confirm", Text="确定")
    public static String OK;

    public static Page_SelectTime Inst;
    static
    {
        Inst = new Page_SelectTime();
    }
}
