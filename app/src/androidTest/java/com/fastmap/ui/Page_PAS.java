package com.fastmap.ui;

import com.fang.testAdapter.*;


/**
 * Created by fang on 18/1/22.
 */
public class Page_PAS extends Page_Base_Tips
{
    @FindResource(Id="fm_et_name_pas", ios_name="请输入小区名称")
    public static String NAME;

    @FindResource(Id="fm_et_address_pas", ios_predicate="value CONTAINS '请输入楼栋号'")
    public static String ADDRESS;

    @FindResource(Id="ck_odd", ios_name="奇")
    public static String ODD; //奇

    @FindResource(Id="ck_road", ios_name="路")
    public static String ROAD_TYPE;

    @FindResource(Id="fm_rb_building_house", ios_name="楼栋门牌")
    public static String BUILDING_PAS;
    @FindResource(Id="fm_rb_door_card", ios_name="楼门门牌")
    public static String DOOR_PAS;
    @FindResource(Id="fm_rb_address_card", ios_name="地址门牌")
    public static String ADDRESS_PAS;

    public static Page_PAS Inst;
    static
    {
        Inst = new Page_PAS();
    }
}
