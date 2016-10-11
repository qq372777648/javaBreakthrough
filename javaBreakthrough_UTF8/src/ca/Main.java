package ca;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * 用途：发送方在ca下载 我服务器的公钥 ，用我的公钥加密信息发给我，我用我的私钥解密
* @author lzw   
* @date 2016年10月11日 下午1:24:49 
* @Description: 
* @version V1.0
 */
public class Main {
	// 待加密的明文
	public static final String DATA = "你好世界";
	// KeyStore 密码
	public static final String password = "123456";
	// 存储在 KeyStore 里的证书别名
	public static final String alias = "www.lzw.com";
	// Certificate 路径
	public static final String certificatePath = "mycertificate.cer";
	// KeyStore 路径
	public static final String keyStorePath = "lzwKeyPairs.keystore";

	public static void main(String[] args) throws Exception {
		// 公钥加密--私钥解密
		
		// 从哪里得到公钥？证书   (发送信息方)
		PublicKey publicKey = CertificateUtil.getPublicKeyFromCertificate(certificatePath);
		// 使用公钥进行加密
		byte[] cipher = CertificateUtil.encrypt(DATA.getBytes(), publicKey);
		System.out.println("密文 " + BytesToString.fromBytesToString(cipher));
		
		
		// 使用私钥进行解密
		// 从哪里得到私钥？  自己生成公私钥，公钥放ca,发送方从ca下载 带公钥的证书  （接受方）
		PrivateKey privateKey = CertificateUtil.getPrivateKeyFromKeyStore(keyStorePath, alias, password);
		byte[] plain = CertificateUtil.decrypt(cipher, privateKey);
		System.out.println("明文 " + new String(plain));
	}
	
}
