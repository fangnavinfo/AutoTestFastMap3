package com.fastmap.ui;

import com.fang.testAdapter.*;


/**
 * Created by fang on 18/1/22.
 */
public class Page_Info_Camera extends FastMapPage
{
    @FindResource(Id="take_pic_imgbtn", ios_name="camera btn nor")
    public static String TAKE_PIC;

    @FindResource(Id="task_pic_back_imgbtn", ios_name="返回")
    public static String BACK;

    public static Page_Info_Camera Inst;
    static
    {
        Inst = new Page_Info_Camera();
    }
}
