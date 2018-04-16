package com.example.fang.autotestfastmap;

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

import static org.junit.Assert.*;

/**
 * Created by fang on 17/11/21.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testFastMapZF extends testFastMapBase
{
    @BeforeClass
    public static void setClassUp() throws Exception
    {
        //testFastMapBase.setClassUp("collector2","123456");
    }

    @AfterClass
    public static void setClassDown() throws InterruptedException, IOException
    {
    }

    @Before
    public void setUp() throws Exception {

        if (currTestName.getMethodName().equals("test00101_licence_plate_check"))
        {
            setClassUpByLicenceCheck("collector2", "123456", "鄂A12345");
        }
        else if (currTestName.getMethodName().equals("test00101_poi_hm_brand_check"))
        {
            this.setClassUp("zhanglingling03655", "036550", true);
        }
        else
        {
            setClassUp("collector2", "123456");
        }
    }

    @After
    public  void setAfter() //throws IOException, InterruptedException {
    {

        //super.setAfter();
    }

    // 车牌录入校验
    @Test @IMPORTANT
    public void test00101_licence_plate_check() throws Exception
    {

        String carNum;
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.EXIT);

        Page_Confirm.Inst.Click(Page_Confirm.OK);
        Page_Login.Inst.Click(Page_Login.CAR_MODE_RADIO);
        carNum = Page_Login.Inst.GetValue(Page_Login.CAR_NUM);

        assertEquals("鄂A12345", carNum);
    }

    // POI 分类品牌表增加港澳标识
    @Test
    public void test00101_poi_hm_brand_check() throws Exception
    {

    	if(FastMapPage.IS_OS_TEST)
    	{
    		return;
    	}
    	
        String[][] attrib = {
                { Page_POI.NAME, "测试ＰＯＩ"},
                { Page_POI.SELECT_TYPE, "厂家一览表内汽车修理"},
                { Page_POI.SELECT_BRAND, "丰田维修"},
        };

        AddPOI(attrib);

        GotoMyData(Page_MyData.POI_TYPE);
        Assert.assertTrue(Page_MyData.Inst.isExistByName("测试ＰＯＩ"));
    }


    // POI 联系方式去除手机号不能以19开头的限制
    @Test
    public void test00102_poi_telnum_check() throws Exception
    {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                             {Page_POI.SELECT_TYPE, "中餐馆"},
                             {Page_POI.TEL, "19012345678"}};
        AddPOI(attrib);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        Page_POI.Inst.isExistByName("19012345678");
    }

    //采纳情报fid保存
    @Test @IMPORTANT
    public void test00103_poi_report_check() throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {
        // 上报情报
        addReport();
        // 同步情报
        synchronize(Page_GridManager.INFO_UPDATE);
        // 采纳情报
        accept();
        // 检查情报fid
        checkFid();

    }

    // 删除标记
    @Test @IMPORTANT
    public void test00104_tips_delete_check() throws Exception
    {
        String[] LIGHT_LOC = {"116.40631", "39.91562"};
        SearchLocation(LIGHT_LOC);

        //添加红绿灯
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_LIGHT);
        Page_MainBoard.Inst.ClickCenter();

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("红绿灯");
        String infoRowkey = Page_Light.Inst.GetValue(Page_Light.ROWKEY);
        Page_Light.Inst.Click(Page_Light.CANCEL);
        ExitMyData();

        IndoorCheckConfirm("红绿灯");

        //同步数据
        synchronize(Page_GridManager.TIPS_UPDATE);

        //删除前定位红绿灯tips位置
        SearchLocation(LIGHT_LOC);
        
        //增加删除标记
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DELETE_ROAD_MARKER);
        Page_MainBoard.Inst.ClickCenter();
        Page_DeleteList.Inst.Click(Page_DeleteList.DELETE);

        IndoorCheckConfirm("红绿灯");

        //同步数据
        synchronize(Page_GridManager.TIPS_UPDATE);

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
    public void test00105_1_poi_father_error_check() throws Exception
    {
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
        synchronize(Page_GridManager.POI_UPDATE);

        CheckErrorList("Poi", "子(fid:" + infoFid + ")不存在", "POI");
    }

    @Test
    public void test00105_2_poi_father_error_check() throws Exception
    {
        String[][] attrib1 = {{Page_POI.NAME, "大厦TEST1"},
                              {Page_POI.SELECT_TYPE, "大厦/写字楼"}};
        String infoFid =AddPOI(attrib1);


        String[][] attrib2 = {{Page_POI.NAME, "中餐馆TEST1"},
                              {Page_POI.SELECT_TYPE, "中餐馆"},
                              {Page_POI.POI_FATHER, "大厦ＴＥＳＴ１"}};

        AddPOI(attrib2);

        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MultiList.Inst.ClickbyText("中餐馆ＴＥＳＴ１");

        Page_POI.Inst.DeleteFather("大厦ＴＥＳＴ１");

        Thread.sleep(3000);
        
        //移动父POI
        Page_MultiList.Inst.Click(Page_MultiList.CHECK_LIST_ITEM);
        Page_MultiList.Inst.Click(Page_MultiList.MOVE);
        Page_MultiList.Inst.Click(Page_MultiList.MOVE_POINT_AND_LINE);

        Page_MainBoard.Inst.Drag(1024, 816, 1024, 1160, 10);

        Page_MultiList.Inst.Click(Page_MultiList.MOVE_POINT_AND_LINE);
        Thread.sleep(3000);
        Page_MultiList.Inst.Click(Page_MultiList.CANCEL_POI);

        Sqlitetools.RefreshData();

        String child = new String((byte[])Sqlitetools.GePoiDataByFid(infoFid, "relateChildren"));
        assertEquals(child, "[]");

    }

    // POI 错误列表增加父子关系、同一关系错误类型
    @Test
    public void test00106_poi_same_error_check() throws Exception
    {

        String[][] attrib1 = {{Page_POI.NAME, "政府机关TEST"},
                              {Page_POI.SELECT_TYPE, "区级政府机关(广州市）"}};

        AddPOI(attrib1, "116.40624", "39.96918");

        String[][] attrib2 = {{Page_POI.NAME, "银行TEST"},
                              {Page_POI.SELECT_TYPE, "银行"},
                              {Page_POI.POI_SAME, "政府机关ＴＥＳＴ"}};

        String infoFid = AddPOI(attrib2, "116.40628", "39.96918");

        SearchLocation("116.40624", "39.96918");
        synchronize(Page_GridManager.POI_UPDATE);

        CheckErrorList("Poi", "同一poi(" + "fid:"+infoFid + ")在库中不存在", "POI");
    }

    // 高速实景图手动录入编号
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

        synchronize(Page_GridManager.TIPS_UPDATE);

        //根据rowkey查找该实景图
        SearchTips(rowkey);

        assertTrue(Page_TrueSence.Inst.isExistByName("6bCD1234"));
    }

    // 功能面验证
    @Test @IMPORTANT
    public void test00108_001_functionalarea_check() throws Exception
    {
        //绘制功能面
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.FUNCTIONAL_SURFACE);
        Page_MainBoard.Inst.Click(new Point(500,500));
        Page_MainBoard.Inst.Click(new Point(800,500));
        Page_MainBoard.Inst.Click(new Point(500,800));
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
    @Test @IMPORTANT
    public void test00108_002_functionalarea_check() throws Exception
    {
        //绘制功能面
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.FUNCTIONAL_SURFACE);
        Page_MainBoard.Inst.Click(new Point(500,500));
        Page_MainBoard.Inst.Click(new Point(800,500));
        Page_MainBoard.Inst.Click(new Point(500,800));
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
    public void test00109_poi_picture_check() throws Exception
    {
        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"}};
        AddPOI(attrib);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        Page_POI.Inst.ScrollClick(Page_POI.MULIT_MEDIA);

        Page_POI.Inst.Click(Page_POI.PICTURE);

        assertTrue(Page_TrueSence.Inst.isExistByName("保存"));

    }

    // 第三方数据验证
    @Test @IMPORTANT
    public void test00110_3rdParty_Data_check() throws Exception
    {
    	if(FastMapPage.IS_OS_TEST)
    	{
    		return;
    	}
    	
        // 创建情报
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.POINT_INFO); //点击点情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(900,500)); //点击情报位置

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
        Page_MyData.Inst.ClickbyText("自采集情报(POI)(点)");
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

    // 精细化作业要素渲染
    @Test
    public void test00111_hide_feature_check() throws Exception
    {
        // 创建点门牌
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);

        Page_PAS.Inst.SetValue(Page_PAS.NAME, "测试ＰＡＳ");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "101");
        Page_PAS.Inst.Click(Page_PAS.ODD);
        Page_PAS.Inst.Click(Page_PAS.ROAD_TYPE);
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
    public void test00112_sync_over_grid_check() throws Exception
    {
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
    public void test00113_1_poi_truck_check() throws Exception
    {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"},
                {Page_POI.POI_TRUCK, "非卡车"}};
        AddPOI(attrib);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        Page_POI.Inst.isExistByName("非卡车");
    }
    // POI 卡车标识验证
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

        Page_POI.Inst.isExistByName("仅卡车");
    }
    // POI 卡车标识验证
    @Test
    public void test00113_3_poi_truck_check() throws Exception
    {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"},
                {Page_POI.POI_TRUCK, "卡车+小汽车"}};
        AddPOI(attrib);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        Page_POI.Inst.isExistByName("卡车+小汽车");
    }

    // POI 标记字段验证
    @Test
    public void test00114_1_poi_remark_check() throws Exception
    {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"},
                {Page_POI.POI_REMARK, "名称"}};
        AddPOI(attrib);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        Page_POI.Inst.isExistByName("名称");
    }
    // POI 标记字段验证
    @Test
    public void test00114_2_poi_remark_check() throws Exception
    {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"},
                {Page_POI.POI_REMARK, "电话"}};
        AddPOI(attrib);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        Page_POI.Inst.isExistByName("电话");
    }
    // POI 标记字段验证
    @Test
    public void test00114_3_poi_remark_check() throws Exception
    {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"},
                {Page_POI.POI_REMARK, "分类"}};
        AddPOI(attrib);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        Page_POI.Inst.isExistByName("分类");
    }
    // POI 标记字段验证
    @Test
    public void test00114_4_poi_remark_check() throws Exception
    {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"},
                {Page_POI.POI_REMARK, "品牌"}};
        AddPOI(attrib);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        Page_POI.Inst.isExistByName("品牌");
    }
    // POI 标记字段验证
    @Test
    public void test00114_5_poi_remark_check() throws Exception
    {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"},
                {Page_POI.POI_REMARK, "地址"}};
        AddPOI(attrib);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        Page_POI.Inst.isExistByName("地址");
    }
    // POI 标记字段验证
    @Test
    public void test00114_6_poi_remark_check() throws Exception
    {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"},
                {Page_POI.POI_REMARK, "邮编"}};
        AddPOI(attrib);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        Page_POI.Inst.isExistByName("邮编");
    }
    // POI 标记字段验证
    @Test
    public void test00114_7_poi_remark_check() throws Exception
    {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"},
                {Page_POI.POI_REMARK, "深度信息"}};
        AddPOI(attrib);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        Page_POI.Inst.isExistByName("深度信息");
    }
    //危险信息Tips修改实时控制条件
    @Test
    public void test00115_1_tips_dangerous_info_check() throws Exception
    {

        String[] LOC = {"116.54238", "39.93779"};
        //SearchLocation(LOC);

        //创建危险信息tips
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DANGEROUS_INFO);
        Page_MainBoard.Inst.ClickCenter();

        //左侧合流
        Page_Dangerous.Inst.Click(Page_Dangerous.CONFLUENCE_LEFT);

        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据

        Page_POI.Inst.isExistByName("危险信息");

    }

    @Test
    public void test00115_2_tips_dangerous_info_check() throws Exception
    {

        String[] LOC = {"116.54246", "39.93779"};
        SearchLocation(LOC);

        //创建危险信息tips
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DANGEROUS_INFO);
        Page_MainBoard.Inst.ClickCenter();

        //左侧合流
        Page_Dangerous.Inst.Click(Page_Dangerous.CONFLUENCE_LEFT);

        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据

        Page_POI.Inst.isExistByName("危险信息");

    }

    @Test
    public void test00115_3_tips_dangerous_info_check() throws Exception
    {

        String[] LOC = {"116.54238", "39.93779"};
        //SearchLocation(LOC);

        //创建危险信息tips
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DANGEROUS_INFO);
        Page_MainBoard.Inst.ClickCenter();

        //右侧合流
        Page_Dangerous.Inst.Click(Page_Dangerous.CONFLUENCE_RIGHT);

        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据

        Page_POI.Inst.isExistByName("危险信息");

    }

    @Test
    public void test00115_4_tips_dangerous_info_check() throws Exception
    {

        String[] LOC = {"116.54246", "39.93779"};
        SearchLocation(LOC);

        //创建危险信息tips
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DANGEROUS_INFO);
        Page_MainBoard.Inst.ClickCenter();

        //右侧合流
        Page_Dangerous.Inst.Click(Page_Dangerous.CONFLUENCE_RIGHT);

        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据

        Page_POI.Inst.isExistByName("危险信息");

    }

    //补充同一关系原则
    //风景名胜（180400）可以和任意类型（除自身以及210304风景名胜售票点）做同一关系
    @Test
    public void test00116_1_poi_same_error_check() throws Exception
    {

        String[][] attrib1 = {{Page_POI.NAME, "中餐馆TEST"},
                {Page_POI.SELECT_TYPE, "中餐馆"}};

        AddPOI(attrib1, "116.40624", "39.95918");

        String[][] attrib2 = {{Page_POI.NAME, "风景名胜TEST"},
                {Page_POI.SELECT_TYPE, "风景名胜"},
                {Page_POI.POI_SAME, "中餐馆ＴＥＳＴ"}};

        String infoFid = AddPOI(attrib2, "116.40628", "39.95918");

        SearchLocation("116.40624", "39.95918");
        synchronize(Page_GridManager.POI_UPDATE);

        CheckErrorList("Poi", "同一poi(" + "fid:"+infoFid + ")在库中不存在", "POI");
    }

    //补充同一关系原则
    //风景名胜（180400）可以和任意类型（除自身以及210304风景名胜售票点）做同一关系
    @Test
    public void test00116_2_poi_same_error_check() throws Exception
    {

        String[][] attrib1 = {{Page_POI.NAME, "风景名胜TEST"},
                {Page_POI.SELECT_TYPE, "风景名胜"}};

        AddPOI(attrib1, "116.40624", "39.95918");

        String[][] attrib2 = {{Page_POI.NAME, "风景名胜售票点TEST"},
                {Page_POI.SELECT_TYPE, "风景名胜售票点"},
                {Page_POI.POI_SAME, "风景名胜ＴＥＳＴ"}};

        try {
            AddPOI(attrib2, "116.40628", "39.95918");
        }catch (Exception e) {

        }

        assertTrue(Page_TrueSence.Inst.isExistByName("保存"));
    }
    //补充同一关系原则
    //旅游观光（180403）可以和任意类型（除自身以及210304风景名胜售票点）做同一关系
    @Test
    public void test00116_3_poi_same_error_check() throws Exception
    {

        String[][] attrib1 = {{Page_POI.NAME, "中餐馆TEST"},
                {Page_POI.SELECT_TYPE, "中餐馆"}};

        AddPOI(attrib1, "116.40624", "39.95918");

        String[][] attrib2 = {{Page_POI.NAME, "旅游观光TEST"},
                {Page_POI.SELECT_TYPE, "旅游观光"},
                {Page_POI.POI_SAME, "中餐馆ＴＥＳＴ"}};

        String infoFid = AddPOI(attrib2, "116.40628", "39.95918");

        SearchLocation("116.40624", "39.95918");
        synchronize(Page_GridManager.POI_UPDATE);

        CheckErrorList("Poi", "同一poi(" + "fid:"+infoFid + ")在库中不存在", "POI");
    }

    //补充同一关系原则
    //旅游观光（180403）可以和任意类型（除自身以及210304风景名胜售票点）做同一关系
    @Test
    public void test00116_4_poi_same_error_check() throws Exception
    {

        String[][] attrib1 = {{Page_POI.NAME, "旅游观光TEST"},
                {Page_POI.SELECT_TYPE, "旅游观光"}};

        AddPOI(attrib1, "116.40624", "39.95918");

        String[][] attrib2 = {{Page_POI.NAME, "风景名胜售票点TEST"},
                {Page_POI.SELECT_TYPE, "风景名胜售票点"},
                {Page_POI.POI_SAME, "旅游观光ＴＥＳＴ"}};

        try {
            AddPOI(attrib2, "116.40628", "39.95918");
        }catch (Exception e) {

        }

        assertTrue(Page_TrueSence.Inst.isExistByName("保存"));
    }

    //补充同一关系原则
    //风景名胜（180400）与旅游观光（180403）不能建立同一关系
    @Test
    public void test00116_5_poi_same_error_check() throws Exception
    {

        String[][] attrib1 = {{Page_POI.NAME, "旅游观光TEST"},
                {Page_POI.SELECT_TYPE, "旅游观光"}};

        AddPOI(attrib1, "116.40624", "39.95918");

        String[][] attrib2 = {{Page_POI.NAME, "风景名胜TEST"},
                {Page_POI.SELECT_TYPE, "风景名胜"},
                {Page_POI.POI_SAME, "旅游观光ＴＥＳＴ"}};

        try {
            AddPOI(attrib2, "116.40628", "39.95918");
        }catch (Exception e) {

        }

        assertTrue(Page_TrueSence.Inst.isExistByName("保存"));
    }



    // FM_1113_2_1 车道限速
    @Test
    public void test_FM_1113_2_1_check() throws Exception
    {
    	if(FastMapPage.IS_OS_TEST)
    	{
    		return;
    	}
    	
        // 创建车道限速
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);
        Page_MainBoard.Inst.ClickCenter();
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.ROADLIMIT);
        Page_MainBoard.Inst.Drag(85,514,90,514,5);
        Page_SpeedLimit.Inst.Click(new Point(65,354));
        Page_SpeedLimit.Inst.Click(new Point(65,435));
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM30);
        //Page_SpeedLimit.Inst.Click(new Point(155,553));
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM30);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        AssertIndoorCheck("车道限速", "高", "FM-1113-2-1", "车道限速各车道的限速值一样时，不需采集", "忽略");
    }

    // FM-1207-6-2
    @Test
    public void test_FM_1207_6_2_check() throws Exception
    {

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
    public void test_FM_1208_2_1_check() throws Exception
    {
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
    public void test_FM_1301_6_4_1_check() throws Exception
    {

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
    public void test_FM_1304_6_2_1_check() throws Exception
    {
        SearchLocation(LOC_K1);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Page_MainBoard.Inst.ClickCenter();
        Page_NoPassing.Inst.Click(Page_NoPassing.SAVE);

        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");
    }

    // FM-1304-6-2
    @Test
    public void test_FM_1304_6_2_2_check() throws Exception
    {
        SearchLocation(LOC_K2);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Page_MainBoard.Inst.ClickCenter();
        Page_NoPassing.Inst.Click(Page_NoPassing.SAVE);

        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");
    }

    // FM-1304-6-2
    @Test
    public void test_FM_1304_6_2_3_check() throws Exception
    {
        SearchLocation(LOC_K3);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Page_MainBoard.Inst.ClickCenter();
        Page_NoPassing.Inst.Click(Page_NoPassing.SAVE);

        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");
    }

    // FM-1304-6-2
    @Test
    public void test_FM_1304_6_2_4_check() throws Exception
    {
        SearchLocation(LOC_K4);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Page_MainBoard.Inst.ClickCenter();
        Page_NoPassing.Inst.Click(Page_NoPassing.SAVE);

        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");
    }

    @Test
    public void test_FM_1304_6_2_5_check() throws Exception
    {
    	SearchLocation("116.41738", "39.96387");
    	
        //同步tips
        synchronize(Page_GridManager.TIPS_UPDATE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Page_MainBoard.Inst.ClickCenter();
        Page_NoPassing.Inst.Click(Page_NoPassing.SAVE);

        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");
    }

    @Test
    public void test_FM_1304_6_2_6_check() throws Exception
    {
    	SearchLocation("116.41757", "39.96337");
    	
        //同步tips
        synchronize(Page_GridManager.TIPS_UPDATE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Page_MainBoard.Inst.ClickCenter();
        Page_NoPassing.Inst.Click(Page_NoPassing.SAVE);

        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");

    }

    @Test
    public void test_FM_1304_6_2_7_check() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(1000, 790));
        Page_MainBoard.Inst.Click(new Point(1300, 790));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.NATIONAL_RD);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_2);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        //禁止穿行3级道路（测线且t_sync=0）
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Page_MainBoard.Inst.Click(new Point(1000,790));
        Page_NoPassing.Inst.Click(Page_NoPassing.SAVE);

        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");
    }

    @Test
    public void test_FM_1304_6_2_8_check() throws Exception
    {

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(1000, 1000));
        Page_MainBoard.Inst.Click(new Point(1300, 1000));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.NATIONAL_RD);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_2);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        //禁止穿行3级道路（测线且t_sync=0）
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Page_MainBoard.Inst.Click(new Point(1000,1000));
        Page_NoPassing.Inst.Click(Page_NoPassing.SAVE);

        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");
    }

    // FM-1305-6-1
    @Test
    public void test_FM_1305_6_1_1_check() throws Exception
    {
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
    public void test_FM_1305_6_1_2_check() throws Exception
    {
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
    public void test_FM_1305_6_2_1_check() throws Exception
    {

        SearchLocation(LOC_K1);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);


        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

   // FM-1304-6-2
    @Test
    public void test_FM_1305_6_2_2_check() throws Exception
    {

        SearchLocation(LOC_K2);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);

        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

    // FM-1304-6-2
    @Test
    public void test_FM_1305_6_2_3_check() throws Exception
    {

        SearchLocation(LOC_K3);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);


        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

    // FM-1304-6-2
    @Test
    public void test_FM_1305_6_2_4_check() throws Exception
    {

        SearchLocation(LOC_K4);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);


        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

    @Test
    public void test_FM_1305_6_2_5_check() throws Exception
    {

    	SearchLocation("116.41738", "39.96387");
    	
        //同步tips
        synchronize(Page_GridManager.TIPS_UPDATE);

        //禁止驶入1级道路（测线且t_sync=1）

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);

        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

    @Test
    public void test_FM_1305_6_2_6_check() throws Exception
    {

    	SearchLocation("116.41757", "39.96337");
    	
        //同步tips
        synchronize(Page_GridManager.TIPS_UPDATE);

        //禁止驶入2级道路（测线且t_sync=1）

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);


        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

    @Test
    public void test_FM_1305_6_2_7_check() throws Exception
    {
        //绘制测线
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(1000, 790));
        Page_MainBoard.Inst.Click(new Point(1300, 790));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.NATIONAL_RD);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_2);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        //禁止驶入3级道路（测线且t_sync=0）
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.Click(new Point(1000,790));
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);

        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

    @Test
    public void test_FM_1305_6_2_8_check() throws Exception
    {
        //绘制测线
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(1000, 1000));
        Page_MainBoard.Inst.Click(new Point(1300, 1000));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.PROVINCIAL_RD);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_2);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        //禁止驶入4级道路（测线且t_sync=0）
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.Click(new Point(1000,1000));
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);

        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

    //FM-1503-6-1
    @Test
    public void test_FM_1503_6_1_1_check() throws Exception
    {

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

        AssertIndoorCheck("高架路", "中", "FM-1503-6-1", "高架路与跨越桥（或穿越地道）不能共存","");
    }

    @Test
    public void test_FM_1503_6_1_2_check() throws Exception
    {

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

        AssertIndoorCheck("高架路", "中", "FM-1503-6-1", "高架路与跨越桥（或穿越地道）不能共存","");
    }

    @Test
    public void test_FM_1503_6_1_3_check() throws Exception
    {
        Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500)};
        DrawRoad(arrayPoint);
        
        SetStartEndPoint(arrayPoint[0], arrayPoint[1], Page_StartEndPoint.OVERHEAD_ROAD_BT);
        SetStartEndPoint(arrayPoint[0], arrayPoint[1], Page_StartEndPoint.OVERPASS_BT);

        AssertIndoorCheck("高架路", "中", "FM-1503-6-1", "高架路与跨越桥（或穿越地道）不能共存","");
    }

    @Test
    public void test_FM_1503_6_1_4_check() throws Exception
    {
        Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500)};
        DrawRoad(arrayPoint);
        
        SetStartEndPoint(arrayPoint[0], arrayPoint[1], Page_StartEndPoint.OVERHEAD_ROAD_BT);
        SetStartEndPoint(arrayPoint[0], arrayPoint[1], Page_StartEndPoint.UNDER_PASS_BT);

        AssertIndoorCheck("高架路", "中", "FM-1503-6-1", "高架路与跨越桥（或穿越地道）不能共存","");
    }

    //FM-1521-1-2
    @Test
    public void test_FM_1521_1_2_check() throws Exception
    {
        Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500)};
        DrawRoad(arrayPoint);
        
        SetStartEndPoint(arrayPoint[0], arrayPoint[1], Page_StartEndPoint.TRAVELING_BRIDGE_BT);

        //删除测线
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.SelectData("测线");
        Page_SurveyLine.Inst.Click(Page_SurveyLine.DELETE);
        Page_SurveyLine.Inst.ClickbyText("仅删除测线");
        ExitMyData();

        AssertIndoorCheck("移动式桥", "中", "FM-1521-1-2", "Tips没有关联道路或测线或Node","");
    }

    // 上报情报
    public void addReport() throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {

        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.POINT_INFO); //点击点情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(900,500)); //点击情报位置

        Page_InfoPoint.Inst.SetValue(Page_InfoPoint.NAME, "测试上报情报6"); //输入情报名称
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

        //获取globalID
        GotoMyData(Page_MyData.INFO_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("自采集情报(POI)(点)", "测试上报情报6");
        globalId = Page_InfoPoint.Inst.GetValue(Page_InfoPoint.GLOBAL_ID).substring(10);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.CANCEL);
        ExitMyData(); //退出我的数据

    }


    // 采纳情报
    public void accept() throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {

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

            infoFid =  Page_POI.Inst.GetValue(Page_POI.FID);

            Page_POI.Inst.Click(Page_POI.SAVE); //点击保存
            Page_SearchResultList.Inst.Click(Page_SearchResultList.BACK); //点击返回
    }

    // 检查情报fid
    public void checkFid() throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {

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