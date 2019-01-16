package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * 地下通道/过街天桥
 * Created by h on 2019/1/16.
 */

public class Page_UndergroundOverpass extends Page_Base_Tips
{

    @FindResource(Id="btn_overpass")
    public static String OVERPASS;

    @FindResource(Id="btn_underpass")
    public static String UNDERPASS;

    @FindResource(Id="end_to_end_checkBox")
    public static String END_TO_END;


    public static Page_UndergroundOverpass Inst;
    static
    {
        Inst = new Page_UndergroundOverpass();
    }
}
