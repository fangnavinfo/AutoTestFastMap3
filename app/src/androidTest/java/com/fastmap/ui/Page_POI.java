package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by fang on 18/1/19.
 */

public class Page_POI extends FastMapPage
{
    @FindResource(Id="fm_et_name", ios_name="请输入名称")
    public static String NAME;

    @FindResource(Id="tv_assort_type", Text="请选择分类", ios_name="请选择类别")
    public static String SELECT_TYPE;
    @FindResource(Id="tv_poi_brand", Text="请选择品牌")
    public static String SELECT_BRAND;

    @FindResource(Id="fm_et_post_code_txt", ios_name="postcode")
    public static String POST_CODE;

    @FindResource(Id="img_post_code", ios_name="poiCore_postCode")
    public static String IMA_POST_CODE;

    @FindResource(Id="filter_edit", Text="请输入搜索内容")
    public static String SEARCH_BRAND;
    @FindResource(Id="tv_city_name", ios_x = 430, ios_y=108)
    public static String SEARCH_BRAND_RESULT;

    @FindResource(Id="tv_poi_father", ios_xpath="//XCUIElementTypeApplication[@name=\"FastMap-18秋\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[4]/XCUIElementTypeOther[3]")
    public static String POI_FATHER;
    @FindResource(Id="tv_poi_same_one", Text="同一关系")
    public static String POI_SAME;
    @FindResource(Id="tv_truck", Text="非卡车")
    public static String POI_TRUCK;
    @FindResource(Id="tv_poi_remark", Text="标记字段")
    public static String POI_REMARK;

    @FindResource(Id="delete_button", ios_name="operate_deletelBtn")
    public static String DELETE;
    @FindResource(Id="cancel_button", ios_name="operate_cancelBtn")
    public static String CANCEL;
    @FindResource(Id="save_button", ios_name="operate_saveBtn")
    public static String SAVE;
    @FindResource(Id="tv_poi_fid_hd", Text="fid : ")
    public static String FID;

    @FindResource(Id="et_kind_search", Text="请输入搜索内容", ios_name="请输入分类名或kindCode")
    public static String SEARCH_TYPE;

    @FindResource(Id="top_name_txtinfo",  ios_x=384, ios_y=108)
    public static String SEARCH_TYPE_RESULT;

    @FindResource(Id="edt_contactItem_telNum", ios_xpath="//XCUIElementTypeApplication[@name=\"FastMap-18秋\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeTextField[2]")
    public static String TEL;

    @FindResource(Id="camera_button_myselt", ios_name="mediaOperate_photoBtn")
    public static String CAMERA;

    @FindResource(clazz="android.widget.CheckBox", Text="人行门")
    public static String PERSION_GATE;

    @FindResource(clazz="android.widget.ScrollView", ios_x=740, ios_y=314)
    public static String SCROLL;

    @FindResource(Id="photo_tv_edit", ios_name="编辑")
    public static String PICTURE;

    @FindResource(clazz="android.widget.TextView", Text = "多媒体")
    public static String MULIT_MEDIA;

    //充电枪
    @FindResource(Id="rbtn_charge_stake_gun_0", Text="有")
    public static String CHARGE_GUN;
    @FindResource(Id="rbtn_charge_stake_gun_1", Text="无")
    public static String NO_CHARGE_GUN;

    //停车管理
    @FindResource(Id="rbtn_chargingStation_park_manager_no", Text="无")
    public static String CHARGE_PARKING_NO;
    @FindResource(Id="rbtn_chargingStation_park_manager_yes", Text="有")
    public static String CHARGE_PARKING_YES;

    //指示牌
    @FindResource(Id="rbtn_chargingStation_park_signboard_no", Text="无")
    public static String CHARGE_SIGNBOARD_NO;
    @FindResource(Id="rbtn_chargingStation_park_signboard_yes", Text="有")
    public static String CHARGE_SIGNBOARD_YES;


    @FindResource(Id="fmcard_et_charging_connectorId")
    public static String CHARGING_CONNECTOR_ID;

    @FindResource(Id="fm_iv_name")
    public static String TOTAL_NAME;
    public static Page_POI Inst;
    static
    {
        Inst = new Page_POI();
    }

    public void SetValue(String findRes, String value) throws NoSuchFieldException, ClassNotFoundException, InterruptedException
    {
    	if (findRes.equals(SELECT_TYPE))
    	{
        	Click(SELECT_TYPE);
        	super.SetValue(SEARCH_TYPE, value);
        	
        	Thread.sleep(1000);
        	Click(SEARCH_TYPE_RESULT);
        	return;    		
    	}

        if (findRes.equals(SELECT_BRAND))
        {
            Click(SELECT_BRAND);
            super.SetValue(SEARCH_BRAND, value);
            Click(SEARCH_BRAND_RESULT);

            return;
        }

        if (findRes.equals(POI_FATHER))
        {
            SelectFather(value);
            return;
        }

        if (findRes.equals(POI_SAME))
        {
            SelectSame(value);
            return;
        }

        if (findRes.equals(POI_TRUCK))
        {
            SelectTruckType(value);
            return;
        }

        if (findRes.equals(POI_REMARK))
        {
            SelectRemarkType(value);
            return;
        }

        super.SetValue(findRes, value);
    }

    public void DeleteFather(String father) throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {
        Page_POI.Inst.ClickbyText(father);
        Page_POI.Inst.ClickbyText("删除父子关系");
        Page_POI.Inst.ClickbyText("是", "确定");
        Page_POI.Inst.Click(Page_POI.SAVE);

    }

    private void SelectFather(String name) throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {
        Click(Page_POI.POI_FATHER);
        ClickByText(name);
    }

    private void SelectSame(String name) throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {
        Click(Page_POI.POI_SAME);
        ClickByText(name);
    }
    private void SelectTruckType(String name) throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {
        Click(Page_POI.POI_TRUCK);
        ClickByText(name);
        ClickByText("确定");
    }
    private void SelectRemarkType(String name) throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {
        Click(Page_POI.POI_REMARK);
        ClickByText(name);
        ClickByText("确定");
    }

}
