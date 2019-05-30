package com.dodo.project.base.commons.utils;


import com.dodo.project.base.commons.utils.encrypt.Des3Helper;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.DatatypeConverter;

/*
 * <b>Des3HelperTest</b></br>
 *
 * <pre>
 *  3des加密-单元测试
 * </pre>
 *
 * @Author xqyjjq walk_code@163.com
 * @Date 2019/5/17 16:04
 * @Since JDK 1.8
 */
public class Des3HelperTest {

	@Test
	public void encrypedAndDecryped(){
		String needEncrypedMessage = "This is a secret message";
		String encryptionKeyString = "appSecret88TTDFDSDSFDSHJKGHSNSKJGHSFKHEHDKJNDJKFDFNDBDDJKNDDS"; // 加密key
		byte [] codedtext = new byte[0];
		try {
			codedtext = Des3Helper.encrypt(needEncrypedMessage, encryptionKeyString);
			String decodedtext = Des3Helper.decrypt(codedtext, encryptionKeyString);
			System.out.println(codedtext); // this is a byte array, you'll just see a reference to an array
			System.out.println(decodedtext); // This correctly shows "kyle boon"
			Assert.assertTrue("加密失败",needEncrypedMessage.equals(decodedtext));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
