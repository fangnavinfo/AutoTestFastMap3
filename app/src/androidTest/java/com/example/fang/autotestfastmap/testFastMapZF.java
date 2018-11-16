package com.example.fang.autotestfastmap;

import android.support.test.uiautomator.UiObject2;

import com.fang.testAdapter.*;
import com.fastmap.ui.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

/**
 * Created by fang on 17/11/21.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testFastMapZF extends testFastMapBase {
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

        if (currTestName.getMethodName().equals("test00101_licence_plate_check")) {
            setClassUpByLicenceCheck("collector2", "123456", "鄂A12345");
        } else if (currTestName.getMethodName().equals("test00101_poi_hm_brand_check")) {
            this.setClassUp("zhanglingling03655", "036550", true);
        } else {
            setClassUp("collector2", "123456");
        }
    }

    @After
    public void setAfter() //throws IOException, InterruptedException {
    {

        //super.setAfter();
        CPUMonitor.Assert();
    }


    // 车牌录入校验
    @Test
    @IMPORTANT
    public void test00101_licence_plate_check() throws Exception {

        String carNum;
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainBoard.Inst.Drag(100, 600, 100, 200, 10);
        Thread.sleep(1000);
        Page_MainMenu.Inst.Click(Page_MainMenu.EXIT);

        Page_Confirm.Inst.Click(Page_Confirm.OK);
        Page_Login.Inst.Click(Page_Login.CAR_MODE_RADIO);
        carNum = Page_Login.Inst.GetValue(Page_Login.CAR_NUM);

        assertEquals("鄂A12345", carNum);
    }

    // POI 分类品牌表增加港澳标识
    @Test
    public void test00101_poi_hm_brand_check() throws Exception {

        if (FastMapPage.IS_OS_TEST) {
            return;
        }

        String[][] attrib = {
                {Page_POI.NAME, "测试ＰＯＩ"},
                {Page_POI.SELECT_TYPE, "厂家一览表内汽车修理"},
                {Page_POI.SELECT_BRAND, "丰田维修"},
        };

        AddPOI(attrib);

        GotoMyData(Page_MyData.POI_TYPE);
        Assert.assertTrue(Page_MyData.Inst.isExistByName("测试ＰＯＩ"));
    }


    // POI 联系方式去除手机号不能以19开头的限制
    @Test
    public void test00102_1_poi_telnum_check() throws Exception {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"}};
        AddPOI(attrib);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        assertTrue(Page_POI.Inst.isExistByName("19012345678"));
    }

    // POI 联系方式去除手机号不能以146开头的限制
    @Test
    public void test00102_2_poi_telnum_check() throws Exception {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "14612345678"}};
        AddPOI(attrib);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        assertTrue(Page_POI.Inst.isExistByName("14612345678"));
    }

    // POI 联系方式去除手机号不能以148开头的限制
    @Test
    public void test00102_3_poi_telnum_check() throws Exception {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "14812345678"}};
        AddPOI(attrib);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        assertTrue(Page_POI.Inst.isExistByName("14812345678"));
    }

    // POI 联系方式去除手机号不能以166开头的限制
    @Test
    public void test00102_4_poi_telnum_check() throws Exception {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "16612345678"}};
        AddPOI(attrib);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        assertTrue(Page_POI.Inst.isExistByName("16612345678"));
    }

    // POI 电话号码输入后自动隐藏输入法
    @Test
    public void test00102_5_poi_telnum_check() throws Exception {

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.Click(Page_POI.TEL);

        Thread.sleep(1000);
        Page_POI.Inst.Click(new Point(685, 975));
        Page_POI.Inst.Click(new Point(1350, 975));
        Page_POI.Inst.Click(new Point(685, 975));
        Page_POI.Inst.Click(new Point(685, 975));
        Page_POI.Inst.Click(new Point(685, 975));
        Page_POI.Inst.Click(new Point(685, 975));
        Page_POI.Inst.Click(new Point(685, 975));
        Page_POI.Inst.Click(new Point(685, 975));
        Page_POI.Inst.Click(new Point(685, 975));
        Page_POI.Inst.Click(new Point(685, 975));
        Page_POI.Inst.Click(new Point(685, 975));

        Page_POI.Inst.Click(new Point(1945, 1480));

        assertTrue(Page_POI.Inst.isExistByName("返回"));

    }

    //采纳情报fid保存
    @Test
    @IMPORTANT
    public void test00103_1_poi_report_check() throws InterruptedException, NoSuchFieldException, ClassNotFoundException {
        // 上报情报
        addReport(Page_InfoPoint.POI_TYPE);
        // 同步情报
        synchronize_zhou(Page_GridManager.INFO_UPDATE);
        // 采纳情报
        accept();
        // 检查情报fid
        checkFid();

    }

    // 情报采纳新增POI原则
    @Test
    @IMPORTANT
    public void test00103_2_poi_report_check() throws InterruptedException, NoSuchFieldException, ClassNotFoundException {
        // 上报情报
        addReport(Page_InfoPoint.POI_TYPE);
        // 同步情报
        synchronize_zhou(Page_GridManager.INFO_UPDATE);
        // 采纳情报
        accept();

    }

    // 删除标记
    @Test
    @IMPORTANT
    public void test00104_tips_delete_check() throws Exception {
        String[] LIGHT_LOC = {"116.40631", "39.91562"};

        String infoRowkey = "";

        //添加红绿灯
        for (int i = 0; i < 2; i++) {
            SearchLocation(LIGHT_LOC);
            Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_LIGHT);
            Page_MainBoard.Inst.ClickCenter();

            GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据
            Page_MyData.Inst.SelectData("红绿灯");
            infoRowkey = Page_Light.Inst.GetValue(Page_Light.ROWKEY);
            Page_Light.Inst.Click(Page_Light.CANCEL);
            ExitMyData();

            IndoorCheckConfirm("红绿灯");

            //同步数据
            synchronize_zhou(Page_GridManager.TIPS_UPDATE);
        }


        //删除前定位红绿灯tips位置
        SearchLocation(LIGHT_LOC);

        //增加删除标记
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DELETE_ROAD_MARKER);
        Page_MainBoard.Inst.ClickCenter();
        Page_DeleteList.Inst.Click(Page_DeleteList.DELETE);

        IndoorCheckConfirm("红绿灯");

        //同步数据
        synchronize_zhou(Page_GridManager.TIPS_UPDATE);

        //确认
        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("红绿灯");
        String rowkey = Page_Light.Inst.GetValue(Page_Light.ROWKEY);
        Page_Light.Inst.Click(Page_Light.CANCEL);
        ExitMyData();

        assertEquals(infoRowkey, rowkey);

    }

    // POI 错误列表增加父子关系、同一关系错误类型
    @Test
    public void test00105_1_poi_father_error_check() throws Exception {
        String[] FATHER_LOC = {"116.40631", "39.91562"};
        String[] SON_LOC = {"116.40631", "39.91562"};

        String[][] attrib1 = {{Page_POI.NAME, "大厦TEST1"},
                {Page_POI.SELECT_TYPE, "大厦/写字楼"}};

        AddPOI(attrib1, "116.40557", "39.96121");

        String[][] attrib2 = {{Page_POI.NAME, "中餐馆TEST1"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.POI_FATHER, "大厦ＴＥＳＴ１"}};

        String infoFid = AddPOI(attrib2, "116.40667", "39.96115");

        SearchLocation("116.40557", "39.96121");
        synchronize_zhou(Page_GridManager.POI_UPDATE);

        //检查错误列表
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.ClickByText("错误列表");
        Page_ErrorList.Inst.ClickbyText("Poi");
        Page_ErrorList.Inst.ClickbyText("查看详情");

        String txtErrMessage = Page_ErrorList.Inst.GetValue(Page_ErrorList.ERROR_CONTENT);
        assertTrue(txtErrMessage.equals("子(fid:" + infoFid + ")不存在") || txtErrMessage.equals("子(" + infoFid + ")不存在"));
    }

    @Test
    public void test00105_2_poi_father_error_check() throws Exception {
        String[][] attrib1 = {{Page_POI.NAME, "大厦TEST1"},
                {Page_POI.SELECT_TYPE, "大厦/写字楼"}};
        String infoFid = AddPOI(attrib1, "116.40557", "39.96121");


        String[][] attrib2 = {{Page_POI.NAME, "中餐馆TEST1"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.POI_FATHER, "大厦ＴＥＳＴ１"}};

        AddPOI(attrib2, "116.40557", "39.96121");

        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MultiList.Inst.ClickbyText("中餐馆ＴＥＳＴ１");

        Page_POI.Inst.DeleteFather("大厦ＴＥＳＴ１");

        Thread.sleep(3000);

        //移动父POI
        Page_MultiList.Inst.Click(Page_MultiList.CHECK_LIST_ITEM);
        //Page_MultiList.Inst.Click(Page_MultiList.MOVE);
        Page_MultiList.Inst.Click(Page_MultiList.MOVE_POINT_AND_LINE);

        Page_MainBoard.Inst.Drag(1024, 816, 1024, 1160, 10);

        Page_MultiList.Inst.Click(Page_MultiList.MOVE_POINT_AND_LINE);
        Thread.sleep(3000);
        Page_MultiList.Inst.Click(Page_MultiList.CANCEL_POI);

        Sqlitetools.RefreshData();

        String child = new String((byte[]) Sqlitetools.GePoiDataByFid(infoFid, "relateChildren"));
        assertEquals(child, "[]");

    }

    //采集端父冠子名时加“-”
    @Test
    public void test00105_3_poi_father_name_check() throws Exception {

        String[][] attrib1 = {{Page_POI.NAME, "大厦TEST1"},
                {Page_POI.SELECT_TYPE, "大厦/写字楼"}};

        AddPOI(attrib1);

        String[][] attrib2 = {{Page_POI.NAME, "中餐馆TEST1"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.POI_FATHER, "大厦ＴＥＳＴ１"}};

        AddPOI(attrib2);


        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("中餐馆ＴＥＳＴ１");

        Page_POI.Inst.Click(Page_POI.NAME_ICON);

        assertEquals("大厦ＴＥＳＴ１-中餐馆ＴＥＳＴ１", Page_POI.Inst.GetValue(Page_POI.NAME));

        Page_POI.Inst.Click(Page_POI.NAME_ICON);

        assertEquals("中餐馆ＴＥＳＴ１", Page_POI.Inst.GetValue(Page_POI.NAME));
    }

    // POI 错误列表增加父子关系、同一关系错误类型
    @Test
    public void test00106_poi_same_error_check() throws Exception {

        String[][] attrib1 = {{Page_POI.NAME, "政府机关TEST"},
                {Page_POI.SELECT_TYPE, "区级政府机关(广州市）"}};

        AddPOI(attrib1, "116.40624", "39.96918");

        String[][] attrib2 = {{Page_POI.NAME, "银行TEST"},
                {Page_POI.SELECT_TYPE, "银行"},
                {Page_POI.POI_SAME, "政府机关ＴＥＳＴ"}};

        String infoFid = AddPOI(attrib2, "116.40628", "39.96918");

        SearchLocation("116.40624", "39.96918");
        synchronize_zhou(Page_GridManager.POI_UPDATE);

        //检查错误列表
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.ClickByText("错误列表");
        Page_ErrorList.Inst.ClickbyText("Poi");
        Page_ErrorList.Inst.ClickbyText("查看详情");

        String txtErrMessage = Page_ErrorList.Inst.GetValue(Page_ErrorList.ERROR_CONTENT);
        assertTrue(txtErrMessage.equals("同一poi(" + "fid:" + infoFid + ")在库中不存在") || txtErrMessage.equals("同一poi(" + infoFid + ")在库中不存在"));
    }

    // 高速实景图手动录入编号(需求取消)
    /*
    @Test @IMPORTANT
    public void test00107_tips_true_sence_check() throws Exception
    {
        //点击新增实景图POI
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUE_SCENE);
        Page_MainBoard.Inst.Click(new Point(700,268));

        //高速出口
        Page_TrueSence.Inst.Click(Page_TrueSence.HIGHWAY_LOAD_OUT);
        //输入编号
        Page_TrueSence.Inst.SetValue(Page_TrueSence.ET_IMG_NUMBER, "6bCD1234");

        //拍照5张并返回
        Page_TrueSence.Inst.Click(Page_TrueSence.CAMERA);
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(1000);

        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        //点击保存
        Page_TrueSence.Inst.Click(Page_TrueSence.SAVE);

        //获取rowkey
        GotoMyData(Page_MyData.TIPS_TYPE);

        Page_MyData.Inst.ClickbyText("实景图");
        String rowkey = Page_TrueSence.Inst.GetRowKey();
        Page_TrueSence.Inst.Click(Page_TrueSence.CANCEL);
        ExitMyData();

        //确认数据
        IndoorCheckConfirm("实景图");

        synchronize_zhou(Page_GridManager.TIPS_UPDATE);

        //根据rowkey查找该实景图
        SearchTips(rowkey);

        assertTrue(Page_TrueSence.Inst.isExistByName("6bCD1234"));
    }
    */
    // 功能面验证
    @Test
    @IMPORTANT
    public void test00108_1_functionalarea_check() throws Exception {
        //绘制功能面
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.FUNCTIONAL_SURFACE);
        Page_MainBoard.Inst.Click(new Point(500, 500));
        Page_MainBoard.Inst.Click(new Point(800, 500));
        Page_MainBoard.Inst.Click(new Point(500, 800));
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.COMPLETE);

        //选择大学类型功能面
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.UNIVERSITY);

        Page_FunctionalArea.Inst.SetValue(Page_FunctionalArea.NAME, "name1");

        //保存
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("功能面");

        Page_FunctionalArea.Inst.ScrollClick(Page_FunctionalArea.NAME_STATIC);

        assertTrue(Page_FunctionalArea.Inst.isExistByName("name1"));

    }

    // 功能面名称空格验证
    @Test
    @IMPORTANT
    public void test00108_2_functionalarea_check() throws Exception {
        //绘制功能面
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.FUNCTIONAL_SURFACE);
        Page_MainBoard.Inst.Click(new Point(500, 500));
        Page_MainBoard.Inst.Click(new Point(800, 500));
        Page_MainBoard.Inst.Click(new Point(500, 800));
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.COMPLETE);

        //选择大学类型功能面
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.UNIVERSITY);

        Page_FunctionalArea.Inst.SetValue(Page_FunctionalArea.NAME, "    ");

        //保存
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);

        assertTrue(Page_FunctionalArea.Inst.isExistByName("保存"));

    }

    // POI照片优化
    @Test
    public void test00109_poi_picture_check() throws Exception {
        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"}};
        AddPOI(attrib);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        try {
            Page_POI.Inst.Click(Page_POI.HIDE_POI_NAME);
        } catch (Exception e) {

        }

        Page_POI.Inst.ScrollClick(Page_POI.MULIT_MEDIA);

        Page_POI.Inst.Click(Page_POI.PICTURE);

        assertTrue(Page_TrueSence.Inst.isExistByName("保存"));

    }

    // 第三方数据验证
    @Test
    @IMPORTANT
    public void test00110_1_3rdParty_Data_check() throws Exception {
        if (FastMapPage.IS_OS_TEST) {
            return;
        }

        // 创建情报
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.POINT_INFO); //点击点情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(900, 500)); //点击情报位置

        Page_InfoPoint.Inst.SetValue(Page_InfoPoint.NAME, "测试上报情报TEST"); //输入情报名称
        Page_InfoPoint.Inst.Click(Page_InfoPoint.POI_TYPE);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.LEVEL_1);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.TIME); //点击选择时间
        Page_InfoPoint.Inst.Click(Page_InfoPoint.TIME_CONFIRM);

        Page_InfoPoint.Inst.Click(Page_InfoPoint.CAMERA);//拍照
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//点击拍照
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);//点击返回


        Page_InfoPoint.Inst.Click(Page_InfoPoint.SAVE); //点击保存

        Sqlitetools.RefreshData();

        GotoMyData(Page_MyData.INFO_TYPE);
        Page_MyData.Inst.ClickbyText("测试上报情报TEST");
        String globalId = Page_InfoPoint.Inst.GetValue(Page_InfoPoint.GLOBAL_ID).substring(10);
        Page_InfoPoint.Inst.ClickByText("取消");
        ExitMyData();

        testadapter.StopApp();

        testadapter.ClearWal();
        Sqlitetools.update3rdPartyInfo(globalId);

        testadapter.ClearWal();

        Sqlitetools.RefreshData();

        GotoMyData(Page_MyData.THIRD_TYPE);
        Page_MyData.Inst.ClickbyText("测试上报情报TEST");
        String globalId2 = Page_InfoPoint.Inst.GetValue(Page_InfoPoint.GLOBAL_ID).substring(10);
        assertTrue(globalId.equals(globalId2));

    }

    // 第三方数据验证 补充需求
    @Test
    @IMPORTANT
    public void test00110_2_3rdParty_Data_check() throws Exception {
        if (FastMapPage.IS_OS_TEST) {
            return;
        }

        // 创建情报
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.POINT_INFO); //点击点情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.ClickCenter(); //点击情报位置

        Page_InfoPoint.Inst.SetValue(Page_InfoPoint.NAME, "测试上报情报TEST1"); //输入情报名称
        Page_InfoPoint.Inst.Click(Page_InfoPoint.POI_TYPE);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.LEVEL_1);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.TIME); //点击选择时间
        Page_InfoPoint.Inst.Click(Page_InfoPoint.TIME_CONFIRM);

        Page_InfoPoint.Inst.Click(Page_InfoPoint.CAMERA);//拍照
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//点击拍照
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);//点击返回


        Page_InfoPoint.Inst.Click(Page_InfoPoint.SAVE); //点击保存


        // 创建情报
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.POINT_INFO); //点击点情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.ClickCenter(); //点击情报位置

        Page_InfoPoint.Inst.SetValue(Page_InfoPoint.NAME, "测试上报情报TEST2"); //输入情报名称
        Page_InfoPoint.Inst.Click(Page_InfoPoint.POI_TYPE);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.LEVEL_1);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.TIME); //点击选择时间
        Page_InfoPoint.Inst.Click(Page_InfoPoint.TIME_CONFIRM);

        Page_InfoPoint.Inst.Click(Page_InfoPoint.CAMERA);//拍照
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//点击拍照
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);//点击返回


        Page_InfoPoint.Inst.Click(Page_InfoPoint.SAVE); //点击保存

        Sqlitetools.RefreshData();

