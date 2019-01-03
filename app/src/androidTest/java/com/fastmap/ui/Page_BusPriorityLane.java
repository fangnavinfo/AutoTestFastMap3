package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * 公交优先车道
 * Created by zhou on 18/12/27.
 */
public class Page_BusPriorityLane extends Page_Base_Tips
{
    @FindResource(Id="ck_move_point_or_line")
    public static String MOVE;

    @FindResource(Id = "only_button")
    public static String CHOOSE_END;

    @FindResource(Id="reverse_card_time_edit")
    public static String TIME;

    @FindResource(Id="reverse_card_add_time")
    public static String ADD_TIME;


    public static Page_BusPriorityLane Inst;
    static
    {
        Inst = new Page_BusPriorityLane();
    }
}