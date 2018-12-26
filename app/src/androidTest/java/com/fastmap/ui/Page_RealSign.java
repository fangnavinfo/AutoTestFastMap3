package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * Created by h on 2018/8/8.
 */

public class Page_RealSign extends Page_Base_Tips
{

    public static Page_RealSign Inst;

    @FindResource(Id="direction_board_copy")
    public static String COPY;
    @FindResource(Id="direction_board_paste")
    public static String PASTE;

    static
    {
        Inst = new Page_RealSign();
    }
}
