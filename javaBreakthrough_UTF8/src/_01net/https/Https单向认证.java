package _01net.https;

import java.util.HashMap;

/**   
* @author lzw   
* @Description: 
* @version V1.0   
*/
public class Https单向认证 {
	public static void main(String[] args) {
		System.out.println(HttpUtil.doPostSSL("https://liangzhenwei:8444/cpsystem/share/login/login.action",new HashMap<>()));
	}

}
