package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by fang on 18/1/19.
 */
public class Page_POI_Camera extends FastMapPage
{
    @FindResource(Id="take_pic_imgbtn", ios_name="camera btn nor")
    public static String TAKE_PIC;

    @FindResource(Id="task_pic_back_img", ios_name="返回")
    public static String BACK;

    @FindResource(Id="mingcheng_btn", Text="名称")
    public static String NAME_TYPE;

    @FindResource(Id="plan_of_subway_station_btn", Text="地铁站平面图")
    public static String SUBWAY_TYPE;

    @FindResource(Id="radio_revolution1", Text="低")
    public static String RADIO_LOW; //低分辨率

    @FindResource(Id="radio_revolution2", Text="中")
    public static String RADIO_MID; //中分辨率

    @FindResource(Id="radio_revolution3", Text="高")
    public static String RADIO_HIG; //高分辨率
	
    @FindResource(Id="shuipai_btn", Text="水牌")
    public static String SHUIPAI_TYPE; //水牌

    @FindResource(Id="chanpinquanmao_btn", Text="全貌")
    public static String FULL_VIEW; //产品全貌

    public static Page_POI_Camera Inst;
    static
    {
        Inst = new Page_POI_Camera();
    }
}
