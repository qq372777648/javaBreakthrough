package temp_test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**   
* @author lzw   
* @date 2016年10月24日 下午4:31:47 
* @Description: 
* @version V1.0   
*/
public class test1 {
	public static void main(String[] args) {
		Map<Integer,Integer> map=new HashMap<>();
		map.put(1, 2);
		int x=map.get(1)+2;
		System.out.println(map.get(1));//2
		
		
		DateFormat df=
			df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(df.format(new Date()));
		
	}

}
