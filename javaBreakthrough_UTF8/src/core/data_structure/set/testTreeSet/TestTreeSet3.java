package core.data_structure.set.testTreeSet;

import java.util.*;

public class TestTreeSet3 {
	public static void main(String[] args) {
		Comparator c=new Comparator() {   //匿名接口回调

			
			@Override
			public int compare(Object o1, Object o2) {
				Hero h1=(Hero)o1;
				Hero h2=(Hero)o2;
				return h1.power-h2.power ==0 ? h1.age-h2.age :-(h1.power-h2.power);
			}
		};		
		
		Set ts=new TreeSet( c);
//		ts.add(new Hero("令狐冲", 20, 9000));
//		ts.add(new Hero("少林武僧", 33, 900));
//		ts.add(new Hero("张无忌", 25, 9001));
		
		Random ran=new Random();
		
		long start=System.currentTimeMillis();
		System.out.println(start);
		for (int i = 0; i < 10; i++) {
			ts.add(new Hero("张无忌"+i, 25, ran.nextInt(3)));
		}
		System.out.println(System.currentTimeMillis()-start);
		
		
		for(Iterator it=ts.iterator();it.hasNext();){
			System.out.println(it.next());
		}
		
	}
}

class Hero {
	String name;
	int age;
	int power;
	public Hero(String name, int age, int power) {
		super();
		this.name = name;
		this.age = age;
		this.power = power;
	}
	@Override
	public String toString() {
		return "Hero [age=" + age + ", name=" + name + ", power=" + power + "]";
	}
	
}
