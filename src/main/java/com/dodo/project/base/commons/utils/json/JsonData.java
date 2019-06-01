package com.dodo.project.base.commons.utils.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * <b>JsonData</b></br>
 *
 * <pre>
 * 对未知类型的json数据解析辅助类
 * </pre>
 *
 * @Author xqyjjq walk_code@163.com
 * @Date 2019/5/31 17:51
 * @Since JDK 1.8
 */
public class JsonData {
	private JSONObject jsonObject;

	private JSONArray jsonArray;

	public JsonData() {
	}

	public JsonData(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}

	public JsonData(JSONArray jsonArray) {
		this.jsonArray = jsonArray;
	}

	/*
	 * @Description: json字符串转json对象
	 * @Author: walk_code walk_code@163.com
	 * @Param: [jsonStr]
	 * @return: com.alibaba.fastjson.JSONObject
	 * @Date: 2019/5/31 18:12
	 */
	public static JsonData createObject(String jsonStr) {
		JSONObject jsonObject = JSON.parseObject(jsonStr, JSONObject.class);

		return new JsonData(jsonObject);
	}

	/*
	 * @Description: json字符串转json数组
	 * @Author: walk_code walk_code@163.com
	 * @Param: [jsonStr]
	 * @return: com.dodo.project.base.commons.utils.json.JsonData
	 * @Date: 2019/5/31 18:19
	 */
	public static JsonData createArray(String jsonStr) {
		JSONArray jsonArray = JSON.parseObject(jsonStr, JSONArray.class);

		return new JsonData(jsonArray);
	}

	/*
	 * @Description: 通过key获取json对象
	 * @Author: walk_code walk_code@163.com
	 * @Param: [key]
	 * @return: java.lang.String
	 * @Date: 2019/5/31 18:22
	 */
	public String getStr(String key) {
		if (null == jsonObject) {
			return null;
		}

		return jsonObject.getString(key);
	}

	/*
	 * @Description: 通过key获取json对象int类型的值
	 * @Author: walk_code walk_code@163.com
	 * @Param: [key]
	 * @return: int
	 * @Date: 2019/5/31 18:25
	 */
	public int getInt(String key) {
		if (null == jsonObject) {
			return 0;
		}

		return jsonObject.getIntValue(key);
	}

	/*
	 * @Description:  通过key获取json对象short类型的值
	 * @Author: walk_code walk_code@163.com
	 * @Param: [key]
	 * @return: short
	 * @Date: 2019/5/31 18:27
	 */
	public short getShort(String key) {
		if (null == jsonObject) {
			return 0;
		}

		return jsonObject.getShortValue(key);
	}


	/*
	 * @Description: 通过key获取json对象double类型的值
	 * @Author: walk_code walk_code@163.com
	 * @Param: [key]
	 * @return: double
	 * @Date: 2019/5/31 18:28
	 */
	public double getDouble(String key) {
		if (null == jsonObject) {
			return 0;
		}

		return jsonObject.getDoubleValue(key);
	}

	/*
	 * @Description: 通过key获取json对象long类型的值
	 * @Author: walk_code walk_code@163.com
	 * @Param: [key]
	 * @return: long
	 * @Date: 2019/5/31 18:30
	 */
	public long getLong(String key) {
		if (null == jsonObject) {
			return 0;
		}

		return jsonObject.getLongValue(key);
	}

	/*
	 * @Description: 通过key获取json对象byte类型的值
	 * @Author: walk_code walk_code@163.com
	 * @Param: [key]
	 * @return: byte
	 * @Date: 2019/5/31 18:33
	 */
	public byte getByte(String key) {
		if (null == jsonObject) {
			return 0;
		}

		return jsonObject.getByte(key);
	}

	/*
	 * @Description: 通过key获取json对象float类型的值
	 * @Author: walk_code walk_code@163.com
	 * @Param: [key]
	 * @return: float
	 * @Date: 2019/5/31 18:39
	 */
	public float getFloat(String key) {
		if (null == jsonObject) {
			return 0;
		}

		return jsonObject.getFloatValue(key);
	}

	/*
	 * @Description: 通过key获取json对象char类型的值
	 * @Author: walk_code walk_code@163.com
	 * @Param: [key]
	 * @return: char
	 * @Date: 2019/5/31 18:40
	 */
	public boolean getBoolean(String key) {
		if (null == jsonObject) {
			return false;
		}

		return jsonObject.getBooleanValue(key);
	}

	/*
	 * @Description: 通过key获取JsonData对象
	 * @Author: walk_code walk_code@163.com
	 * @Param: [key]
	 * @return: com.dodo.project.base.commons.utils.json.JsonData
	 * @Date: 2019/5/31 18:44
	 */
	public JsonData toMap(String key) {
		if (null != jsonObject) {
			this.jsonObject = jsonObject.getJSONObject(key);
		}

		return this;
	}

	/*
	 * @Description: 通过key获取JsonData对象
	 * @Author: walk_code walk_code@163.com
	 * @Param: [key]
	 * @return: com.dodo.project.base.commons.utils.json.JsonData
	 * @Date: 2019/5/31 18:46
	 */
	public JsonData toArray(String key) {
		if (null != jsonObject) {
			this.jsonArray = jsonObject.getJSONArray(key);
		}

		return this;
	}

	/*
	 * @Description: 获取json对象
	 * @Author: walk_code walk_code@163.com
	 * @Param: []
	 * @return: java.util.Map<java.lang.String,java.lang.Object>
	 * @Date: 2019/6/1 17:03
	 */
	public Map<String, Object> getMap() {
		return this.jsonObject;
	}

	/*
	 * @Description: 获取指定bean类型的list
	 * @Author: walk_code walk_code@163.com
	 * @Param: [tClass]
	 * @return: java.util.List<T>
	 * @Date: 2019/6/1 17:10
	 */
	public <T> List<T> getList(Class<T> tClass) {
		if (null == this.jsonObject) {
			return new ArrayList<T>();
		}

		return this.jsonArray.toJavaList(tClass);
	}

	/*
	 * @Description: 根据下标获取数组中指定项
	 * @Author: walk_code walk_code@163.com
	 * @Param: [index]
	 * @return: com.dodo.project.base.commons.utils.json.JsonData
	 * @Date: 2019/6/1 17:14
	 */
	public JsonData getItem(int index) {
		if (null != jsonArray) {
			this.jsonObject =  this.jsonArray.getJSONObject(index);
		}

		return this;
	}

	/*
	 * @Description: 获取List大小
	 * @Author: walk_code walk_code@163.com
	 * @Param: []
	 * @return: int
	 * @Date: 2019/6/1 17:15
	 */
	public int getListSize() {
		if (null != jsonArray) {
			return this.jsonArray.size();
		}

		return 0;
	}
}
