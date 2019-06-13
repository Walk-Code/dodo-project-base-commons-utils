package com.dodo.project.base.commons.utils.enums;

import com.dodo.project.base.commons.utils.base.BaseEnum;

import java.lang.reflect.Field;
import java.util.logging.Logger;

/*
 * <b>EnumsHelper</b></br>
 *
 * <pre>
 * 枚举操作-辅助类
 * </pre>
 *
 * @Author xqyjjq walk_code@163.com
 * @Date 2019/6/3 14:11
 * @Since JDK 1.8
 */
public class EnumsHelper<E> {
	private static final Logger log = Logger.getLogger("EnumsHelper");

	/*
	 * @Description: 获取枚举值
	 * @Author: walk_code walk_code@163.com
	 * @Param: [tclass, id]
	 * @return: E
	 * @Date: 2019/6/3 15:08
	 */
	public static <E extends Enum<E>> E getEnums(Class<E> tclass, String id) {
		E result;
		try {
			result = Enum.valueOf(tclass, id);

		} catch (Exception e) {
			throw new RuntimeException("无效的enum值 " + tclass.getSimpleName() + ": " + id);
		}

		return result;
	}

}
