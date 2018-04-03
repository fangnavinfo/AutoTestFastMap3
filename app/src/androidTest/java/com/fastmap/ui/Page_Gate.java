package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by h on 2018/1/29.
 */

public class Page_Gate extends Page_Base_Tips 
{
    @FindResource(Id = "gate_type_eg", Text="EG")
    public static String EG;

    @FindResource(Id = "gate_type_kg", Text="KG")
    public static String KG;

    @FindResource(Id = "gate_type_pg", Text="PG")
    public static String PG;


    @FindResource(Id = "traffic_object_car_ckb", Text = "车辆")
    public static String CAR;

    @FindResource(Id = "traffic_object_car_img", ios_xpath="(//XCUIElementTypeButton[@name=\"clock\"])[1]")
    public static String TIMECAR;

    @FindResource(Id = "traffic_object_person_ckb",Text = "行人")
    public static String PERSON;

    @FindResource(Id = "traffic_object_person_img", ios_xpath="(//XCUIElementTypeButton[@name=\"clock\"])[2]")
    public static String TIMEPERSON;

    @FindResource(Id = "traffic_object_bicycle_ckb",Text = "自行车")
    public static String BICYCLE;

    @FindResource(Id = "traffic_object_bicycle_img", ios_xpath="(//XCUIElementTypeButton[@name=\"clock\"])[3]")
    public static String TIMEBICYCLE;

    @FindResource(Id = "traffic_object_tricycle_ckb",Text = "三轮车")
    public static String TRICYCLE;

    @FindResource(Id = "traffic_object_tricycle_img", ios_xpath="(//XCUIElementTypeButton[@name=\"clock\"])[4]")
    public static String TIMETRICYCLE;

    @FindResource(Id = "checkBox_single_dir_gate", Text="单方向大门")
    public static String SINGLEGATE;

    @FindResource(Id = "card_road_direction_swap",Text = "调整箭头方向")
    public static String CHANGEDIR;

    public static Page_Gate Inst;
    static {
        Inst = new Page_Gate();
    }
}
