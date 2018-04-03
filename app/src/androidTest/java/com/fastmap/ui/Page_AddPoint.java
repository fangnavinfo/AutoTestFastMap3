package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * 打点
 * Created by fang on 18/3/1.
 */

public class Page_AddPoint extends Page_Base_Tips
{
    @FindResource(Id="obstruction_rb", ios_xpath="//XCUIElementTypeButton[@name=\"gridView_obstacle.png\"]")
    public static String OBST; //障碍物

    public static Page_AddPoint Inst;
    static
    {
        Inst = new Page_AddPoint();
    }
}
