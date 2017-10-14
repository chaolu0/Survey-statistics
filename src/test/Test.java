package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import use.Statistics;

public class Test {

	public static void main(String[] args) throws IOException {
		Statistics statistics = new Statistics();
		ArrayList<Integer> list = new ArrayList<>();
		File file = new File("e:\\temp\\in.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		while((line = reader.readLine())!=null){
			if (line == ""||line.length()==0) {
				continue;
			}
			int x = Integer.valueOf(line);
			list.add(x);
		}
		Integer[] sourse = new Integer[list.size()];
		list.toArray(sourse);
		statistics.begin(sourse);
	}

}
