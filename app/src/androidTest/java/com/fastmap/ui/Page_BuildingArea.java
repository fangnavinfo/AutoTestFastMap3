package com.fastmap.ui;

import com.fang.testAdapter.FindResource;

/**
 * Created by zhou on 18/3/14.
 * 建筑面
 */

public class Page_BuildingArea extends Page_Base_Tips
{
    @FindResource(clazz="android.widget.ScrollView")
    public static String SCROLL;

    @FindResource(Id="btn_building_area_point_draw_last", Text="上一步")
    public static String LAST_STEP;
    @FindResource(Id="btn_building_area_point_draw_clear", Text="重绘")
    public static String REPAINT;
    @FindResource(Id="btn_building_area_point_draw_finish", Text="完成")
    public static String COMPLETE;

    @FindResource(Id="edt_building_area_height_poi_floor", ios_name="building_hightTF")
    public static String FLOOR_NUMBER;

    //形状
    @FindResource(Id="rbtn_building_area_state_shape_change", ios_name="building_shape_0", Text="修改")
    public static String SHAPE_CHANGE;
    @FindResource(Id="rbtn_building_area_state_shape_add", ios_name="building_shape_1", Text="新增")
    public static String SHAPE_ADD;
    @FindResource(Id="rbtn_building_area_state_shape_edit", ios_name="building_shape_2", Text="删除")
    public static String SHAPE_DELETE;

    //高度
    @FindResource(Id="rbtn_building_area_state_type_change", ios_name="building_height_0", Text="修改")
    public static String HEIGHT_CHANGE;
    @FindResource(Id="rbtn_building_area_state_type_add", ios_name="building_height_1", Text="新增")
    public static String HEIGHT_ADD;
    @FindResource(Id="rbtn_building_area_state_type_edit", ios_name="building_height_2", Text="删除")
    public static String HEIGHT_DELETE;

    //关联状态
    @FindResource(Id="rbtn_building_area_state_name_change", ios_name="building_relation_0", Text="修改")
    public static String ASSOCIATE_CHANGE;
    @FindResource(Id="rbtn_building_area_state_name_add", ios_name="building_relation_1", Text="新增")
    public static String ASSOCIATE_ADD;
    @FindResource(Id="rbtn_building_area_state_name_edit", ios_name="building_relation_2", Text="删除")
    public static String ASSOCIATE_DELETE;

    public static Page_BuildingArea Inst;
    static
    {
        Inst = new Page_BuildingArea();
    }
}
