package bean;

import java.util.Comparator;

public class QuestionComparator implements Comparator<Question>{

	@Override
	public int compare(Question o1, Question o2) {
		if (o1.getId()<o2.getId()) {
			return -1;
		}else if(o1.getId() == o2.getId()){
			return 0;
		}else {
			return 1;
		}
	}

}
