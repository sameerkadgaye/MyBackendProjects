package finalAndStaticTickyQuestions.finalConcepts;

import java.util.HashMap;
import java.util.Map;

public class AllImmutableClassIsFinalInJava {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("1", "first");
		map.put("2", "second");
		Student s = new Student("ABC", 101, map);
		System.out.println(s.getName());
		System.out.println(s.getRegNo());
		System.out.println(s.getMetadata());

		// Uncommenting below line causes error
		// s.regNo = 102;

		map.put("3", "third");
		System.out.println(s.getMetadata()); // Remains unchanged due to deep copy in constructor

		s.getMetadata().put("4", "fourth");
		System.out.println(s.getMetadata()); // Remains unchanged due to deep copy in getter
	}
}
