package com.fastmap.ui;

import com.fang.testAdapter.*;

/**
 * 测量数据页面
 */

public class Page_DistanceMeasure extends FastMapPage
{
    @FindResource(Id="tv_distance_measure_value", ios_predicate="value ENDSWITH '米'")
    public static String MEASURE_VALUE;
    
    @FindResource(Id="img_distance_measure_close", ios_name="measure close")
    public static String CLOSE;
    
    public static Page_DistanceMeasure Inst;
    static
    {
        Inst = new Page_DistanceMeasure();
    }
}
