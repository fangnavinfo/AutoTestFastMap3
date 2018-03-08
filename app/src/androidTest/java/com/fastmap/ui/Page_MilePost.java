package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by h on 2018/1/22.
 */

public class Page_MilePost extends FastMapPage {
    @FindResource(Id="tv_virtualKeyboard_0")
    public static String ZERO;

    @FindResource(Id="save_button" ,Text = "保存")
    public static String SAVE;

    @FindResource(Id="image_button_add_one")
    public static String ADD;

    @FindResource(Id="milepost_rb")
    public static String MILEPOST;

    public static Page_MilePost Inst;
    static
    {
        Inst = new Page_MilePost();
    }
}
