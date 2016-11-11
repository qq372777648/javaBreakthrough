package zhengze;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**   
* @author lzw   
* @date 2016年10月26日 上午10:18:20 
* @Description: 
* @version V1.0   
*/
public class TestPattern {
	public static void main(String[] args) {
            // 只允许字母和数字       
            // String   regEx  =  "[^a-zA-Z0-9]";                     
               // 清除掉所有特殊字符  
      String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";  
//      regEx   =   "[^a-zA-Z0-9]";
      Pattern   p   =   Pattern.compile(regEx);     
      Matcher   m   =   p.matcher("\\牛");   
      System.out.println(m.replaceAll("x").trim());
      
      System.out.println(StringFilter.filterSpecialChar(regEx+"x x x	x"));
      
      System.out.println("//2\\2");
	}

}
