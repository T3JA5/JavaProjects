package com.parser;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder buldier = factory.newDocumentBuilder();
			Document doc = buldier.parse("Sample.xml");
			NodeList bookList = doc.getElementsByTagName("book");
			for(int i=0;i<bookList.getLength();i++) {
				
				Node b = bookList.item(i);
				if(b.getNodeType() == Node.ELEMENT_NODE) {
					Element book = (Element) b;
					String id = book.getAttribute("id");
					NodeList list = book.getChildNodes();
					for(int j=0;j<list.getLength();j++) {
						Node l = list.item(j);
						if(l.getNodeType() == Node.ELEMENT_NODE) {
							Element e = (Element) l;
							System.out.println("Book "+ id + ":" +e.getTagName()+" = "+e.getTextContent());
						}
					}
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception occured");
		}
		
	}

}
