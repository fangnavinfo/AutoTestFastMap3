package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * 区域内属性
 * Created by h on 2018/1/23.
 */

public class Page_RoundAbout extends Page_Base_Tips 
{
    @FindResource(Id="card_intra_regional_road",Text = "区域内道路", ios_name="gridView_extentLine_num_3.png")
    public static String REGION_ROAD;//范围线

    @FindResource(Id="card_add_att",Text = "增属性", ios_name="增属性")
    public static String ADD;//增属性

    @FindResource(Id="card_del_att",Text = "删属性", ios_name="删属性")
    public static String DELETE;//删属性

    public static Page_RoundAbout Inst;
    static
    {
        Inst = new Page_RoundAbout();
    }
}
