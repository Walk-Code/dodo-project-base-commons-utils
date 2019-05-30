package com.dodo.project.base.commons.utils;

import com.dodo.project.base.commons.utils.arithmetic.ArithmeticHelper;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/*
 * <b>ArithmeticHelperTest</b></br>
 *
 * <pre>
 * 精度计算-单元测试
 * </pre>
 *
 * @Author xqyjjq walk_code@163.com
 * @Date 2019/5/30 17:18
 * @Since JDK 1.8
 */
public class ArithmeticHelperTest {
	@Test
	public void add() {
		double     a      = 0.156d;
		float      b      = 0.1f;
		BigDecimal result = ArithmeticHelper.add(a, b, 2, BigDecimal.ROUND_HALF_EVEN);
		System.out.println(result);
		Assert.assertTrue("相加错误。", result.doubleValue() == 0.26);
	}

	@Test
	public void subtraction() {
		double     a      = 0.156d;
		float      b      = 0.1f;
		BigDecimal result = ArithmeticHelper.subtraction(a, b, 2, BigDecimal.ROUND_HALF_EVEN);
		System.out.println(result);
		Assert.assertTrue("相减错误。", result.doubleValue() == 0.06);
	}

	@Test
	public void multiply() {
		double     a      = 0.15d;
		float      b      = 0.1f;
		BigDecimal result = ArithmeticHelper.multiply(a, b, 2, BigDecimal.ROUND_HALF_EVEN);
		System.out.println(result);
		Assert.assertTrue("相乘错误", result.doubleValue() == 0.02);
	}

	@Test
	public void divide(){
		double     a      = 0.156d;
		float      b      = 0.1f;
		BigDecimal result = ArithmeticHelper.divide(a, b, 2, BigDecimal.ROUND_HALF_EVEN);
		System.out.println(result);
		Assert.assertTrue("相除错误", result.doubleValue() == 1.56);
	}

}
