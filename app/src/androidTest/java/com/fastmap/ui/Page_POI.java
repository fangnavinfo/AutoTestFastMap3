package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by fang on 18/1/19.
 */

public class Page_POI extends FastMapPage
{
    @FindResource(Id="fm_et_name", ios_name="请输入名称")
    public static String NAME;
    @FindResource(Id="fm_et_name_alias", ios_name="请输入别名")
    public static String ALIAS_NAME;
    @FindResource(Id="fm_et_name_before", ios_name="请输入曾用名")
    public static String BEFORE_NAME;

    @FindResource(Id="img_name_alias_add")
    public static String ALIAS_ADD;
    @FindResource(Id="img_name_list_alias_del")
    public static String ALIAS_DEL;
    @FindResource(Id="img_name_before_add")
    public static String BEFORE_ADD;
    @FindResource(Id="img_name_list_before_del")
    public static String BEFORE_DEL;

    @FindResource(Id="fm_iv_name")
    public static String NAME_ICON;

    @FindResource(Id="tv_name_list_relative_station")
    public static String SUBWAY_STATION;
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
    @FindResource(Id="tv_marquee_frame_complete")
    public static String FRAME_COMPLETE;
    @FindResource(Id="cb_snap_check_list_item")
    public static String LIST_ITEM;
    @FindResource(Id="delete_button", ios_name="operate_deletelBtn")
    public static String DELETE;
    @FindResource(Id="cancel_button", ios_name="operate_cancelBtn")
    public static String CANCEL;
    @FindResource(Id="save_button", ios_name="operate_saveBtn")
    public static String SAVE;
    @FindResource(Id="tv_poi_fid_hd", Text="fid : ")
    public static String FID;

    @FindResource(Id="cb_open_24h")
    public static String H24;
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

    //充电站营业时间
    @FindResource(Id="tv_chargingStation_openHour_start", Text="有")
    public static String CHARGINGSTATION_OPEN_HOUR;
    @FindResource(Id="fm_edit_start_time", Text="请选择营业时间")
    public static String START_TIME;
    @FindResource(Id="btn_select_time")
    public static String SELECT_TIME;

    //燃油类型
    @FindResource(Id="fm_cb_diesel", Text="柴油")
    public static String DIESEL;

    @FindResource(Id="fmcard_et_charging_connectorId")
    public static String CHARGING_CONNECTOR_ID;

    @FindResource(Id="fm_iv_name")
    public static String TOTAL_NAME;

    @FindResource(Id="rbtn_poi_fine_tag_0",Text="未作业")
    public static String TAG0;
    @FindResource(Id="rbtn_poi_fine_tag_1",Text="未采集")
    public static String TAG1;
    @FindResource(Id="rbtn_poi_fine_tag_2",Text="已采集")
    public static String TAG2;
    @FindResource(Id="rbtn_poi_fine_feedback_0",Text="无")
    public static String FEEDBACK0;
    @FindResource(Id="rbtn_poi_fine_feedback_1",Text="无采集内容")
    public static String FEEDBACK1;
    @FindResource(Id="rbtn_poi_fine_feedback_2",Text="现场无法进入")
    public static String FEEDBACK2;
    @FindResource(Id="rbtn_poi_fine_feedback_3",Text="已拆除")
    public static String FEEDBACK3;
    @FindResource(Id="rbtn_poi_fine_feedback_4",Text="现场找不到")
    public static String FEEDBACK4;
    @FindResource(Id="rbtn_poi_fine_feedback_5",Text="非指定分类")
    public static String FEEDBACK5;
    @FindResource(Id="rbtn_poi_fine_feedback_6",Text="在建中，无法作业")
    public static String FEEDBACK6;
    @FindResource(Id="rbtn_poi_fine_feedback_7",Text="不符合采集标准")
    public static String FEEDBACK7;
    @FindResource(Id="rbtn_poi_fine_feedback_8",Text="其它")
    public static String FEEDBACK8;

    @FindResource(Id="cb_door_type")
    public static String DOOR;

    @FindResource(Id="img_father_pop_close")
    public static String POPCLOSE;
    @FindResource(Id="fail_name")
    public static String FAILNAME;

    @FindResource(clazz="android.widget.CheckBox", Text="交流3孔家用")
    public static String AC_3;
    @FindResource(clazz="android.widget.CheckBox", Text="国标交流7孔")
    public static String GB_7;
    @FindResource(clazz="android.widget.CheckBox", Text="国标直流9孔")
    public static String GB_9;
    @FindResource(clazz="android.widget.CheckBox", Text="特斯拉专用")
    public static String TESLA;
    @FindResource(clazz="android.widget.CheckBox", Text="其它")
    public static String OTHER;
    @FindResource(clazz="android.widget.CheckBox", Text="无法采集")
    public static String NO_COLLECT;

    //框选POI按钮
    @FindResource(Id="tv_marquee_frame_repaint")
    public static String REPAINT;
    @FindResource(Id="tv_marquee_frame_last_paint")
    public static String LAST_PAINT;
    @FindResource(Id="tv_marquee_frame_complete")
    public static String COMPLETE;

    @FindResource(Id="move_points")
    public static String MOVE_POINT;
    @FindResource(Id="move_one_point")
    public static String COMBINE_POINT;
    @FindResource(Id="auto_link")
    public static String AUTO_LINK;
    @FindResource(Id="manual_link")
    public static String MANUAL_LINK;
    @FindResource(Id="select_link")
    public static String SELECT_LINK;

    //景区等级
    @FindResource(Id="fmcard_cb_attraction_1",Text="1A")
    public static String A1;
    @FindResource(Id="fmcard_cb_attraction_2",Text="2A")
    public static String A2;
    @FindResource(Id="fmcard_cb_attraction_3",Text="3A")
    public static String A3;
    @FindResource(Id="fmcard_cb_attraction_4",Text="4A")
    public static String A4;
    @FindResource(Id="fmcard_cb_attraction_5",Text="5A")
    public static String A5;
    @FindResource(clazz="android.widget.LinearLayout")
    public static String LISTCLASS;
    @FindResource(clazz="android.widget.TextView")
    public static String TEXTVIEW;
    @FindResource(Id="img_poi_name_list_hide")
    public static String HIDE_POI_NAME;
    @FindResource(Id="fmdialog_tv_snap_point_add")
    public static String SELECTSON;

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
