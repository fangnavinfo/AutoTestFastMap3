package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * 卡车交限
 * Created by fang on 18/1/22.
 */
public class Page_TruckForbidden extends FastMapPage
{
    @FindResource(Id="traffic_forbidden_icon_c2", ios_xpath="//XCUIElementTypeApplication[@name=\"FastMap-18夏\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeCollectionView/XCUIElementTypeCell[2]")
    public static String FORB_LEFT;//禁止左转

    @FindResource(Id="save_button", ios_xpath="//XCUIElementTypeButton[@name=\"保存\"]")
    public static String SAVE;

    public static Page_TruckForbidden Inst;
    static
    {
        Inst = new Page_TruckForbidden();
    }
}
