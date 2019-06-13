package com.dodo.project.base.commons.utils.encrypt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;
import java.util.Base64;

/*
 * <b>RSAKeyPairGenerator</b></br>
 *
 * <pre>
 *  RSA密钥对生成器
 * </pre>
 *
 * @Author xqyjjq walk_code@163.com
 * @Date 2019/5/31 14:20
 * @Since JDK 1.8
 */
public class RSAKeyPairGenerator {
	private PrivateKey privateKey;

	private PublicKey publicKey;

	public RSAKeyPairGenerator() {
		try {
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(1024);
			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			this.privateKey = keyPair.getPrivate();
			this.publicKey = keyPair.getPublic();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	/*
	 * @Description: 写入文件中
	 * @Author: walk_code walk_code@163.com
	 * @Param: []
	 * @return: void
	 * @Date: 2019/5/31 14:25
	 */
	public void writeToFile(String path, byte[] key) throws IOException {
		File file = new File(path);
		file.getParentFile().mkdir();

		FileOutputStream fos = new FileOutputStream(file);
		fos.write(key);
		fos.flush();
		fos.close();
	}

	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	public PublicKey getPublicKey() {
		return publicKey;
	}

	/*public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		RSAKeyPairGenerator keyPairGenerator = new RSAKeyPairGenerator();
		keyPairGenerator.writeToFile("RSA/publicKey", keyPairGenerator.getPublicKey().getEncoded());
		keyPairGenerator.writeToFile("RSA/privateKey", keyPairGenerator.getPrivateKey().getEncoded());
		System.out.println(Base64.getEncoder().encodeToString(keyPairGenerator.getPublicKey().getEncoded()));
		System.out.println(Base64.getEncoder().encodeToString(keyPairGenerator.getPrivateKey().getEncoded()));
	}*/
}
