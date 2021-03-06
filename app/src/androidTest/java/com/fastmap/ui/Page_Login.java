package com.fastmap.ui;

import com.fang.testAdapter.*;


/**
 * Created by fang on 18/1/26.
 */
public class Page_Login extends FastMapPage
{
    @FindResource(Id="login_account_et", ios_name="login_UserTF")
    public static String USER_NAME;

    @FindResource(Id="login_pswd_et", ios_name="login_pwdTF")
    public static String USER_PASSWD;

    @FindResource(Id="login_car_num_et", ios_name="login_carNumTF")
    public static String CAR_NUM;

    @FindResource(Id="login_btn", ios_name="login_loginBtn")
    public static String LOGIN_BTN;

    @FindResource(Id="camera_button")
    public static String SERVER_BTN;

    @FindResource(Id="camera_button")
    public static String DEVELOP_SERV;

    @FindResource(Id="chk_work_area_type", ios_name="login_wtBtn")
    public static String HKM_RADIO; //选择港澳服务器
    
    @FindResource(Id="chk_enter_car_mode", ios_name="login_collectBtn")
    public static String CAR_MODE_RADIO; //车采模式

    @FindResource(Id="chk_work_area_type", ios_predicate="value CONTAINS 'http:'")
    public static String SERVER; //选择港澳服务器
    
    public static Page_Login Inst;
    static
    {
        Inst = new Page_Login();
    }

    public static void SelectHKM() throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {
        if (!Inst.isChecked(HKM_RADIO))
        {
            Inst.Click(HKM_RADIO);
        }
    }


    public static void NoSelectHKM() throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {
        if(Inst.isChecked(HKM_RADIO))
        {
            Inst.Click(HKM_RADIO);
        }
    }
}
