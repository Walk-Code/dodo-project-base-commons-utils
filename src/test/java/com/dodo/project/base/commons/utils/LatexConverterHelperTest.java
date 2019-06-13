package com.dodo.project.base.commons.utils;

import com.dodo.project.base.commons.utils.latex.LatexConverterHelper;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

/*
 * <b>LatexConverterHelperTest</b></br>
 *
 * <pre>
 * Latex转换图片 - 单元测试
 * </pre>
 *
 * @Author xqyjjq walk_code@163.com
 * @Date 2019/6/13 17:51
 * @Since JDK 1.8
 */
public class LatexConverterHelperTest {
	@Test
	public void converterImage(){
		String latexStr = "\\frac{1}{12}";
		String latexTempImgPath = LatexConverterHelper.convertToImage(latexStr);
		System.out.println(latexTempImgPath);
		Assert.assertTrue("转换失败。", StringUtils.isNotBlank(latexTempImgPath));
	}
}
