package parsexml;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import bean.Configuration;
/**
 * 
 * @author shxy
 * 配置注入
 */
public class SettingParserHandler extends DefaultHandler {

	private String value;
	private Configuration config = new Configuration();
	
	public Configuration getConfig(){
		return config;
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		System.out.println("setting parsing ...");
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("setting parse finish");
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		if (qName.equals("xmlpath")) {
			config.setXmlFilePath(value);
		} else if (qName.equals("outpath")) {
			config.setOutFIlePath(value);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		value = new String(ch, start, length);
	}
}
