package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * Created by zhou on 18/1/24.
 * 红绿灯受控
 */

public class Page_LightControl extends Page_Base_Tips
{
    @FindResource(Id="camera_button")
    public static String CAMERA_BUTTON;

    public static Page_LightControl Inst;
    static
    {
        Inst = new Page_LightControl();
    }

}
