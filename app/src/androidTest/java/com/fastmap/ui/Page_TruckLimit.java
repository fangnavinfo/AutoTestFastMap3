package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * Created by h on 2018/4/10.
 * 卡车限制
 */

public class Page_TruckLimit extends Page_Base_Tips
{

    @FindResource(Id="truck_limit_weight")
    public static String WEIGHT; //限重

    @FindResource(Id="truck_limit_axle")
    public static String AXLE; //限轴重

    @FindResource(Id="truck_limit_width")
    public static String WIDTH; //限宽


    public static Page_TruckLimit Inst;
    static
    {
        Inst = new Page_TruckLimit();
    }
}
