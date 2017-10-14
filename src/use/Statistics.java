package use;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import bean.Configuration;
import bean.Question;
import bean.QuestionComparator;
import parsexml.SettingParserHandler;
import parsexml.ShxyParserHandler;

public class Statistics {

	private List<Question> questions = null;
	private String inPath;
	private String outPath;

	private int qCount = 0;


	public void begin(Integer[] source) throws IOException {
		System.out.println("begin task");
		parserSetting();
		questions = parser();
		qCount = questions.size();
		count(source);
		writeFile();
		System.out.println("task successed");
	}
	//路径配置
	private void parserSetting(){
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			SettingParserHandler handler = new SettingParserHandler();
			parser.parse("config.xml", handler);
			Configuration configuration = handler.getConfig();
			inPath = configuration.getXmlFilePath();
			outPath = configuration.getOutFIlePath();
		} catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//写文件
	private void writeFile() throws IOException {
		System.out.println("write file...");
		PrintWriter writer = new PrintWriter(new FileWriter(new File(outPath)));
		for (int i = 0; i < qCount; i++) {
			writer.print((i+1) + " : ");
			Question question = questions.get(i);
			Integer[] arr = question.getArr();
			for(int j=0;j<question.getOptionCount();j++){
				if (j==0) {
					writer.print(arr[j]);
				}else{
					writer.print("," + arr[j]);
				}
			}
			writer.println();
		}
		writer.flush();
		writer.close();
		System.out.println("write file successed");
	}
	//统计
	private void count(Integer[] source) {
		System.out.println("source.length = " + source.length);
		Integer index = 0;//所有输入索引
		int current = 0;//当前问题索引
		while (index != source.length) {
            System.out.println("current = " + current);
            System.out.println("index = " + index);
            System.out.println("sourse = " + source[index]);

            System.out.println("temp = " + (source[index] -1));

			// has a answer -> do
			if (source[index] != 0) {
				// sample
				if (!questions.get(current).getIsMutil()) {
					sample(source, index, current);
                    index++;
				} else {
                    index = mutil(source, index, current);
				}
				current++;
			}
			// no answer -> pass
			else {
                current++;
                index++;
			}
			if (current == qCount) {
                System.out.println("下一张问卷");
                current = 0;
			}


		}
	}
	//多选题处理
	private int mutil(Integer[] source, Integer index, int current) {
		for (int i = index;; i++) {
			if (source[i] == 0) {
				index++;
				return index;
			} else {
				questions.get(current).getArr()[source[index] - 1]++;
				index++;
			}
		}
	}
	//单选题处理
	private void sample(Integer[] source, int index, int current) {
        int temp = source[index] -1;
        questions.get(current).getArr()[temp]++;
	}
	//问卷解析
	private List<Question> parser() {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		List<Question> q = null;
		try {
			SAXParser parser = factory.newSAXParser();
			ShxyParserHandler handler = new ShxyParserHandler();
			parser.parse(inPath, handler);
			q = handler.getQuestions();
			Collections.sort(q, new QuestionComparator());
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return q;
	}
}
