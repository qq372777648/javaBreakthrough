package xml_dom_dom4j;

import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;



public class TestDom4j {

	public static void main(String[] args) {
		String xmlString = "<root><people>ACELY</people></root>";
		
		try {
			
			
			
			Document document = DocumentHelper.parseText(xmlString);
			
//			System.out.println(document.asXML());
			
				FileWriter out = new FileWriter( "src/xml_dom_dom4j/dom4jcreated.xml" );
				  document.write( out );
				  out.close();
				  
				  
				  OutputFormat format = OutputFormat.createPrettyPrint();
				  XMLWriter  writer = new XMLWriter( System.out, format );
			        writer.write( document );
			
			
			
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}


