package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 *  人渡轮渡时间限制
 * Created by h on 2019/1/15.
 */

public class Page_FerryTime extends Page_Base_Tips
{
    @FindResource(Id="ferry_time_card_time_edit")
    public static String TIME;

    @FindResource(Id="ferry_time_card_add_time")
    public static String ADD_TIME;

    public static Page_FerryTime Inst;
    static
    {
        Inst = new Page_FerryTime();
    }
}
