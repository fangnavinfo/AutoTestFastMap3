package com.fastmap.ui;

import com.fang.testAdapter.FindResource;


/**
 * 线门牌
 */
public class Page_Line_PAS extends Page_Base_Tips
{
    //建立起点
    @FindResource(Id="tv_line_sign_select")
    public static String START;

    //建立终点
    @FindResource(Id="tv_line_sign_select")
    public static String END;

    public static Page_Line_PAS Inst;

    static
    {
        Inst = new Page_Line_PAS();
    }
}
