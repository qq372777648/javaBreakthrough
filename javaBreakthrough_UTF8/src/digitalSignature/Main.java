package digitalSignature;
import java.util.Map;

import digest.BytesToHex;


public class Main {

	//待加密的明文
	public static final String DATA = "i will alway love you";
	
	
	public static void main(String[] args) throws Exception {
		// Test RSASignature
		Map<String, Object> keyMap = RSASignatureUtil.initKey();
		byte[] rsaPublicKey = RSASignatureUtil.getPublicKey(keyMap);
		byte[] rsaPrivateKey = RSASignatureUtil.getPrivateKey(keyMap);
		System.out.println("RSASignature PublicKey : " + BytesToHex.fromBytesToHex(rsaPublicKey));
		System.out.println("RSASignature PrivateKey : " + BytesToHex.fromBytesToHex(rsaPrivateKey));
		
		// Sign
		byte[] sign = RSASignatureUtil.sign(DATA.getBytes(), rsaPrivateKey);
		System.out.println("RSA Sign : " + BytesToHex.fromBytesToHex(sign));
		
		// Verify
		boolean isValid = RSASignatureUtil.verify((DATA).getBytes(), rsaPublicKey, sign);
		System.out.println("RSA Verify : " + isValid);
		
		
		
		
		
		
		// Test DSASignature
		// 初始化密钥对
		Map<String, Object> keyMap2 = DSASignatureUtil.initKey();
		byte[] dsaPublicKey = DSASignatureUtil.getPublicKey(keyMap2);
		byte[] dsaPrivateKey = DSASignatureUtil.getPrivateKey(keyMap2);
		System.out.println("DSASignature PublicKey : " + BytesToHex.fromBytesToHex(dsaPublicKey));
		System.out.println("DSASignature PrivateKey : " + BytesToHex.fromBytesToHex(dsaPrivateKey));
		
		// Sign
		byte[] sign2 = DSASignatureUtil.sign(DATA.getBytes(), dsaPrivateKey);
		System.out.println("DSA Sign : " + BytesToHex.fromBytesToHex(sign2));
		
		// Verify
		boolean isValid2 = DSASignatureUtil.verify((DATA).getBytes(), dsaPublicKey, sign2);
		System.out.println("DSA Verify : " + isValid2);
		
	}

}
