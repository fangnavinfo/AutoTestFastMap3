package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by zhou on 18/1/24.
 * 红绿灯
 */

public class Page_Light extends Page_Base_Tips
{
    @FindResource(Id="camera_button")
    public static String CAMERA_BUTTON;

    public static Page_Light Inst;
    static
    {
        Inst = new Page_Light();
    }

}
