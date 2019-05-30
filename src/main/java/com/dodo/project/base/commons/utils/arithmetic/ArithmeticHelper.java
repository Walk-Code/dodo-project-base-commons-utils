package com.dodo.project.base.commons.utils.arithmetic;

import java.math.BigDecimal;

/*
 * <b>ArithmeticHelper</b></br>
 *
 * <pre>
 * 精度计算相关
 * </pre>
 *
 * @Author xqyjjq walk_code@163.com
 * @Date 2019/5/30 16:23
 * @Since JDK 1.8
 */
public class ArithmeticHelper {
	/*
	 * @Description: 默认精度为小数点后11位
	 * @Author: walk_code walk_code@163.com
	 * @Param:
	 * @return:
	 * @Date: 2019/5/30 16:43
	 */
	public static final int DEFAULT_SCALE = 11;


	/*
	 * @Description: 两个数相加, double、float
	 * @Author: walk_code walk_code@163.com
	 * @Param: [a, b, roundingType]
	 * @return: java.math.BigDecimal
	 * @Date: 2019/5/30 16:48
	 */
	public static BigDecimal add(Object a, Object b, int roundingType) {
		return add(a, b, DEFAULT_SCALE, roundingType);
	}

	/*
	 * @Description: 两个数相加, double、float
	 * @Author: walk_code walk_code@163.com
	 * @Param: [a, b, scal, roundingType]
	 * @return: java.math.BigDecimal
	 * @Date: 2019/5/30 16:59
	 */
	public static BigDecimal add(Object a, Object b, int scale, int roundingType) {
		BigDecimal aB    = new BigDecimal(a.toString());
		BigDecimal bB    = new BigDecimal(b.toString());
		BigDecimal total = aB.add(bB);

		return round(total, scale, roundingType);
	}

	/*
	 * @Description: 两个数相减，double、float
	 * @Author: walk_code walk_code@163.com
	 * @Param: [a, b, roundingType]
	 * @return: java.math.BigDecimal
	 * @Date: 2019/5/30 17:02
	 */
	public static BigDecimal subtraction(Object a, Object b, int roundingType) {
		return subtraction(a, b, DEFAULT_SCALE, roundingType);
	}

	/*
	 * @Description: 两个数相减，double、float
	 * @Author: walk_code walk_code@163.com
	 * @Param: [a, b, scale, roundingType]
	 * @return: java.math.BigDecimal
	 * @Date: 2019/5/30 17:03
	 */
	public static BigDecimal subtraction(Object a, Object b, int scale, int roundingType) {
		BigDecimal aB     = new BigDecimal(a.toString());
		BigDecimal bB     = new BigDecimal(b.toString());
		BigDecimal result = aB.subtract(bB);

		return round(result, scale, roundingType);
	}

	/*
	 * @Description: 两个数相乘，double、float
	 * @Author: walk_code walk_code@163.com
	 * @Param: [a, b, roundingType]
	 * @return: java.math.BigDecimal
	 * @Date: 2019/5/30 17:05
	 */
	public static BigDecimal multiply(Object a, Object b, int roundingType) {
		return multiply(a, b, DEFAULT_SCALE, roundingType);
	}

	/*
	 * @Description: 两个数相乘， double、float
	 * @Author: walk_code walk_code@163.com
	 * @Param: [a, b, scale, roundingType]
	 * @return: java.math.BigDecimal
	 * @Date: 2019/5/30 17:06
	 */
	public static BigDecimal multiply(Object a, Object b, int scale, int roundingType) {
		BigDecimal aB     = new BigDecimal(a.toString());
		BigDecimal bB     = new BigDecimal(b.toString());
		BigDecimal result = aB.multiply(bB);

		return round(result, scale, roundingType);
	}

	/*
	 * @Description: 两个数相除，double、 float
	 * @Author: walk_code walk_code@163.com
	 * @Param: [a, b, roundingType]
	 * @return: java.math.BigDecimal
	 * @Date: 2019/5/30 17:14
	 */
	public static BigDecimal divide(Object a, Object b, int roundingType) {
		return divide(a, b, DEFAULT_SCALE, roundingType);
	}

	/*
	 * @Description: 两个数相除，double、 float
	 * @Author: walk_code walk_code@163.com
	 * @Param: [a, b, scale, roundingType]
	 * @return: java.math.BigDecimal
	 * @Date: 2019/5/30 17:16
	 */
	public static BigDecimal divide(Object a, Object b, int scale, int roundingType) {
		BigDecimal aB     = new BigDecimal(a.toString());
		BigDecimal bB     = new BigDecimal(b.toString());
		BigDecimal result = aB.divide(bB);

		return round(result, scale, roundingType);
	}

	/*
	 * @Description: 精度处理
	 * @Author: walk_code walk_code@163.com
	 * @Param: [result, roundingType]
	 * @return: java.math.BigDecimal
	 * @Date: 2019/5/30 16:53
	 */
	public static BigDecimal round(BigDecimal result, int scale, int roundingType) {
		return result.setScale(scale, roundingType);
	}
}
