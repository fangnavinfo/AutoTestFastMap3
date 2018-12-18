package com.example.fang.autotestfastmap;

import android.support.test.uiautomator.UiObject2;

import com.fang.testAdapter.Point;
import com.fang.testAdapter.Sqlitetools;
import com.fang.testAdapter.testadapter;
import com.fastmap.ui.Page_FunctionalArea;
import com.fastmap.ui.Page_GridManager;
import com.fastmap.ui.Page_InfoLine;
import com.fastmap.ui.Page_Light;
import com.fastmap.ui.Page_Line_PAS;
import com.fastmap.ui.Page_MainBoard;
import com.fastmap.ui.Page_MyData;
import com.fastmap.ui.Page_NoParking;
import com.fastmap.ui.Page_PAS;
import com.fastmap.ui.Page_POI;
import com.fastmap.ui.Page_POI_Camera;
import com.fastmap.ui.Page_Search;
import com.fastmap.ui.Page_SearchResultList;
import com.fastmap.ui.Page_TruckLimitLane;

import org.json.JSONArray;
import org.json.JSONObject;
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

        assertEquals(time.isEmpty(),false);
    }

    // 线门牌检查需求 点门牌+点门牌
    @Test
    public void test00144_1_line_pas_check() throws Exception {
        // 创建点门牌1
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);

        Page_PAS.Inst.SetValue(Page_PAS.NAME, "P1");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "A1");
        Page_PAS.Inst.Click(Page_PAS.ODD);
        Page_PAS.Inst.Click(Page_PAS.ROAD_TYPE);
        Page_PAS.Inst.Click(Page_PAS.ADDRESS_PAS);
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        GotoMyData(Page_MyData.PAS_TYPE);
        Thread.sleep(1000);
        Page_MyData.Inst.SelectData("Ｐ１Ａ１");
        String fid1 = Page_PAS.Inst.GetValue(Page_PAS.FID);
        fid1 = fid1.replace("fid:","").replace("fid：","");
        Page_PAS.Inst.Click(Page_PAS.CANCEL);
        ExitMyData();

        Page_MainBoard.Inst.Drag(600, 600, 400, 600, 10);

        // 创建点门牌2
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);

        Page_PAS.Inst.SetValue(Page_PAS.NAME, "P2");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "A2");
        Page_PAS.Inst.Click(Page_PAS.ODD);
        Page_PAS.Inst.Click(Page_PAS.ROAD_TYPE);
        Page_PAS.Inst.Click(Page_PAS.ADDRESS_PAS);
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        GotoMyData(Page_MyData.PAS_TYPE);
        Thread.sleep(1000);
        Page_MyData.Inst.SelectData("Ｐ２Ａ２");
        String fid2 = Page_PAS.Inst.GetValue(Page_PAS.FID);
        fid2 = fid2.replace("fid:","").replace("fid：","");
        Page_PAS.Inst.Click(Page_PAS.CANCEL);
        ExitMyData();

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LINE_PAS);

        List<UiObject2> lst = testadapter.findAllObjectsByClass("tips_fragment_content", "android.widget.TextView");

        UiObject2 obj;

        //建立起点
        obj = lst.get(1);
        obj.click();
        Thread.sleep(2000);

        Page_MainBoard.Inst.Click(new Point(testadapter.getDisplayWidth()/2 , testadapter.getDisplayHeight()/2));

        lst = testadapter.findAllObjectsByClass("tips_fragment_content", "android.widget.TextView");
        //建立终点
        obj = lst.get(9);
        obj.click();
        Thread.sleep(2000);

        Page_MainBoard.Inst.Click(new Point(testadapter.getDisplayWidth()/2-200, testadapter.getDisplayHeight()/2));

        Page_Line_PAS.Inst.Click(Page_Line_PAS.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("线门牌");

        assertTrue(Page_Line_PAS.Inst.isExistByName(fid1));
        assertTrue(Page_Line_PAS.Inst.isExistByName(fid2));
        assertTrue(Page_Line_PAS.Inst.isExistByName("Ｐ１"));
        assertTrue(Page_Line_PAS.Inst.isExistByName("Ｐ２"));
        assertTrue(Page_Line_PAS.Inst.isExistByName("Ａ１"));
        assertTrue(Page_Line_PAS.Inst.isExistByName("Ａ２"));


    }

    // 线门牌检查需求
    @Test
    public void test00144_2_line_pas_check() throws Exception {
        // 创建点门牌1
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);

        Page_PAS.Inst.SetValue(Page_PAS.NAME, "P1");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "A1");
        Page_PAS.Inst.Click(Page_PAS.ODD);
        Page_PAS.Inst.Click(Page_PAS.ROAD_TYPE);
        Page_PAS.Inst.Click(Page_PAS.ADDRESS_PAS);
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        GotoMyData(Page_MyData.PAS_TYPE);
        Thread.sleep(1000);
        Page_MyData.Inst.SelectData("Ｐ１Ａ１");
        String fid1 = Page_PAS.Inst.GetValue(Page_PAS.FID);
        fid1 = fid1.replace("fid:","").replace("fid：","");
        Page_PAS.Inst.Click(Page_PAS.CANCEL);
        ExitMyData();


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LINE_PAS);

        List<UiObject2> lst = testadapter.findAllObjectsByClass("tips_fragment_content", "android.widget.TextView");

        UiObject2 obj;

        //建立起点
        obj = lst.get(1);
        obj.click();
        Thread.sleep(2000);

        Page_MainBoard.Inst.Click(new Point(testadapter.getDisplayWidth()/2 , testadapter.getDisplayHeight()/2));
        Page_Line_PAS.Inst.Click(Page_Line_PAS.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("线门牌");

        assertTrue(Page_Line_PAS.Inst.isExistByName(fid1));
        assertTrue(Page_Line_PAS.Inst.isExistByName("Ｐ１"));
        assertTrue(Page_Line_PAS.Inst.isExistByName("Ａ１"));
    }

    // 线门牌检查需求
    @Test
    public void test00144_3_line_pas_check() throws Exception {
        // 创建点门牌1
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);

        Page_PAS.Inst.SetValue(Page_PAS.NAME, "P1");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "A1");
        Page_PAS.Inst.Click(Page_PAS.ODD);
        Page_PAS.Inst.Click(Page_PAS.ROAD_TYPE);
        Page_PAS.Inst.Click(Page_PAS.ADDRESS_PAS);
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        GotoMyData(Page_MyData.PAS_TYPE);
        Thread.sleep(1000);
        Page_MyData.Inst.SelectData("Ｐ１Ａ１");
        String fid1 = Page_PAS.Inst.GetValue(Page_PAS.FID);
        fid1 = fid1.replace("fid:","").replace("fid：","");
        Page_PAS.Inst.Click(Page_PAS.CANCEL);
        ExitMyData();


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LINE_PAS);

        List<UiObject2> lst = testadapter.findAllObjectsByClass("tips_fragment_content", "android.widget.TextView");

        UiObject2 obj;

        //建立终点
        obj = lst.get(9);
        obj.click();
        Thread.sleep(2000);

        Page_MainBoard.Inst.Click(new Point(testadapter.getDisplayWidth()/2 , testadapter.getDisplayHeight()/2));
        Page_Line_PAS.Inst.Click(Page_Line_PAS.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("线门牌");

        assertTrue(Page_Line_PAS.Inst.isExistByName(fid1));
        assertTrue(Page_Line_PAS.Inst.isExistByName("Ｐ１"));
        assertTrue(Page_Line_PAS.Inst.isExistByName("Ａ１"));
    }

    // 线门牌检查需求 点门牌+POI
    @Test
    public void test00144_4_line_pas_check() throws Exception {
        // 创建点门牌1
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);

        Page_PAS.Inst.SetValue(Page_PAS.NAME, "P1");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "A1");
        Page_PAS.Inst.Click(Page_PAS.ODD);
        Page_PAS.Inst.Click(Page_PAS.ROAD_TYPE);
        Page_PAS.Inst.Click(Page_PAS.ADDRESS_PAS);
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        GotoMyData(Page_MyData.PAS_TYPE);
        Thread.sleep(1000);
        Page_MyData.Inst.SelectData("Ｐ１Ａ１");
        String fid1 = Page_PAS.Inst.GetValue(Page_PAS.FID);
        fid1 = fid1.replace("fid:","").replace("fid：","");
        Page_PAS.Inst.Click(Page_PAS.CANCEL);
        ExitMyData();

        Page_MainBoard.Inst.Drag(600, 600, 400, 600, 10);

        // 创建POI2
        String[][] attrib0 = {{Page_POI.NAME, "中餐馆0"},
                {Page_POI.SELECT_TYPE, "中餐馆"},};
        AddPOI(attrib0, "捕捉点位新增");

        String[][] attrib = {{Page_POI.NAME, "中餐馆1"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.ADDRESS, "ADD1"}};
        AddPOI(attrib, "捕捉点位新增");

        String[][] attrib2 = {{Page_POI.NAME, "中餐馆2"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.ADDRESS, "ADD2"}};
        String fid2 = AddPOI(attrib2, "捕捉点位新增");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LINE_PAS);

        List<UiObject2> lst = testadapter.findAllObjectsByClass("tips_fragment_content", "android.widget.TextView");

        UiObject2 obj;

        //建立起点
        obj = lst.get(1);
        obj.click();
        Thread.sleep(2000);

        Page_MainBoard.Inst.Click(new Point(testadapter.getDisplayWidth()/2 , testadapter.getDisplayHeight()/2));
        Page_MainBoard.Inst.ClickByText("中餐馆２");
        Page_MainBoard.Inst.ClickByText("确定");




        lst = testadapter.findAllObjectsByClass("tips_fragment_content", "android.widget.TextView");
        //建立终点
        obj = lst.get(9);
        obj.click();
        Thread.sleep(2000);

        Page_MainBoard.Inst.Click(new Point(testadapter.getDisplayWidth()/2-200, testadapter.getDisplayHeight()/2));

        Page_Line_PAS.Inst.Click(Page_Line_PAS.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("线门牌");

        assertTrue(Page_Line_PAS.Inst.isExistByName(fid1));
        assertTrue(Page_Line_PAS.Inst.isExistByName(fid2));
        assertTrue(Page_Line_PAS.Inst.isExistByName("Ｐ１"));
        assertTrue(Page_Line_PAS.Inst.isExistByName("中餐馆２"));
        assertTrue(Page_Line_PAS.Inst.isExistByName("Ａ１"));
        assertTrue(Page_Line_PAS.Inst.isExistByName("ＡＤＤ２"));


    }

    // 线门牌检查需求 POI+POI
    @Test
    public void test00144_5_line_pas_check() throws Exception {
        // 创建点门牌1
        String[][] attrib0 = {{Page_POI.NAME, "中餐馆1"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.ADDRESS, "ADD1"}};
        String fid1 = AddPOI(attrib0, "捕捉点位新增");

        Page_MainBoard.Inst.Drag(600, 600, 400, 600, 10);

        // 创建POI2
        String[][] attrib = {{Page_POI.NAME, "中餐馆0"},
                {Page_POI.SELECT_TYPE, "中餐馆"}};
        AddPOI(attrib, "捕捉点位新增");

        String[][] attrib2 = {{Page_POI.NAME, "中餐馆2"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.ADDRESS, "ADD2"}};
        String fid2 = AddPOI(attrib2, "捕捉点位新增");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LINE_PAS);

        List<UiObject2> lst = testadapter.findAllObjectsByClass("tips_fragment_content", "android.widget.TextView");

        UiObject2 obj;

        //建立起点
        obj = lst.get(1);
        obj.click();
        Thread.sleep(2000);

        Page_MainBoard.Inst.Click(new Point(testadapter.getDisplayWidth()/2 , testadapter.getDisplayHeight()/2));



        lst = testadapter.findAllObjectsByClass("tips_fragment_content", "android.widget.TextView");
        //建立终点
        obj = lst.get(9);
        obj.click();
        Thread.sleep(2000);

        Page_MainBoard.Inst.Click(new Point(testadapter.getDisplayWidth()/2-200, testadapter.getDisplayHeight()/2));

        Page_Line_PAS.Inst.Click(Page_Line_PAS.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("线门牌");

        assertTrue(Page_Line_PAS.Inst.isExistByName(fid1));
        assertTrue(Page_Line_PAS.Inst.isExistByName(fid2));
        assertTrue(Page_Line_PAS.Inst.isExistByName("中餐馆１"));
        assertTrue(Page_Line_PAS.Inst.isExistByName("ＡＤＤ１"));
        assertTrue(Page_Line_PAS.Inst.isExistByName("中餐馆２"));
        assertTrue(Page_Line_PAS.Inst.isExistByName("ＡＤＤ２"));


    }

    /////////以下注释用例均为月基线功能用例开始///////////////////
    //品牌
    @Test
    public void test999_05910_poi_chain_add() throws Exception
    {
        //品牌s
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "北京汉庭酒店");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "星级酒店");
        Page_POI.Inst.Click(Page_POI.SELECT_BRAND);
        Page_POI.Inst.ClickbyText("汉庭酒店");
        Thread.sleep(1000);
        String strResult = Page_POI.Inst.GetValue(Page_POI.SELECT_BRAND);
        assertEquals(strResult,"汉庭酒店");
        Thread.sleep(3000);
        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickByText("北京汉庭酒店");
        strResult = Page_POI.Inst.GetValue(Page_POI.SELECT_BRAND);
        assertEquals(strResult,"汉庭酒店");
        Thread.sleep(3000);
        Page_POI.Inst.Click(Page_POI.SAVE);
        ExitMyData();
        synchronize(Page_GridManager.POI_UPDATE);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickByText("北京汉庭酒店");
        strResult = Page_POI.Inst.GetValue(Page_POI.SELECT_BRAND);
        assertEquals(strResult,"汉庭酒店");
        Thread.sleep(3000);
        Page_POI.Inst.Click(Page_POI.SAVE);
        ExitMyData();
    }

    @Test
    public void test999_05911_poi_chain_add() throws Exception
    {
        //品牌
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "超市｜｜｜酒店");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.Click(Page_POI.SELECT_BRAND);
        assertTrue(Page_POI.Inst.isExistByName("无关联品牌"));
        Thread.sleep(1000);
        Page_POI.Inst.Click(Page_POI.SAVE);
    }

    @Test
    public void test999_05912_poi_chain_add() throws Exception
    {
        //品牌
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.Click(Page_POI.SELECT_BRAND);
        assertTrue(Page_POI.Inst.isExistByName("无关联品牌"));
        Thread.sleep(3000);
        Page_POI.Inst.Click(Page_POI.SAVE);
    }

    @Test
    public void test999_05913_poi_chain_add() throws Exception
    {
        //品牌
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "北京证券交易会");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "证券");
        Page_POI.Inst.Click(Page_POI.SELECT_BRAND);
        assertTrue(Page_POI.Inst.isExistByName("请选择品牌"));
        Thread.sleep(3000);
        Page_POI.Inst.SetValue(Page_POI.NAME, "北京市朝阳区政府办公厅");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "政府及管理机构");
        Page_POI.Inst.Click(Page_POI.SELECT_BRAND);
        assertTrue(Page_POI.Inst.isExistByName("请选择品牌"));
        Thread.sleep(3000);
        Page_POI.Inst.Click(Page_POI.SAVE);
    }

    @Test
    public void test999_05914_poi_chain_add() throws Exception
    {
        //品牌
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "北京银座超市｜首都锦江之星酒店");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "星级酒店");
        Page_POI.Inst.Click(Page_POI.SELECT_BRAND);
        Page_POI.Inst.ClickbyText("锦江之星");
        Thread.sleep(1000);
        String strResult = Page_POI.Inst.GetValue(Page_POI.SELECT_BRAND);
        assertEquals(strResult,"锦江之星");
        Thread.sleep(3000);
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "超级市场零售");
        Page_POI.Inst.Click(Page_POI.SELECT_BRAND);
        Page_POI.Inst.ClickbyText("银座");
        Thread.sleep(1000);
        strResult = Page_POI.Inst.GetValue(Page_POI.SELECT_BRAND);
        assertEquals(strResult,"银座");
        Thread.sleep(3000);
        Page_POI.Inst.Click(Page_POI.SAVE);
    }

    @Test
    public void test999_05915_poi_chain_add() throws Exception
    {
        //品牌
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "　");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "厂家一览表内汽车零售");
        Page_POI.Inst.Click(Page_POI.SELECT_BRAND);
        Page_POI.Inst.ClickbyText("无关联品牌");

        Page_POI.Inst.SetValue(Page_POI.NAME, "北京ds代理店|epsilon雪佛兰销售\\维修|Ｗｅｙ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "厂家一览表内汽车零售");
        Page_POI.Inst.Click(Page_POI.SELECT_BRAND);
        Page_POI.Inst.ClickbyText("DS代理店");
        Thread.sleep(1000);
        String strResult = Page_POI.Inst.GetValue(Page_POI.SELECT_BRAND);
        assertEquals(strResult,"DS代理店");
        Thread.sleep(3000);
        Page_POI.Inst.Click(Page_POI.SELECT_BRAND);
        Page_POI.Inst.ClickbyText("ＥＰＳＩＬＯＮ雪佛兰销售\\维修");
        Thread.sleep(1000);
        strResult = Page_POI.Inst.GetValue(Page_POI.SELECT_BRAND);
        assertEquals(strResult,"ＥＰＳＩＬＯＮ雪佛兰销售\\维修");
        Thread.sleep(3000);
        Page_POI.Inst.Click(Page_POI.SELECT_BRAND);
        Page_POI.Inst.ClickbyText("WEY");
        Thread.sleep(1000);
        strResult = Page_POI.Inst.GetValue(Page_POI.SELECT_BRAND);
        assertEquals(strResult,"WEY");
        Thread.sleep(3000);
        Page_POI.Inst.Click(Page_POI.SAVE);
    }
    //基础信息卡片 新增别名  曾用名 站点线路名
    @Test
    public void test999_06001_poi_name_add() throws Exception
    {
        SearchLocation(LOC_K1);
        //别名 非必选
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.Click(Page_POI.SAVE);

        SearchLocation(LOC_K1);
        Page_MainBoard.Inst.ClickCenter();
        Page_POI.Inst.SetValue(Page_POI.ALIAS_NAME,"别名测试");
        String strResult = Page_POI.Inst.GetValue(Page_POI.ALIAS_NAME);
        assertEquals("别名测试",strResult);
        Page_POI.Inst.Click(Page_POI.ALIAS_ADD);
        Thread.sleep(2000);
        strResult = Page_POI.Inst.GetValuebyIndex(Page_POI.ALIAS_NAME,4);
        assertEquals("",strResult);
        Page_POI.Inst.GetValuebyIndex(Page_POI.ALIAS_DEL,5);
        Page_POI.Inst.Click(Page_POI.SAVE);
    }

    @Test
    public void test999_06002_poi_name_add() throws Exception
    {
        SearchLocation(LOC_K1);
        //别名 非必选
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME, "测试");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.Click(Page_POI.SAVE);

        SearchLocation(LOC_K1);
        Page_MainBoard.Inst.ClickCenter();
        Page_POI.Inst.SetValue(Page_POI.ALIAS_NAME,"别名测试");
        String strResult = Page_POI.Inst.GetValue(Page_POI.ALIAS_NAME);
        assertEquals("别名测试",strResult);
        Page_POI.Inst.Click(Page_POI.ALIAS_ADD);
        strResult = Page_POI.Inst.GetValuebyIndex(Page_POI.ALIAS_NAME,4);
        assertEquals("",strResult);
        Page_POI.Inst.GetValuebyIndex(Page_POI.ALIAS_DEL,5);
        Page_POI.Inst.Click(Page_POI.SAVE);
    }

    @Test
    public void test999_06003_poi_name_add() throws Exception
    {
        SearchLocation(LOC_K1);
        //曾用名 非必选
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.Click(Page_POI.SAVE);

        SearchLocation(LOC_K1);
        Page_MainBoard.Inst.ClickCenter();
        Page_POI.Inst.SetValue(Page_POI.BEFORE_NAME,"曾用名测试");
        String strResult = Page_POI.Inst.GetValue(Page_POI.BEFORE_NAME);
        assertEquals("曾用名测试",strResult);
        Page_POI.Inst.Click(Page_POI.BEFORE_ADD);
        strResult = Page_POI.Inst.GetValuebyIndex(Page_POI.BEFORE_NAME,10);
        assertEquals("",strResult);
        Page_POI.Inst.GetValuebyIndex(Page_POI.BEFORE_DEL,11);
        Page_POI.Inst.Click(Page_POI.SAVE);
    }

    @Test
    public void test999_06004_poi_name_add() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "230111");
        Page_POI.Inst.Click(Page_POI.SUBWAY_STATION);
        Thread.sleep(2000);
        Page_POI.Inst.ClickByText("13号线");
        Thread.sleep(1000);
        Page_POI.Inst.ClickByText("昌平线");
        Thread.sleep(1000);
        Page_POI.Inst.ClickByText("确定");
        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickByText("测试");
        String strResult = Page_POI.Inst.GetValue(Page_POI.SUBWAY_STATION);
        assertEquals(strResult,"13号线/昌平线");
        Page_POI.Inst.Click(Page_POI.SUBWAY_STATION);
        Thread.sleep(2000);
        Page_POI.Inst.ClickByText("10号线");
        Thread.sleep(1000);
        Page_POI.Inst.ClickByText("昌平线");
        Thread.sleep(1000);
        Page_POI.Inst.ClickByText("确定");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MyData.Inst.ClickByText("测试");
        strResult = Page_POI.Inst.GetValue(Page_POI.SUBWAY_STATION);
        assertEquals(strResult,"10号线/13号线");
