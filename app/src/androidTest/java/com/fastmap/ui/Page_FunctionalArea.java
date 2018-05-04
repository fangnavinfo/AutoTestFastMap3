package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * Created by zhou on 18/3/14.
 * 功能面
 */

public class Page_FunctionalArea extends Page_Base_Tips
{
    @FindResource(clazz="android.widget.ScrollView")
    public static String SCROLL;

    @FindResource(Id="btn_last_step", Text="上一步")
    public static String LAST_STEP;
    @FindResource(Id="btn_repaint", Text="重绘")
    public static String REPAINT;
    @FindResource(Id="btn_complete", Text="完成")
    public static String COMPLETE;

    @FindResource(Id="rbtn_university", ios_name="gridView_function_university.png")
    public static String UNIVERSITY;
    @FindResource(Id="rbtn_shopping", ios_name="gridView_function_shopping.png")
    public static String SHOPPING;
    @FindResource(Id="rbtn_hospital", ios_name="gridView_function_hospital.png")
    public static String HOSPITAL;
    @FindResource(Id="rbtn_stadium", ios_name="gridView_function_stadium.png")
    public static String STADIUM;
    @FindResource(Id="rbtn_airport")
    public static String AIRPORT;

    @FindResource(Id="edit_name", Text="请输入名称")
    public static String NAME;

    @FindResource(clazz="android.widget.TextView", Text="名称")
    public static String NAME_STATIC;

    public static Page_FunctionalArea Inst;
    static
    {
        Inst = new Page_FunctionalArea();
    }
}
