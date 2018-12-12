package com.example.fang.autotestfastmap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;

import static junit.framework.Assert.assertEquals;

/**
 * Created by fang on 17/11/21.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({testFastMapCommon.class,testFastMapMonthBranch.class})
public class RunMonthBranch extends testFastMapBase {

}