package core.data_structure.set.testTreeSet;

import java.util.*;

public class TestTreeSet {
	public static void main(String[] args) {
//		Set ts=new TreeSet();
//		SortedSet ts=new TreeSet();
		TreeSet ts=new TreeSet();
		ts.add(20);
		ts.add(10);
		ts.add(40);
		ts.add(40);
		ts.add(8);
		for(Iterator it=ts.iterator();it.hasNext();){
			System.out.println(it.next());
			
		}
		System.out.println("==================");
		TreeSet ts2=new TreeSet();
		ts2.add("aea");
		ts2.add("ddd");
		ts2.add("abb");
		ts2.add("ccc");
		for(Iterator it=ts2.iterator();it.hasNext();){
			System.out.println(it.next());
			
		}
	}
}
