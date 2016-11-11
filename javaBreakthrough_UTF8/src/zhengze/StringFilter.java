package zhengze;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**   
* @author lzw   
* @date 2016年10月26日 上午10:22:04 
* @Description: 
* @version V1.0   
*/
public class StringFilter {
	public static final String regEx="[`\\s~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";  
	public static String filterSpecialChar(String str) {
	  Pattern   p   =   Pattern.compile(regEx);     
	  Matcher   m   =   p.matcher(str);   
	  return m.replaceAll("").trim().replaceAll("\\\\", "");// \必定以\\定义 ，
	}

}
