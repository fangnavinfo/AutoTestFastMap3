package com.fastmap.ui;

import junit.framework.Assert;

import com.fang.testAdapter.*;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by fang on 18/1/19.
 */
public class Page_MyData extends FastMapPage
{
    @FindResource(Id="tv_my_data_condition_1", ios_x=0, ios_y=75)
    public static String SELECT_DATA_TYPE;

    @FindResource(Id="rb_condition_poi", ios_xpath="//XCUIElementTypeStaticText[@name=\"POI数据\"]")
    public static String POI_TYPE;

    @FindResource(Id="rb_condition_tips", ios_xpath="//XCUIElementTypeStaticText[@name=\"Tips数据\"]")
    public static String TIPS_TYPE;

    @FindResource(Id="rb_condition_pas", ios_xpath="//XCUIElementTypeStaticText[@name=\"点门牌\"]")
    public static String PAS_TYPE;

    @FindResource(Id="rb_condition_live_information", ios_xpath="//XCUIElementTypeStaticText[@name=\"自采集情报\"]")
    public static String INFO_TYPE;

    @FindResource(Id="tv_condition_confirm_hd", ios_xpath="//XCUIElementTypeButton[@name=\"确定\"]")
    public static String SELECT_CONFIRM;

    @FindResource(Id="iv_my_data_back", ios_xpath="//XCUIElementTypeButton[@name=\"white arrow\"]")
    public static String BACK;

    public static Page_MyData Inst;
    static
    {
        Inst = new Page_MyData();
    }

    public void CheckVaild(String type, String name, String ios_name) throws NoSuchFieldException, ClassNotFoundException, InterruptedException {
        Click(SELECT_DATA_TYPE);
        Click(type);
        Click(SELECT_CONFIRM);

        //AssertExistByName(name);
        Assert.assertTrue(isExistByName(name, ios_name));
        //assertNotNull(mDevice.wait(Until.findObject(By.text(name)), 500));
    }

	public void CheckNotExist(String type, String name) throws NoSuchFieldException, ClassNotFoundException, InterruptedException
    {
        Click(SELECT_DATA_TYPE);
        Click(type);
        Click(SELECT_CONFIRM);

        Assert.assertFalse(isExistByName(name, null));
        
        //assertNull(mDevice.wait(Until.findObject(By.text(name)), 500));
    }

    public void SelectData(String name, String ios_name) throws InterruptedException
    {
        //ClickByText(name, ios_name);
    }
    
    public void SelectData(String name) throws InterruptedException
    {
        ClickByText(name);
    }
}