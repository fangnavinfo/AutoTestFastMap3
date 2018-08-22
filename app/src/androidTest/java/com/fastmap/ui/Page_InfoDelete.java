package com.fastmap.ui;

import com.fang.testAdapter.FastMapPage;
import com.fang.testAdapter.FindResource;

/**
 * Created by h on 2018/1/31.
 */

public class Page_InfoDelete extends FastMapPage
{
    @FindResource(Id="save_button", Text="保存")
    public static String SAVE;

    @FindResource(Id="cancel_button", Text="取消")
    public static String CANCEL;

    @FindResource(Text="库中已有")
    public static String EXIST;

    @FindResource(Text="现场未发生变化")
    public static String NO_CHANGE;

    @FindResource(Text="未开通")
    public static String NOT_OPEN;

    @FindResource(Text="未找到")
    public static String NOT_FIND;

    @FindResource(Text="无法到达")
    public static String CANNOT_REACH;

    @FindResource(Text="不符合采集标准")
    public static String NOT_MATCH;

    @FindResource(Text="删除复制新增")
    public static String DELETE;


    @FindResource(Id="camera_button_myselt")
    public static String CAMERA;

    public static Page_InfoDelete Inst;
    static
    {
        Inst = new Page_InfoDelete();
    }
}
