package com.dodo.project.base.commons.utils.encrypt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;

import static java.util.Arrays.*;

/*
 * <b>Des3Helper</b></br>
 *
 * <pre>
 * 3Des加密辅助类
 * </pre>
 *
 * @Author xqyjjq walk_code@163.com
 * @Date 2019/5/17 15:04
 * @Since JDK 1.8
 */
public class Des3Helper {

	// 指定加密算法
	private static final String ENCRYPTION_ALGORITHM = "DESede";// DESede  AES

	private static final Logger log = LoggerFactory.getLogger(Des3Helper.class);

	/*
	 * @Description: 加密字符
	 * @Author: walk_code walk_code@163.com
	 * @Param: [message, keyBytes]
	 * @return: byte[]
	 * @Date: 2019/5/17 15:08
	 */
	public static byte[] encrypt(String message, String keySpec) throws Exception {
		MessageDigest md               = MessageDigest.getInstance("md5");
		byte[]        digestOfPassword = md.digest(keySpec.getBytes("utf-8"));
		byte[]        keyBytes         = copyOf(digestOfPassword, 24);
		createKeyBytes(keyBytes);

		SecretKey       key    = new SecretKeySpec(keyBytes, ENCRYPTION_ALGORITHM);
		IvParameterSpec iv     = new IvParameterSpec(new byte[8]);
		Cipher          cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key, iv);

		byte[] plainTextBytes = message.getBytes("utf-8");
		byte[] cipherText     = cipher.doFinal(plainTextBytes);

		return cipherText;
	}

	/*
	 * @Description: 解密字符
	 * @Author: walk_code walk_code@163.com
	 * @Param: [encryptedMessage, keyBytes]
	 * @return: byte[]
	 * @Date: 2019/5/17 15:41
	 */
	public static String decrypt(byte[] message, String keySpec) throws Exception {
		MessageDigest md               = MessageDigest.getInstance("md5");
		byte[]        digestOfPassword = md.digest(keySpec.getBytes("utf-8"));
		byte[]        keyBytes         = copyOf(digestOfPassword, 24);
		createKeyBytes(keyBytes);
		SecretKey       key      = new SecretKeySpec(keyBytes, "DESede");
		IvParameterSpec iv       = new IvParameterSpec(new byte[8]);
		Cipher          decipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
		decipher.init(Cipher.DECRYPT_MODE, key, iv);
		byte[] plainText = decipher.doFinal(message);

		return new String(plainText, "UTF-8");
	}

	/*
	 * @Description: 根据secretKey长度指定字节数组大小
	 * @Author: walk_code walk_code@163.com
	 * @Param: [keyBytes]
	 * @return: byte[]
	 * @Date: 2019/5/30 10:06
	 */
	private static void createKeyBytes(byte[] keyBytes) {
		for (int j = 0, k = 16; j < 8; ) {
			keyBytes[k++] = keyBytes[j++];
		}
	}
}
