package DH_RSA;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

import digest.BytesToHex;


public class Main {

	//待加密的明文
	public static final String DATA = "i will alway love you";
	
	
	public static void main(String[] args) throws Exception {
	
		/* Test DH */
		// 甲方公钥
		byte[] publicKey1;
		// 甲方私钥
		byte[] privateKey1;
		// 甲方本地密钥
		byte[] secretKey1;
		// 乙方公钥
		byte[] publicKey2;
		// 乙方私钥
		byte[] privateKey2;
		// 乙方本地密钥
		byte[] secretKey2;

		// 初始化密钥 并生成甲方密钥对
		Map<String, Object> keyMap1 = DHUtil.initKey();
		publicKey1 = DHUtil.getPublicKey(keyMap1);
		privateKey1 = DHUtil.getPrivateKey(keyMap1);
		System.out.println("DH 甲方公钥 : " + BytesToHex.fromBytesToHex(publicKey1));
		System.out.println("DH 甲方私钥 : " + BytesToHex.fromBytesToHex(privateKey1));
		
		// 乙方根据甲方公钥产生乙方密钥对
		Map<String, Object> keyMap2 = DHUtil.initKey(publicKey1);
		publicKey2 = DHUtil.getPublicKey(keyMap2);
		privateKey2 = DHUtil.getPrivateKey(keyMap2);
		System.out.println("DH 乙方公钥 : " + BytesToHex.fromBytesToHex(publicKey2));
		System.out.println("DH 乙方私钥 : " + BytesToHex.fromBytesToHex(privateKey2));
		
		//对于甲方， 根据其私钥和乙方发过来的公钥， 生成其本地密钥secretKey1
		secretKey1 = DHUtil.getSecretKey(publicKey2, privateKey1);
		System.out.println("DH 甲方 本地密钥 : " + BytesToHex.fromBytesToHex(secretKey1));
		
		//对于乙方， 根据其私钥和甲方发过来的公钥， 生成其本地密钥secretKey2
		secretKey2 = DHUtil.getSecretKey(publicKey1, privateKey2);
		System.out.println("DH 乙方 本地密钥 : " + BytesToHex.fromBytesToHex(secretKey2));
		
		
		
		
		
		/* Test RSA */
		Map<String, Object> keyMap = RSAUtil.initKey();
		RSAPublicKey rsaPublicKey = RSAUtil.getPublicKey(keyMap);
		RSAPrivateKey rsaPrivateKey = RSAUtil.getPrivateKey(keyMap);
		System.out.println("RSA PublicKey : " + rsaPublicKey);
		System.out.println("RSA PrivateKey : " + rsaPrivateKey);
		
		byte[] rsaResult = RSAUtil.encrypt(DATA.getBytes(), rsaPublicKey);
		System.out.println(DATA + ">>>RSA 加密>>>" + BytesToHex.fromBytesToHex(rsaResult));
		
		byte[] plainResult = RSAUtil.decrypt(rsaResult, rsaPrivateKey);
		System.out.println(DATA + ">>>RSA 解密>>>" + new String(plainResult));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
