package com.dodo.project.base.commons.utils;

import com.alibaba.fastjson.JSONArray;
import com.dodo.project.base.commons.utils.json.JsonData;
import org.junit.Assert;
import org.junit.Test;

/*
 * <b>JsonDataTest</b></br>
 *
 * <pre>
 * 对未知类型的json数据解析辅助类-单元测试
 * </pre>
 *
 * @Author xqyjjq walk_code@163.com
 * @Date 2019/6/1 17:17
 * @Since JDK 1.8
 */
public class JsonDataTest {
	@Test
	public void resolveJson() {
		String   data     = "{\"status\":\"1\",\"count\":\"2\",\"info\":\"OK\",\"infocode\":\"10000\",\"tips\":[{\"id\":\"B00140UFXT\",\"name\":\"广东工业大学(大学城校区)\",\"district\":\"广东省广州市番禺区\",\"adcode\":\"440113\",\"location\":\"113.393116,23.039404\",\"address\":\"大学城外环西路100号\",\"typecode\":\"141201\",\"city\":[]},{\"id\":\"B00141S9KD\",\"name\":\"广东工业大学-理学馆\",\"district\":\"广东省广州市番禺区\",\"adcode\":\"440113\",\"location\":\"113.399989,23.034991\",\"address\":\"大学城外环西路广东工业大学大学城校区\",\"typecode\":\"141201\",\"city\":[]}]}";
		JsonData jsonData = JsonData.createObject(data);
		String   status   = jsonData.getStr("status");
		Assert.assertEquals("获取状态失败。", status, "1");
		JsonData jsonDataListObj = jsonData.toArray("tips");
		String   resolveId       = jsonDataListObj.getItem(0).getStr("id");
		Assert.assertEquals("获取tips第一项中的id值。",resolveId, "B00140UFXT");
	}

}
