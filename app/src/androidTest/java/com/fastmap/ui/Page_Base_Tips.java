package com.fastmap.ui;

import java.lang.reflect.Field;

import com.fang.testAdapter.*;

public class Page_Base_Tips extends FastMapPage
{
    @FindResource(Id="et_title", ios_predicate="value MATCHES '^[0-9a-fA-F]{10,}$'")
    public static String ROWKEY;
    
    @FindResource(Id="delete_button", ios_name="operate_deletelBtn")
    public static String DELETE;
    @FindResource(Id="cancel_button", ios_name="operate_cancelBtn")
    public static String CANCEL;
    @FindResource(Id="save_button", ios_name="operate_saveBtn")
    public static String SAVE;
    
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
