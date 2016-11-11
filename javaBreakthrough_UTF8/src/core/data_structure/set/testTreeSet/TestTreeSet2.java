package core.data_structure.set.testTreeSet;

import java.util.*;

public class TestTreeSet2 {
	public static void main(String[] args) {
		//Set ts=new TreeSet();
		TreeSet ts=new TreeSet();
		//先比较年龄按升序输出，若年龄相同，分数大的在前面
		
		ts.add(new Stu("乔峰", 20, 92));
		ts.add(new Stu("令狐冲", 18, 59));
		ts.add(new Stu("杨过", 20, 80));
		ts.add(new Stu("花无缺", 20, 78));
		ts.add(new Stu("小鱼儿", 21, 82));
		
		
		for(Iterator it=ts.iterator();it.hasNext();){
			System.out.println(it.next());
			
		}
	}
}

class Stu implements Comparable{
	String name;
	int age;
	double score;
	public Stu(String name, int age, double score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
	}
	
	@Override
	public int compareTo(Object o) {
		Stu s=(Stu)o;
		//关键在返回值，	0	负数	  正数
		int flag= (int)(this.age-s.age);
		if (flag>0) 
			return 1;
		if (flag<0)
			return -1;
		if(flag==0){
			int flag2= -(int)(this.score-s.score);
			if (flag2>0) 
				return 1;
			if (flag2<0)
				return -1;
		}
			
		return 0;
	}

	@Override
	public String toString() {
		return "Stu [age=" + age + ", name=" + name + ", score=" + score + "]";
	}
}
