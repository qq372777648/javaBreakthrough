package excel.导出功能;

import jvc.web.action.ActionContent;

/**
 * @auther Lzw   e-mail:372777648@qq.com
 * @date 2016年7月13日
 * <p>Description: <／p>
 */

public class tt {
	
	tt me=null;
	public void setInput(a input){
    	if(me==null)return;
    	System.out.println("sdfsdf");
    	me.setInput(input);
    }
	
	
	public static void main(String[] args) {
		tt t=new tt();
		t.me=t;
		t.setInput(new a());
	}

}

class a{}