package base64;
import java.io.IOException;


public class Main {

	//待加密的明文
	public static final String DATA = "jikexueyuan";
	
	
	public static void main(String[] args) throws Exception {
		/* Test Base64 */
		String base64Result = Base64Util.encryptBase64(DATA.getBytes());
		System.out.println(DATA + "  >>>Base64编码>>>" + base64Result);
		String base64String = Base64Util.decryptBase64(base64Result);
		System.out.println(base64Result + "  >>>Base64解码>>>" + base64String);
	}

}
