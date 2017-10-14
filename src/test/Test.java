package test;

import java.io.*;
import java.util.ArrayList;

import use.Statistics;

public class Test {

	public static void main(String[] args) throws IOException {
		Statistics statistics = new Statistics();
		ArrayList<Integer> list = new ArrayList<>();
		File file = new File("example\\in.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		while((line = reader.readLine())!=null){
			if (line == ""||line.length()==0) {
				continue;
			}
			int x = 0;
			String[] split = line.split(" ");
			//System.out.println(split.length);
			for(int i =0;i<split.length;i++){
				x = Integer.valueOf(split[i]);
				list.add(x);
			}

		}
		Integer[] sourse = new Integer[list.size()];
		list.toArray(sourse);
		statistics.begin(sourse);
	}

}
