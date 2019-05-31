package com.dodo.project.base.commons.utils.encrypt;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/*
 * <b>RsaHelper</b></br>
 *
 * <pre>
 *  RSA加解密辅助类
 *  使用RSA加密。服务端生成RSA的密钥对；将公钥发给客户端；客户端使用该公钥对关键信息进行加密后，再将关键信息发送给服务器；
 *  服务器收到关键信息后，使用私钥进行解密，然后通过甄别解密后的关键信息，从而判定是否是真实有效的客户端用户。
 * </pre>
 *
 * @Author xqyjjq walk_code@163.com
 * @Date 2019/5/31 14:12
 * @Since JDK 1.8
 */
public class RsaHelper {
	/*
	 * @Description: 获取公钥
	 * @Author: walk_code walk_code@163.com
	 * @Param: [base64PublicKey]
	 * @return: java.security.PublicKey
	 * @Date: 2019/5/31 14:44
	 */
	public static PublicKey getPublicKey(String base64PublicKey) {
		PublicKey          publicKey = null;
		X509EncodedKeySpec keySpec   = new X509EncodedKeySpec(Base64.getDecoder().decode(base64PublicKey.getBytes()));
		try {
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			publicKey = keyFactory.generatePublic(keySpec);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return publicKey;
	}

	/*
	 * @Description: 加密
	 * @Author: walk_code walk_code@163.com
	 * @Param: []
	 * @return: byte[]
	 * @Date: 2019/5/31 14:53
	 */
	public static byte[] encrypt(String data, String publicKey) {
		try {
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(publicKey));

			return cipher.doFinal(data.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/*
	 * @Description: 获取私钥
	 * @Author: walk_code walk_code@163.com
	 * @Param: [base64PrivateKey]
	 * @return: java.security.PrivateKey
	 * @Date: 2019/5/31 15:00
	 */
	public static PrivateKey getPrivateKey(String base64PrivateKey) {
		PrivateKey          privateKey = null;
		PKCS8EncodedKeySpec keySpec    = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(base64PrivateKey.getBytes()));
		KeyFactory          keyFactory = null;
		try {
			keyFactory = keyFactory.getInstance("RSA");
			privateKey = keyFactory.generatePrivate(keySpec);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return privateKey;
	}

	/*
	 * @Description: RSA解密
	 * @Author: walk_code walk_code@163.com
	 * @Param: []
	 * @return: java.lang.String
	 * @Date: 2019/5/31 15:08
	 */
	public static String decrypt(byte [] data, PrivateKey privateKey) {
		try {
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte [] decryptData = cipher.doFinal(data);

			return new String(decryptData);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static String decrypt(String data, String base64PrivateKey) {
		return decrypt(Base64.getDecoder().decode(data.getBytes()), getPrivateKey(base64PrivateKey));
	}
}
