package com.example.fang.autotestfastmap;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by fang on 17/11/21.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({testFastMapCommon.class,testFastMapMainBranch.class})
public class RunMainBranch extends testFastMapBase {

}