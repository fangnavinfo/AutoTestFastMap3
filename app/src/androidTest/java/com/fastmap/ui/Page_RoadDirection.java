package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by zhou on 18/1/19.
 * 道路方向
 */

public class Page_RoadDirection extends Page_Base_Tips
{
    @FindResource(Id="card_road_direction_unidirectional", Text="单方向")
    public static String UNIDIRECTIONAL;
    @FindResource(Id="card_road_direction_bidirectional", Text="双方向")
    public static String BIDIRECTION;

    public static Page_RoadDirection Inst;
    static
    {
        Inst = new Page_RoadDirection();
    }
}
