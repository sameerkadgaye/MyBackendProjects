/**
 * 
 */
package collectionQuestions.map.hashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SAMEER KADGAYE
 *
 */
public class PrintHashMap {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		
		HashMap<String, String> names = new HashMap();
		names.put("First", "sameer");
		names.put("Second", "sanket");
		names.put("Third", "Saket");
		
		System.out.println("For Each Loop ====>>>> \n");
		names.forEach((key, value) -> {
			System.out.println(key +" : "+value);
		});
		
		System.out.println("\nEnhance For Loop ====>>>> \n");
		for(Map.Entry<String, String> entry : names.entrySet()) {
			System.out.println(entry.getKey() +" : "+entry.getValue());
		}
	}

}
