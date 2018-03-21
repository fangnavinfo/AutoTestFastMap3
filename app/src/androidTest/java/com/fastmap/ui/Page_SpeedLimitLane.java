package com.fastmap.ui;

import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import com.fang.testAdapter.FastMapPage;
import com.fang.testAdapter.FindResource;

/**
 * Created by h on 2018/3/21.
 */

public class Page_SpeedLimitLane extends FastMapPage {
    @FindResource(Id="seek_view_container")
    public static String CTROL;

    @FindResource(Id="speed_limit_number_90")
    public static String NUM90;

    @FindResource(Id="speed_limit_number_110")
    public static String NUM110;

    @FindResource(Id="save_button")
    public static String SAVE;
    @FindResource(Id="card_speed_limit_type_driveway")
    public static String ROADLIMIT;

    @FindResource(Id="speed_limit_type_point")
    public static String POINTLIMIT;
    @FindResource(Id="et_speed_limit_number")
    public static String MAXNUM;
    @FindResource(Id="speed_limit_number_40")
    public static String NUM40;
    @FindResource(Id="et_speed_limit_number_min")
    public static String MINNUM;
    @FindResource(Id="speed_limit_number_30")
    public static String NUM30;

    public static Page_SpeedLimitLane Inst;
    static
    {
        Inst = new Page_SpeedLimitLane();
    }

    public  void ClickByIndex(int index) throws UiObjectNotFoundException {
        UiObject obj = new UiObject(new UiSelector().className("android.widget.TextView").instance(index));
        //UiObject obj = new UiObject(new UiSelector().instance(index));
        obj.click();
    }
}
