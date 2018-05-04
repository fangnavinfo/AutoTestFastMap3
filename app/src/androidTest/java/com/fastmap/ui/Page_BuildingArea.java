package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * Created by h on 2018/5/2.
 */

public class Page_BuildingArea extends Page_Base_Tips
{
    @FindResource(Id="btn_building_area_point_draw_last", Text="上一步")
    public static String LAST_STEP;
    @FindResource(Id="btn_building_area_point_draw_clear", Text="重绘")
    public static String REPAINT;
    @FindResource(Id="btn_building_area_point_draw_finish", Text="完成")
    public static String COMPLETE;

    public static Page_BuildingArea Inst;
    static
    {
        Inst = new Page_BuildingArea();
    }
}
