package DES_AES;
import digest.BytesToHex;


public class Main {

	//待加密的明文
	public static final String DATA = "jikexueyuan";
	
	
	public static void main(String[] args) throws Exception {

		/* Test DES */
		byte[] desKey = DESUtil.initKey();
		System.out.println("DES KEY : " + BytesToHex.fromBytesToHex(desKey));
		byte[] desResult = DESUtil.encrypt(DATA.getBytes(), desKey);
		System.out.println(DATA + ">>>DES 加密>>>" + BytesToHex.fromBytesToHex(desResult));
		
		byte[] desPlain = DESUtil.decrypt(desResult, desKey);
		System.out.println(DATA + ">>>DES 解密>>>" + new String(desPlain));
		
		
		/* Test 3DES */
		byte[] tridesKey = TripleDESUtil.initKey();
		System.out.println("3DES KEY : " + BytesToHex.fromBytesToHex(tridesKey));
		byte[] tridesResult = TripleDESUtil.encrypt(DATA.getBytes(), tridesKey);
		System.out.println(DATA + ">>>3DES 加密>>>" + BytesToHex.fromBytesToHex(tridesResult));
		
		byte[] tridesPlain = TripleDESUtil.decrypt(tridesResult, tridesKey);
		System.out.println(DATA + ">>>3DES 解密>>>" + new String(tridesPlain));
		
		
		/* Test AES */
		byte[] aesKey = AESUtil.initKey();
		System.out.println("AES KEY : " + BytesToHex.fromBytesToHex(aesKey));
		byte[] aesResult = AESUtil.encrypt(DATA.getBytes(), aesKey);
		System.out.println(DATA + ">>>AES 加密>>>" + BytesToHex.fromBytesToHex(aesResult));
		
		byte[] aesPlain = AESUtil.decrypt(aesResult, aesKey);
		System.out.println(DATA + ">>>AES 解密>>>" + new String(aesPlain));
		
		
		
		
	}

}
