package com.fastmap.ui;

import com.fang.testAdapter.FastMapPage;
import com.fang.testAdapter.FindResource;

/**
 * 方向看板
 * Created by fang on 18/2/7.
 */
public class Page_DirectionBoard extends FastMapPage
{
    @FindResource(Id="save_button", ios_xpath="//XCUIElementTypeButton[@name=\"保存\"]")
    public static String SAVE;

    @FindResource(Id="delete_button", ios_xpath="//XCUIElementTypeButton[@name=\"删除\"]")
    public static String DELETE;

    @FindResource(Id="btn_fm_confirm", ios_ignore=true)
    public static String CONFIRM;

    @FindResource(Id="cancel_button", ios_xpath="//XCUIElementTypeButton[@name=\"取消\"]")
    public static String CANNCLE;
    
    @FindResource(Id="camera_button", ios_xpath="//XCUIElementTypeButton[@name=\"photo icon\"]")
    public static String CAMERA;
    
    public static Page_DirectionBoard Inst;
    static
    {
        Inst = new Page_DirectionBoard();
    }
}
