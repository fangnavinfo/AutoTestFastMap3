package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * Created by zhou on 18/12/26.
 * 变道提示
 */
public class Page_ChangeLaneNotice extends Page_Base_Tips
{
    @FindResource(Id="select_out_line")
    public static String SELECT_OUT_LINE;
    @FindResource(Id="cl_clean")
    public static String CLEAN_OUT_LINE;



    public static Page_ChangeLaneNotice Inst;
    static
    {
        Inst = new Page_ChangeLaneNotice();
    }
}