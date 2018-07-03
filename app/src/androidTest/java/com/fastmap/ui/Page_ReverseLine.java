package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * 潮汐车道
 * Created by fang on 18/1/19.
 */
public class Page_ReverseLine extends Page_Base_Tips
{
    @FindResource(Id="save_button", Text="保存")
    public static String SAVE;
    @FindResource(Id="ck_move_point_or_line")
    public static String MOVE;

    @FindResource(Id = "only_button")
    public static String CHOOSE_END;

    public static Page_ReverseLine Inst;
    static
    {
        Inst = new Page_ReverseLine();
    }
}