//        Page_POI.Inst.Click(Page_POI.SUBWAY_STATION);
//        Thread.sleep(2000);
//        boolean temp = Page_POI.Inst.isChecked("10号线");
//        assertTrue(temp);
//        Thread.sleep(2000);
//        temp = Page_POI.Inst.isChecked("13号线");
//        assertTrue(temp);
//        Thread.sleep(2000);
//        temp = Page_POI.Inst.isChecked("昌平线");
//        assertFalse(temp);
//        Thread.sleep(1000);
//        Page_POI.Inst.ClickByText("确定");
        Page_POI.Inst.Click(Page_POI.SAVE);
    }

    @Test
    public void test999_06005_poi_name_add() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "230114");
        Page_POI.Inst.Click(Page_POI.SUBWAY_STATION);
        Thread.sleep(2000);
        Page_POI.Inst.ClickByText("13号线");
        Thread.sleep(1000);
        Page_POI.Inst.ClickByText("昌平线");
        Thread.sleep(1000);
        Page_POI.Inst.ClickByText("确定");
        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickByText("测试");
        String strResult = Page_POI.Inst.GetValue(Page_POI.SUBWAY_STATION);
        assertEquals(strResult,"13号线/昌平线");
        Page_POI.Inst.Click(Page_POI.SUBWAY_STATION);
        Thread.sleep(2000);
        Page_POI.Inst.ClickByText("10号线");
        Thread.sleep(1000);
        Page_POI.Inst.ClickByText("昌平线");
        Thread.sleep(1000);
        Page_POI.Inst.ClickByText("确定");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MyData.Inst.ClickByText("测试");
        strResult = Page_POI.Inst.GetValue(Page_POI.SUBWAY_STATION);
        assertEquals(strResult,"10号线/13号线");
        Page_POI.Inst.Click(Page_POI.SAVE);
    }

    @Test
    public void test999_06101_poi_carDeep_add() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "停车场测试");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "230210");
        Page_POI.Inst.Click(Page_POI.H24);
        Page_POI.Inst.Drag(1734,1200,1734,903,5);
        Page_POI.Inst.ClickByText("室外");
        Page_POI.Inst.Drag(1734,1200,1734,903,5);
        String strResult = Page_POI.Inst.GetValue(Page_POI.START_TIME);
        assertEquals("00:00-23:59",strResult);
        Page_POI.Inst.Click(Page_POI.SELECT_TIME);
        Page_POI.Inst.ClickByText("确定");
        Thread.sleep(2000);
        strResult = Page_POI.Inst.GetValue(Page_POI.START_TIME);
        assertEquals("00:00-23:59|06:00-20:00",strResult);
        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_POI.Inst.ClickByText("停车场测试");
        Page_POI.Inst.Click(Page_POI.H24);
        Page_POI.Inst.Click(Page_POI.H24);
        Page_POI.Inst.Click(Page_POI.SAVE);
        Page_POI.Inst.ClickByText("停车场测试");
        Page_POI.Inst.Drag(1734,1200,1734,903,5);
        Thread.sleep(2000);
        Page_POI.Inst.Drag(1734,1200,1734,903,5);
        strResult = Page_POI.Inst.GetValue(Page_POI.START_TIME);
        assertEquals("００：００－２３：５９",strResult);
        Page_POI.Inst.Click(Page_POI.SAVE);
    }

    @Test
    public void test999_06102_poi_carDeep_add() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME, "停车场测试");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "230213");
        Page_POI.Inst.Click(Page_POI.H24);
        Page_POI.Inst.Drag(1734,1200,1734,903,5);
        Page_POI.Inst.ClickByText("室外");
        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_POI.Inst.ClickByText("停车场测试");
        Thread.sleep(2000);
        Page_POI.Inst.Drag(1734,1200,1734,903,5);
        Thread.sleep(2000);
        Page_POI.Inst.Drag(1734,1200,1734,903,5);
        Page_POI.Inst.Click(Page_POI.SELECT_TIME);
        Page_POI.Inst.ClickByText("确定");
        String strResult = Page_POI.Inst.GetValue(Page_POI.START_TIME);
        assertEquals("００：００－２３：５９|06:00-20:00",strResult);
        Page_POI.Inst.Click(Page_POI.SAVE);
        Page_POI.Inst.ClickByText("停车场测试");
        Page_POI.Inst.Drag(1734,1200,1734,903,5);
        Thread.sleep(2000);
        Page_POI.Inst.Drag(1734,1200,1734,903,5);
        assertEquals("００：００－２３：５９｜０６：００－２０：００",strResult);
        Page_POI.Inst.Click(Page_POI.SAVE);
    }

    @Test
    public void test999_06103_poi_carDeep_add() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "停车场测试");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "230214");
        Page_POI.Inst.Click(Page_POI.H24);
        Page_POI.Inst.Drag(1734,1200,1734,903,5);
        Page_POI.Inst.ClickByText("室外");
        Page_POI.Inst.Drag(1734,1200,1734,903,5);
        String strResult = Page_POI.Inst.GetValue(Page_POI.START_TIME);
        assertEquals("00:00-23:59",strResult);
        Page_POI.Inst.Click(Page_POI.SELECT_TIME);
        Page_POI.Inst.ClickByText("确定");
        Thread.sleep(2000);
        strResult = Page_POI.Inst.GetValue(Page_POI.START_TIME);
        assertEquals("00:00-23:59|06:00-20:00",strResult);
        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_POI.Inst.ClickByText("停车场测试");
        Page_POI.Inst.Click(Page_POI.H24);
        Page_POI.Inst.Click(Page_POI.SAVE);
        Page_POI.Inst.ClickByText("停车场测试");
        Page_POI.Inst.Drag(1734,1200,1734,903,5);
        Thread.sleep(2000);
        Page_POI.Inst.Drag(1734,1200,1734,903,5);
        strResult = Page_POI.Inst.GetValue(Page_POI.START_TIME);
        assertEquals("００：００－２３：５９",strResult);
        Page_POI.Inst.Click(Page_POI.SAVE);
    }


    @Test
    public void test999_05007_FunctionalArea() throws Exception
    {
        //功能面 关联有名称POI
        SearchLocation(LOC_K3);
        String[][] attrib1 = {{Page_POI.NAME, "大厦ＴＥＳＴ１"},
                {Page_POI.SELECT_TYPE, "大厦/写字楼"}};
        String infoFid =AddPOI(attrib1,"捕捉点位新增");
        //新增物流园
        //SearchLocation(LOC_K1);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.FUNCTIONAL_SURFACE);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Click(new Point(500,500));
        Page_MainBoard.Inst.Click(new Point(800,500));
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.COMPLETE);
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.PARK);
        Page_FunctionalArea.Inst.Drag(1634,1164,1634,600,5);
        Page_FunctionalArea.Inst.SetValue(Page_FunctionalArea.NAME,"测试");
        Page_FunctionalArea.Inst.ClickbyText("关联POI");
        Thread.sleep(2000);
        Page_FunctionalArea.Inst.ClickCenter();
        Thread.sleep(2000);
        String str = Page_FunctionalArea.Inst.GetValue(Page_FunctionalArea.RELATIEPOI);
        assertEquals("大厦ＴＥＳＴ１",str);
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据
        Page_MyData.Inst.isExistByName("功能面");
        Page_MyData.Inst.ClickbyText("功能面");
        String rowkey = Page_TruckLimitLane.Inst.GetRowKey();
        Thread.sleep(2000);
        Page_FunctionalArea.Inst.ClickbyText("修改形状");
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.MODIFY_SAVE);
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);
        ExitMyData();

        Sqlitetools.RefreshData();
        String temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        String pFid = jsonObject.getString("pFid");
        assertEquals(pFid,infoFid);
    }

    @Test
    public void test999_05008_FunctionalArea() throws Exception
    {
        //功能面 关联无名称POI
        SearchLocation(LOC_K3);
        String[][] attrib1 = {{Page_POI.SELECT_TYPE, "大厦/写字楼"}};
        String infoFid =AddPOI(attrib1,"捕捉点位新增");
        //新增物流园
        //SearchLocation(LOC_K1);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.FUNCTIONAL_SURFACE);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Click(new Point(500,500));
        Page_MainBoard.Inst.Click(new Point(800,500));
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.COMPLETE);
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.PARK);
        Page_FunctionalArea.Inst.Drag(1634,1164,1634,600,5);
        Page_FunctionalArea.Inst.SetValue(Page_FunctionalArea.NAME,"测试");
        Page_FunctionalArea.Inst.ClickbyText("关联POI");
        Thread.sleep(2000);
        Page_FunctionalArea.Inst.ClickCenter();
        Thread.sleep(2000);
        String str = Page_FunctionalArea.Inst.GetValue(Page_FunctionalArea.RELATIEPOI);
        assertEquals("<无名称>",str);
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.RELATIEPOI);
        str = Page_FunctionalArea.Inst.GetValue(Page_FunctionalArea.TITLE);
        assertEquals("提示信息",str);
        str = Page_FunctionalArea.Inst.GetValue(Page_FunctionalArea.TEXT);
        assertEquals("正在关联POI,请选择操作",str);
        str = Page_FunctionalArea.Inst.GetValue(Page_FunctionalArea.REBUILDREL);
        assertEquals("重新建立",str);
        str = Page_FunctionalArea.Inst.GetValue(Page_FunctionalArea.DELELEREL);
        assertEquals("删除关联POI",str);
        str = Page_FunctionalArea.Inst.GetValue(Page_FunctionalArea.CANCLEADDREL);
        assertEquals("取消",str);
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.CANCLEADDREL);
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据
        Page_MyData.Inst.isExistByName("功能面");
        Page_MyData.Inst.ClickbyText("功能面");
        Thread.sleep(2000);
        String rowkey = Page_TruckLimitLane.Inst.GetRowKey();
        Page_FunctionalArea.Inst.ClickbyText("修改形状");
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.MODIFY_SAVE);
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);
        ExitMyData();

        Sqlitetools.RefreshData();
        String temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        String pFid = jsonObject.getString("pFid");
        assertEquals(pFid,infoFid);
    }
    //我的数据中暂时不支持关联POI操作(自然语音同理)
