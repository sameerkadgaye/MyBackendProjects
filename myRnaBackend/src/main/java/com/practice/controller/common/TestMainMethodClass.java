/**
 * 
 */
package com.practice.controller.common;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.practice.model.common.TestSequenceClass;

/**
 * @author sameer.kadgaye
 *
 */
public class TestMainMethodClass {

	public static List<TestSequenceClass> getSequenece(List<TestSequenceClass> testSequenceClassList) {
		Collections.sort(testSequenceClassList, new Comparator<TestSequenceClass>() {
			@Override
			public int compare(TestSequenceClass o1, TestSequenceClass o2) {
				return o1.getSeqId() - o2.getSeqId();
			}
		});
		System.out.println("Sequence in get Sequence ===>> " + testSequenceClassList);
		return testSequenceClassList;
	}

//	public static void main(String[] args) {
//		List<TestSequenceClass> sequeneces = getSequenece(Arrays.asList(new TestSequenceClass(1, "Company Master", 3),
//				new TestSequenceClass(2, "Deposite Acc", 2), new TestSequenceClass(3, "Sms", 1)));
//		
//		System.out.println(sequeneces);
//	}
}
