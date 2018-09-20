package com.fastmap.ui;

import com.fang.testAdapter.FastMapPage;
import com.fang.testAdapter.FindResource;

/**
 * Created by h on 2018/2/6.
 */

public class Page_Default_Pas_Set extends FastMapPage
{
    @FindResource(Id = "btn_back")
    public static String BACK;

    @FindResource(Id = "fm_ck_building_house")
    public static String BUILDING;

    @FindResource(Id = "fm_ck_door_card")
    public static String DOOR;

    @FindResource(Id = "fm_ck_address_card")
    public static String ADDRESS;


    public static Page_Default_Pas_Set Inst;
    static {
        Inst = new Page_Default_Pas_Set();
    }
}