//    @Test
//    public void test999_05009_FunctionalArea() throws Exception
//    {
//        //功能面 关联无名称POI
//        SearchLocation(LOC_K3);
//        String[][] attrib1 = {{Page_POI.NAME, "大厦ＴＥＳＴ１"},
//                {Page_POI.SELECT_TYPE, "大厦/写字楼"}};
//        String infoFid1 =AddPOI(attrib1,"捕捉点位新增");
//        String[][] attrib2 = {{Page_POI.SELECT_TYPE, "大厦/写字楼"}};
//        String infoFid2 =AddPOI(attrib2,"捕捉点位新增");
//        String[][] attrib3 = {{Page_POI.NAME, "紧急停车带"},
//                {Page_POI.SELECT_TYPE, "紧急停车带"}};
//        String infoFid3 =AddPOI(attrib3);
//        //新增物流园
//        //SearchLocation(LOC_K1);
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.FUNCTIONAL_SURFACE);
//        Page_MainBoard.Inst.ClickCenter();
//        Page_MainBoard.Inst.Click(new Point(500,500));
//        Page_MainBoard.Inst.Click(new Point(800,500));
//        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.COMPLETE);
//        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.PARK);
//        Page_FunctionalArea.Inst.Drag(1634,1164,1634,600,5);
//        Page_FunctionalArea.Inst.SetValue(Page_FunctionalArea.NAME,"测试");
//        Page_FunctionalArea.Inst.ClickbyText("关联POI");
//        Thread.sleep(2000);
//        Page_FunctionalArea.Inst.ClickCenter();
//        String str = Page_FunctionalArea.Inst.GetValue(Page_FunctionalArea.TVTITLE);
//        assertEquals("请选择关联POI",str);
//        Thread.sleep(2000);
//        Page_FunctionalArea.Inst.ClickbyText("大厦ＴＥＳＴ１");
//        str = Page_FunctionalArea.Inst.GetValue(Page_FunctionalArea.RELATIEPOI);
//        assertEquals("大厦ＴＥＳＴ１",str);
//        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);
//
//        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据
//        Page_MyData.Inst.isExistByName("功能面");
//        Page_MyData.Inst.ClickbyText("功能面");
//        Thread.sleep(2000);
//        String rowkey = Page_TruckLimitLane.Inst.GetRowKey();
//        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);
//        ExitMyData();
//
//        Sqlitetools.RefreshData();
//        String temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
//        JSONObject jsonObject = new JSONObject(temp);
//        String pFid = jsonObject.getString("pFid");
//        assertEquals(pFid,infoFid1);
//
//        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据
//        Page_MyData.Inst.ClickbyText("功能面");
//        Thread.sleep(2000);
//        Page_FunctionalArea.Inst.Drag(1634,1164,1634,600,5);
//        Page_FunctionalArea.Inst.ClickbyText("大厦ＴＥＳＴ１");
//        Page_FunctionalArea.Inst.ClickbyText("删除关联POI");
//        Page_FunctionalArea.Inst.ClickbyText("关联POI");
//        Page_FunctionalArea.Inst.ClickCenter();
//        //Page_FunctionalArea.Inst.ClickbyText("");
//        Page_FunctionalArea.Inst.ClickbyText("紧急停车带");
//        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);
//        ExitMyData();
//
//        Sqlitetools.RefreshData();
//        temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
//        jsonObject = new JSONObject(temp);
//        pFid = jsonObject.getString("pFid");
//        assertEquals(pFid,infoFid3);
//
//        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据
//        Page_MyData.Inst.ClickbyText("功能面");
//        Thread.sleep(2000);
//        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.RELATIEPOI);
//        Page_FunctionalArea.Inst.ClickbyText("重新建立");
//        Page_FunctionalArea.Inst.ClickCenter();
//        Page_FunctionalArea.Inst.ClickbyText("");
//        str = Page_FunctionalArea.Inst.GetValue(Page_FunctionalArea.RELATIEPOI);
//        assertEquals("<无名称>",str);
//        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);
//        ExitMyData();
//
//        Sqlitetools.RefreshData();
//        temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
//        jsonObject = new JSONObject(temp);
//        pFid = jsonObject.getString("pFid");
//        assertEquals(pFid,infoFid2);
//    }
//
//    @Test
//    public void test999_05010_FunctionalArea() throws Exception
//    {
//        //功能面 关联无名称POI
//        SearchLocation(LOC_K3);
//        String[][] attrib1 = {{Page_POI.NAME, "大厦ＴＥＳＴ１"},
//                {Page_POI.SELECT_TYPE, "大厦/写字楼"}};
//        String infoFid1 =AddPOI(attrib1,"捕捉点位新增");
//        String[][] attrib2 = {{Page_POI.SELECT_TYPE, "大厦/写字楼"}};
//        String infoFid2 =AddPOI(attrib2,"捕捉点位新增");
//        String[][] attrib3 = {{Page_POI.NAME, "紧急停车带"},
//                {Page_POI.SELECT_TYPE, "紧急停车带"}};
//        String infoFid3 =AddPOI(attrib3);
//
//        synchronize(Page_GridManager.POI_UPDATE);
//        //新增物流园
//        SearchLocation(LOC_K3);
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.FUNCTIONAL_SURFACE);
//        Page_MainBoard.Inst.ClickCenter();
//        Page_MainBoard.Inst.Click(new Point(500,500));
//        Page_MainBoard.Inst.Click(new Point(800,500));
//        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.COMPLETE);
//        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.PARK);
//        Page_FunctionalArea.Inst.Drag(1634,1164,1634,600,5);
//        Page_FunctionalArea.Inst.SetValue(Page_FunctionalArea.NAME,"测试");
//        Page_FunctionalArea.Inst.ClickbyText("关联POI");
//        Thread.sleep(2000);
//        Page_FunctionalArea.Inst.ClickCenter();
//        String str = Page_FunctionalArea.Inst.GetValue(Page_FunctionalArea.TVTITLE);
//        assertEquals("请选择关联POI",str);
//        Thread.sleep(2000);
//        Page_FunctionalArea.Inst.ClickbyText("大厦ＴＥＳＴ１");
//        str = Page_FunctionalArea.Inst.GetValue(Page_FunctionalArea.RELATIEPOI);
//        assertEquals("大厦ＴＥＳＴ１",str);
//        Page_FunctionalArea.Inst.ClickbyText("大厦ＴＥＳＴ１");
//        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);
//
//        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据
//        Page_MyData.Inst.isExistByName("功能面");
//        Page_MyData.Inst.ClickbyText("功能面");
//        Thread.sleep(2000);
//        String rowkey = Page_TruckLimitLane.Inst.GetRowKey();
//        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);
//        ExitMyData();
//
//        Sqlitetools.RefreshData();
//        String temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
//        JSONObject jsonObject = new JSONObject(temp);
//        String pFid = jsonObject.getString("pFid");
//        assertEquals(pFid,infoFid1);
//
//        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据
//        Page_MyData.Inst.ClickbyText("功能面");
//        Thread.sleep(2000);
//        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.RELATIEPOI);
//        Page_FunctionalArea.Inst.ClickbyText("删除关联POI");
//        Page_FunctionalArea.Inst.ClickbyText("关联POI");
//        Page_FunctionalArea.Inst.ClickCenter();
//        //Page_FunctionalArea.Inst.ClickbyText("");
//        Page_FunctionalArea.Inst.ClickbyText("紧急停车带");
//        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);
//        ExitMyData();
//
//        Sqlitetools.RefreshData();
//        temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
//        jsonObject = new JSONObject(temp);
//        pFid = jsonObject.getString("pFid");
//        assertEquals(pFid,infoFid3);
//
//        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据
//        Page_MyData.Inst.ClickbyText("功能面");
//        Thread.sleep(2000);
//        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.RELATIEPOI);
//        Page_FunctionalArea.Inst.ClickbyText("重新建立");
//        Page_FunctionalArea.Inst.ClickCenter();
//        Page_FunctionalArea.Inst.ClickbyText("");
//        str = Page_FunctionalArea.Inst.GetValue(Page_FunctionalArea.RELATIEPOI);
//        assertEquals("<无名称>",str);
//        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);
//        ExitMyData();
//
//        Sqlitetools.RefreshData();
//        temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
//        jsonObject = new JSONObject(temp);
//        pFid = jsonObject.getString("pFid");
//        assertEquals(pFid,infoFid2);
//    }
//
//    @Test
//    public void test999_05011_FunctionalArea() throws Exception
//    {
//        //功能面 关联有名称POI
//        SearchLocation(LOC_K3);
//        String[][] attrib1 = {{Page_POI.NAME, "大厦ＴＥＳＴ１"},
//                {Page_POI.SELECT_TYPE, "大厦/写字楼"}};
//        String infoFid =AddPOI(attrib1,"捕捉点位新增");
//        //新增物流园
//        //SearchLocation(LOC_K1);
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.FUNCTIONAL_SURFACE);
//        Page_MainBoard.Inst.ClickCenter();
//        Page_MainBoard.Inst.Click(new Point(500,500));
//        Page_MainBoard.Inst.Click(new Point(800,500));
//        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.COMPLETE);
//        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.PARK);
//        String rowkey = Page_TruckLimitLane.Inst.GetRowKey();
//        Page_FunctionalArea.Inst.Drag(1634,1164,1634,600,5);
//        Page_FunctionalArea.Inst.SetValue(Page_FunctionalArea.NAME,"测试");
//        Page_FunctionalArea.Inst.ClickbyText("关联POI");
//        Page_FunctionalArea.Inst.ClickCenter();
//        Thread.sleep(2000);
//        String str = Page_FunctionalArea.Inst.GetValue(Page_FunctionalArea.RELATIEPOI);
//        assertEquals("大厦ＴＥＳＴ１",str);
//        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);
//
//        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
//        Page_MyData.Inst.ClickbyText("大厦ＴＥＳＴ１");
//        Page_POI.Inst.SetValue(Page_POI.NAME,"");
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据
//        Page_MyData.Inst.ClickbyText("功能面");
//        Thread.sleep(2000);
//        str = Page_FunctionalArea.Inst.GetValue(Page_FunctionalArea.RELATIEPOI);
//        assertEquals(str,"大厦ＴＥＳＴ１");
//        Page_FunctionalArea.Inst.ClickbyText("重新建立");
//        Page_FunctionalArea.Inst.ClickCenter();
//        str = Page_FunctionalArea.Inst.GetValue(Page_FunctionalArea.RELATIEPOI);
//        assertEquals("<无名称>",str);
//        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);
//        ExitMyData();
//
//        Sqlitetools.RefreshData();
//        String temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
//        JSONObject jsonObject = new JSONObject(temp);
//        String pFid = jsonObject.getString("pFid");
//        assertEquals(pFid,infoFid);
//    }
    @Test
    public void test999_05012_FunctionalArea() throws Exception
    {
        //功能面 关联无名称POI
        SearchLocation(LOC_K3);
        String[][] attrib1 = {{Page_POI.NAME, "大厦ＴＥＳＴ１"},
                {Page_POI.SELECT_TYPE, "大厦/写字楼"}};
        String infoFid1 =AddPOI(attrib1,"捕捉点位新增");
        String[][] attrib2 = {{Page_POI.SELECT_TYPE, "大厦/写字楼"}};
        String infoFid2 =AddPOI(attrib2,"捕捉点位新增");
        String[][] attrib3 = {{Page_POI.NAME, "紧急停车带"},
                {Page_POI.SELECT_TYPE, "紧急停车带"}};
        String infoFid3 =AddPOI(attrib3,"捕捉点位新增");
        //新增物流园
        SearchLocation(LOC_K3);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.FUNCTIONAL_SURFACE);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Click(new Point(500,500));
        Page_MainBoard.Inst.Click(new Point(800,500));
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.COMPLETE);
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.PARK);
        Page_FunctionalArea.Inst.Drag(1634,1164,1634,600,5);
        Page_FunctionalArea.Inst.SetValue(Page_FunctionalArea.NAME,"测试");
        Page_FunctionalArea.Inst.ClickbyText("关联POI");
        Thread.sleep(2000);
        Page_FunctionalArea.Inst.ClickCenter();
        String str = Page_FunctionalArea.Inst.GetValue(Page_FunctionalArea.TVTITLE);
        assertEquals("请选择关联POI",str);
        Thread.sleep(2000);
        Page_FunctionalArea.Inst.ClickbyText("大厦ＴＥＳＴ１");
        str = Page_FunctionalArea.Inst.GetValue(Page_FunctionalArea.RELATIEPOI);
        assertEquals("大厦ＴＥＳＴ１",str);
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据
        Page_MyData.Inst.isExistByName("功能面");
        Page_MyData.Inst.ClickbyText("功能面");
        Thread.sleep(2000);
        String rowkey = Page_TruckLimitLane.Inst.GetRowKey();
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);
        ExitMyData();

        Sqlitetools.RefreshData();
        String temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        String pFid = jsonObject.getString("pFid");
        assertEquals(pFid,infoFid1);

        String[] tempLoc= {"116.45368", "39.95903"};
        SearchLocation(tempLoc);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_FunctionalArea.Inst.Drag(1634,1164,1634,600,5);
        Page_FunctionalArea.Inst.ClickbyText("大厦ＴＥＳＴ１");
        Page_FunctionalArea.Inst.ClickbyText("删除关联POI");
        Page_FunctionalArea.Inst.ClickbyText("关联POI");
        Thread.sleep(2000);
        Page_FunctionalArea.Inst.Click(new Point(1219,900));//poi当前位置
        //Page_FunctionalArea.Inst.ClickbyText("");
        Page_FunctionalArea.Inst.ClickbyText("紧急停车带");
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);

        Sqlitetools.RefreshData();
        temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        jsonObject = new JSONObject(temp);
        pFid = jsonObject.getString("pFid");
        assertEquals(pFid,infoFid3);

        SearchLocation(tempLoc);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_FunctionalArea.Inst.Drag(1634,1164,1634,600,5);
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.RELATIEPOI);
        Page_FunctionalArea.Inst.ClickbyText("重新建立");
        Thread.sleep(2000);
        Page_FunctionalArea.Inst.Click(new Point(1219,900));
        Page_FunctionalArea.Inst.ClickbyText("大厦ＴＥＳＴ１");
        str = Page_FunctionalArea.Inst.GetValue(Page_FunctionalArea.RELATIEPOI);
        assertEquals("大厦ＴＥＳＴ１",str);
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);

        Sqlitetools.RefreshData();
        temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        jsonObject = new JSONObject(temp);
        pFid = jsonObject.getString("pFid");
        assertEquals(pFid,infoFid1);
    }
