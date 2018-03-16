package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * 打点
 * Created by fang on 18/3/1.
 */

public class Page_AddPoint extends FastMapPage
{
    @FindResource(Id="obstruction_rb", ios_predicate = "name == 'obstacle'")
    public static String OBST; //障碍物

    @FindResource(Id="save_button", Text="保存")
    public static String SAVE;

    public static Page_AddPoint Inst;
    static
    {
        Inst = new Page_AddPoint();
    }
}
