package com.fastmap.ui;

import com.fang.testAdapter.*;


/**
 * Created by fang on 18/1/26.
 */
public class Page_Login extends FastMapPage
{
    @FindResource(Id="login_account_et", ios_xpath="//XCUIElementTypeApplication[@name=\"FastMap-18夏\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeTextField[1]")
    public static String USER_NAME;

    @FindResource(Id="login_pswd_et", ios_xpath="//XCUIElementTypeApplication[@name=\"FastMap-18夏\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeSecureTextField")
    public static String USER_PASSWD;

    @FindResource(Id="login_car_num_et")
    public static String CAR_NUM;

    @FindResource(Id="login_btn", ios_xpath="//XCUIElementTypeButton[@name=\"登    录\"]")
    public static String LOGIN_BTN;

    @FindResource(Id="camera_button")
    public static String SERVER_BTN;

    @FindResource(Id="camera_button")
    public static String DEVELOP_SERV;

    @FindResource(Id="chk_work_area_type", ios_xpath="//XCUIElementTypeButton[@name=\"港澳作业\"]")
    public static String HKM_RADIO; //选择港澳服务器

    public static Page_Login Inst;
    static
    {
        Inst = new Page_Login();
    }

    public static void SelectHKM() throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {
        if(!Inst.isChecked(HKM_RADIO))
        {
            Inst.Click(HKM_RADIO);
        }
    }
}
