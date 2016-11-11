package core.data_structure.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

/**   
* @author lzw   
* @date 2016年10月25日 上午10:28:54 
* @Description: 
* @version V1.0   
*/
public class MapUtil {
	/** 
     * 使用 Map按value进行排序 
     * @param map 
     * @return 
     */  
    public static Map<String, Integer> sortMapByValue(Map<String, Integer> map) {  
        if (map == null || map.isEmpty()) {  
            return null;  
        }  
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();  
        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());  
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {  
            public int compare(Entry<String, Integer> me1, Entry<String, Integer> me2) {  
                return -me1.getValue().compareTo(me2.getValue());  
            }  
        }); 
        Iterator<Map.Entry<String, Integer>> iter = entryList.iterator();  
        Map.Entry<String, Integer> tmpEntry = null;  
        while (iter.hasNext()) {  
            tmpEntry = iter.next();  
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());  
        }  
        return sortedMap;  
    }  
    
    
    public static void main(String ...a){
    	Map<String, Integer> m=new LinkedHashMap<String, Integer>();
    	m.put("a", 3);
    	m.put("b", 5);
    	m.put("c", 2);
    	m.put("d", 1);
    	m.put("e", 9);
    	m.put("f", 8);
    	m.put("g", 1);
    	
//    	Random r=new Random();
//    	for (int i = 0; i < 2000000; i++) {
//    		m.put("a"+i, r.nextInt(10000));
//		}
    	
    	Long start=System.currentTimeMillis();
    	for (String key:sortMapByValue(m).keySet()) {
			System.out.println(key+"--"+m.get(key));
		}
    	System.out.println(System.currentTimeMillis()-start);
    }
    
    
  

}