//        GotoMyData(Page_MyData.INFO_TYPE);
//        Page_MyData.Inst.ClickbyText("自采集情报(POI)(点)");
//        String globalId = Page_InfoPoint.Inst.GetValue(Page_InfoPoint.GLOBAL_ID).substring(10);
//        Page_InfoPoint.Inst.ClickByText("取消");
//        ExitMyData();

        testadapter.StopApp();

        testadapter.ClearWal();
        Sqlitetools.update3rdPartyInfo("");

        testadapter.ClearWal();

        Sqlitetools.RefreshData();

        Page_MainBoard.Inst.ClickCenter();

    }

    // 精细化作业要素渲染
    @Test
    public void test00111_hide_feature_check() throws Exception {
        // 创建点门牌
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);

        Page_PAS.Inst.SetValue(Page_PAS.NAME, "测试ＰＡＳ");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "101");
        Page_PAS.Inst.Click(Page_PAS.ODD);
        Page_PAS.Inst.Click(Page_PAS.ROAD_TYPE);
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        //隐藏要素
        Page_MainBoard.Inst.Click(Page_MainBoard.MODE);
        Page_MainBoard.Inst.Click(Page_MainBoard.REFINEMENT);
        Page_MainBoard.Inst.Click(Page_MainBoard.CLOSE);

        Page_MainBoard.Inst.ClickCenter();

        //点击要素
        assertTrue(!Page_TrueSence.Inst.isExistByName("保存"));

        //还原渲染开关
        Page_MainBoard.Inst.Click(Page_MainBoard.MODE);
        Page_MainBoard.Inst.Click(Page_MainBoard.REFINEMENT);
        Page_MainBoard.Inst.Click(Page_MainBoard.CLOSE);


    }

    // 入库结果对话框去掉大区内/跨大区的提示信息
    @Test
    public void test00112_sync_over_grid_check() throws Exception {
        String[] FATHER_LOC = {"116.40631", "39.91562"};
        String[] SON_LOC = {"116.40631", "39.91562"};

        String[][] attrib1 = {{Page_POI.NAME, "大厦TEST1"},
                {Page_POI.SELECT_TYPE, "大厦/写字楼"}};

        AddPOI(attrib1, "116.40557", "39.96121");

        String[][] attrib2 = {{Page_POI.NAME, "中餐馆TEST1"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.POI_FATHER, "大厦ＴＥＳＴ１"}};

        String infoFid = AddPOI(attrib2, "116.40667", "39.96115");

        SearchLocation("116.40557", "39.96121");

        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.GRID_MANAGER); //Grid管理
        Page_GridManager.Inst.Click(Page_GridManager.PROJECT_BUTTON);
        Thread.sleep(1000);
        Page_MainBoard.Inst.ClickCenter();

        Thread.sleep(1000);
        Page_GridManager.Inst.Click(Page_GridManager.POI_UPDATE); //情报数据
        Thread.sleep(1000);
        Page_GridManager.Inst.ClickByText("同步数据"); //同步
        Page_GridManager.Inst.Click(Page_GridManager.NO_TASK_CONFIRM);
        Thread.sleep(1000);
        Page_GridManager.Inst.Click(Page_GridManager.STATIS_CONFIRM);

        Page_GridManager.Inst.Click(Page_GridManager.GRID_SYNC_BTN_POSITIVE);

        Thread.sleep(1000);

        boolean rst = Page_GridManager.Inst.isExistByName("大区");

        assertEquals(rst, false);
    }

    // POI 卡车标识验证
    @Test
    public void test00113_1_poi_truck_check() throws Exception {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"}};
        AddPOI(attrib);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        assertTrue(Page_POI.Inst.isExistByName("非卡车"));
    }

    // POI 卡车标识验证
    /*
    @Test
    public void test00113_2_poi_truck_check() throws Exception
    {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"},
                {Page_POI.POI_TRUCK, "仅卡车"}};
        AddPOI(attrib);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        assertTrue(Page_POI.Inst.isExistByName("仅卡车"));
    }
    */
    // POI 卡车标识验证
    @Test
    public void test00113_3_poi_truck_check() throws Exception {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"},
                {Page_POI.POI_TRUCK, "卡车+小汽车"}};
        AddPOI(attrib);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        assertTrue(Page_POI.Inst.isExistByName("卡车+小汽车"));
    }

    // POI 标记字段验证
    @Test
    public void test00114_1_poi_remark_check() throws Exception {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"},
                {Page_POI.POI_REMARK, "名称"}};
        AddPOI(attrib);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        assertTrue(Page_POI.Inst.isExistByName("名称"));
    }

    // POI 标记字段验证
    @Test
    public void test00114_2_poi_remark_check() throws Exception {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"},
                {Page_POI.POI_REMARK, "电话"}};
        AddPOI(attrib);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        assertTrue(Page_POI.Inst.isExistByName("电话"));
    }

    // POI 标记字段验证
    @Test
    public void test00114_3_poi_remark_check() throws Exception {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"},
                {Page_POI.POI_REMARK, "分类"}};
        AddPOI(attrib);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        assertTrue(Page_POI.Inst.isExistByName("分类"));
    }

    // POI 标记字段验证
    @Test
    public void test00114_4_poi_remark_check() throws Exception {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"},
                {Page_POI.POI_REMARK, "品牌"}};
        AddPOI(attrib);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        assertTrue(Page_POI.Inst.isExistByName("品牌"));
    }

    // POI 标记字段验证
    @Test
    public void test00114_5_poi_remark_check() throws Exception {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"},
                {Page_POI.POI_REMARK, "地址"}};
        AddPOI(attrib);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        assertTrue(Page_POI.Inst.isExistByName("地址"));
    }

    // POI 标记字段验证
    @Test
    public void test00114_6_poi_remark_check() throws Exception {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"},
                {Page_POI.POI_REMARK, "邮编"}};
        AddPOI(attrib);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        assertTrue(Page_POI.Inst.isExistByName("邮编"));
    }

    // POI 标记字段验证
    @Test
    public void test00114_7_poi_remark_check() throws Exception {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"},
                {Page_POI.POI_REMARK, "深度信息"}};
        AddPOI(attrib);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        assertTrue(Page_POI.Inst.isExistByName("深度信息"));
    }

    //危险信息Tips修改实时控制条件
    @Test
    public void test00115_1_tips_dangerous_info_check() throws Exception {

        String[] LOC = {"116.54238", "39.93779"};
        SearchLocation(LOC);

        //创建危险信息tips
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DANGEROUS_INFO);
        Page_MainBoard.Inst.ClickCenter();

        //左侧合流
        Page_Dangerous.Inst.Click(Page_Dangerous.CONFLUENCE_LEFT);

        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据

        assertTrue(Page_POI.Inst.isExistByName("危险信息"));

    }

    @Test
    public void test00115_2_tips_dangerous_info_check() throws Exception {

        String[] LOC = {"116.54246", "39.93779"};
        SearchLocation(LOC);

        //创建危险信息tips
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DANGEROUS_INFO);
        Page_MainBoard.Inst.ClickCenter();

        //左侧合流
        Page_Dangerous.Inst.Click(Page_Dangerous.CONFLUENCE_LEFT);

        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据

        assertTrue(Page_POI.Inst.isExistByName("危险信息"));

    }

    @Test
    public void test00115_3_tips_dangerous_info_check() throws Exception {

        String[] LOC = {"116.54238", "39.93779"};
        SearchLocation(LOC);

        //创建危险信息tips
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DANGEROUS_INFO);
        Page_MainBoard.Inst.ClickCenter();

        //右侧合流
        Page_Dangerous.Inst.Click(Page_Dangerous.CONFLUENCE_RIGHT);

        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据

        assertTrue(Page_POI.Inst.isExistByName("危险信息"));

    }

    @Test
    public void test00115_4_tips_dangerous_info_check() throws Exception {

        String[] LOC = {"116.54246", "39.93779"};
        SearchLocation(LOC);

        //创建危险信息tips
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DANGEROUS_INFO);
        Page_MainBoard.Inst.ClickCenter();

        //右侧合流
        Page_Dangerous.Inst.Click(Page_Dangerous.CONFLUENCE_RIGHT);

        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据

        assertTrue(Page_POI.Inst.isExistByName("危险信息"));

    }

    //补充同一关系原则
    //风景名胜（180400）可以和任意类型（除自身以及210304风景名胜售票点）做同一关系
    @Test
    public void test00116_1_poi_same_error_check() throws Exception {

        String[][] attrib1 = {{Page_POI.NAME, "中餐馆TEST"},
                {Page_POI.SELECT_TYPE, "中餐馆"}};

        AddPOI(attrib1, "116.40624", "39.95918");

        String[][] attrib2 = {{Page_POI.NAME, "风景名胜TEST"},
                {Page_POI.SELECT_TYPE, "风景名胜"},
                {Page_POI.POI_SAME, "中餐馆ＴＥＳＴ"}};

        String infoFid = AddPOI(attrib2, "116.40628", "39.95918");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_POI.Inst.ClickByText("已采集");
        Page_POI.Inst.Click(Page_POI.SAVE);

        SearchLocation("116.40624", "39.95918");
        synchronize_zhou(Page_GridManager.POI_UPDATE);

        //检查错误列表
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.ClickByText("错误列表");
        Page_ErrorList.Inst.ClickbyText("Poi");
        Page_ErrorList.Inst.ClickbyText("查看详情");

        String txtErrMessage = Page_ErrorList.Inst.GetValue(Page_ErrorList.ERROR_CONTENT);
        assertTrue(txtErrMessage.equals("同一poi(" + "fid:" + infoFid + ")在库中不存在") || txtErrMessage.equals("同一poi(" + infoFid + ")在库中不存在"));
    }

    //补充同一关系原则
    //风景名胜（180400）可以和任意类型（除自身以及210304风景名胜售票点）做同一关系
    @Test
    public void test00116_2_poi_same_error_check() throws Exception {

        String[][] attrib1 = {{Page_POI.NAME, "风景名胜TEST"},
                {Page_POI.SELECT_TYPE, "风景名胜"}};

        AddPOI(attrib1, "116.40624", "39.95918");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_POI.Inst.ClickByText("已采集");
        Page_POI.Inst.Click(Page_POI.SAVE);

        String[][] attrib2 = {{Page_POI.NAME, "风景名胜售票点TEST"},
                {Page_POI.SELECT_TYPE, "风景名胜售票点"},
                {Page_POI.POI_SAME, "风景名胜ＴＥＳＴ"}};

        try {
            AddPOI(attrib2, "116.40628", "39.95918");
        } catch (Exception e) {

        }

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("风景名胜售票点ＴＥＳＴ");

        assertTrue(Page_TrueSence.Inst.isExistByName("同一关系"));
    }

    //补充同一关系原则
    //旅游观光（180403）可以和任意类型（除自身以及210304风景名胜售票点）做同一关系
    @Test
    public void test00116_3_poi_same_error_check() throws Exception {

        String[][] attrib1 = {{Page_POI.NAME, "中餐馆TEST"},
                {Page_POI.SELECT_TYPE, "中餐馆"}};

        AddPOI(attrib1, "116.40624", "39.95918");

        String[][] attrib2 = {{Page_POI.NAME, "旅游观光TEST"},
                {Page_POI.SELECT_TYPE, "旅游观光"},
                {Page_POI.POI_SAME, "中餐馆ＴＥＳＴ"}};

        String infoFid = AddPOI(attrib2, "116.40628", "39.95918");

        SearchLocation("116.40624", "39.95918");
        synchronize_zhou(Page_GridManager.POI_UPDATE);

        //检查错误列表
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.ClickByText("错误列表");
        Page_ErrorList.Inst.ClickbyText("Poi");
        Page_ErrorList.Inst.ClickbyText("查看详情");

        String txtErrMessage = Page_ErrorList.Inst.GetValue(Page_ErrorList.ERROR_CONTENT);
        assertTrue(txtErrMessage.equals("同一poi(" + "fid:" + infoFid + ")在库中不存在") || txtErrMessage.equals("同一poi(" + infoFid + ")在库中不存在"));
    }

    //补充同一关系原则
    //旅游观光（180403）可以和任意类型（除自身以及210304风景名胜售票点）做同一关系
    @Test
    public void test00116_4_poi_same_error_check() throws Exception {

        String[][] attrib1 = {{Page_POI.NAME, "旅游观光TEST"},
                {Page_POI.SELECT_TYPE, "旅游观光"}};

        AddPOI(attrib1, "116.40624", "39.95918");

        String[][] attrib2 = {{Page_POI.NAME, "风景名胜售票点TEST"},
                {Page_POI.SELECT_TYPE, "风景名胜售票点"},
                {Page_POI.POI_SAME, "旅游观光ＴＥＳＴ"}};

        try {
            AddPOI(attrib2, "116.40628", "39.95918");
        } catch (Exception e) {

        }

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("风景名胜售票点ＴＥＳＴ");

        assertTrue(Page_TrueSence.Inst.isExistByName("同一关系"));
    }

    //补充同一关系原则
    //风景名胜（180400）与旅游观光（180403）不能建立同一关系
    @Test
    public void test00116_5_poi_same_error_check() throws Exception {

        String[][] attrib1 = {{Page_POI.NAME, "旅游观光TEST"},
                {Page_POI.SELECT_TYPE, "旅游观光"}};

        AddPOI(attrib1, "116.40624", "39.95918");

        String[][] attrib2 = {{Page_POI.NAME, "风景名胜TEST"},
                {Page_POI.SELECT_TYPE, "风景名胜"},
                {Page_POI.POI_SAME, "旅游观光ＴＥＳＴ"}};

        try {
            AddPOI(attrib2, "116.40628", "39.95918");
        } catch (Exception e) {

        }

        assertTrue(Page_TrueSence.Inst.isExistByName("保存") || Page_MainBoard.Inst.isExistByName("气泡"));
    }

    //点门牌：属性栏布局优化
    @Test
    public void test00117_1_pas_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);
        Thread.sleep(2000);

        String name = Page_PAS.Inst.GetValue(Page_PAS.NAME);
        String address = Page_PAS.Inst.GetValue(Page_PAS.ADDRESS);
        assertEquals("请输入小区名称", name);
        assertEquals("请输入楼栋号", address);
    }

    @Test
    public void test00117_2_pas_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.DOOR_PAS);
        String name = Page_PAS.Inst.GetValue(Page_PAS.NAME);
        String address = Page_PAS.Inst.GetValue(Page_PAS.ADDRESS);
        assertEquals("请输入小区名称", name);
        assertEquals("请输入楼栋号与楼门号", address);
    }

    @Test
    public void test00117_3_pas_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.ADDRESS_PAS);
        String name = Page_PAS.Inst.GetValue(Page_PAS.NAME);
        String address = Page_PAS.Inst.GetValue(Page_PAS.ADDRESS);

        assertEquals("请输入道路名称", name);
        assertEquals("请输入门牌号", address);
    }

    // 室内整理工具增加量测工具
    @Test
    public void test00118_measure_tool_check() throws Exception {
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.INDOOR_TOOL);
        Page_IndoorTools.Inst.Click(Page_IndoorTools.MYDATA);
        Page_MainBoard.Inst.Click(Page_MainBoard.DISTANCE_MEASURE_LEFT_TOP);
        assertTrue(Page_MainBoard.Inst.isExistByName("重绘"));
    }

    // 点门牌框选
    @Test
    public void test00119_pas_select_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.ADDRESS_PAS);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "道路名1");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "门牌号1");
        Page_PAS.Inst.Click(Page_PAS.SAVE);


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_SELECT);
        Page_MainBoard.Inst.Click(new Point(500, 500));
        Page_MainBoard.Inst.Click(new Point(500, 1000));
        Page_MainBoard.Inst.Click(new Point(1500, 1000));
        Page_MainBoard.Inst.Click(new Point(1500, 500));
        Page_PAS.Inst.Click(Page_PAS.COMPLETE);
        Page_PAS.Inst.Click(Page_PAS.MOVE_POINTS);
        Page_MainBoard.Inst.Drag(500, 500, 1300, 500, 5);
        Page_PAS.Inst.Click(Page_PAS.MOVE_POINTS);
        Page_PAS.Inst.Click(Page_PAS.AUTO_LINK);
        Page_MainBoard.Inst.ClickByText("确定");
    }

    // 建筑物tips复制
    @Test
    public void test00120_tips_copy_building_check() throws Exception {
        //创建建筑面
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.BUILDING_AREA);
        Page_MainBoard.Inst.Click(new Point(200, 300));
        Page_MainBoard.Inst.Click(new Point(200, 500));
        Page_MainBoard.Inst.Click(new Point(300, 500));
        Page_MainBoard.Inst.Click(new Point(300, 300));

        Page_BuildingArea.Inst.Click(Page_BuildingArea.COMPLETE);
        Page_BuildingArea.Inst.SetValue(Page_BuildingArea.FLOOR_NUMBER, "26");

        Page_BuildingArea.Inst.Click(Page_BuildingArea.SHAPE_CHANGE);
        Page_BuildingArea.Inst.Click(Page_BuildingArea.HEIGHT_ADD);
        Page_BuildingArea.Inst.Click(Page_BuildingArea.ASSOCIATE_DELETE);

        Page_BuildingArea.Inst.Click(Page_BuildingArea.SAVE);

        //复制tips
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_COPY_TIPS);
        Page_MainBoard.Inst.Click(new Point(250, 400));

        Page_MainBoard.Inst.Drag(100, 200, 500, 200, 10);
        Page_MainBoard.Inst.Drag(100, 200, 100, 600, 10);

        Page_MainBoard.Inst.ClickByText("确定");
        Thread.sleep(2000);

        Page_MainBoard.Inst.ClickCenter();

        String height = Page_BuildingArea.Inst.GetValue(Page_BuildingArea.FLOOR_NUMBER);

        assertTrue("26".equals(height));

    }

    // POI：同点位多点增加按楼层筛选功能
    @Test
    public void test00121_1_poi_same_floor_check() throws Exception {
        String[][] attrib1 = {{Page_POI.NAME, "大厦TEST1"},
                {Page_POI.SELECT_TYPE, "百货商场零售"}};

        AddPOI(attrib1, "116.40557", "39.96121");

        String[][] attrib2 = {{Page_POI.NAME, "中餐馆TEST1"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.POI_FATHER, "大厦ＴＥＳＴ１"}};
        String fid1 = AddPOI(attrib2, "116.40557", "39.96121");

        String[][] attrib3 = {{Page_POI.NAME, "异国风味TEST1"},
                {Page_POI.SELECT_TYPE, "异国风味"},
                {Page_POI.POI_FATHER, "大厦ＴＥＳＴ１"}};
        String fid2 = AddPOI(attrib3, "116.40557", "39.96121");

        Sqlitetools.RefreshData();

        testadapter.StopApp();

        testadapter.ClearWal();
        Sqlitetools.updatePoiFloorInfo(fid1, fid2);

        testadapter.ClearWal();

        Sqlitetools.RefreshData();

        SearchLocation("116.40557", "39.96121");
        Page_MainBoard.Inst.ClickCenter();

        assertTrue(Page_MainBoard.Inst.isExistByName("１层"));
        assertTrue(Page_MainBoard.Inst.isExistByName("２层"));

    }

    // POI：同点位多点POI按楼层筛选优化
    @Test
    public void test00121_2_poi_same_floor_check() throws Exception {
        String[][] attrib1 = {{Page_POI.NAME, "大厦TEST1"},
                {Page_POI.SELECT_TYPE, "百货商场零售"}};

        AddPOI(attrib1, "116.40557", "39.96121");

        String[][] attrib2 = {{Page_POI.NAME, "中餐馆TEST1"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.POI_FATHER, "大厦ＴＥＳＴ１"}};
        String fid1 = AddPOI(attrib2, "116.40557", "39.96121");

        String[][] attrib3 = {{Page_POI.NAME, "异国风味TEST1"},
                {Page_POI.SELECT_TYPE, "异国风味"},
                {Page_POI.POI_FATHER, "大厦ＴＥＳＴ１"}};
        String fid2 = AddPOI(attrib3, "116.40557", "39.96121");

        String[][] attrib4 = {{Page_POI.NAME, "酒吧TEST1"},
                {Page_POI.SELECT_TYPE, "酒吧"},
                {Page_POI.POI_FATHER, "大厦ＴＥＳＴ１"}};
        String fid3 = AddPOI(attrib4, "116.40557", "39.96121");

        String[][] attrib5 = {{Page_POI.NAME, "冷饮店TEST1"},
                {Page_POI.SELECT_TYPE, "冷饮店"},
                {Page_POI.POI_FATHER, "大厦ＴＥＳＴ１"}};
        String fid4 = AddPOI(attrib5, "116.40557", "39.96121");

        Sqlitetools.RefreshData();

        testadapter.StopApp();

        testadapter.ClearWal();
        Sqlitetools.updatePoiFloorInfo(fid1, fid2);
        Sqlitetools.updatePoiFloorInfo2(fid3, fid4);

        testadapter.ClearWal();

        Sqlitetools.RefreshData();

        SearchLocation("116.40557", "39.96121");
        Page_MainBoard.Inst.ClickCenter();

        assertTrue(Page_MainBoard.Inst.isExistByName("１层"));
        assertTrue(Page_MainBoard.Inst.isExistByName("２层"));

    }

    // t_fieldDate字段赋值原则（非室内整理界面，当天）
    @Test
    public void test00122_1_tips_t_filedDate_check() throws Exception {
        //增加匝道
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.RAMP);
        Page_MainBoard.Inst.ClickCenter();
        Page_Ramp.Inst.Click(Page_Ramp.RAMP);
        Page_Ramp.Inst.Click(Page_Ramp.SAVE);

        Sqlitetools.RefreshData();
        String fieldDateBefore = Sqlitetools.GetFieldDate().toString();

        //修改
        Thread.sleep(1000);
        Page_MainBoard.Inst.ClickCenter();
        Page_Ramp.Inst.Click(Page_Ramp.SAVE);

        Sqlitetools.RefreshData();
        String fieldDateAfter = Sqlitetools.GetFieldDate().toString();

        assertEquals(fieldDateBefore, fieldDateAfter);

    }

    // t_fieldDate字段赋值原则（非室内整理界面，非当天）
    @Test
    public void test00122_2_tips_t_filedDate_check() throws Exception {
        //增加匝道
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.RAMP);
        Page_MainBoard.Inst.ClickCenter();
        Page_Ramp.Inst.Click(Page_Ramp.RAMP);
        Page_Ramp.Inst.Click(Page_Ramp.SAVE);

        Sqlitetools.RefreshData();

        testadapter.StopApp();

        testadapter.ClearWal();

        Sqlitetools.updateFieldDate("20180619121212");

        testadapter.ClearWal();

        Sqlitetools.RefreshData();

        //String fieldDateBefore = Sqlitetools.GetFieldDate().toString();

        //修改
        Thread.sleep(1000);
        Page_MainBoard.Inst.ClickCenter();
        Page_Ramp.Inst.Click(Page_Ramp.SAVE);

        Sqlitetools.RefreshData();
        String fieldDateAfter = Sqlitetools.GetFieldDate().toString();

        assertNotEquals("20180619121212", fieldDateAfter);

    }

    // t_fieldDate字段赋值原则（室内整理界面，当天）
    @Test
    public void test00122_3_tips_t_filedDate_check() throws Exception {
        //增加匝道
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.RAMP);
        Page_MainBoard.Inst.ClickCenter();
        Page_Ramp.Inst.Click(Page_Ramp.RAMP);
        Page_Ramp.Inst.Click(Page_Ramp.SAVE);

        Sqlitetools.RefreshData();
        String fieldDateBefore = Sqlitetools.GetFieldDate().toString();

        //修改
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.INDOOR_TOOL);
        Page_IndoorTools.Inst.Click(Page_IndoorTools.MYDATA);
        Page_MainBoard.Inst.ClickByText("匝道");
        Page_MainBoard.Inst.ClickByText("匝道");
        Page_Ramp.Inst.Click(Page_Ramp.SAVE);

        Sqlitetools.RefreshData();
        String fieldDateAfter = Sqlitetools.GetFieldDate().toString();

        assertEquals(fieldDateBefore, fieldDateAfter);

    }

    // t_fieldDate字段赋值原则（室内整理界面，非当天）
    @Test
    public void test00122_4_tips_t_filedDate_check() throws Exception {
        //增加匝道
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.RAMP);
        Page_MainBoard.Inst.ClickCenter();
        Page_Ramp.Inst.Click(Page_Ramp.RAMP);
        Page_Ramp.Inst.Click(Page_Ramp.SAVE);

        Sqlitetools.RefreshData();

        testadapter.StopApp();

        testadapter.ClearWal();

        Sqlitetools.updateFieldDate("20180619121212");

        testadapter.ClearWal();

        Sqlitetools.RefreshData();

        //String fieldDateBefore = Sqlitetools.GetFieldDate().toString();

        //修改
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.INDOOR_TOOL);
        Page_IndoorTools.Inst.Click(Page_IndoorTools.MYDATA);
        Page_MainBoard.Inst.ClickByText("匝道");
        Page_MainBoard.Inst.ClickByText("匝道");
        Page_Ramp.Inst.Click(Page_Ramp.SAVE);

        Sqlitetools.RefreshData();
        String fieldDateAfter = Sqlitetools.GetFieldDate().toString();

        assertEquals("20180619121212", fieldDateAfter);

    }

    // t_fieldDate字段赋值原则（非室内整理，测线）
    @Test
    public void test00122_5_tips_t_filedDate_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(1250, 500));
        Page_MainBoard.Inst.Click(new Point(1250, 800));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.HIGH_SPEED);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_1);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        Sqlitetools.RefreshData();

        testadapter.StopApp();

        testadapter.ClearWal();

        Sqlitetools.updateFieldDate("20180619121212");

        testadapter.ClearWal();

        Sqlitetools.RefreshData();

        //打断测线
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1250, 650));
        Page_MainBoard.Inst.Drag(1800, 1000, 1800, 200, 10);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.EDIT_BREAK);
        Page_MainBoard.Inst.Click(new Point(1250, 700));
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        Sqlitetools.RefreshData();
        int count = Sqlitetools.GetDataCount("20180619121212", "20180619121212");

        assertEquals(0, count);

    }

    // t_fieldDate字段赋值原则（室内整理，测线）
    @Test
    public void test00122_6_tips_t_filedDate_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(1250, 500));
        Page_MainBoard.Inst.Click(new Point(1250, 800));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.HIGH_SPEED);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_1);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        Sqlitetools.RefreshData();
        String fieldDateBefore = Sqlitetools.GetFieldDate().toString();

        //修改
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.INDOOR_TOOL);
        Page_IndoorTools.Inst.Click(Page_IndoorTools.MYDATA);
        Page_MainBoard.Inst.ClickByText("测线");
        Page_MainBoard.Inst.ClickByText("测线");
        Page_MainBoard.Inst.Drag(1800, 1000, 1800, 200, 10);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.EDIT_BREAK);
        Page_MainBoard.Inst.Click(new Point(704, 970));
        Page_Ramp.Inst.Click(Page_Ramp.SAVE);

        Sqlitetools.RefreshData();
        String fieldDateAfter = Sqlitetools.GetFieldDate().toString();

        assertEquals(fieldDateBefore, fieldDateAfter);

    }

    // POI：充电桩采集变更
    @Test
    public void test00123_1_poi_charge_check() throws Exception {

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "电动汽车充电桩");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        Page_POI.Inst.Click(Page_POI.CHARGE_GUN);

        Page_POI.Inst.SetValue(Page_POI.CHARGING_CONNECTOR_ID, "1234567890abcdefghijklmnopqrstuvwxyz");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_POI.Inst.Click(Page_POI.AC_3);

        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("测试ＰＯＩ");
        Thread.sleep(1000);

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        Page_POI.Inst.isExistByName("1234567890abcdefghijklmnopqrstuvwxyz");
        assertTrue(Page_POI.Inst.isChecked(Page_POI.CHARGE_GUN));

    }

    // POI：充电桩采集变更
    @Test
    public void test00123_2_poi_charge_check() throws Exception {

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "电动汽车充电桩");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        Page_POI.Inst.Click(Page_POI.NO_CHARGE_GUN);

        Page_POI.Inst.SetValue(Page_POI.CHARGING_CONNECTOR_ID, "1234567890abcdefghijklmnopqrstuvwxyz");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_POI.Inst.Click(Page_POI.AC_3);

        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("测试ＰＯＩ");

        Thread.sleep(1000);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        Page_POI.Inst.isExistByName("1234567890abcdefghijklmnopqrstuvwxyz");
        assertTrue(Page_POI.Inst.isChecked(Page_POI.NO_CHARGE_GUN));

    }

    // POI：充电站采集变更
    @Test
    public void test00123_3_poi_charge_check() throws Exception {

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "电动汽车充电站");

        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("测试ＰＯＩ");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        assertTrue(Page_POI.Inst.isChecked(Page_POI.CHARGE_PARKING_NO));
        assertTrue(Page_POI.Inst.isChecked(Page_POI.CHARGE_SIGNBOARD_NO));

    }

    // POI：充电站采集变更
    @Test
    public void test00123_4_poi_charge_check() throws Exception {

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "电动汽车充电站");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        Page_POI.Inst.Click(Page_POI.CHARGE_PARKING_YES);
        Page_POI.Inst.Click(Page_POI.CHARGE_SIGNBOARD_YES);


        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("测试ＰＯＩ");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);


        assertTrue(Page_POI.Inst.isChecked(Page_POI.CHARGE_PARKING_YES));
        assertTrue(Page_POI.Inst.isChecked(Page_POI.CHARGE_SIGNBOARD_YES));

    }

    // POI：采集端充电站开放时间默认值设定
    @Test
    public void test00123_5_poi_charge_check() throws Exception {

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "电动汽车充电站");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        Page_POI.Inst.Click(Page_POI.CHARGINGSTATION_OPEN_HOUR);
        Page_TimeCtl.Inst.Click(Page_TimeCtl.CONFIRM);
        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("测试ＰＯＩ");

        Thread.sleep(1000);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        assertTrue(Page_InfoPoint.Inst.isExistByName("00:00-23:59"));

    }

    // POI：采集端充电桩插孔类型改善
    @Test
    public void test00123_6_poi_charge_check() throws Exception {

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "电动汽车充电桩");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        Page_POI.Inst.Click(Page_POI.NO_CHARGE_GUN);

        Page_POI.Inst.SetValue(Page_POI.CHARGING_CONNECTOR_ID, "1234567890abcdefghijklmnopqrstuvwxyz");

        Page_POI.Inst.Click(Page_POI.SAVE);

        assertTrue(Page_InfoPoint.Inst.isExistByName("保存"));

    }

    // MS数据验证
    @Test
    public void test00124_1_MS_Data_check() throws Exception {
        // 上报情报
        addReport(Page_InfoPoint.ROAD_TYPE);


        Sqlitetools.RefreshData();
        testadapter.StopApp();

        testadapter.ClearWal();
        Sqlitetools.updateMSdata(globalId);
        Sqlitetools.updateInfoData(1);

        testadapter.ClearWal();

        Sqlitetools.RefreshData();

        //检索情报
        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Page_Search.Inst.ClickbyText("情报");
        Page_Search.Inst.SetValue(Page_Search.EDITINFO, globalId);
        Page_Search.Inst.Click(Page_Search.SEARCH_START_INFO);
        Page_SearchResultList.Inst.Click(Page_SearchResultList.DATA_LIST);

        //采纳情报
        Page_InfoPoint.Inst.ClickbyText("舍弃"); //点击采纳

        assertTrue(Page_InfoPoint.Inst.isExistByName("现场与挖掘结果不一致"));
        assertTrue(Page_InfoPoint.Inst.isExistByName("现场与挖掘结果一致但不满足采集标准"));
        assertTrue(Page_InfoPoint.Inst.isExistByName("其它"));

    }

    // MS数据验证
    /*
    @Test
    public void test00124_2_MS_Data_check() throws Exception
    {
        SearchLocation("116.43615", "39.97134");

        //同步情报
        synchronize_zhou(Page_GridManager.INFO_UPDATE);


        //检索情报
        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Page_Search.Inst.ClickbyText("情报");
        Page_Search.Inst.SetValue(Page_Search.EDITINFO, "5a7d96391ac947ddbaec3cf8063ca446");
        Page_Search.Inst.Click(Page_Search.SEARCH_START_INFO);
        Page_SearchResultList.Inst.Click(Page_SearchResultList.DATA_LIST);

        //采纳情报
        Page_InfoPoint.Inst.ClickbyText("舍弃"); //点击采纳

        assertTrue(Page_InfoPoint.Inst.isExistByName("现场与挖掘结果不一致"));
        assertTrue(Page_InfoPoint.Inst.isExistByName("现场与挖掘结果一致但不满足采集标准"));
        assertTrue(Page_InfoPoint.Inst.isExistByName("其它"));

    }
    */

    // 卡车交限卡片验证
    @Test
    public void test00125_1_truck_limit_check() throws Exception {
        //交限
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUCK_TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();

        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.ICON_1);
        assertTrue(Page_TruckForbidden.Inst.isExistByName("属性卡片一"));

        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.ADD_VIEW);
        assertTrue(Page_TruckForbidden.Inst.isExistByName("属性卡片二"));

        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.ADD_VIEW);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        assertTrue(Page_TruckForbidden.Inst.isExistByName("属性卡片三"));

        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.SAVE);

    }

    @Test
    public void test00125_2_truck_limit_check() throws Exception {
        //交限
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUCK_TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();

        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.NO_PULL_INTO);
        assertTrue(Page_TruckForbidden.Inst.isExistByName("属性卡片一"));

        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.ADD_VIEW);
        assertTrue(Page_TruckForbidden.Inst.isExistByName("属性卡片二"));

        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.ADD_VIEW);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        assertTrue(Page_TruckForbidden.Inst.isExistByName("属性卡片三"));

        Page_TruckForbidden.Inst.Click(Page_TrafficForbidden.SAVE);

    }

    //公交车道、可逆车道支持起点移动
    @Test
    public void test00126_bus_line_check() throws Exception {
        SearchLocation(LOC_K7);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.BUS_LINE);
        Page_MainBoard.Inst.Click(new Point(950, 750));
        Page_BusLine.Inst.Click(Page_BusLine.CHOOSE_END);
        Page_MainBoard.Inst.Click(new Point(1000, 750));
        Page_MainBoard.Inst.Drag(100, 450, 180, 450, 10);
        Page_MainBoard.Inst.Click(new Point(100, 300));
        Page_BusLine.Inst.Click(Page_BusLine.SAVE);

        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(new Point(705, 745));
        Page_BusLine.Inst.Click(Page_BusLine.MOVE);
        Page_MainBoard.Inst.Drag(100, 450, 150, 450, 10);
        Page_BusLine.Inst.Click(Page_BusLine.MOVE);
        Page_BusLine.Inst.Click(Page_BusLine.SAVE);

        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(new Point(618, 785));
        Page_BusLine.Inst.Click(Page_BusLine.CHOOSE_END);
        Page_MainBoard.Inst.Click(new Point(1100, 750));
        Page_BusLine.Inst.Click(Page_BusLine.SAVE);
    }

    //公交车道、可逆车道支持起点移动
    @Test
    public void test00127_reverse_line_check() throws Exception {
        SearchLocation(LOC_K7);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.REVERSE);
        Page_MainBoard.Inst.Click(new Point(950, 750));
        Page_ReverseLine.Inst.Click(Page_ReverseLine.CHOOSE_END);
        Page_MainBoard.Inst.Click(new Point(1000, 750));
        Page_MainBoard.Inst.Drag(100, 450, 180, 450, 10);
        Page_ReverseLine.Inst.Click(Page_ReverseLine.ADD_TIME);
        Page_MainBoard.Inst.ClickByText("确定");
        Page_ReverseLine.Inst.Click(Page_ReverseLine.SAVE);

        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(new Point(705, 745));
        Page_ReverseLine.Inst.Click(Page_ReverseLine.MOVE);
        Page_MainBoard.Inst.Drag(100, 450, 150, 450, 10);
        Page_BusLine.Inst.Click(Page_BusLine.MOVE);
        Page_ReverseLine.Inst.Click(Page_ReverseLine.SAVE);

        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(new Point(618, 785));
        Page_ReverseLine.Inst.Click(Page_ReverseLine.CHOOSE_END);
        Page_MainBoard.Inst.Click(new Point(1100, 750));
        Page_ReverseLine.Inst.Click(Page_ReverseLine.SAVE);
    }

    // POI：增加Tag子表
    @Test
    public void test00128_1_poi_category_check() throws Exception {

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "医疗机构");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        Page_POI.Inst.ClickByText("医院内部设施");
        Page_POI.Inst.ClickByText("专科医院");
        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("测试ＰＯＩ");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        List<UiObject2> lst = testadapter.findAllObjectsByClass("fm_ll_poi_tag_layout", "android.widget.CheckBox");

        UiObject2 obj;

        for (int i = 0; i < 5; i++) {
            obj = lst.get(i);
            if (i == 0 || i == 4) {
                assertTrue(obj.isChecked());
            } else {
                assertTrue(!obj.isChecked());
            }
        }

    }

    @Test
    public void test00128_2_poi_category_check() throws Exception {

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "医疗机构");
        Page_POI.Inst.Click(Page_POI.SAVE);
        ExitMyData();

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("测试ＰＯＩ");

        Thread.sleep(1000);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        List<UiObject2> lst = testadapter.findAllObjectsByClass("fm_ll_poi_tag_layout", "android.widget.CheckBox");

        UiObject2 obj;
        for (int i = 0; i < 5; i++) {
            obj = lst.get(i);
            assertTrue(!obj.isChecked());
        }
        Page_POI.Inst.Click(Page_POI.CANCEL);
        ExitMyData();

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("测试ＰＯＩ");

        Thread.sleep(1000);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_POI.Inst.ClickByText("医院内部设施");
        Page_POI.Inst.ClickByText("专科医院");
        Page_POI.Inst.Click(Page_POI.SAVE);
        ExitMyData();

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("测试ＰＯＩ");

        Thread.sleep(1000);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        lst = testadapter.findAllObjectsByClass("fm_ll_poi_tag_layout", "android.widget.CheckBox");

        for (int i = 0; i < 5; i++) {
            obj = lst.get(i);
            if (i == 0 || i == 4) {
                assertTrue(obj.isChecked());
            } else {
                assertTrue(!obj.isChecked());
            }
        }

    }

    //图形专项作业
    @Test
    public void test00129_1_indoor_data_check() throws Exception {
        SearchLocation(LOC_K7);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DIRECTION_BOARD);
        Page_MainBoard.Inst.Click(new Point(850, 750));
        Page_DirectionBoard.Inst.Click(Page_DirectionBoard.CAMERA);
        Thread.sleep(1000);
        Page_Info_Camera.Inst.Click(Page_Info_Camera.TAKE_PIC);
        Page_Info_Camera.Inst.Click(Page_Info_Camera.BACK);
        Page_DirectionBoard.Inst.Click(Page_DirectionBoard.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_SELECT_LINE_10001);
        Page_MainBoard.Inst.Click(new Point(850, 760));
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_SELECT_LINE_10001);

        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.INDOOR_TOOL);
        Page_IndoorTools.Inst.Click(Page_IndoorTools.GRAPHIC_WORK);

        assertTrue(Page_InfoPoint.Inst.isExistByName("方向看板"));

    }

    @Test
    public void test00129_2_indoor_data_check() throws Exception {
        SearchLocation(LOC_K7);

        //点击新增实景图POI
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUE_SCENE);
        Page_MainBoard.Inst.Click(new Point(850, 750));

        //高速出口
        Page_TrueSence.Inst.Click(Page_TrueSence.HIGHWAY_LOAD_OUT);
        //输入编号
        Page_TrueSence.Inst.Click(Page_TrueSence.REQUEST);

        //拍照5张并返回
        Page_TrueSence.Inst.Click(Page_TrueSence.CAMERA);
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(1000);

        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        //点击保存
        Page_TrueSence.Inst.Click(Page_TrueSence.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_SELECT_LINE_10001);
        Page_MainBoard.Inst.Click(new Point(850, 760));
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_SELECT_LINE_10001);

        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.INDOOR_TOOL);
        Page_IndoorTools.Inst.Click(Page_IndoorTools.GRAPHIC_WORK);

        assertTrue(Page_InfoPoint.Inst.isExistByName("实景图"));

    }

    // POI：停车场深度信息增加界面提示
    @Test
    public void test00130_parking_deep_info_check() throws Exception {

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "停车场");
        Page_POI.Inst.Click(Page_POI.SAVE);

        assertTrue(Page_InfoPoint.Inst.isExistByName("保存"));
    }

    // 框选POI-跨道路批量关联功能
    @Test
    public void test00131_poi_select_check() throws Exception {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"}};
        AddPOI(attrib);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.MARQUEE_POI_9002);
        Page_MainBoard.Inst.Click(new Point(500, 500));
        Page_MainBoard.Inst.Click(new Point(500, 1000));
        Page_MainBoard.Inst.Click(new Point(1500, 1000));
        Page_MainBoard.Inst.Click(new Point(1500, 500));

        Page_POI.Inst.Click(Page_POI.COMPLETE);

        Page_POI.Inst.Click(Page_POI.SELECT_LINK);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1000, 640));
        Thread.sleep(1000);
        Page_POI.Inst.Click(Page_POI.SELECT_LINK);

        Page_POI.Inst.ClickByText("是");

        assertTrue(Page_InfoPoint.Inst.isExistByName("框选POI"));
    }


    //ASCII   @:64 A:65    Z:90 [:91
    //        ':96 a:97    z:122 {:123
    // 点门牌：门牌录入方式优化
    @Test
    public void test00132_1_pas_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "小区名称TEST");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "楼栋号1");
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 425));
        Thread.sleep(1000);
        assertTrue(!Page_PAS.Inst.isExistByName("楼栋号０"));
        assertTrue(!Page_PAS.Inst.isExistByName("楼栋号-１"));

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 500));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号１"));

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 595));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号２"));
    }

    // 点门牌：门牌录入方式优化
    @Test
    public void test00132_2_pas_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "小区名称TEST");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "楼栋号a");
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);


        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 500));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号ａ"));

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 595));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号ｂ"));
    }

    // 点门牌：门牌录入方式优化
    @Test
    public void test00132_3_pas_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "小区名称TEST");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "楼栋号A");
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 500));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号Ａ"));

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 595));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号Ｂ"));
    }

    // 点门牌：门牌录入方式优化
    @Test
    public void test00132_4_pas_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "小区名称TEST");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "楼栋号Z");
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 500));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号Ｚ"));


        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 595));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号Ｙ"));

    }

    // 点门牌：门牌录入方式优化
    @Test
    public void test00132_5_pas_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "小区名称TEST");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "楼栋号z");
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 500));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号ｚ"));


        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 595));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号ｙ"));

    }

    // 点门牌：门牌录入方式优化
    @Test
    public void test00132_6_pas_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "小区名称TEST");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "楼栋号E");
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 425));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号Ｅ"));


        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 500));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号Ｄ"));


        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 595));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号Ｆ"));

    }

    // 点门牌：门牌录入方式优化
    @Test
    public void test00132_7_pas_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "小区名称TEST");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "楼栋号e");
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 425));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号ｅ"));

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 500));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号ｄ"));

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 595));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号ｆ"));
    }

    @Test
    public void test00133_1_pas_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.DOOR_PAS);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "小区名称TEST");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "楼栋号1");
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Page_PAS.Inst.Click(Page_PAS.DOOR_PAS);

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 425));
        Thread.sleep(1000);
        assertTrue(!Page_PAS.Inst.isExistByName("楼栋号０"));
        assertTrue(!Page_PAS.Inst.isExistByName("楼栋号-１"));

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 500));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号１"));

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 595));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号２"));
    }

    // 点门牌：门牌录入方式优化
    @Test
    public void test00133_2_pas_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.DOOR_PAS);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "小区名称TEST");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "楼栋号a");
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Page_PAS.Inst.Click(Page_PAS.DOOR_PAS);


        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 500));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号ａ"));

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 595));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号ｂ"));
    }

    // 点门牌：门牌录入方式优化
    @Test
    public void test00133_3_pas_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.DOOR_PAS);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "小区名称TEST");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "楼栋号A");
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Page_PAS.Inst.Click(Page_PAS.DOOR_PAS);

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 500));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号Ａ"));

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 595));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号Ｂ"));
    }

    // 点门牌：门牌录入方式优化
    @Test
    public void test00133_4_pas_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.DOOR_PAS);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "小区名称TEST");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "楼栋号Z");
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Page_PAS.Inst.Click(Page_PAS.DOOR_PAS);

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 500));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号Ｚ"));


        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 595));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号Ｙ"));
    }

    // 点门牌：门牌录入方式优化
    @Test
    public void test00133_5_pas_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.DOOR_PAS);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "小区名称TEST");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "楼栋号z");
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Page_PAS.Inst.Click(Page_PAS.DOOR_PAS);

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 500));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号ｚ"));


        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 595));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号ｙ"));
    }

    // 点门牌：门牌录入方式优化
    @Test
    public void test00133_6_pas_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.DOOR_PAS);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "小区名称TEST");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "楼栋号E");
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Page_PAS.Inst.Click(Page_PAS.DOOR_PAS);

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 425));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号Ｅ"));

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 500));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号Ｄ"));

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 595));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号Ｆ"));
    }

    // 点门牌：门牌录入方式优化
    @Test
    public void test00133_7_pas_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.DOOR_PAS);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "小区名称TEST");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "楼栋号e");
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Page_PAS.Inst.Click(Page_PAS.DOOR_PAS);

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 425));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号ｅ"));


        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 500));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号ｄ"));


        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 595));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号ｆ"));
    }

    // 点门牌：门牌录入方式优化
    @Test
    public void test00134_pas_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        assertTrue(Page_PAS.Inst.isExistByName("别墅"));
    }

    // 一级情报增加反馈照片功能
    @Test
    public void test00135_1_info_feedback_picture_update_check() throws Exception {
        // 上报情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.POINT_INFO); //点击点情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(900, 500)); //点击情报位置

        Page_InfoLine.Inst.SetValue(Page_InfoLine.NAME, "测试上报情报"); //输入情报名称
        Page_InfoLine.Inst.Click(Page_InfoLine.ROAD_TYPE);
        Page_InfoLine.Inst.Click(Page_InfoLine.LEVEL_1);
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME); //点击选择时间
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME_CONFIRM);

        Page_InfoLine.Inst.Click(Page_InfoLine.CAMERA);//拍照
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//点击拍照
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);//点击返回


        Page_InfoLine.Inst.Click(Page_InfoLine.SAVE); //点击保存

        //获取globalID
        GotoMyData(Page_MyData.INFO_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("测试上报情报", "测试上报情报");
        globalId = Page_InfoLine.Inst.GetValue(Page_InfoLine.GLOBAL_ID).substring(10);
        Page_InfoLine.Inst.Click(Page_InfoLine.CANCEL);
        ExitMyData(); //退出我的数据

        Sqlitetools.RefreshData();

        testadapter.StopApp();

        testadapter.ClearWal();
        Sqlitetools.updateInfoData(0);

        testadapter.ClearWal();

        Sqlitetools.RefreshData();

        //采纳
        //检索情报
        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Page_Search.Inst.ClickbyText("情报");
        Page_Search.Inst.SetValue(Page_Search.EDITINFO, globalId);
        Page_Search.Inst.Click(Page_Search.SEARCH_START_INFO);
        Page_SearchResultList.Inst.Click(Page_SearchResultList.DATA_LIST);

        //采纳情报
        Page_InfoAccept.Inst.Click(Page_InfoAccept.ACCEPT); //点击采纳
        Thread.sleep(3000);
        assertTrue(Page_InfoLine.Inst.isExistByName("采纳"));
        Page_InfoLine.Inst.Click(Page_InfoLine.CAMERA);
        Thread.sleep(1000);
        Page_Info_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC); //点击拍照
        Thread.sleep(2000);
        Page_Info_Camera.Inst.Click(Page_POI_Camera.BACK); //点击返回
        Page_InfoAccept.Inst.Click(Page_InfoAccept.ACCEPT); //点击采纳
        assertTrue(Page_InfoLine.Inst.isExistByName("测试上报情报"));

    }

    // 一级情报增加反馈照片功能
    @Test
    public void test00135_2_info_feedback_picture_update_check() throws Exception {
        // 上报情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.POINT_INFO); //点击点情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(900, 500)); //点击情报位置

        Page_InfoLine.Inst.SetValue(Page_InfoLine.NAME, "测试上报情报"); //输入情报名称
        Page_InfoLine.Inst.Click(Page_InfoLine.ROAD_TYPE);
        Page_InfoLine.Inst.Click(Page_InfoLine.LEVEL_1);
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME); //点击选择时间
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME_CONFIRM);

        Page_InfoLine.Inst.Click(Page_InfoLine.CAMERA);//拍照
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//点击拍照
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);//点击返回


        Page_InfoLine.Inst.Click(Page_InfoLine.SAVE); //点击保存

        //获取globalID
        GotoMyData(Page_MyData.INFO_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("测试上报情报", "测试上报情报");
        globalId = Page_InfoLine.Inst.GetValue(Page_InfoLine.GLOBAL_ID).substring(10);
        Page_InfoLine.Inst.Click(Page_InfoLine.CANCEL);
        ExitMyData(); //退出我的数据

        Sqlitetools.RefreshData();

        testadapter.StopApp();

        testadapter.ClearWal();
        Sqlitetools.updateInfoData(0);

        testadapter.ClearWal();

        Sqlitetools.RefreshData();

        //部分采纳
        //检索情报
        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Page_Search.Inst.ClickbyText("情报");
        Page_Search.Inst.SetValue(Page_Search.EDITINFO, globalId);
        Page_Search.Inst.Click(Page_Search.SEARCH_START_INFO);
        Page_SearchResultList.Inst.Click(Page_SearchResultList.DATA_LIST);

        //部分采纳情报
        Page_InfoAccept.Inst.Click(Page_InfoAccept.PART_ACCEPT); //点击采纳
        Thread.sleep(3000);
        assertTrue(Page_InfoLine.Inst.isExistByName("部分采纳"));
        Page_InfoLine.Inst.Click(Page_InfoLine.CAMERA);
        Thread.sleep(1000);
        Page_Info_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC); //点击拍照
        Thread.sleep(2000);
        Page_Info_Camera.Inst.Click(Page_POI_Camera.BACK); //点击返回
        Page_InfoAccept.Inst.Click(Page_InfoAccept.PART_ACCEPT); //点击采纳
        assertTrue(Page_MainBoard.Inst.isExistByName("点情报"));
        assertTrue(Page_MainBoard.Inst.isExistByName("线情报"));
        assertTrue(Page_MainBoard.Inst.isExistByName("面情报"));

    }

    // 一级情报增加反馈照片功能
    @Test
    public void test00135_3_info_feedback_picture_update_check() throws Exception {
        // 上报情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.POINT_INFO); //点击点情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(900, 500)); //点击情报位置

        Page_InfoLine.Inst.SetValue(Page_InfoLine.NAME, "测试上报情报"); //输入情报名称
        Page_InfoLine.Inst.Click(Page_InfoLine.ROAD_TYPE);
        Page_InfoLine.Inst.Click(Page_InfoLine.LEVEL_1);
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME); //点击选择时间
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME_CONFIRM);

        Page_InfoLine.Inst.Click(Page_InfoLine.CAMERA);//拍照
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//点击拍照
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);//点击返回


        Page_InfoLine.Inst.Click(Page_InfoLine.SAVE); //点击保存

        //获取globalID
        GotoMyData(Page_MyData.INFO_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("测试上报情报", "测试上报情报");
        globalId = Page_InfoLine.Inst.GetValue(Page_InfoLine.GLOBAL_ID).substring(10);
        Page_InfoLine.Inst.Click(Page_InfoLine.CANCEL);
        ExitMyData(); //退出我的数据

        Sqlitetools.RefreshData();

        testadapter.StopApp();

        testadapter.ClearWal();
        Sqlitetools.updateInfoData(1);

        testadapter.ClearWal();

        Sqlitetools.RefreshData();

        //舍弃-现场未发生变化
        //检索情报
        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Page_Search.Inst.ClickbyText("情报");
        Page_Search.Inst.SetValue(Page_Search.EDITINFO, globalId);
        Page_Search.Inst.Click(Page_Search.SEARCH_START_INFO);
        Page_SearchResultList.Inst.Click(Page_SearchResultList.DATA_LIST);

        //舍弃
        Page_InfoAccept.Inst.Click(Page_InfoAccept.DELETE); //舍弃
        Page_InfoDelete.Inst.Click(Page_InfoDelete.NO_CHANGE);
        Page_InfoDelete.Inst.Click(Page_InfoDelete.SAVE);
        Thread.sleep(3000);
        assertTrue(Page_InfoLine.Inst.isExistByName("保存"));
        Page_InfoDelete.Inst.Click(Page_InfoDelete.CAMERA);
        Thread.sleep(1000);
        Page_Info_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC); //点击拍照
        Thread.sleep(2000);
        Page_Info_Camera.Inst.Click(Page_POI_Camera.BACK); //点击返回
        Page_InfoDelete.Inst.Click(Page_InfoDelete.SAVE);

        assertTrue(Page_InfoLine.Inst.isExistByName("测试上报情报"));

    }

    // 一级情报增加反馈照片功能
    @Test
    public void test00135_4_info_feedback_picture_update_check() throws Exception {
        // 上报情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.POINT_INFO); //点击点情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(900, 500)); //点击情报位置

        Page_InfoLine.Inst.SetValue(Page_InfoLine.NAME, "测试上报情报"); //输入情报名称
        Page_InfoLine.Inst.Click(Page_InfoLine.ROAD_TYPE);
        Page_InfoLine.Inst.Click(Page_InfoLine.LEVEL_1);
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME); //点击选择时间
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME_CONFIRM);

        Page_InfoLine.Inst.Click(Page_InfoLine.CAMERA);//拍照
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//点击拍照
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);//点击返回


        Page_InfoLine.Inst.Click(Page_InfoLine.SAVE); //点击保存

        //获取globalID
        GotoMyData(Page_MyData.INFO_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("测试上报情报", "测试上报情报");
        globalId = Page_InfoLine.Inst.GetValue(Page_InfoLine.GLOBAL_ID).substring(10);
        Page_InfoLine.Inst.Click(Page_InfoLine.CANCEL);
        ExitMyData(); //退出我的数据

        Sqlitetools.RefreshData();

        testadapter.StopApp();

        testadapter.ClearWal();
        Sqlitetools.updateInfoData(1);

        testadapter.ClearWal();

        Sqlitetools.RefreshData();

        //舍弃-未开通
        //检索情报
        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Page_Search.Inst.ClickbyText("情报");
        Page_Search.Inst.SetValue(Page_Search.EDITINFO, globalId);
        Page_Search.Inst.Click(Page_Search.SEARCH_START_INFO);
        Page_SearchResultList.Inst.Click(Page_SearchResultList.DATA_LIST);

        //舍弃
        Page_InfoAccept.Inst.Click(Page_InfoAccept.DELETE); //舍弃
        Page_InfoDelete.Inst.Click(Page_InfoDelete.NOT_OPEN);
        Page_InfoDelete.Inst.Click(Page_InfoDelete.SAVE);
        Thread.sleep(3000);
        assertTrue(Page_InfoLine.Inst.isExistByName("保存"));
        Page_InfoDelete.Inst.Click(Page_InfoDelete.CAMERA);
        Thread.sleep(1000);
        Page_Info_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC); //点击拍照
        Thread.sleep(2000);
        Page_Info_Camera.Inst.Click(Page_POI_Camera.BACK); //点击返回
        Page_InfoDelete.Inst.Click(Page_InfoDelete.SAVE);

        assertTrue(Page_InfoLine.Inst.isExistByName("测试上报情报"));

    }

    // 室内整理工具（pad）：快速切出切回功能
    @Test
    public void test00136_indoor_tool_switch_check() throws Exception {
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.INDOOR_TOOL);
        Page_IndoorTools.Inst.Click(Page_IndoorTools.MYDATA);
        Page_MainBoard.Inst.Click(Page_MainBoard.INDOOR_CHANGE_WORK);
        Page_MainBoard.Inst.Click(Page_MainBoard.POI_MARQUESS);
        assertTrue(Page_MainBoard.Inst.isExistByName("框选POI"));

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

    // 点门牌默认类型设置
    @Test
    public void test00139_1_default_pas_check() throws Exception {
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainBoard.Inst.Drag(100, 600, 100, 200, 10);
        Thread.sleep(1000);
        Page_MainMenu.Inst.Click(Page_MainMenu.SET);

        //点门牌默认类型设置
        Page_Set.Inst.Click(Page_Set.PAS_DEFAULT_SET);
        //楼栋门牌
        Page_Default_Pas_Set.Inst.Click(Page_Default_Pas_Set.BUILDING);

        Page_Default_Pas_Set.Inst.Click(Page_Default_Pas_Set.BACK);
        Page_Set.Inst.Click(Page_Set.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        assertTrue(Page_PAS.Inst.isChecked(Page_PAS.BUILDING_PAS));
    }

    @Test
    public void test00139_2_default_pas_check() throws Exception {
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainBoard.Inst.Drag(100, 600, 100, 200, 10);
        Thread.sleep(1000);
        Page_MainMenu.Inst.Click(Page_MainMenu.SET);

        //点门牌默认类型设置
        Page_Set.Inst.Click(Page_Set.PAS_DEFAULT_SET);
        //楼门门牌
        Page_Default_Pas_Set.Inst.Click(Page_Default_Pas_Set.DOOR);

        Page_Default_Pas_Set.Inst.Click(Page_Default_Pas_Set.BACK);
        Page_Set.Inst.Click(Page_Set.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        assertTrue(Page_PAS.Inst.isChecked(Page_PAS.DOOR_PAS));
    }

    @Test
    public void test00139_3_default_pas_check() throws Exception {
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainBoard.Inst.Drag(100, 600, 100, 200, 10);
        Thread.sleep(1000);
        Page_MainMenu.Inst.Click(Page_MainMenu.SET);

        //点门牌默认类型设置
        Page_Set.Inst.Click(Page_Set.PAS_DEFAULT_SET);
        //地址门牌
        Page_Default_Pas_Set.Inst.Click(Page_Default_Pas_Set.ADDRESS);

        Page_Default_Pas_Set.Inst.Click(Page_Default_Pas_Set.BACK);
        Page_Set.Inst.Click(Page_Set.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        assertTrue(Page_PAS.Inst.isChecked(Page_PAS.ADDRESS_PAS));
    }

    @Test
    public void test00140_1_default_info_name_check() throws Exception {
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.POINT_INFO); //点击点情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(900, 500)); //点击情报位置

        Page_InfoPoint.Inst.Click(Page_InfoPoint.POI_TYPE);

        assertEquals("设施情报", Page_InfoPoint.Inst.GetValue(Page_InfoPoint.NAME));
    }

    @Test
    public void test00140_2_default_info_name_check() throws Exception {
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.POINT_INFO); //点击点情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(900, 500)); //点击情报位置

        Page_InfoPoint.Inst.Click(Page_InfoPoint.ROAD_TYPE);

        assertEquals("道路情报", Page_InfoPoint.Inst.GetValue(Page_InfoPoint.NAME));
    }

    @Test
    public void test00140_3_default_info_name_check() throws Exception {
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.LINE_INFO); //点击点情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(900, 500)); //点击情报位置
        Page_MainBoard.Inst.Click(new Point(1000, 500));

        Page_InfoLine.Inst.Click(Page_InfoLine.DRAW_FINISH);
        Page_InfoLine.Inst.Click(Page_InfoLine.POI_TYPE);

        assertEquals("设施情报", Page_InfoLine.Inst.GetValue(Page_InfoLine.NAME));
    }

    @Test
    public void test00140_4_default_info_name_check() throws Exception {
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.LINE_INFO); //点击点情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(900, 500)); //点击情报位置
        Page_MainBoard.Inst.Click(new Point(1000, 500));

        Page_InfoLine.Inst.Click(Page_InfoLine.DRAW_FINISH);
        Page_InfoLine.Inst.Click(Page_InfoLine.ROAD_TYPE);

        assertEquals("道路情报", Page_InfoLine.Inst.GetValue(Page_InfoLine.NAME));
    }

    @Test
    public void test00140_5_default_info_name_check() throws Exception {
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.LINE_INFO); //点击点情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(900, 500)); //点击情报位置
        Page_MainBoard.Inst.Click(new Point(1000, 500));
        Page_MainBoard.Inst.Click(new Point(1000, 600));

        Page_InfoFrame.Inst.Click(Page_InfoFrame.DRAW_FINISH);
        Page_InfoFrame.Inst.Click(Page_InfoFrame.POI_TYPE);

        assertEquals("设施情报", Page_InfoFrame.Inst.GetValue(Page_InfoFrame.NAME));
    }

    @Test
    public void test00140_6_default_info_name_check() throws Exception {
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.FRAME_INFO); //点击点情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(900, 500)); //点击情报位置
        Page_MainBoard.Inst.Click(new Point(1000, 500));
        Page_MainBoard.Inst.Click(new Point(1000, 600));

        Page_InfoFrame.Inst.Click(Page_InfoFrame.DRAW_FINISH);
        Page_InfoFrame.Inst.Click(Page_InfoFrame.ROAD_TYPE);

        assertEquals("道路情报", Page_InfoFrame.Inst.GetValue(Page_InfoFrame.NAME));
    }

    // 月基线点门牌采集端需求-关联POI
    @Test
    public void test00141_1_pas_poi_check() throws Exception {
        //POI
        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ"},
                {Page_POI.SELECT_TYPE, "小区"},
                {Page_POI.TEL, "19012345678"}};
        AddPOI(attrib);

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
        AddPOI(attrib);

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
        AddPOI(attrib);

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


    //卡车限制
    @Test
    public void test_FM_1110_2_3_check() throws Exception {
        SearchLocation(LOC_K8);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUCK_LIMIT);
        Page_MainBoard.Inst.Click(new Point(1500, 800));
        Page_TruckLimit.Inst.Click(Page_TruckLimit.WEIGHT);
        Page_TruckLimit.Inst.ClickByText("10");
        Page_TruckLimit.Inst.Click(Page_TruckLimit.SAVE);


        AssertIndoorCheck("卡车限制", "中", "FM-1110-2-3", "卡车地图采集7级及以上等级道路上的卡车地图内容，其他等级道路不采集卡车地图内容。", "");
    }

    // FM_1113_2_1 车道限速
    @Test
    public void test_FM_1113_2_1_check() throws Exception {
        if (FastMapPage.IS_OS_TEST) {
            return;
        }

        // 创建车道限速
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);
        Page_MainBoard.Inst.ClickCenter();
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.ROADLIMIT);
        Page_MainBoard.Inst.Drag(85, 445, 155, 445, 5);
        Page_SpeedLimit.Inst.Click(new Point(105, 283));
        Page_SpeedLimit.Inst.Click(new Point(105, 362));
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM30);
        //Page_SpeedLimit.Inst.Click(new Point(195,362));
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM30);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        AssertIndoorCheck("车道限速", "高", "FM-1113-2-1", "车道限速各车道的限速值一样时，不需采集", "忽略");
    }

    //卡车限速
    @Test
    public void test_FM_1114_2_1_check() throws Exception {
        SearchLocation(LOC_K8);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);
        Page_MainBoard.Inst.Click(new Point(1500, 800));
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.TRUCKLIMIT);
        Page_SpeedLimit.Inst.ClickByText("30");
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.SAVE);


        AssertIndoorCheck("卡车限制", "中", "FM-1114-2-1", "卡车地图采集7级及以上等级道路上的卡车地图内容，其他等级道路不采集卡车地图内容。", "");
    }

    //卡车禁停
    @Test
    public void test_FM_1120_2_2_check() throws Exception {
        SearchLocation(LOC_K8);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING_TRUCK);
        Page_MainBoard.Inst.Click(new Point(1500, 800));
        Page_NoParkingTruck.Inst.Click(Page_NoParkingTruck.SAVE);


        AssertIndoorCheck("卡车限制", "中", "FM-1120-2-2", "卡车地图采集7级及以上等级道路上的卡车地图内容，其他等级道路不采集卡车地图内容。", "");
    }


    // FM-1207-6-2
    @Test
    public void test_FM_1207_6_2_check() throws Exception {

        String[][] attrib1 = {{Page_POI.NAME, "测试ＰＯＩ001"},
                {Page_POI.SELECT_TYPE, "中餐馆"}};

        AddPOI(attrib1, "116.40572", "39.96958");

        //增加匝道
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.RAMP);

        Page_MainBoard.Inst.ClickCenter();
        Page_Ramp.Inst.Click(Page_Ramp.RAMP);
        Page_Ramp.Inst.Click(Page_Ramp.SAVE);

        AssertIndoorCheck("匝道", "低", "FM-1207-6-2", "匝道属性道路连接了POI", "忽略");
    }

    // FM-1208-2-1
    @Test
    public void test_FM_1208_2_1_check() throws Exception {
        SearchLocation(LOC_K8);

        //增加道路方向：单向
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_DIRECTION);
        Page_MainBoard.Inst.ClickCenter();
        Page_RoadDirection.Inst.Click(Page_RoadDirection.SAVE);

        //增加停车场出入口link
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PARK_ENTRANCE_LINK);
        Page_MainBoard.Inst.ClickCenter();
        Page_ParkLink.Inst.Click(Page_ParkLink.SAVE);

        AssertIndoorCheckNull("FM-1208-2-1");
    }

    // FM-1301-6-4
    @Test
    public void test_FM_1301_6_4_1_check() throws Exception {

        SearchLocation(LOC_K8);

        //增加车信
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);
        Page_MainBoard.Inst.ClickCenter();

        Page_LaneInfo.Inst.Click(Page_LaneInfo.ONE_G_A_F);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.APPEND);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.SAVE);

        AssertIndoorCheck("车信", "低", "FM-1301-6-4", "有附加车信，是否车道变化点采集遗漏", "忽略");

    }

    // FM-1301-6-4
    @Test
    public void test_FM_1301_6_4_2_check() throws Exception {

        // 测线
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(1250, 530));
        Page_MainBoard.Inst.Click(new Point(1250, 700));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.HIGH_SPEED);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_1);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        //增加道路方向：单向
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_DIRECTION);

        //测线中点
        Page_MainBoard.Inst.Click(new Point(1250, 600));
        //保存
        Page_RoadDirection.Inst.Click(Page_RoadDirection.SAVE);

        //增加车信
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);
        Page_MainBoard.Inst.Click(new Point(720, 800));

        Page_LaneInfo.Inst.Click(Page_LaneInfo.ONE_G_A_F);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.APPEND);

        //保存
        Page_LaneInfo.Inst.Click(Page_LaneInfo.SAVE);

        AssertIndoorCheck("车信", "低", "FM-1301-6-4", "有附加车信，是否车道变化点采集遗漏", "忽略");

    }


    // FM-1304-6-2
    @Test
    public void test_FM_1304_6_2_1_check() throws Exception {
        SearchLocation(LOC_K1);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Page_MainBoard.Inst.ClickCenter();
        Page_NoPassing.Inst.Click(Page_NoPassing.SAVE);

        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");
    }

    // FM-1304-6-2
    @Test
    public void test_FM_1304_6_2_2_check() throws Exception {
        SearchLocation(LOC_K2);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Page_MainBoard.Inst.ClickCenter();
        Page_NoPassing.Inst.Click(Page_NoPassing.SAVE);

        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");
    }

    // FM-1304-6-2
    @Test
    public void test_FM_1304_6_2_3_check() throws Exception {
        SearchLocation(LOC_K3);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Page_MainBoard.Inst.ClickCenter();
        Page_NoPassing.Inst.Click(Page_NoPassing.SAVE);

        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");
    }

    // FM-1304-6-2
    @Test
    public void test_FM_1304_6_2_4_check() throws Exception {
        SearchLocation(LOC_K4);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Page_MainBoard.Inst.ClickCenter();
        Page_NoPassing.Inst.Click(Page_NoPassing.SAVE);

        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");
    }

    @Test
    public void test_FM_1304_6_2_5_check() throws Exception {
        SearchLocation(LOC_K7);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.KIND);
        Page_MainBoard.Inst.Click(new Point(1500, 800));
        Page_Kind.Inst.Click(Page_Kind.CITY_HIGH_SPEED);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Page_MainBoard.Inst.ClickCenter();
        Page_NoPassing.Inst.Click(Page_NoPassing.SAVE);

        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");
    }

    @Test
    public void test_FM_1304_6_2_6_check() throws Exception {
        SearchLocation(LOC_K7);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.KIND);
        Page_MainBoard.Inst.Click(new Point(1500, 800));
        Page_Kind.Inst.Click(Page_Kind.HIGH_SPEED);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Page_MainBoard.Inst.ClickCenter();
        Page_NoPassing.Inst.Click(Page_NoPassing.SAVE);

        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");

    }

    @Test
    public void test_FM_1304_6_2_7_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(1000, 790));
        Page_MainBoard.Inst.Click(new Point(1300, 790));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.NATIONAL_RD);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_2);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        //禁止穿行3级道路（测线且t_sync=0）
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Page_MainBoard.Inst.Click(new Point(1000, 790));
        Page_NoPassing.Inst.Click(Page_NoPassing.SAVE);

        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");
    }

    @Test
    public void test_FM_1304_6_2_8_check() throws Exception {

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(1000, 1000));
        Page_MainBoard.Inst.Click(new Point(1300, 1000));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.NATIONAL_RD);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_2);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        //禁止穿行3级道路（测线且t_sync=0）
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Page_MainBoard.Inst.Click(new Point(1000, 1000));
        Page_NoPassing.Inst.Click(Page_NoPassing.SAVE);

        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");
    }

    // FM-1305-6-1
    @Test
    public void test_FM_1305_6_1_1_check() throws Exception {
        SearchLocation(LOC_K8);

        //增加道路方向：单向
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_DIRECTION);
        Page_MainBoard.Inst.ClickCenter();
        Page_RoadDirection.Inst.Click(Page_RoadDirection.SAVE);


        //交限
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);

        AssertIndoorCheck("禁止驶入", "中", "FM-1305-6-1", "禁止驶入与单行线重复", "");
    }

    // FM-1305-6-1
    @Test
    public void test_FM_1305_6_1_2_check() throws Exception {
        String[] StartLoc = {"116.41757", "39.96337"};
        SearchLocation(StartLoc);

        // 测线
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Click(new Point(1250, 700));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.HIGH_SPEED);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_1);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        SearchLocation(StartLoc);

        //增加道路方向：单向
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_DIRECTION);
        Page_MainBoard.Inst.ClickCenter();

        Page_RoadDirection.Inst.Click(Page_RoadDirection.SAVE);

        SearchLocation(StartLoc);

        //交限
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();

        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);

        AssertIndoorCheck("禁止驶入", "中", "FM-1305-6-1", "禁止驶入与单行线重复", "");
    }


    // FM-1305-6-2
    @Test
    public void test_FM_1305_6_2_1_check() throws Exception {

        SearchLocation(LOC_K1);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);


        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

    // FM-1304-6-2
    @Test
    public void test_FM_1305_6_2_2_check() throws Exception {

        SearchLocation(LOC_K2);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);

        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

    // FM-1304-6-2
    @Test
    public void test_FM_1305_6_2_3_check() throws Exception {

        SearchLocation(LOC_K3);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);


        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

    // FM-1304-6-2
    @Test
    public void test_FM_1305_6_2_4_check() throws Exception {

        SearchLocation(LOC_K4);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);


        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

    @Test
    public void test_FM_1305_6_2_5_check() throws Exception {

        SearchLocation(LOC_K7);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.KIND);
        Page_MainBoard.Inst.Click(new Point(1500, 800));
        Page_Kind.Inst.Click(Page_Kind.HIGH_SPEED);

        //禁止驶入1级道路（测线且t_sync=1）

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);

        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

    @Test
    public void test_FM_1305_6_2_6_check() throws Exception {

        SearchLocation(LOC_K7);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.KIND);
        Page_MainBoard.Inst.Click(new Point(1500, 800));
        Page_Kind.Inst.Click(Page_Kind.HIGH_SPEED);

        //禁止驶入2级道路（测线且t_sync=1）

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);


        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

    @Test
    public void test_FM_1305_6_2_7_check() throws Exception {
        //绘制测线
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(1000, 790));
        Page_MainBoard.Inst.Click(new Point(1300, 790));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.NATIONAL_RD);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_2);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        //禁止驶入3级道路（测线且t_sync=0）
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.Click(new Point(1000, 790));
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);

        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

    @Test
    public void test_FM_1305_6_2_8_check() throws Exception {
        //绘制测线
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(1000, 1000));
        Page_MainBoard.Inst.Click(new Point(1300, 1000));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.PROVINCIAL_RD);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_2);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        //禁止驶入4级道路（测线且t_sync=0）
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.Click(new Point(1000, 1000));
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);

        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

    @Test
    public void test_FM_1406_4_3_1_check() throws Exception {
        //点击新增实景图POI
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUE_SCENE);
        Page_MainBoard.Inst.Click(new Point(700, 268));

        //高速出口
        Page_TrueSence.Inst.Click(Page_TrueSence.HIGHWAY_LOAD_OUT);
        //输入编号
        //Page_TrueSence.Inst.SetValue(Page_TrueSence.ET_IMG_NUMBER, "7bCD1234");

        //拍照5张并返回
        Page_TrueSence.Inst.Click(Page_TrueSence.CAMERA);
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(1000);

        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        //点击保存
        Page_TrueSence.Inst.Click(Page_TrueSence.SAVE);

        AssertIndoorCheck("实景图", "中", "FM-1406-4-3", "高速路口实景图的编号不能为空，且必须为8位，首位必须是6或9！", "");
    }

    @Test
    public void test_FM_1406_4_3_2_check() throws Exception {
        //点击新增实景图POI
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUE_SCENE);
        Page_MainBoard.Inst.Click(new Point(700, 268));

        //高速入口
        Page_TrueSence.Inst.Click(Page_TrueSence.HIGHWAY_LOAD_IN);
        //输入编号
        //Page_TrueSence.Inst.SetValue(Page_TrueSence.ET_IMG_NUMBER, "7bCD1234");

        //拍照5张并返回
        Page_TrueSence.Inst.Click(Page_TrueSence.CAMERA);
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(1000);

        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        //点击保存
        Page_TrueSence.Inst.Click(Page_TrueSence.SAVE);

        AssertIndoorCheck("实景图", "中", "FM-1406-4-3", "高速路口实景图的编号不能为空，且必须为8位，首位必须是6或9！", "");
    }

    //FM-1503-6-1
    @Test
    public void test_FM_1503_6_1_1_check() throws Exception {

        SearchLocation(LOC_K7);

        //绘制高架路
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(1280, 785));
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.OVERHEAD_ROAD_BT);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);

        SearchLocation(LOC_K7);

        //绘制跨越桥
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(1280, 785));
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.OVERPASS_BT);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);

        AssertIndoorCheck("高架路", "中", "FM-1503-6-1", "高架路与跨越桥（或穿越地道）不能共存", "");
    }

    @Test
    public void test_FM_1503_6_1_2_check() throws Exception {

        SearchLocation(LOC_K7);

        //绘制高架路
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(1280, 785));
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.OVERHEAD_ROAD_BT);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);

        SearchLocation(LOC_K7);

        //绘制穿越地道
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(1280, 785));
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.UNDER_PASS_BT);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);

        AssertIndoorCheck("高架路", "中", "FM-1503-6-1", "高架路与跨越桥（或穿越地道）不能共存", "");
    }

    @Test
    public void test_FM_1503_6_1_3_check() throws Exception {
        Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500)};
        DrawRoad(arrayPoint);

        SetStartEndPoint(arrayPoint[0], arrayPoint[1], Page_StartEndPoint.OVERHEAD_ROAD_BT);
        SetStartEndPoint(arrayPoint[0], arrayPoint[1], Page_StartEndPoint.OVERPASS_BT);

        AssertIndoorCheck("高架路", "中", "FM-1503-6-1", "高架路与跨越桥（或穿越地道）不能共存", "");
    }

    @Test
    public void test_FM_1503_6_1_4_check() throws Exception {
        Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500)};
        DrawRoad(arrayPoint);

        SetStartEndPoint(arrayPoint[0], arrayPoint[1], Page_StartEndPoint.OVERHEAD_ROAD_BT);
        SetStartEndPoint(arrayPoint[0], arrayPoint[1], Page_StartEndPoint.UNDER_PASS_BT);

        AssertIndoorCheck("高架路", "中", "FM-1503-6-1", "高架路与跨越桥（或穿越地道）不能共存", "");
    }

    //FM-1521-1-2
    @Test
    public void test_FM_1521_1_2_check() throws Exception {
        Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500)};
        DrawRoad(arrayPoint);

        SetStartEndPoint(arrayPoint[0], arrayPoint[1], Page_StartEndPoint.TRAVELING_BRIDGE_BT);

        //删除测线
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.SelectData("测线");
        Page_SurveyLine.Inst.Click(Page_SurveyLine.DELETE);
        Page_SurveyLine.Inst.ClickbyText("仅删除测线");
        ExitMyData();

        AssertIndoorCheck("移动式桥", "中", "FM-1521-1-2", "Tips没有关联道路或测线或Node", "");
    }

    @Test
    public void test_FM_1524_1_2_check() throws Exception {
        // 测线
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(1250, 530));
        Page_MainBoard.Inst.Click(new Point(1250, 700));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.HIGH_SPEED);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_1);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(1260, 530));
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(1260, 700));
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.CAR_TEST_BT);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("测线");
        Page_SurveyLine.Inst.Click(Page_SurveyLine.DELETE);
        Page_MyData.Inst.ClickbyText("仅删除测线");
        ExitMyData(); //退出我的数据


        AssertIndoorCheck("车辆测试路段", "中", "FM-1524-1-2", "Tips没有关联道路或测线或Node", "");
    }

    //FM-1521-1-2
    @Test
    public void test_FM_1525_1_2_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(1250, 530));
        Page_MainBoard.Inst.Click(new Point(1250, 700));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.HIGH_SPEED);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_1);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(1260, 530));
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(1260, 700));
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.DRIVING_TEST_BT);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("测线");
        Page_SurveyLine.Inst.Click(Page_SurveyLine.DELETE);
        Page_MyData.Inst.ClickbyText("仅删除测线");
        ExitMyData(); //退出我的数据

        AssertIndoorCheck("驾照考试路段", "中", "FM-1525-1-2", "Tips没有关联道路或测线或Node", "");
    }

    //（不查gdb数据）点限速
    @Test
    public void test_FM_1101_1_2_check() throws Exception {
        SearchLocation("116.41939", "39.96208");
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);

        Page_MainBoard.Inst.ClickCenter();

        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.MAX_SPEED);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.SPEED_120);

        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.MIN_SPEED);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.SPEED_60);

        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.SAVE);

        Sqlitetools.RefreshData();

        testadapter.StopApp();

        testadapter.ClearWal();

        Sqlitetools.updateLinkId();

        testadapter.ClearWal();

        Sqlitetools.RefreshData();

        AssertIndoorCheck("驾照考试路段", "中", null, "Tips没有关联道路或测线或Node", "");
    }

    //里程桩tips的道路名称，全部都是字母和阿拉伯数字，则报错
    @Test
    public void test_FM_1707_2_2_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "Road001");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "中", "FM-1707-2-2", "里程桩道路名称不能只存在字母和阿拉伯数字", "");
    }

    //检查里程桩tips的道路名称是否含有英文字母（含大写和小写），存在则报错误
    @Test
    public void test_FM_1707_2_3_1_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "ROAD");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "中", "FM-1707-2-2", "里程桩道路名称不能只存在字母和阿拉伯数字", "忽略");
    }

    //里程桩tips的道路名称，全部都是字母和阿拉伯数字，则报错
    @Test
    public void test_FM_1707_2_2_1_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "1234");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "中", "FM-1707-2-2", "里程桩道路名称不能只存在字母和阿拉伯数字", "忽略");
    }

    //里程桩tips的道路名称，全部都是字母和阿拉伯数字，则报错
    @Test
    public void test_FM_1707_2_2_2_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "road1234");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "中", "FM-1707-2-2", "名称中含有字母，请确认是否正确", "忽略");
    }

    //检查里程桩tips的道路名称是否含有英文字母（含大写和小写），存在则报错误
    @Test
    public void test_FM_1707_2_3_2_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "road");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "中", "FM-1707-2-3", "名称中含有字母，请确认是否正确", "忽略");
    }

    //里程桩tips的道路名称，不能含有“/”或“|”（不区分全半角），否则报log1
    @Test
    public void test_FM_1707_2_4_1_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路/");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-4", "里程桩道路名称不能含有“/”或“|”", "");
    }

    //里程桩tips的道路名称，不能含有“/”或“|”（不区分全半角），否则报log1
    @Test
    public void test_FM_1707_2_4_2_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路|");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-4", "里程桩道路名称不能含有“/”或“|”", "");
    }

    //.里程桩tips的道路编号，不能含有“/”或“|”（不区分全半角），否则报log2
    @Test
    public void test_FM_1707_2_4_3_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001/");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-4", "里程桩道路编号不能含有“/”或“|”", "");
    }

    //.里程桩tips的道路编号，不能含有“/”或“|”（不区分全半角），否则报log2
    @Test
    public void test_FM_1707_2_4_4_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001|");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-4", "里程桩道路编号不能含有“/”或“|”", "");
    }

    //.里程桩tips的道路名称含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log1
    @Test
    public void test_FM_1707_2_5_1_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路$");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路名称不能含有$，。？、字符（包含全半角）", "");
    }

    //里程桩tips的道路名称含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log1
    @Test
    public void test_FM_1707_2_5_2_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路,");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路名称不能含有$，。？、字符（包含全半角）", "");
    }

    //.里程桩tips的道路名称含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log1
    @Test
    public void test_FM_1707_2_5_3_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路，");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路名称不能含有$，。？、字符（包含全半角）", "");
    }

    //.里程桩tips的道路名称含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log1
    @Test
    public void test_FM_1707_2_5_4_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路.");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路名称不能含有$，。？、字符（包含全半角）", "");
    }

    //.里程桩tips的道路名称含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log1
    @Test
    public void test_FM_1707_2_5_5_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路。");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路名称不能含有$，。？、字符（包含全半角）", "");
    }

    //.里程桩tips的道路名称含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log1
    @Test
    public void test_FM_1707_2_5_6_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路?");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路名称不能含有$，。？、字符（包含全半角）", "");
    }

    //.里程桩tips的道路名称含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log1
    @Test
    public void test_FM_1707_2_5_7_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路？");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路名称不能含有$，。？、字符（包含全半角）", "");
    }

    //.里程桩tips的道路名称含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log1
    @Test
    public void test_FM_1707_2_5_8_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路、");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路名称不能含有$，。？、字符（包含全半角）", "");
    }

    //.里程桩tips的道路编号含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log2
    @Test
    public void test_FM_1707_2_5_9_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001$");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路编号不能含有$，。？、字符（包含全半角）", "");
    }

    //里程桩tips的道路编号含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log2
    @Test
    public void test_FM_1707_2_5_10_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001,");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路编号不能含有$，。？、字符（包含全半角）", "");
    }

    //.里程桩tips的道路编号含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log2
    @Test
    public void test_FM_1707_2_5_11_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001，");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路编号不能含有$，。？、字符（包含全半角）", "");
    }

    //.里程桩tips的道路编号含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log2
    @Test
    public void test_FM_1707_2_5_12_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001.");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路编号不能含有$，。？、字符（包含全半角）", "");
    }

    //.里程桩tips的道路编号含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log2
    @Test
    public void test_FM_1707_2_5_13_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001。");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路编号不能含有$，。？、字符（包含全半角）", "");
    }

    //.里程桩tips的道路编号含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log2
    @Test
    public void test_FM_1707_2_5_14_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001?");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路编号不能含有$，。？、字符（包含全半角）", "");
    }

    //.里程桩tips的道路编号含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log2
    @Test
    public void test_FM_1707_2_5_15_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001？");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路编号不能含有$，。？、字符（包含全半角）", "");
    }

    //.里程桩tips的道路编号含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log2
    @Test
    public void test_FM_1707_2_5_16_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001、");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路编号不能含有$，。？、字符（包含全半角）", "");
    }

    //里程桩tips的道路名称字段前后和中间，含有空格（不区分全半角），报log1
    @Test
    public void test_FM_1707_2_6_1_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, " 测 试 路 ");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "中", "FM-1707-2-6", "里程桩道路名称含有空格信息，请确认是否正确", "忽略");
    }

    //里程桩tips的道路名称字段前后和中间，含有空格（不区分全半角），报log1
    @Test
    public void test_FM_1707_2_6_2_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "　测　试　路　");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "中", "FM-1707-2-6", "里程桩道路名称含有空格信息，请确认是否正确", "忽略");
    }

    //里程桩tips的道路编号字段前后和中间，含有空格（不区分全半角），报log2
    @Test
    public void test_FM_1707_2_6_3_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S 0 0 1 ");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "中", "FM-1707-2-6", "里程桩道路编号含有空格信息，请确认是否正确", "忽略");
    }

    //里程桩tips的道路编号字段前后和中间，含有空格（不区分全半角），报log2
    @Test
    public void test_FM_1707_2_6_4_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S　0　0　1　");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "中", "FM-1707-2-6", "里程桩道路编号含有空格信息，请确认是否正确", "忽略");
    }

    //里程桩tips的道路名称和道路编号不能完全一致，忽略全半角差异。（忽略道路名和道路编号都为空的情况）
    @Test
    public void test_FM_1707_2_7_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "Ｓ00１");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "中", "FM-1707-2-7", "里程桩道路名称和道路编号一致，请删除其中之一", "");
    }

    //里程桩tips的道路编号，如果不为空，则必须同时存在字母和阿拉伯数字。
    @Test
    public void test_FM_1707_2_8_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "SsABCD");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "中", "FM-1707-2-8", "里程桩tips的道路编号，只能存在且必须同时存在字母和阿拉伯数字", "");
    }

    //里程桩tips的道路名称和道路编号都为空，需要报错
    @Test
    public void test_FM_1707_2_9_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "低", "FM-1707-2-9", "请确认里程桩道路名称和道路编号是否都为空", "");
    }


    // 上报情报
    public void addReport(String infoType) throws InterruptedException, NoSuchFieldException, ClassNotFoundException {

        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.POINT_INFO); //点击点情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(900, 500)); //点击情报位置

        Page_InfoPoint.Inst.SetValue(Page_InfoPoint.NAME, "测试上报情报6"); //输入情报名称
        Page_InfoPoint.Inst.Click(infoType);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.LEVEL_1);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.TIME); //点击选择时间
        Page_InfoPoint.Inst.Click(Page_InfoPoint.TIME_CONFIRM);

        Page_InfoPoint.Inst.Click(Page_InfoPoint.CAMERA);//拍照
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//点击拍照
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);//点击返回


        Page_InfoPoint.Inst.Click(Page_InfoPoint.SAVE); //点击保存

        //获取globalID
        GotoMyData(Page_MyData.INFO_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("测试上报情报6", "测试上报情报6");
        globalId = Page_InfoPoint.Inst.GetValue(Page_InfoPoint.GLOBAL_ID).substring(10);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.CANCEL);
        ExitMyData(); //退出我的数据

    }


    // 采纳情报
    public void accept() throws InterruptedException, NoSuchFieldException, ClassNotFoundException {

        //检索情报
        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Page_Search.Inst.ClickbyText("情报");
        Page_Search.Inst.SetValue(Page_Search.EDITINFO, globalId);
        Page_Search.Inst.Click(Page_Search.SEARCH_START_INFO);
        Page_SearchResultList.Inst.Click(Page_SearchResultList.DATA_LIST);

        //采纳情报
        Page_InfoPoint.Inst.ClickbyText("采纳"); //点击采纳
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC); //点击拍照
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK); //点击返回
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");//点击选择分类

        infoFid = Page_POI.Inst.GetValue(Page_POI.FID);

        Page_POI.Inst.Click(Page_POI.SAVE); //点击保存
        Page_SearchResultList.Inst.Click(Page_SearchResultList.BACK); //点击返回
    }

    // 检查情报fid
    public void checkFid() throws InterruptedException, NoSuchFieldException, ClassNotFoundException {

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.ClickbyText("测试上报情报６");

        String strFid = "";
        try {
            strFid = Page_POI.Inst.GetValue(Page_POI.FID);
            Page_POI.Inst.Click(Page_POI.CANCEL);
            ExitMyData();
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(infoFid, strFid);
    }

    private static String globalId = "";
    private static String infoFid = "";
}