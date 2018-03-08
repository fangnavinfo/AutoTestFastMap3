package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * 测线
 * Created by fang on 18/1/19.
 */
public class Page_SurveyLine extends FastMapPage
{
    @FindResource(Id="card_high_speed", ios_xpath="//XCUIElementTypeButton[@name=\"k1\"]")
    public static String HIGH_SPEED;

    @FindResource(Id="card_city_high_speed", ios_xpath="//XCUIElementTypeButton[@name=\"k2\"]")
    public static String CITY_HIGH_SPEED;

    @FindResource(Id="card_national_rd", ios_xpath="//XCUIElementTypeButton[@name=\"k3\"]")
    public static String NATIONAL_RD;

    @FindResource(Id="card_provincial_rd", ios_xpath="//XCUIElementTypeButton[@name=\"k4\"]")
    public static String PROVINCIAL_RD; //省道

    @FindResource(Id="card_county_rd", ios_xpath="//XCUIElementTypeButton[@name=\"k6\"]")
    public static String COUNTY_RD; //省道
    
    @FindResource(Id="card_other_rd", ios_xpath="//XCUIElementTypeButton[@name=\"k8\"]")
    public static String OTHER_RD;  //其他道路
    
    @FindResource(Id="card_nine_rd", ios_xpath="//XCUIElementTypeButton[@name=\"k9\"]")
    public static String NINE_RD;  //9级辅路

    @FindResource(Id="card_pedestrian_rd", ios_xpath="//XCUIElementTypeButton[@name=\"k10\"]")
    public static String PEDESTRIAN_RD;  //行人道路
    
    @FindResource(Id="card_people_crossing", ios_xpath="//XCUIElementTypeButton[@name=\"k11\"]")
    public static String PEOPLE_CROSS_RD; //人渡
    
    @FindResource(Id="card_ferry", ios_xpath="//XCUIElementTypeButton[@name=\"k13\"]")
    public static String FERRY_RD; //轮渡
    
    @FindResource(Id="lane_num_1", ios_xpath="//XCUIElementTypeButton[@name=\"lane num 1\"]")
    public static String LANE_NUM_1; //1车道

    @FindResource(Id="lane_num_2", ios_xpath="//XCUIElementTypeButton[@name=\"lane num 2\"]")
    public static String LANE_NUM_2;

    @FindResource(Id="delete_button", ios_xpath="//XCUIElementTypeButton[@name=\"删除\"]")
    public static String DELETE;
    @FindResource(Id="save_button", ios_xpath="//XCUIElementTypeButton[@name=\"保存\"]")
    public static String SAVE;

    public static Page_SurveyLine Inst;
    static
    {
        Inst = new Page_SurveyLine();
    }
}