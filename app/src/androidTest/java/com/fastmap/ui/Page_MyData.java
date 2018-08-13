package com.fastmap.ui;

import com.fang.testAdapter.FastMapPage;
import com.fang.testAdapter.FindResource;

import junit.framework.Assert;

/**
 * Created by fang on 18/1/19.
 */
public class Page_MyData extends FastMapPage
{
    @FindResource(Id="tv_my_data_condition_1", ios_x=0, ios_y=75)
    public static String SELECT_DATA_TYPE;

    @FindResource(Id="rb_condition_poi", ios_name="POI数据")
    public static String POI_TYPE;

    @FindResource(Id="rb_condition_tips", ios_name="Tips数据")
    public static String TIPS_TYPE;

    @FindResource(Id="rb_condition_pas", ios_name="点门牌")
    public static String PAS_TYPE;

    @FindResource(Id="rb_condition_live_information", ios_name="自采集情报")
    public static String INFO_TYPE;

    @FindResource(Id="rb_condition_third_data")
    public static String THIRD_TYPE;

    @FindResource(Id="tv_condition_confirm_hd", ios_name="确定")
    public static String SELECT_CONFIRM;

    @FindResource(Id="iv_my_data_back", ios_name="white arrow")
    public static String BACK;

    @FindResource(Id="tv_my_data_snap_list_item_index")
    public static String INDEX;
    public static Page_MyData Inst;
    static
    {
        Inst = new Page_MyData();
    }

    public void CheckVaild(String type, String name, String ios_name) throws NoSuchFieldException, ClassNotFoundException, InterruptedException {
        if(!type.equals(TIPS_TYPE))
        {
        	Click(SELECT_DATA_TYPE);
            Click(type);
            Click(SELECT_CONFIRM);
        }
        //AssertExistByName(name);
        Assert.assertTrue(isExistByName(name, ios_name));
        //assertNotNull(mDevice.wait(Until.findObject(By.text(name)), 500));
    }

	public void CheckNotExist(String type, String name) throws NoSuchFieldException, ClassNotFoundException, InterruptedException
    {
        if(!type.equals(TIPS_TYPE))
        {
	        Click(SELECT_DATA_TYPE);
	        Click(type);
	        Click(SELECT_CONFIRM);
        }

        int Count = 0;
        while (isExistByName(name, null))
        {
            if(Count++ == 5)
            {
                Assert.fail(name + " still exist");
            }
            Thread.sleep(1000);
        }

        
        //assertNull(mDevice.wait(Until.findObject(By.text(name)), 500));
    }

    public void SelectData(String name, String ios_name) throws InterruptedException
    {
        ClickByText(name, ios_name);
    }
    
    public void SelectData(String name) throws InterruptedException
    {
        ClickByText(name);
    }
}