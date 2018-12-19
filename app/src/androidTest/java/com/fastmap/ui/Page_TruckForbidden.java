package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * 卡车交限
 * Created by fang on 18/1/22.
 */
public class Page_TruckForbidden extends Page_Base_Tips
{
    @FindResource(Id="traffic_forbidden_icon_c2", ios_xpath="//XCUIElementTypeApplication[@name=\"FastMap-18秋\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeCollectionView/XCUIElementTypeCell[2]")
    public static String FORB_LEFT;//禁止左转


    @FindResource(Id="traffic_forbidden_icon_c1")
    public static String ICON_1;

    @FindResource(Id="traffic_forbidden_icon_c3")
    public static String ICON_3;

    @FindResource(Id="traffic_forbidden_icon_c4")
    public static String ICON_4;

    @FindResource(Id="traffic_forbidden_icon_c5")
    public static String ICON_5;

    @FindResource(Id="traffic_forbidden_icon_c6")
    public static String ICON_6;

    @FindResource(Id="traffic_forbidden_icon_c7")
    public static String ICON_7;

    @FindResource(Id="add_view_button")
    public static String ADD_VIEW;

    @FindResource(Id="delete_view_button")
    public static String DELETE_VIEW;

    //轻微型
    @FindResource(Id="fm_truck_small")
    public static String TRUCK_SAMLL;

    //中型
    @FindResource(Id="fm_truck_middle")
    public static String TRUCK_MIDDLE;

    //重型
    @FindResource(Id="fm_truck_big")
    public static String TRUCK_BIG;

    @FindResource(Id="truck_traffic_forbidden_no_pull_into")
    public static String NO_PULL_INTO;

    public static Page_TruckForbidden Inst;
    static
    {
        Inst = new Page_TruckForbidden();
    }
}
