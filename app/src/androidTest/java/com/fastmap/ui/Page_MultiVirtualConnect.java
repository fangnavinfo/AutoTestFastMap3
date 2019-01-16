package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * 复合虚拟连接
 * Created by h on 2019/1/16.
 */

public class Page_MultiVirtualConnect extends Page_Base_Tips
{

    @FindResource(Id="btn_multi_virtual_connect_last")
    public static String PRE_STEP;

    @FindResource(Id="btn_multi_virtual_connect_clear")
    public static String REPAINT;

    @FindResource(Id="btn_multi_virtual_connect_finish")
    public static String FINISH;



    @FindResource(Id="rbtn_multi_virtual_connect_cableway")
    public static String CABLEWAY;

    @FindResource(Id="rbtn_multi_virtual_connect_building")
    public static String BUILDING;

    @FindResource(Id="rbtn_multi_virtual_connect_park")
    public static String PARK;

    @FindResource(Id="rbtn_multi_virtual_connect_square")
    public static String SQUARE;

    @FindResource(Id="rbtn_multi_virtual_connect_street")
    public static String STREET;

    @FindResource(Id="rbtn_multi_virtual_connect_underground_pass")
    public static String UNDERGROUND_PASS;

    @FindResource(Id="rbtn_multi_virtual_connect_other")
    public static String OTHER;

    @FindResource(Id="img_multi_virtual_connect_time")
    public static String ADD_TIME;

    @FindResource(Id="edt_multi_virtual_connect_name")
    public static String NAME;

    @FindResource(Id="edt_multi_virtual_connect_time")
    public static String TIME;

    @FindResource(Id="rbtn_multi_virtual_connect_nObs_no")
    public static String NOBS_NO;

    @FindResource(Id="rbtn_multi_virtual_connect_nObs_yes")
    public static String NOBS_YES;

    @FindResource(Id="rbtn_multi_virtual_connect_fee_no")
    public static String FEE_NO;

    @FindResource(Id="rbtn_multi_virtual_connect_fee_yes")
    public static String FEE_YES;

    @FindResource(Id="rbtn_multi_virtual_c_array_lr")
    public static String LR;

    @FindResource(Id="rbtn_multi_virtual_c_array_asc")
    public static String ASC;

    @FindResource(Id="rbtn_multi_virtual_c_array_desc")
    public static String DESC;

    @FindResource(Id="rbtn_multi_virtual_c_array_nlr")
    public static String NLR;


    public static Page_MultiVirtualConnect Inst;
    static
    {
        Inst = new Page_MultiVirtualConnect();
    }
}
