package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * Created by h on 2018/4/13.
 * 禁停
 */

public class Page_NoParking extends Page_Base_Tips
{
    @FindResource(Id="no_parking_time_button")
    public static String TIME;

    @FindResource(Id="no_parking_desc")
    public static String DESC;

    @FindResource(Id="et_remark_txt")
    public static String REMARK;

    @FindResource(Id="elec_eye_adapter_checkbox")
    public static String CHECKBOX;

    @FindResource(Id="btn_fm_confirm")
    public static String DELETE_CONFIRM;


    public static Page_NoParking Inst;
    static
    {
        Inst = new Page_NoParking();
    }
}