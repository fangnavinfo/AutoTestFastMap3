package com.fastmap.ui;

import android.support.test.uiautomator.StaleObjectException;

import com.fang.testAdapter.*;

/**
 * Created by fang on 18/1/19.
 */

public class Page_POI extends FastMapPage
{
    @FindResource(Id="fm_et_name", ios_xpath="//XCUIElementTypeStaticText[@name=\"请输入名称\"]")
    public static String NAME;

    @FindResource(Id="tv_assort_type", Text="请选择分类", ios_xpath="//XCUIElementTypeStaticText[@name=\"请选择类别\"]")
    public static String SELECT_TYPE;
    @FindResource(Id="tv_poi_brand", Text="请选择品牌")
    public static String SELECT_BRAND;

    @FindResource(Id="filter_edit", Text="请输入搜索内容")
    public static String SEARCH_BRAND;
    @FindResource(Id="tv_city_name", ios_x = 430, ios_y=108)
    public static String SEARCH_BRAND_RESULT;

    @FindResource(Id="tv_poi_father", ios_xpath="//XCUIElementTypeApplication[@name=\"FastMap-18夏\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[4]/XCUIElementTypeOther[3]")
    public static String POI_FATHER;
    @FindResource(Id="tv_poi_same_one", Text="同一关系")
    public static String POI_SAME;

    @FindResource(Id="delete_button", Text="删除")
    public static String DELETE;
    @FindResource(Id="cancel_button", Text="取消")
    public static String CANCEL;
    @FindResource(Id="save_button", Text="保存", ios_xpath="//XCUIElementTypeButton[@name=\"保存\"]")
    public static String SAVE;
    @FindResource(Id="tv_poi_fid_hd", ios_predicate="value BEGINSWITH 'fid'")
    public static String FID;

    @FindResource(Id="et_kind_search", Text="请输入搜索内容", ios_xpath="//XCUIElementTypeSearchField[@name=\"请输入分类名或kindCode\"]")
    public static String SEARCH_TYPE;

    @FindResource(Id="top_name_txtinfo",  ios_x=384, ios_y=108)
    public static String SEARCH_TYPE_RESULT;

    @FindResource(Id="edt_contactItem_telNum", ios_xpath="//XCUIElementTypeApplication[@name=\"FastMap-18夏\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeTextField[2]")
    public static String TEL;

    @FindResource(Id="camera_button")
    public static String CAMERA;

    @FindResource(clazz="android.widget.CheckBox", Text="人行门")
    public static String PERSION_GATE;

    @FindResource(clazz="android.widget.ScrollView")
    public static String SCROLL;

    @FindResource(Id="iv_photo_list2")
    public static String PICTURE;

    public static Page_POI Inst;
    static
    {
        Inst = new Page_POI();
    }

    public void SetValue(String findRes, String value) throws NoSuchFieldException, ClassNotFoundException, InterruptedException
    {

        try{
            if (findRes.equals(SELECT_TYPE))
            {
                Click(SELECT_TYPE);
                super.SetValue(SEARCH_TYPE, value);

                Thread.sleep(1000);

                Click(SEARCH_TYPE_RESULT);
                return;
            }

        }catch (StaleObjectException e) {
            Thread.sleep(10000);

            Click(SEARCH_TYPE_RESULT);
            return;
        }



        if (findRes.equals(SELECT_BRAND))
        {
            Click(SELECT_BRAND);
            super.SetValue(SEARCH_BRAND, value);
            Click(SEARCH_BRAND_RESULT);

            return;
        }

        if (findRes.equals(POI_FATHER))
        {
            SelectFather(value);
            return;
        }

        if (findRes.equals(POI_SAME))
        {
            SelectSame(value);
            return;
        }

        super.SetValue(findRes, value);
    }

    public void DeleteFather(String father) throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {
        Page_POI.Inst.ClickbyText(father);
        Page_POI.Inst.ClickbyText("删除父子关系");
        Page_POI.Inst.ClickbyText("是", "确定");
        Page_POI.Inst.Click(Page_POI.SAVE);

    }

    private void SelectFather(String name) throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {
        Click(Page_POI.POI_FATHER);
        ClickByText(name);
    }

    private void SelectSame(String name) throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {
        Click(Page_POI.POI_SAME);
        ClickByText(name);
    }

}
