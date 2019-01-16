package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * 通路行人非机动车禁行
 * Created by h on 2019/1/16.
 */

public class Page_OrdinaryRoadNoCrossing extends Page_Base_Tips
{

    @FindResource(Id="tv_ordinary_line_button")
    public static String CHOOSE_END;


    @FindResource(Id="pedestrian_crossing")
    public static String NO_PED_CROSSING;

    @FindResource(Id="bicycle_crossing")
    public static String NO_BICYCLE_CROSSING;

    @FindResource(Id="tricycle_crossing")
    public static String NO_TRICYCLE_CROSSING;

    @FindResource(Id="electric_bicycle_crossing")
    public static String NO_ELEC_BICYCLE_CROSSING;

    public static Page_OrdinaryRoadNoCrossing Inst;
    static
    {
        Inst = new Page_OrdinaryRoadNoCrossing();
    }
}
