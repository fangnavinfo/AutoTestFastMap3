package com.fastmap.ui;


import com.fang.testAdapter.*;

/**
 * Created by zhou on 18/1/24.
 * 起点终点TIPS
 */

public class Page_StartEndPoint extends FastMapPage
{
    @FindResource(Id="bridge_bt", ios_xpath="//XCUIElementTypeButton[@name=\"sedoting brige\"]")
    public static String BRIDGE_BT;
    @FindResource(Id="tunnel_bt", ios_xpath="//XCUIElementTypeButton[@name=\"sedoting tunnel\"]")
    public static String TUNNEL_BT;
    @FindResource(Id="cross_line_overpass_bt", ios_xpath="//XCUIElementTypeButton[@name=\"sedoting clOverpass\"]")
    public static String CROSS_LINE_OVERPASS_BT;
    @FindResource(Id="walking_street_bt", ios_xpath="//XCUIElementTypeButton[@name=\"sedoting promenade\"]")
    public static String WALKING_STREET_BT;
    @FindResource(Id="overhead_road_bt", ios_xpath="//XCUIElementTypeButton[@name=\"sedoting elevatedRoad\"]")
    public static String OVERHEAD_ROAD_BT;
    @FindResource(Id="under_construction_bt", ios_xpath="//XCUIElementTypeButton[@name=\"sedoting construction\"]")
    public static String UNDER_CONSTRUCTION_BT;
    @FindResource(Id="repair_bt", ios_xpath="//XCUIElementTypeButton[@name=\"sedoting maintenance\"]")
    public static String REPAIR_BT;
    @FindResource(Id="up_low_separation_bt", ios_xpath="//XCUIElementTypeButton[@name=\"sedoting luds\"]")
    public static String UP_LOW_SAPARATION_BT;
    @FindResource(Id="side_road_bt", ios_xpath="//XCUIElementTypeButton[@name=\"sedoting sideway\"]")
    public static String SIDE_ROAD_BT;
    @FindResource(Id="bus_lane_bt", ios_xpath="//XCUIElementTypeButton[@name=\"sedoting busOnlyLane\"]")
    public static String BUS_LANE_BT;
    @FindResource(Id="pavement_cover_bt", ios_xpath="//XCUIElementTypeButton[@name=\"sedoting pavementCover\"]")
    public static String PAVEMENT_COVER_BT;
    @FindResource(Id="narrow_lane_bt", ios_xpath="//XCUIElementTypeButton[@name=\"sedoting narrowRoad\"]")
    public static String NARROW_LANE_BT;
    @FindResource(Id="overpass_bt", ios_xpath="//XCUIElementTypeButton[@name=\"sedoting overPass\"]")
    public static String OVERPASS_BT;
    @FindResource(Id="under_pass_bt", ios_xpath="//XCUIElementTypeButton[@name=\"sedoting underPass\"]")
    public static String UNDER_PASS_BT;
    @FindResource(Id="seasonal_closure_bt", ios_xpath="//XCUIElementTypeButton[@name=\"sedoting scr\"]")
    public static String SEASONAL_CLOSURE_BT;
    @FindResource(Id="usage_fee_required_bt", ios_xpath="//XCUIElementTypeButton[@name=\"sedoting ufr\"]")
    public static String USAGE_FEE_REQUIRED_BT;
    @FindResource(Id="bypath_bt", ios_xpath="//XCUIElementTypeButton[@name=\"sedoting bypath\"]")
    public static String BYPATH_BT;
    @FindResource(Id="traveling_bridge_bt", ios_xpath="//XCUIElementTypeButton[@name=\"sedoting moveBrige\"]")
    public static String TRAVELING_BRIDGE_BT;


    @FindResource(Id="save_button", ios_xpath="//XCUIElementTypeButton[@name=\"保存\"]")
    public static String SAVE;

    public static Page_StartEndPoint Inst;
    static
    {
        Inst = new Page_StartEndPoint();
    }
}