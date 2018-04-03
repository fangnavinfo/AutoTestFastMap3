package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * 测线
 * Created by fang on 18/1/19.
 */
public class Page_SurveyLine extends Page_Base_Tips
{
    @FindResource(Id="card_high_speed", ios_xpath="//XCUIElementTypeButton[@name=\"gridView_k1.png\"]")
    public static String HIGH_SPEED;

    @FindResource(Id="card_city_high_speed", ios_xpath="//XCUIElementTypeButton[@name=\"gridView_k2.png\"]")
    public static String CITY_HIGH_SPEED;

    @FindResource(Id="card_national_rd", ios_xpath="//XCUIElementTypeButton[@name=\"gridView_k3.png\"]")
    public static String NATIONAL_RD;

    @FindResource(Id="card_provincial_rd", ios_xpath="//XCUIElementTypeButton[@name=\"gridView_k4.png\"]")
    public static String PROVINCIAL_RD; //省道

    @FindResource(Id="card_county_rd", ios_xpath="//XCUIElementTypeButton[@name=\"gridView_k6.png\"]")
    public static String COUNTY_RD; //省道
    
    @FindResource(Id="card_other_rd", ios_xpath="//XCUIElementTypeButton[@name=\"gridView_k8.png\"]")
    public static String OTHER_RD;  //其他道路
    
    @FindResource(Id="card_nine_rd", ios_xpath="//XCUIElementTypeButton[@name=\"gridView_k9.png\"]")
    public static String NINE_RD;  //9级辅路

    @FindResource(Id="card_pedestrian_rd", ios_xpath="//XCUIElementTypeButton[@name=\"gridView_k10.png\"]")
    public static String PEDESTRIAN_RD;  //行人道路
    
    @FindResource(Id="card_people_crossing", ios_xpath="//XCUIElementTypeButton[@name=\"gridView_k11.png\"]")
    public static String PEOPLE_CROSS_RD; //人渡
    
    @FindResource(Id="card_ferry", ios_xpath="//XCUIElementTypeButton[@name=\"gridView_k13.png\"]")
    public static String FERRY_RD; //轮渡
    
    @FindResource(Id="lane_num_1", ios_xpath="//XCUIElementTypeButton[@name=\"gridView_lane_num_1.png\"]")
    public static String LANE_NUM_1; //1车道

    @FindResource(Id="lane_num_2", ios_xpath="//XCUIElementTypeButton[@name=\"gridView_lane_num_2.png\"]")
    public static String LANE_NUM_2;

    @FindResource(clazz = "android.widget.Button", Text="测线修形")
    public static String EDIT_SHAPE;

    @FindResource(clazz="android.widget.ScrollView")
    public static String SCROLL;

    public static Page_SurveyLine Inst;
    static
    {
        Inst = new Page_SurveyLine();
    }
}