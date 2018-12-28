package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * HOV车道
 * Created by zhou on 18/12/27.
 */
public class Page_HovLine extends Page_Base_Tips
{
    @FindResource(Id="ck_move_point_or_line")
    public static String MOVE;

    @FindResource(Id = "only_button")
    public static String CHOOSE_END;

    @FindResource(Id="hov_card_time_edit")
    public static String TIME;

    @FindResource(Id="hov_card_add_time")
    public static String ADD_TIME;

    @FindResource(Id="hov_car_type_1")
    public static String KECHE;

    @FindResource(Id="hov_car_type_4")
    public static String JIJIUCHE;

    @FindResource(Id="hov_car_type_6")
    public static String GONGJIAOCHE;

    @FindResource(Id="hov_car_type_2")
    public static String PEISONGKACHE;

    @FindResource(Id="hov_car_type_3")
    public static String YUNSHUKACHE;

    @FindResource(Id="hov_car_type_5")
    public static String CHUZUCHE;

    @FindResource(Id="hov_min_edit")
    public static String MIN_TOTAL;

    @FindResource(Id="hov_max_edit")
    public static String MAX_TOTAL;

    @FindResource(Id="hov_fuel_type_1")
    public static String QIYOU;

    @FindResource(Id="hov_fuel_type_2")
    public static String DIANDONG;

    @FindResource(Id="hov_fuel_type_3")
    public static String YOUDIANHUNDONG;

    @FindResource(Id="hov_fuel_type_4")
    public static String KETIDAINENGYUAN;

    @FindResource(Id="hov_fuel_type_5")
    public static String QITA;

    public static Page_HovLine Inst;
    static
    {
        Inst = new Page_HovLine();
    }
}