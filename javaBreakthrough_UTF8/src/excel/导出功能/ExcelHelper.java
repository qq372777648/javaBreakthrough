package excel.导出功能;

import java.io.File;
import java.io.FileOutputStream;

import jvc.util.LogUtils;
import jvc.util.report.ExcelTemplatePoi;
import jvc.util.report.ExcelTemplatePoi2;
import jvc.web.action.ActionContent;

public class ExcelHelper {

	public static ExcelTemplatePoi getExcel(String inXls , String outXls){
		try {
			 ExcelTemplatePoi el = new ExcelTemplatePoi();
		     el.setInputFile(inXls);
		     el.setOutputSream(new FileOutputStream(new File(outXls)));
		     return el;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		 
	}
	
	public static void createAndCloseExcel(ExcelTemplatePoi el ,ActionContent   input){
		try {
			el.setInput(input);
	        el.write();
	        el.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
