package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by fang on 18/1/22.
 */
public class Page_ElecEye extends Page_Base_Tips
{
    @FindResource(Id="tv_electronic_eye_type_more", ios_name="更多")
    public static String TYPE_MORE;

    @FindResource(Id="tv_electronic_eye_type_more", clazz="android.widget.TextView", Text="收起", ios_name="收起")
    public static String TYPE_RETURN;
    
    @FindResource(Id="electronic_eye_overspeed", ios_name="elecEye 1")
    public static String EYE_OVERSPEED;

    @FindResource(Id="electronic_eye_ultra_low_speed", ios_name="elecEye 2")
    public static String EYE_LOWSPEED;

    @FindResource(Id="electronic_eye_move_velocity_measurement", ios_name="elecEye 3")
    public static String EYE_MOVE; //移动测速

    @FindResource(Id="electronic_eye_variable_velocity_measurement", ios_name="elecEye 4")
    public static String EYE_VAR; //可变限速

    @FindResource(Id="electronic_eye_sub_lane_speed_measurement", ios_name="elecEye 5")
    public static String EYE_LANE_SPEED; //车道限速

    @FindResource(Id="electronic_eye_vehicle_metering_speed", ios_name="elecEye 6")
    public static String EYE_VEHICLE;  //分车种限速

    @FindResource(Id="electronic_eye_interval_end", ios_name="elecEye 21")
    public static String EYE_INTERVAL_END; //区间结束

    @FindResource(Id="electronic_eye_bus_lane", ios_name="elecEye 15")
    public static String EYE_BUS_LANE;  //公交车道

    @FindResource(Id="electronic_eye_one_way_street", ios_name="elecEye 12")
    public static String EYE_ONE_WAY; //单行道

    @FindResource(Id="electronic_eye_traffic_controls", ios_name="elecEye 23")
    public static String EYE_NUM_CTRL;  //尾号限行

    @FindResource(Id="electronic_eye_environmental_protection_limit", ios_name="elecEye 24")
    public static String EYE_ENV_PROT; //环境保护

    @FindResource(Id="electronic_eye_not_vehicle_lane", ios_name="elecEye 13")
    public static String EYE_NO_VECHICLE; //非机动车

    @FindResource(Id="electronic_eye_no_turning_around", ios_name="elecEye 16")
    public static String EYE_NO_TURN; //禁止左右转

    @FindResource(Id="electronic_eye_illegal_parking", ios_name="elecEye 22")
    public static String EYE_ILLEGAL_PARKING; //违章停车

    @FindResource(Id="electronic_eye_emergency_lane", ios_name="elecEye 18")
    public static String EYE_EMERG_LANE; //应急车道

    @FindResource(Id="electronic_eye_traffic_lights", ios_name="elecEye 10")
    public static String EYE_TRAFFIC_LIGHT; //闯红灯

    @FindResource(Id="electronic_eye_traffic_marking", ios_name="elecEye 19")
    public static String EYE_TRAFFIC_MARK; //违反禁止线

    @FindResource(Id="electronic_eye_exit_entrance", ios_name="elecEye 14")
    public static String EYE_EXIT_ENTER; //出入口

    @FindResource(Id="electronic_eye_courtesy_pedestrian", ios_name="elecEye 27")
    public static String EYE_PEDESTRIAN; //礼让行人

    @FindResource(Id="electronic_eye_no_audible_warning", ios_name="elecEye 29")
    public static String EYE_AUD_WAIN; //禁止鸣笛

    @FindResource(Id="electronic_eye_no_turn_off", ios_name="elecEye 17")
    public static String EYE_NO_TURNOFF; //禁止掉头

    @FindResource(Id="electronic_eye_violating_lane", ios_name="elecEye 8")
    public static String EYE_VIOLAT_LANE; //违规占道

    @FindResource(Id="electronic_eye_lllegal_corssing", ios_name="elecEye 9")
    public static String EYE_ILLEGAL_CROSS; //违规过路

    @FindResource(Id="electronic_eye_violation_prohibition_sign", ios_name="elecEye 28")
    public static String EYE_VIOLAT_SIGN; //违反禁令

    @FindResource(Id="electronic_eye_lllegal_light", ios_name="elecEye 7")
    public static String EYE_ILLEGAL_LIGHT; //违规用灯

    @FindResource(Id="electronic_eye_no_seat_belt", ios_name="elecEye 25")
    public static String EYE_NO_BELT; //不系安全带

    @FindResource(Id="electronic_eye_drive_cell_phone", ios_name="elecEye 26")
    public static String EYE_DRIVE_PHONE; //开车打手机

    @FindResource(Id="electronic_eye_road_condition_monitoring", ios_name="elecEye 11")
    public static String EYE_ROAD_MONITOR; //路况监控

    @FindResource(Id="electronic_eye_non_annual_inspection", ios_name="elecEye 30")
    public static String EYE_NO_INSPECTION; //未年检

    @FindResource(Id="electronic_eye_tail_gas_exceeding_standard", ios_name="elecEye 31")
    public static String EYE_TAIL_GAS; //尾气超标

    @FindResource(Id="tv_eye_card_add_time", clazz = "android.widget.TextView", Text="增加时间", ios_name="Time_addBtn")
    public static String TIME;

    @FindResource(Id="btn_fm_confirm", ios_name="确定")
    public static String TIME_CONFIRM;

    @FindResource(Id="btn_fm_confirm", ios_ignore=true)
    public static String DELETE_CONFIRM;

    @FindResource(clazz="android.widget.ScrollView")
    public static String SCROLL;

    @FindResource(clazz="android.widget.CheckBox", Text="卡车", ios_name="运输卡车")
    public static String TRUCK;

    @FindResource(Id="electronic_eye_et_speed_limit_number", ios_name="eleceye_valueLabel")
    public static String SPEEDEDIT;
    
    @FindResource(Id="et_eye_card_time", ios_name="Time_timeTF")
    public static String TIMEEDIT;
    
    @FindResource(Id="electronic_eye_interval_start", ios_name="elecEye 20")
    public static String EYE_INTERVAL_START; //区间开始
    @FindResource(Id="electronic_eye_delete_pair", ios_name="删除配对关系")
    public static String DELETE_PAIR;

    @FindResource(Id="elec_eye_adapter_checkbox", ios_name="login checkbox")
    public static String EYE_ADAPTER_CHECKBOX;
    
    public static Page_ElecEye Inst;
    static
    {
        Inst = new Page_ElecEye();
    }

    public void SetSpeed(String value) throws InterruptedException
    {
        ClickByText(value);
    }
    
    @Override
    public void Click(String findRes) throws NoSuchFieldException, ClassNotFoundException, InterruptedException 
    {	
    	if(!findRes.startsWith("EYE_"))
    	{
    		super.Click(findRes);
    		return;
    	}
    	
    	super.Click(TYPE_MORE);
    	super.Click(findRes);
    	super.Click(TYPE_RETURN);
    	
    }
}

