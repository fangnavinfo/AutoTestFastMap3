package com.fastmap.ui;

import com.fang.testAdapter.FastMapPage;
import com.fang.testAdapter.FindResource;

/**
 * Created by zhou on 18/3/14.
 * 功能面
 */

public class Page_FunctionalArea extends FastMapPage
{
    @FindResource(clazz="android.widget.ScrollView")
    public static String SCROLL;

    @FindResource(Id="delete_button", Text="删除")
    public static String DELETE;
    @FindResource(Id="cancel_button", Text="取消")
    public static String CANCEL;
    @FindResource(Id="save_button", Text="保存")
    public static String SAVE;


    @FindResource(Id="btn_last_step", Text="上一步")
    public static String LAST_STEP;
    @FindResource(Id="btn_repaint", Text="重绘")
    public static String REPAINT;
    @FindResource(Id="btn_complete", Text="完成")
    public static String COMPLETE;

    @FindResource(Id="rbtn_university")
    public static String UNIVERSITY;
    @FindResource(Id="rbtn_shopping")
    public static String SHOPPING;
    @FindResource(Id="rbtn_hospital")
    public static String HOSPITAL;
    @FindResource(Id="rbtn_stadium")
    public static String STADIUM;

    @FindResource(Id="edit_name")
    public static String NAME;


    public static Page_FunctionalArea Inst;
    static
    {
        Inst = new Page_FunctionalArea();
    }
}
