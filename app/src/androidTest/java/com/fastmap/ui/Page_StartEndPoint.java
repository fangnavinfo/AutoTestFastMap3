package com.fastmap.ui;


import com.fang.testAdapter.*;

/**
 * Created by zhou on 18/1/24.
 * 起点终点TIPS
 */

public class Page_StartEndPoint extends Page_Base_Tips
{
    @FindResource(Id="bridge_bt", ios_name="gridView_sedoting_brige.png")
    public static String BRIDGE_BT;
    @FindResource(Id="tunnel_bt", ios_name="gridView_sedoting_tunnel.png")
    public static String TUNNEL_BT;
    @FindResource(Id="cross_line_overpass_bt", ios_name="gridView_sedoting_clOverpass.png")
    public static String CROSS_LINE_OVERPASS_BT;
    @FindResource(Id="walking_street_bt", ios_name="gridView_sedoting_promenade.png")
    public static String WALKING_STREET_BT;
    @FindResource(Id="overhead_road_bt", ios_name="gridView_sedoting_elevatedRoad.png")
    public static String OVERHEAD_ROAD_BT;
    @FindResource(Id="under_construction_bt", ios_name="gridView_sedoting_construction.png")
    public static String UNDER_CONSTRUCTION_BT;
    @FindResource(Id="repair_bt", ios_name="gridView_sedoting_maintenance.png")
    public static String REPAIR_BT;
    @FindResource(Id="up_low_separation_bt", ios_name="gridView_sedoting_luds.png")
    public static String UP_LOW_SAPARATION_BT;
    @FindResource(Id="side_road_bt", ios_name="gridView_sedoting_sideway.png")
    public static String SIDE_ROAD_BT;
    @FindResource(Id="bus_lane_bt", ios_name="gridView_sedoting_busOnlyLane.png")
    public static String BUS_LANE_BT;
    @FindResource(Id="pavement_cover_bt", ios_name="gridView_sedoting_pavementCover.png")
    public static String PAVEMENT_COVER_BT;
    @FindResource(Id="narrow_lane_bt", ios_name="gridView_sedoting_narrowRoad.png")
    public static String NARROW_LANE_BT;
    @FindResource(Id="overpass_bt", ios_name="gridView_sedoting_overPass.png")
    public static String OVERPASS_BT;
    @FindResource(Id="under_pass_bt", ios_name="gridView_sedoting_underPass.png")
    public static String UNDER_PASS_BT;
    @FindResource(Id="seasonal_closure_bt", ios_name="gridView_sedoting_scr.png")
    public static String SEASONAL_CLOSURE_BT;
    @FindResource(Id="usage_fee_required_bt", ios_name="gridView_sedoting_ufr.png")
    public static String USAGE_FEE_REQUIRED_BT;
    @FindResource(Id="bypath_bt", ios_name="gridView_sedoting_bypath.png")
    public static String BYPATH_BT;
    @FindResource(Id="traveling_bridge_bt", ios_name="gridView_sedoting_moveBrige.png")
    public static String TRAVELING_BRIDGE_BT;

    public static Page_StartEndPoint Inst;
    static
    {
        Inst = new Page_StartEndPoint();
    }
}