//
//    @Test
//    public void test999_05013_FunctionalArea() throws Exception
//    {
//        //功能面 关联无名称POI
//        SearchLocation(LOC_K3);
//        String[][] attrib1 = {{Page_POI.NAME, "大厦ＴＥＳＴ１"},
//                {Page_POI.SELECT_TYPE, "大厦/写字楼"}};
//        String infoFid1 =AddPOI(attrib1,"捕捉点位新增");
//        String[][] attrib2 = {{Page_POI.SELECT_TYPE, "大厦/写字楼"}};
//        String infoFid2 =AddPOI(attrib2,"捕捉点位新增");
//        String[][] attrib3 = {{Page_POI.NAME, "紧急停车带"},
//                {Page_POI.SELECT_TYPE, "紧急停车带"}};
//        String infoFid3 =AddPOI(attrib3);
//
//        synchronize(Page_GridManager.POI_UPDATE);
//        //新增物流园
//        SearchLocation(LOC_K3);
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.FUNCTIONAL_SURFACE);
//        Page_MainBoard.Inst.ClickCenter();
//        Page_MainBoard.Inst.Click(new Point(500,500));
//        Page_MainBoard.Inst.Click(new Point(800,500));
//        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.COMPLETE);
//        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.PARK);
//        Page_FunctionalArea.Inst.Drag(1634,1164,1634,600,5);
//        Page_FunctionalArea.Inst.SetValue(Page_FunctionalArea.NAME,"测试");
//        Page_FunctionalArea.Inst.ClickbyText("关联POI");
//        Thread.sleep(2000);
//        Page_FunctionalArea.Inst.ClickCenter();
//        String str = Page_FunctionalArea.Inst.GetValue(Page_FunctionalArea.TVTITLE);
//        assertEquals("请选择关联POI",str);
//        Thread.sleep(2000);
//        Page_FunctionalArea.Inst.ClickbyText("大厦ＴＥＳＴ１");
//        str = Page_FunctionalArea.Inst.GetValue(Page_FunctionalArea.RELATIEPOI);
//        assertEquals("大厦ＴＥＳＴ１",str);
//        Page_FunctionalArea.Inst.ClickbyText("大厦ＴＥＳＴ１");
//        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);
//
//        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据
//        Page_MyData.Inst.isExistByName("功能面");
//        Page_MyData.Inst.ClickbyText("功能面");
//        Thread.sleep(2000);
//        String rowkey = Page_TruckLimitLane.Inst.GetRowKey();
//        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);
//        ExitMyData();
//
//        Sqlitetools.RefreshData();
//        String temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
//        JSONObject jsonObject = new JSONObject(temp);
//        String pFid = jsonObject.getString("pFid");
//        assertEquals(pFid,infoFid1);
//
//        String[] tempLoc= {"116.45368", "39.95903"};
//        SearchLocation(tempLoc);
//        Page_MainBoard.Inst.ClickCenter();
//        Thread.sleep(2000);
//        Page_FunctionalArea.Inst.Drag(1634,1164,1634,600,5);
//        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.RELATIEPOI);
//        Page_FunctionalArea.Inst.ClickbyText("删除关联POI");
//        Page_FunctionalArea.Inst.ClickbyText("关联POI");
//        Page_FunctionalArea.Inst.ClickCenter();
//        //Page_FunctionalArea.Inst.ClickbyText("");
//        Page_FunctionalArea.Inst.ClickbyText("紧急停车带");
//        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);
//
//        Sqlitetools.RefreshData();
//        temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
//        jsonObject = new JSONObject(temp);
//        pFid = jsonObject.getString("pFid");
//        assertEquals(pFid,infoFid3);
//
//        //String[] tempLoc= {"116.45368", "39.95903"};
//        SearchLocation(tempLoc);
//        Page_MainBoard.Inst.ClickCenter();
//        Thread.sleep(2000);
//        Page_FunctionalArea.Inst.Drag(1634,1164,1634,600,5);
//        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.RELATIEPOI);
//        Page_FunctionalArea.Inst.ClickbyText("重新建立");
//        Page_FunctionalArea.Inst.ClickCenter();
//        Page_FunctionalArea.Inst.ClickbyText("");
//        str = Page_FunctionalArea.Inst.GetValue(Page_FunctionalArea.RELATIEPOI);
//        assertEquals("<无名称>",str);
//        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);
//
//        Sqlitetools.RefreshData();
//        temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
//        jsonObject = new JSONObject(temp);
//        pFid = jsonObject.getString("pFid");
//        assertEquals(pFid,infoFid2);
//    }

    @Test
    public void test999_05014_FunctionalArea() throws Exception
    {
        //功能面 关联有名称POI
        SearchLocation(LOC_K3);
        String[][] attrib1 = {{Page_POI.NAME, "大厦ＴＥＳＴ１"},
                {Page_POI.SELECT_TYPE, "大厦/写字楼"}};
        String infoFid =AddPOI(attrib1,"捕捉点位新增");
        //新增物流园
        SearchLocation(LOC_K3);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.FUNCTIONAL_SURFACE);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Click(new Point(500,500));
        Page_MainBoard.Inst.Click(new Point(800,500));
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.COMPLETE);
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.PARK);
        Page_FunctionalArea.Inst.Drag(1634,1164,1634,600,5);
        Page_FunctionalArea.Inst.SetValue(Page_FunctionalArea.NAME,"测试");
        Page_FunctionalArea.Inst.ClickbyText("关联POI");
        Thread.sleep(2000);
        Page_FunctionalArea.Inst.ClickCenter();
        String str = Page_FunctionalArea.Inst.GetValue(Page_FunctionalArea.RELATIEPOI);
        assertEquals("大厦ＴＥＳＴ１",str);
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.ClickbyText("大厦ＴＥＳＴ１");
        Page_POI.Inst.SetValue(Page_POI.NAME,"");
        Page_POI.Inst.Click(Page_POI.SAVE);
        ExitMyData();

        String[] tempLoc= {"116.45368", "39.95903"};
        SearchLocation(tempLoc);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        String rowkey = Page_TruckLimitLane.Inst.GetRowKey();
        Page_FunctionalArea.Inst.Drag(1634,1164,1634,600,5);
        str = Page_FunctionalArea.Inst.GetValue(Page_FunctionalArea.RELATIEPOI);
        assertEquals(str,"<无名称>");
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);

        Sqlitetools.RefreshData();
        String temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        String pFid = jsonObject.getString("pFid");
        assertEquals(pFid,infoFid);
    }

    @Test
    public void test999_06501_poi_father_add() throws Exception
    {//poi父子关系 上传两个POI 删除数据库 下载子
        String[][] attrib2 = {{Page_POI.NAME, "级酒店"},
                {Page_POI.SELECT_TYPE, "星级酒店"}};
        String infoFid = AddPOI(attrib2, "116.40728", "39.95918","捕捉点位新增");

        String[][] attrib1 = {{Page_POI.NAME, "餐馆TES"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.POI_FATHER,"级酒店"}};
        AddPOI(attrib1, "116.40528", "39.95918","捕捉点位新增");


        synchronize(Page_GridManager.POI_UPDATE);
        SearchLocation("116.40728", "39.95918");
        synchronize(Page_GridManager.POI_UPDATE);

        testFastMapBase.ClearData();
        SearchLocation("116.40528", "39.95918");
        synchronize(Page_GridManager.POI_UPDATE);
        Thread.sleep(2000);
        Page_POI.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_POI.Inst.ClickByText("餐馆ＴＥＳ");
        String str = Page_POI.Inst.GetValue(Page_POI.POI_FATHER);
        assertEquals(infoFid,str);
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Thread.sleep(2000);
        Page_POI.Inst.ClickByText("定位父POI");
        Thread.sleep(3000);
        str = Page_POI.Inst.GetValue(Page_POI.POPNAME);
        assertEquals("级酒店",str);
    }

    @Test
    public void test999_06502_pas_father_add() throws Exception
    {
        //只能手动建立父子关系
        SearchLocation("116.40828", "39.95918");
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        String strFid = Page_PAS.Inst.GetValue(Page_PAS.FID);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "测试点门牌");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "102");
        Page_PAS.Inst.Click(Page_PAS.ODD);
        Page_PAS.Inst.Click(Page_PAS.ROAD_TYPE);
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        SearchLocation("116.40628", "39.95918");
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "测试点门牌");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "103");
        Page_PAS.Inst.Click(Page_PAS.ODD);
        Page_PAS.Inst.Click(Page_PAS.ROAD_TYPE);
        Page_PAS.Inst.Click(Page_PAS.DOOR_PAS);
        Page_PAS.Inst.Click(Page_PAS.PAS_FATHER);
        Thread.sleep(2000);
        Page_PAS.Inst.ClickbyText("测试点门牌１０２");
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        synchronize(Page_GridManager.POI_UPDATE);
        SearchLocation("116.40628", "39.95918");
        Page_PAS.Inst.ClickCenter();
        String str = Page_PAS.Inst.GetValue(Page_PAS.PAS_FATHER);
        assertEquals(strFid,str);
        Page_PAS.Inst.Click(Page_PAS.PAS_FATHER);
        Thread.sleep(2000);
        Page_PAS.Inst.ClickByText("定位父POI");
        Thread.sleep(3000);
