package digest;
import java.io.IOException;


public class Main {

	//待加密的明文
	public static final String DATA = "jikexueyuan";
	public static final String PATH = "mysql-installer-web-community-5.6.22.0.msi";
	
	
	public static void main(String[] args) throws Exception {
		/* Test Base64 */
		String base64Result = Base64Util.encryptBase64(DATA.getBytes());
		System.out.println(DATA + "  >>>Base64编码>>>" + base64Result);
		String base64String = Base64Util.decryptBase64(base64Result);
		System.out.println(base64Result + "  >>>Base64解码>>>" + base64String);
		
		
		/* Test MD5 */
		String md5Result = MessageDigestUtil.encryptMD5(DATA.getBytes());
		System.out.println(DATA + ">>>MD5>>>" + md5Result);
		
		/* Test MD5 of File */
		String fileMD5Result = MessageDigestUtil.getMD5OfFile(PATH);
		System.out.println("File MD5 : " + fileMD5Result);
		
		/* Test SHA */
		String shaResult = MessageDigestUtil.encryptSHA(DATA.getBytes());
		System.out.println(DATA + ">>>SHA>>>" + shaResult);
		
		/* Test HMAC */
		byte[] hmacKey = MessageDigestUtil.initHmacKey();
		System.out.println("HMAC KEY: " + BytesToHex.fromBytesToHex(hmacKey));
		String hmacResult = MessageDigestUtil.encryptHmac(DATA.getBytes(), hmacKey);
		System.out.println(DATA + ">>>HMAC>>>" + hmacResult);
		
		
		
		
		
		
	}

}
