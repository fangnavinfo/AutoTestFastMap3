package com.fastmap.ui;

import com.fang.testAdapter.*;


/**
 * 质检问题填写界面
 * Created by fang on 18/1/22.
 */
public class Page_QCProblem extends FastMapPage
{

    @FindResource(Id="btn_save_data_check", ios_xpath="//XCUIElementTypeButton[@name=\"确定\"]")
    public static String SAVE;

    @FindResource(Id="btn_save_data_check", ios_xpath="//XCUIElementTypeButton[@name=\"错误\"]")
    public static String PROB_ERROR;
    
    public void SelectError(String error) throws InterruptedException
    {
    	ClickbyText(error);
    }

    public static Page_QCProblem Inst;
    static
    {
        Inst = new Page_QCProblem();
    }
}
