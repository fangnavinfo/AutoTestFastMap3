package com.fastmap.ui;

import com.fang.testAdapter.FastMapPage;
import com.fang.testAdapter.FindResource;

/**
 * Created by h on 2018/3/22.
 */

public class Page_TrafficLight extends FastMapPage {
    @FindResource(Id="et_title")
    public static String TITLE;

    @FindResource(Id="cancel_button")
    public static String CANCEL;

    public static Page_TrafficLight Inst;
    static
    {
        Inst = new Page_TrafficLight();
    }
}
