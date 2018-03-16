package com.example.fang.autotestfastmap;


import com.fastmap.ui.Page_MyData;
import com.fastmap.ui.Page_POI;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;

import static junit.framework.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by fang on 17/11/21.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testFastMapZF_hm extends testFastMapBase
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

        this.setClassUp("collector2", "123456", true);
    }

    @After
    public  void setAfter() //throws IOException, InterruptedException {
    {

        //super.setAfter();
    }

    // POI 分类品牌表增加港澳标识
    @Test
    public void test00101_poi_hm_brand_check() throws Exception
    {

        String[][] attrib = {
                { Page_POI.NAME, "测试ＰＯＩ"},
                { Page_POI.SELECT_TYPE, "厂家一览表内汽车修理"},
                { Page_POI.SELECT_BRAND, "丰田维修"},
        };

        AddPOI(attrib);

        GotoMyData(Page_MyData.POI_TYPE);
        Assert.assertTrue(Page_MyData.Inst.isExistByName("测试ＰＯＩ"));
    }

}
