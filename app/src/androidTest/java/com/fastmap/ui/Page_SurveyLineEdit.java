package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * 修形测线
 * Created by fang on 18/3/14.
 */
public class Page_SurveyLineEdit extends FastMapPage
{
    @FindResource(Id="tv_complete", ios_xpath="//XCUIElementTypeButton[@name=\"保存\"]")
    public static String SAVE;

    public static Page_SurveyLineEdit Inst;
    static
    {
        Inst = new Page_SurveyLineEdit();
    }
}
