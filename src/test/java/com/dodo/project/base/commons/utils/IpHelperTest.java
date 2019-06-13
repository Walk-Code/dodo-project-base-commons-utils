package com.dodo.project.base.commons.utils;

import com.dodo.project.base.commons.utils.ip.IpHelper;
import org.junit.Assert;
import org.junit.Test;

/*
 * <b>IpHelperTest</b></br>
 *
 * <pre>
 * IP操作辅助类-单元测试
 * </pre>
 *
 * @Author xqyjjq walk_code@163.com
 * @Date 2019/5/31 11:23
 * @Since JDK 1.8
 */
public class IpHelperTest {
	@Test
	public void isLocalIp() {
		String localIp = "192.168.3.19";
		Assert.assertTrue("该IP不是本地IP", IpHelper.isLocalIp(localIp));
	}

	@Test
	public void getLocalIp() {
		String localIp = IpHelper.LOCAL_IP;
		System.out.println(localIp);
		System.out.println(IpHelper.HOST_NAME);
		Assert.assertTrue("获取本地ip不正确", localIp.equals("192.168.33.1"));
	}

}
