package ChangeCharsetUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * 
 * @auther Lzw
 * @date 2016年10月3日
 * <p>Description: <／p>
 */
public class ChangeCharsetUtil {
	public static void main(String[] args) {
		System.out.println(ChangeCharsetUtil.class.getResource(""));//类路径
		
		//111111输入文件夹
//		File file = new File("src/ChangeCharsetUtil");
		File file = new File("src/utf8pkg");
//		System.out.println(file.getAbsolutePath());
		
		
		//222222222过滤文件
		File files[]=file.listFiles(new FilenameFilter() {
			private String reg=".*\\.java";  //判断字符串中是否以  .java  结尾
			@Override
			public boolean accept(File dir, String name) {
				if(name.matches(reg))
					return true;//有效
				return false;
			}
		});
		
		//键入文字 -- gbk编码--- 字节    ---文件读取（gbk编码解释字节）--正确内容
		
		//gbk编码文件--gbk编码集读取 ---到底原始字节---utf8编码写入文件--utf8编码读取文件--正确内容
		for (File f:files) {
			//333333333转换编码
			//测试
//			changeCharSet(f, "GBK", "UTF-8",true );
			//正式
			changeCharSet(f, "GBK", "UTF-8",false );
			
//			changeCharSet(f, "UTF-8", "GBK");
		}
		
	}
	
	
	
	
	
	public static void changeCharSet(File f,String originCharSet,String newCharSet,boolean isTest){
//		String path=f.getAbsolutePath();//全路径
		String path=f.getParent();
		System.out.println(path);
		String fileName=f.getName();
		System.out.println(fileName);
		try {
			
			File tempFile=new File(path+"/temp_"+fileName);
			
			FileInputStream fis = new FileInputStream(f);
			FileOutputStream fos = new FileOutputStream(tempFile);
			InputStreamReader isr = new InputStreamReader(fis, originCharSet);
			OutputStreamWriter osw = new OutputStreamWriter(fos, newCharSet);
			
			BufferedReader br = new BufferedReader(isr);
			//BufferedWriter bw = new BufferedWriter(osw);
			PrintWriter pw = new PrintWriter(osw,true);
			
			String input;
			while ((input = br.readLine()) != null) {
				//bw.write(input);
				pw.println(input);
			}
			br.close();
			//bw.flush();bw.close();
			pw.close();
			isr.close();
			fis.close();
			osw.close();
			fos.close();
			
			if(!isTest){
				//删除原文件
				f.delete();
				//重命名新文件
				tempFile.renameTo(f);
				//删除临时的新文件
				tempFile.delete();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
