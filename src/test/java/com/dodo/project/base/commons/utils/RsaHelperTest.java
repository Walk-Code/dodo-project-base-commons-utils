package com.dodo.project.base.commons.utils;

import com.dodo.project.base.commons.utils.encrypt.RsaHelper;
import org.junit.Assert;
import org.junit.Test;

import java.util.Base64;

/*
 * <b>RsaHelperTest</b></br>
 *
 * <pre>
 * Res加解密辅助类-单元测试
 * </pre>
 *
 * @Author xqyjjq walk_code@163.com
 * @Date 2019/5/31 15:17
 * @Since JDK 1.8
 */
public class RsaHelperTest {
	@Test
	public void encryptDecrypt() {
		String data        = "这是一串需要加密的数据:'123'~!!@@#$%^&*()_+";
		String publicKey   = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCJz6KO9VbGJBRsGot6bxXZK5rD4QqHeLuskR8lAtWJBOPBQyP0oUYg6cPZ/BZ4nZ3JNUXa6ezUeH4AI3A5FpBUe7k8p6nB/CngBH5jJjG6uFlDbw3DJCfhpPtvARnR1iszC13KzeteeC1SuHT8TLnWdxK/eom/ge7kzqgBJFc2kQIDAQAB";
		String privateKey  = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAInPoo71VsYkFGwai3pvFdkrmsPhCod4u6yRHyUC1YkE48FDI/ShRiDpw9n8Fnidnck1Rdrp7NR4fgAjcDkWkFR7uTynqcH8KeAEfmMmMbq4WUNvDcMkJ+Gk+28BGdHWKzMLXcrN6154LVK4dPxMudZ3Er96ib+B7uTOqAEkVzaRAgMBAAECgYAKwpCBsvw0ekqx6hyr0ZKWI0ZxNtf4nd+haK9S13bOvPf/dfuPtSvhk/77vSgQANZ6CFPM9OjN6h6Eaj/v5SgdoysMx+8gpRbdCiSieDBfBRIwCrtUXCc3WzVoF83TeLhlSkAzUADYvEy1KvELu+UT33uzm1kZzicXEg5/nWdmsQJBAMhT1Nml/409OxUqhE3OdcyCVlGdNnhMzoI7CwCu1tKCeCUTP5J5zVO9+bYgJx3VKgj9852jrV2CsUHkIGdLtgUCQQCwHB12RJGLNy53Es0+Z8+7ACUNQvfcJ76D0fxhYPX76URyph6O70DwIdQy5i8ji8h36IQRfoCk9AUQtslhMLgdAkEAhgZAE1VRwebDTofheES23xocMgIiXR3V05843z4aD0CmrPdRwuemjW4+ULD2OqlQtC9i+4Z0CGnVuaWsYC9xGQJAJwEjGVWYcp/3H5I/eOnfHUir7CL/6He4/1MbtamW8YM5kLbwH7InzMeBSwCmQhYsgTozPfipn18YXBpPwcHblQJAMPhdXBWJ42INkOdyycUgbFWEcf4HU40bxMi1fz5NS7kcj9qw6dg0srW/QEnr4MabMrZTyok9lmKjK2e+IM0AHg==";
		byte[] encryptCode = RsaHelper.encrypt(data, publicKey);
		String encryptStr  = Base64.getEncoder().encodeToString(encryptCode);
		System.out.println("加密后base64编码：" + encryptStr);
		String decryptStr = RsaHelper.decrypt(encryptStr, privateKey);
		System.out.println("解密后：" + decryptStr);
		Assert.assertTrue("解密失败", data.equals(decryptStr));
	}
}
