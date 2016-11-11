package core.data_structure.list.testLinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**   
* @author lzw   
* @date 2016年10月24日 下午5:32:17 
* @Description: 
* @version V1.0   
*/
public class TestLinkList {
	public static void main(String[] args) {
		int arr_length=979999;
		Integer arr[]=new Integer[arr_length];
		
		Random ran=new Random();
		
		long start=System.currentTimeMillis();
		System.out.println(start);
		for (int i = 0; i < arr_length; i++) {
			arr[i]=ran.nextInt(1000);
		}
		
		
		
		List list = new ArrayList<Integer>();//比 linklist稍微快
	    Collections.addAll(list, arr);
	    Collections.sort(list, new Comparator<Integer>(){

			@Override
		      public int compare(Integer o1, Integer o2) {
//		        if (o1.intValue()  >= o2.intValue()) {
//		          return -1;
//		        }
//		        return 1;
				return o1.compareTo(o2);
		      }

	    });
	    System.out.println(System.currentTimeMillis()-start);
	    System.out.println(list.size());
//	    System.out.println(list);
	}

}
