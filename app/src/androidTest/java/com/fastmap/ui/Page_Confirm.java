package com.fastmap.ui;

import com.fang.testAdapter.FastMapPage;
import com.fang.testAdapter.FindResource;

/**
 * Created by zhou on 18/3/13.
 * 退出确认
 */
public class Page_Confirm extends FastMapPage
{
    @FindResource(Id="btn_fm_cancel", Text="取消")
    public static String CANCEL;

    @FindResource(Id="btn_fm_confirm", ios_name="确定")
    public static String OK;

    public static Page_Confirm Inst;
    static
    {
        Inst = new Page_Confirm();
    }
}
