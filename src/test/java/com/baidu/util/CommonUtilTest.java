package com.baidu.util;

import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Test;

public class CommonUtilTest {

    @Test
    public void testMd5() throws UnsupportedEncodingException {
        String md5 = CommonUtil.md5("admin");
        Assert.assertNotNull(md5);
        System.out.println(md5);
    }

}
