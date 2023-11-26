package com.iweb;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**批量测试
 * @author yiyu
 * @date 2023/11/15 20:37
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({JDBCTest.class, JDBCTest1.class})
public class Test1 {
}
