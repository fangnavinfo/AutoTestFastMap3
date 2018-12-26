package com.fastmap.ui;

import com.fang.testAdapter.FastMapPage;
import com.fang.testAdapter.FindResource;

/**
 * 方向看板
 * Created by fang on 18/2/7.
 */
public class Page_DirectionBoard extends Page_Base_Tips
{
    @FindResource(Id="btn_fm_confirm", ios_ignore=true)
    public static String CONFIRM;

    @FindResource(Id="direction_board_copy")
    public static String COPY;
    @FindResource(Id="direction_board_paste")
    public static String PASTE;

    public static Page_DirectionBoard Inst;
    static
    {
        Inst = new Page_DirectionBoard();
    }
}
