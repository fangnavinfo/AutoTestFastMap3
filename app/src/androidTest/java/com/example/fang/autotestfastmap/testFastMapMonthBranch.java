package com.example.fang.autotestfastmap;

import android.support.test.uiautomator.UiObject2;

import com.fang.testAdapter.Sqlitetools;
import com.fang.testAdapter.testadapter;
import com.fastmap.ui.Page_GridManager;
import com.fastmap.ui.Page_Light;
import com.fastmap.ui.Page_MainBoard;
import com.fastmap.ui.Page_MyData;
import com.fastmap.ui.Page_PAS;
import com.fastmap.ui.Page_POI;
import com.fastmap.ui.Page_POI_Camera;
import com.fastmap.ui.Page_Search;
import com.fastmap.ui.Page_SearchResultList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by fang on 17/11/21.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testFastMapMonthBranch extends testFastMapBase {
    @BeforeClass
    public static void setClassUp() throws Exception {
        CPUMonitor.Start();

        //testFastMapBase.setClassUp("zhanglingling03655","036550");
    }

    @AfterClass
    public static void setClassDown() throws Exception {
        CPUMonitor.End();
    }


    @Before
    public void setUp() throws Exception {
        testFastMapBase.setClassUp();
    }

    @After
    public void setAfter() //throws IOException, InterruptedException {
    {

        //super.setAfter();
        CPUMonitor.Assert();
    }


    // POI：增加照片类型（月基线需求）
    @Test
    public void test00137_poi_picture_type_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Thread.sleep(3000);
        assertTrue(Page_MainBoard.Inst.isExistByName("地铁站平面图"));

    }

    // POI：景点增加等级字段（月基线需求）
    @Test
    public void test00138_1_poi_scenery_level_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "风景名胜");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        //景区等级
        Page_POI.Inst.Click(Page_POI.A1);
        Page_POI.Inst.Click(Page_POI.TAG2);

        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("测试ＰＯＩ");

        Thread.sleep(1000);

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        assertTrue(Page_POI.Inst.isChecked(Page_POI.A1));
        assertTrue(Page_POI.Inst.isChecked(Page_POI.TAG2));

    }

    // POI：景点增加等级字段（月基线需求）
    @Test
    public void test00138_2_poi_scenery_level_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "风景名胜");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        //景区等级
        Page_POI.Inst.Click(Page_POI.A5);
        Page_POI.Inst.Click(Page_POI.TAG2);

        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("测试ＰＯＩ");

        Thread.sleep(1000);

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        assertTrue(Page_POI.Inst.isChecked(Page_POI.A5));
        assertTrue(Page_POI.Inst.isChecked(Page_POI.TAG2));

    }

    // 月基线点门牌采集端需求-关联POI
    @Test
    public void test00141_1_pas_poi_check() throws Exception {
        //POI
        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ"},
                {Page_POI.SELECT_TYPE, "小区"},
                {Page_POI.TEL, "19012345678"}};
        AddPOI(attrib,"忽略捕捉新增");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_POI.Inst.ClickByText("已采集");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 1300, 100);
        // 创建点门牌
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);

        Page_PAS.Inst.SetValue(Page_PAS.NAME, "测试ＰＡＳ");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "101");
        Page_PAS.Inst.Click(Page_PAS.ODD);
        Page_PAS.Inst.Click(Page_PAS.ROAD_TYPE);
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        GotoMyData(Page_MyData.PAS_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("测试ＰＡＳ１０１");
        Page_PAS.Inst.Click(Page_PAS.RELATE_POI);
        Page_MainBoard.Inst.ClickByText("测试ＰＯＩ");
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        Page_MyData.Inst.SelectData("测试ＰＡＳ１０１");
        Assert.assertTrue(Page_MyData.Inst.isExistByName("测试ＰＯＩ"));

    }

    @Test
    public void test00141_2_pas_poi_check() throws Exception {
        //POI
        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"}};
        AddPOI(attrib, "忽略捕捉新增");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 1300, 100);
        // 创建点门牌
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);

        Page_PAS.Inst.SetValue(Page_PAS.NAME, "测试ＰＡＳ");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "101");
        Page_PAS.Inst.Click(Page_PAS.ODD);
        Page_PAS.Inst.Click(Page_PAS.ROAD_TYPE);
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        GotoMyData(Page_MyData.PAS_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("测试ＰＡＳ１０１");
        Page_PAS.Inst.Click(Page_PAS.RELATE_POI);

        Assert.assertTrue(!Page_MyData.Inst.isExistByName("测试ＰＯＩ"));
    }

    //月基线采集端需求--POI曾用名业务需求
    @Test
    public void test00142_before_name_check() throws Exception {
        List<UiObject2> beforeNameList;

        UiObject2 beforeName;

        //POI
        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ"},
                {Page_POI.SELECT_TYPE, "银行"},
                {Page_POI.TEL, "19012345678"}};
        AddPOI(attrib, "忽略捕捉新增");

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("测试ＰＯＩ");

        Page_POI.Inst.SetValue(Page_POI.BEFORE_NAME, "曾用名测试1");

        Page_POI.Inst.Click(Page_POI.BEFORE_ADD);
        beforeNameList = testadapter.findAllObjectsByClass("layer_name_list_before", "android.widget.EditText");
        beforeName = beforeNameList.get(1);
        beforeName.setText("曾用名测试2");

        Page_POI.Inst.Click(Page_POI.BEFORE_ADD);
        beforeNameList = testadapter.findAllObjectsByClass("layer_name_list_before", "android.widget.EditText");
        beforeName = beforeNameList.get(2);
        beforeName.setText("曾用名测试3");

        Page_POI.Inst.Click(Page_POI.BEFORE_ADD);
        beforeNameList = testadapter.findAllObjectsByClass("layer_name_list_before", "android.widget.EditText");
        beforeName = beforeNameList.get(3);
        beforeName.setText("曾用名测试4");

        Page_POI.Inst.Click(Page_POI.BEFORE_ADD);
        beforeNameList = testadapter.findAllObjectsByClass("layer_name_list_before", "android.widget.EditText");
        beforeName = beforeNameList.get(4);
        beforeName.setText("曾用名测试5");

        Page_POI.Inst.Click(Page_POI.BEFORE_ADD);
        beforeNameList = testadapter.findAllObjectsByClass("layer_name_list_before", "android.widget.EditText");
        beforeName = beforeNameList.get(5);
        beforeName.setText("曾用名测试6");

        Page_POI.Inst.Click(Page_POI.BEFORE_ADD);
        beforeNameList = testadapter.findAllObjectsByClass("layer_name_list_before", "android.widget.EditText");
        beforeName = beforeNameList.get(6);
        beforeName.setText("曾用名测试7");

        Page_POI.Inst.Click(Page_POI.BEFORE_ADD);
        beforeNameList = testadapter.findAllObjectsByClass("layer_name_list_before", "android.widget.EditText");
        beforeName = beforeNameList.get(7);
        beforeName.setText("曾用名测试8");

        Page_POI.Inst.Click(Page_POI.BEFORE_ADD);
        beforeNameList = testadapter.findAllObjectsByClass("layer_name_list_before", "android.widget.EditText");
        assertEquals(8, beforeNameList.size());

        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MyData.Inst.SelectData("测试ＰＯＩ");

    }


    // Tips：语音附件上传入库（月基线需求）
    @Test
    public void test00143_1_tips_record_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_LIGHT);
        Page_MainBoard.Inst.ClickCenter();

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("红绿灯");
        String infoRowkey = Page_Light.Inst.GetValue(Page_Light.ROWKEY).trim().substring(8);
        Page_Light.Inst.LongClick(Page_Light.RECORD, 10000);
        Page_Light.Inst.Click(Page_Light.SAVE);
        ExitMyData();

        IndoorCheckConfirm("红绿灯");

        //同步数据
        synchronize_zhou(Page_GridManager.TIPS_UPDATE);


        Sqlitetools.CleanDataAndRestart();

        synchronize_zhou(Page_GridManager.TIPS_UPDATE);

        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Page_Search.Inst.ClickbyText("Tips");
        Page_Search.Inst.SetValue(Page_Search.TIPS_ROWKEY, infoRowkey);

        Page_Search.Inst.Click(Page_Search.SEARCH_START_TIPS);
        Page_SearchResultList.Inst.Click(Page_SearchResultList.DATA_LIST);

        String time = Page_Light.Inst.GetValue(Page_Light.RECORD_TIME);

        assertEquals(time.contains("10"),true);
    }


}