//        str = Page_PAS.Inst.GetValue(Page_PAS.POPNAME);
//        assertEquals("测试点门牌１０１",str);
    }

//    @Test
//    public void test999_06601_GridAddPas() throws Exception
//    {
//        //Grid无任务模式下下载点门牌
//        noTaskDownload(Page_GridManager.PAS_UPDATE);
//    }
//
//    @Test
//    public void test999_06602_GridAddPas() throws Exception
//    {
//        //Grid无任务模式下增加点门牌
//        String[][] attrib= {
//                {Page_POI.NAME, "测试"},
//                {Page_POI.SELECT_TYPE, "中餐馆"}
//        };
//        AddPOI(attrib);
//
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
//        Page_PAS.Inst.SetValue(Page_PAS.NAME, "测试点门牌");
//        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "101");
//        Page_PAS.Inst.Click(Page_PAS.ODD);
//        Page_PAS.Inst.Click(Page_PAS.ROAD_TYPE);
//        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);
//        Page_PAS.Inst.Click(Page_PAS.SAVE);
//
//        noTaskUploadCheck_yang(Page_GridManager.POI_UPDATE);
//        String str = Page_GridManager.Inst.GetValue(Page_GridManager.SHOWDATA);
//        assertEquals(" POI：1 情报：0",str);
//        Page_GridManager.Inst.ClickByText("确定"); //入库结果
//        Page_GridManager.Inst.Click(Page_GridManager.BACK);
//        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
//
//        noTaskUploadCheck_yang(Page_GridManager.INTEGRATE_UPDATE);
//        str = Page_GridManager.Inst.GetValue(Page_GridManager.SHOWDATA);
//        assertEquals(" Tips：0 POI：1 点门牌：1 情报：0",str);
//        Page_GridManager.Inst.ClickByText("确定"); //入库结果
//        Page_GridManager.Inst.Click(Page_GridManager.BACK);
//        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
//
//        noTaskUploadCheck_yang(Page_GridManager.PAS_UPDATE);
//        str = Page_GridManager.Inst.GetValue(Page_GridManager.SHOWDATA);
//        assertEquals(" 点门牌：1 情报：0",str);
//        Page_GridManager.Inst.ClickByText("确定"); //入库结果
//        Page_GridManager.Inst.Click(Page_GridManager.BACK);
//        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
//    }


//////////////月基线功能用例结束////////////////////////////////


}