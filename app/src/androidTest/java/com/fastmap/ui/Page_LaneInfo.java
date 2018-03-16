package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * Created by fang on 18/1/19.
 */

public class Page_LaneInfo extends FastMapPage
{


    @FindResource(Id="delete_button", Text="删除")
    public static String DELETE;
    @FindResource(Id="cancel_button", Text="取消")
    public static String CANCEL;
    @FindResource(Id="save_button", Text="保存")
    public static String SAVE;
    @FindResource(Id="tv_poi_fid_hd")
    public static String FID;

    @FindResource(Id="et_kind_search", Text="请输入搜索内容")
    public static String SEARCH_TYPE;

    @FindResource(Id="top_name_txtinfo")
    public static String SEARCH_TYPE_RESULT;

    @FindResource(Id="edt_contactItem_telNum")
    public static String TEL;

    @FindResource(Id="camera_button")
    public static String CAMERA;

    //单车道
    @FindResource(Id="rb_select_one_d", ios_xpath="//XCUIElementTypeButton[@name=\"1301 d\"]")
    public static String D;
    @FindResource(Id="rb_select_one_b", ios_xpath="//XCUIElementTypeButton[@name=\"1301 b\"]")
    public static String B;
    @FindResource(Id="rb_select_one_a", ios_xpath="//XCUIElementTypeButton[@name=\"1301 a\"]")
    public static String A;
    @FindResource(Id="rb_select_one_c", ios_xpath="//XCUIElementTypeButton[@name=\"1301 c\"]")
    public static String C;
    @FindResource(Id="rb_select_six_r", ios_xpath="//XCUIElementTypeButton[@name=\"1301 r\"]")
    public static String R;
    @FindResource(Id="rb_select_six_s", ios_xpath="//XCUIElementTypeButton[@name=\"1301 s\"]")
    public static String S;
    @FindResource(Id="rb_select_six_t", ios_xpath="//XCUIElementTypeButton[@name=\"1301 t\"]")
    public static String T;
    @FindResource(Id="rb_select_six_x", ios_xpath="//XCUIElementTypeButton[@name=\"1301 x\"]")
    public static String X;
    @FindResource(Id="rb_select_seven_u", ios_xpath="//XCUIElementTypeButton[@name=\"1301 u\"]")
    public static String U;
    @FindResource(Id="rb_select_seven_z", ios_xpath="//XCUIElementTypeButton[@name=\"1301 z\"]")
    public static String Z;
    @FindResource(Id="rb_select_seven_w", ios_xpath="//XCUIElementTypeButton[@name=\"1301 w\"]")
    public static String W;
    @FindResource(Id="rb_select_seven_0", ios_xpath="//XCUIElementTypeButton[@name=\"1301 0\"]")
    public static String ZERO;
    @FindResource(Id="rb_select_eight_v", ios_xpath="//XCUIElementTypeButton[@name=\"1301 v\"]")
    public static String V;
    @FindResource(Id="rb_select_eight_y", ios_xpath="//XCUIElementTypeButton[@name=\"1301 y\"]")
    public static String Y;
    @FindResource(Id="rb_select_eight_2", ios_xpath="//XCUIElementTypeButton[@name=\"1301 2\"]")
    public static String TWO;
    @FindResource(Id="rb_select_eight_5", ios_xpath="//XCUIElementTypeButton[@name=\"1301 5\"]")
    public static String FIVE;
    @FindResource(Id="rb_select_eight_3", ios_xpath="//XCUIElementTypeButton[@name=\"1301 3\"]")
    public static String THREE;
    @FindResource(Id="rb_select_eight_4", ios_xpath="//XCUIElementTypeButton[@name=\"1301 4\"]")
    public static String FOUR;
    @FindResource(Id="rb_select_eight_1", ios_xpath="//XCUIElementTypeButton[@name=\"1301 1\"]")
    public static String ONE;

    @FindResource(Id="ll_bg_select_more",Text="更多")
    public static String MORE;

    //三车道
    @FindResource(Id="rb_select_one_b_a_c", ios_predicate="name == '3 0'")
    public static String ONE_B_A_C;
    @FindResource(Id="rb_select_one_g_a_f", ios_predicate="name == '3 1'")
    public static String ONE_G_A_F;

    @FindResource(Id = "iv_dri", ios_xpath = "//XCUIElementTypeButton[@name=\"close blue\"]")
    public static String DRI;

    @FindResource(Id="tv_add", Text="附加")
    public static String APPEND;

    public static Page_LaneInfo Inst;
    static
    {
        Inst = new Page_LaneInfo();
    }
}
