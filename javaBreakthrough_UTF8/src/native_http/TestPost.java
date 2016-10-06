package native_http;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 未通过！！！！！！！！！！！！！
 * @auther Lzw   e-mail:372777648@qq.com
 * @date 2016年10月5日
 * <p>Description: <／p>
 */

public class TestPost {
	public static void main(String[] args) {
		try {
			URL url =new URL("http://www.baidu.com");
			
			
			
			HttpURLConnection connection= (HttpURLConnection)url.openConnection();
			connection.setRequestProperty("encoding", "utf-8");
			connection.setDoInput(true);// can read response
			connection.setDoOutput(true);//can set params
			connection.setRequestMethod("POST");
			
			OutputStream os=connection.getOutputStream();
			OutputStreamWriter osw=new OutputStreamWriter(os);
			BufferedWriter bw= new BufferedWriter(osw);
			bw.write("a=1&b=2");
			bw.flush();
			
			
			
			
			
			InputStream is= connection.getInputStream();  //!!!!!!!!!!!!!!!
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			
			String line=null;
			StringBuffer sb=new StringBuffer();
			while((line=br.readLine())!=null){
				sb.append(line);
			}
			
			
			
			bw.close();
			osw.close();
			os.close();
			
			br.close();
			isr.close();
			is.close();
			
			System.out.println(sb.toString());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
