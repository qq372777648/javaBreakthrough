package excel.导出功能;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jvc.module.JList;
import jvc.module.JObject;
import jvc.util.report.ExcelTemplatePoi;
import jvc.web.action.ActionContent;
import jvc.web.module.Field;
import jvc.web.module.JVCResult;

public class ExcelFinanceFee {

	
	public void fillPDF(String localPath, String tempSavePath) {

		//localPath="C:/Users/tank/Desktop/tomcat-7.0.22/wtpwebapps5/yongan_proto/pfdTemp/9223370593963898762/new.xlsx";
		localPath="f:/1//new0.xlsx";
		
		
		
		try{
	        ExcelTemplatePoi el = ExcelHelper.getExcel(localPath, tempSavePath);
	        ActionContent input=new ActionContent();

	        
	        Map<String, String> tempMap = new HashMap<String, String>();
	        tempMap.put("a", "已收（√） 未收（  ）");
	        tempMap.put("b", "已收（  ） 未收（√）");
	        tempMap.put("c", "已收（√） 未收（  ）");
	        tempMap.put("d", "已收（  ） 未收（√）");
	        tempMap.put("e", "已收（√） 未收（  ）");
	        Map<String, String> tempMap2 = new HashMap<String, String>();
	        tempMap2.put("a", "2已收（√） 未收（  ）");
	        tempMap2.put("b", "2已收（  ） 未收（√）");
	        tempMap2.put("c", "2已收（√） 未收（  ）");
	        tempMap2.put("d", "2已收（  ） 未收（√）");
	        tempMap2.put("e", "2已收（√） 未收（  ）");
	        List list=new ArrayList<>();
	        list.add(tempMap);
	        list.add(tempMap2);
	        		
	        
	        JList jlist = new JList();
	        //JVCResult rs=new JVCResult();
		    for (int i = 0; i < 10; i++) {
		      JObject obj = new JObject();
		      obj.put("a", i +"");
		      obj.put("b", Integer.valueOf(i));
		      obj.put("c", i+"");
		      obj.put("d", Integer.valueOf(i));
		      obj.put("e", i+"");
		      
		      
		    
//		      Map map=new HashMap<>();
//		      map.put("a", 1+"");
//		      map.put("b", 2+"");
//		      map.put("c", 3+"");
//		      map.put("d", 4+"");
//		      map.put("e", 5+"");
//		      rs.AddColumn(new Field(1,"a","a"));
//		      rs.AddResult(map);
		    
		      
//		      JList jl=new JList();
//		      jl.addJObject(obj);
//		      JObject obj2 = new JObject();
//		      obj2.put("detail", jl); 
//		      jlist.addJObject(obj2);
		      
		      jlist.addJObject(obj);
		    }
		    
		    //JList jl=new JList(rs);
		    
		    
//		    JList group=new JList();
//  	        for(int i=0;i<5;i++){
//  	        	JObject obj=new JObject();
//  	        	obj.put("no", "12"+i);
//  	            JList rs=new JList();
//  	            for(int j=0;j<5;j++){
//  	            	JObject obj2=new JObject();
//  	            	obj2.put("name", "1.00001");
//  		        	obj2.put("spec", "涓枃:"+i);
//  	            	rs.addJObject(obj2);
//  	            }
//  	            obj.put("detail",rs);
//  	        	
//  	        	group.addJObject(obj);
//  	        }
//  	        input.setParam("group", group);
		    
		    
      	  JList group=new JList();
	        for(int i=0;i<5;i++){
	        	JObject obj=new JObject();
	        	
	        	obj.put("no", "12"+i);


	            JList rs=new JList();
	            for(int j=0;j<5;j++){
	            	JObject obj2=new JObject();
	            	obj2.put("name", i+"");
		        	obj2.put("spec", "涓枃:"+i);
	            	rs.addJObject(obj2);
	            }
	            obj.put("detail",rs);
	        	
	        	group.addJObject(obj);
	        }
	        input.setParam("group", group);
		    
	       
	        input.setParam("total", 121);
	        input.setParam("totalz", 14);
	        input.setParam("totalzz", "sdfsdf");
	        input.setParam("detail", jlist);
	        el.replaceSheet(1);
	        ExcelHelper.createAndCloseExcel(el, input);
	           } catch (Exception ex) {
	            ex.printStackTrace();
	     } 
		
	}
	
	public static void main(String[] args) {
	    JList jlist = new JList();
	    for (int i = 0; i < 10; i++) {
	      JObject obj = new JObject();
	      obj.put("detail.a", i);
	      obj.put("detail.b", Integer.valueOf(i));
	      obj.put("detail.c", i);
	      obj.put("detail.d", Integer.valueOf(i));
	      obj.put("detail.e", i);
	      jlist.addJObject(obj);
	    }

//	    jlist.setPageSize(2);
//	    System.out.println("pagecount:" + jlist.getPageCount());
//	    for (int i = 1; i < jlist.getPageCount() + 1; i++) {
//	      JList jPageList = jlist.getPage(i);
//	      System.out.println("jPageList" + i + ".size=" + jPageList.size());
//	      while (jPageList.next())
//	        System.out.println("page:" + i + " value:" + jPageList.getInt("index"));
//	    }
	    
	    
		
		
		new ExcelFinanceFee().fillPDF("", "f:/1/test3.xlsx");
	}

	
}
