package digest;
import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;




public class Base64Util {
	
	public static String encryptBase64(byte[] data){
		return new BASE64Encoder().encode(data);
	}
	
	public static String decryptBase64(String data) throws IOException{
		byte[] resultBytes = new BASE64Decoder().decodeBuffer(data);
		return new String(resultBytes);
	}

}

/*
 * --"JDK"
 * --Commons Codec
 * --Bouncy Castle
 */
