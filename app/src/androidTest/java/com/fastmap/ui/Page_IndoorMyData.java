package com.fastmap.ui;
import com.fang.testAdapter.FastMapPage;
import com.fang.testAdapter.FindResource;

import junit.framework.Assert;

/**
 * Created by fang on 18/1/22.
 */
public class Page_IndoorMyData extends FastMapPage
{
    @FindResource(Id="iv_my_data_back", ios_name="icon user back nor")
    public static String BACK;

    @FindResource(Id="img_indoor_my_data_snap_list_item_qc")
    public static String QC_LIST_ITEM_ICON;

    @FindResource(Id="v_indoor_my_data_snap_list_item_type")
    public static String QC_LIST_ITEM_TYPE;
    
    @FindResource(Id="btn_check", ios_name="开始检查")
    public static String START_CHECK;
    
    @FindResource(Id="progress_btn_positive", ios_name="确定")
    public static String CHECK_CONFIRM;
    @FindResource(Id="list")
    public static String LIST;
    @FindResource(Id="iv_indoor_check_back", ios_name="icon user back nor")
    public static String CHECK_RESULT_BACK;

    @FindResource(Id="img_indoor_mydata_filter", ios_name="indoor filter")
    public static String FILTER;

    @FindResource(Id="btn_fm_confirm", ios_xpath="(//XCUIElementTypeButton[@name=\"确认\"])[2]")
    public static String CONFIRM;

    @FindResource(Id="edt_indoor_mydata_filter_type", ios_xpath="//XCUIElementTypeApplication[@name=\"FastMap-18秋\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField")
    public static String FILTER_EDTOR;

    @FindResource(Id="btn_indoor_mode")
    public static String INDOOR_MODE;
    @FindResource(Id="rb_screen_mode_one")
    public static String INDOOR_MODE_ONE;
    public static Page_IndoorMyData Inst;
    static
    {
        Inst = new Page_IndoorMyData();
    }
    
    public void CheckQcDataExist(String name) throws NoSuchFieldException
    {
    	Assert.assertTrue(isExistByName(name, null));
    }

	public void CheckResultExit(String type, String level, String rule, String error, String severity) 
	{
		Assert.assertTrue(isExistByName(rule, null));
	}

	public void SelectResult(String rule) throws InterruptedException 
	{
		ClickByText(rule);
	}

	public void CheckResultNotExit(String rule) 
	{
		Assert.assertFalse(isExistByName(rule, null));
		
	}
}
