package com.fastmap.ui;
import com.fang.testAdapter.*;
/**
 * Created by zhou on 18/1/24.
 * 删除列表
 */

public class Page_DeleteList extends FastMapPage
{
    @FindResource(Id="tv_del_cancel_list", Text="取消")
    public static String CANCEL;

    @FindResource(Id="delete_tips_list_item_delete_button", ios_xpath="(//XCUIElementTypeStaticText[@name=\"删除\"])[1]")
    public static String DELETE;


    public static Page_DeleteList Inst;
    static
    {
        Inst = new Page_DeleteList();
    }

}
