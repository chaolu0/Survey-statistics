package parsexml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import bean.Question;

public class ShxyParserHandler extends DefaultHandler {

	private List<Question> questions = new ArrayList<>();
	private Question question = null;
	private String value = null;

	public List<Question> getQuestions() {
		return questions;
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		System.out.println("start parse...");
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("stop parse...");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		if (qName.equals("question")) {
			question = new Question();
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		if (qName.equals("question")) {
			Integer[] arr = new Integer[question.getOptionCount()];
			Arrays.fill(arr, 0);
			question.setArr(arr);
			questions.add(question);
		} else if (qName.equals("id")) {
			question.setId(Integer.valueOf(value));
		} else if (qName.equals("opitonCount")) {
			question.setOptionCount(Integer.valueOf(value));
		} else if (qName.equals("isMutil")) {
			question.setIsMutil(Boolean.valueOf(value));
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		value = new String(ch, start, length);
		if (!value.trim().equals("")) {
//			System.out.println("获取到的值是" + value);
		}
	}

}
