package com.fastmap.ui;

import com.fang.testAdapter.FastMapPage;
import com.fang.testAdapter.FindResource;

import java.lang.reflect.Field;

public class Page_Base_Tips extends FastMapPage
{
    @FindResource(Id="et_title", ios_predicate="value MATCHES '^[0-9a-fA-F]{10,}$'")
    public static String ROWKEY;
    @FindResource(Id="tv_left_change_num_clear")
    public static String NUM_CLEAR;
    @FindResource(Id="tv_left_change_name_clear")
    public static String NAME_CLEAR;
    @FindResource(Id="delete_button", ios_name="operate_deletelBtn")
    public static String DELETE;
    @FindResource(Id="cancel_button", ios_name="operate_cancelBtn")
    public static String CANCEL;
    @FindResource(Id="save_button", ios_name="operate_saveBtn")
    public static String SAVE;
    
    @FindResource(Id="et_remark_txt", ios_name="page_multiTextCard")
    public static String REMARK;//备注

    @FindResource(Id="mic_button")
    public static String RECORD;

    @FindResource(Id="tv_time")
    public static String RECORD_TIME;

    @FindResource(Id="camera_button_myselt", ios_name="mediaOperate_photoBtn")
    public static String CAMERA;
    
    public Page_Base_Tips()
    {
        try
        {
            Field[] fields = Page_Base_Tips.class.getDeclaredFields();

            for (Field field : fields)
            {
                if (!field.isAnnotationPresent(FindResource.class))
                {
                    continue;
                }

                field.set(null, field.getName());
            }
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }

    public String GetRowKey() throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {
        String rowkey = GetValue(ROWKEY);
        rowkey = rowkey.replace("rowkey：", "").replace("rowley:", "");

        return rowkey;
    }
}
