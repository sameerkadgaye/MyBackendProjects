/**
 * 
 */
package dataStructureAndAlgorithms.sorting.bubbleSort;

/**
 * @author SAMEER.KADGAYE
 *
 */
public class BubbleSortEnhancementExample {

	// Simple Logic Not Enhancement Program.
	public static void main(String[] args) {
		int unOrderList[] = { 36, 19, 29, 12, 5 };
		int tempHoldValue;
		for (int round = 0; round < unOrderList.length; round++) { // compareArrayIndex Val
			int forBreakFlag = 0;
			for (int compValueOfIndex = 0; compValueOfIndex < unOrderList.length - 1 - round; compValueOfIndex++) {
															 //unOrderList.length - 1 hi condition compare index size justify hoil 
															 //tyach praker lahli ahe. manje ha loop list che index he compare hau saktil tith
															 //parentch chalel. extra nahi gelya pahije manun tith - 1 kel ahe karan length he 
															 //1 pasun count hote ani index ha 0 pasun manun out of bound exception avoid karavych ahe tyat.
				if (unOrderList[compValueOfIndex] > unOrderList[compValueOfIndex + 1]) {
					tempHoldValue = unOrderList[compValueOfIndex];
					unOrderList[compValueOfIndex] = unOrderList[compValueOfIndex + 1];
					unOrderList[compValueOfIndex + 1] = tempHoldValue;
					forBreakFlag = 1;
				}
			}
			if (forBreakFlag == 0) {
				break;
			}
		}
		for (int i = 0; i < unOrderList.length; i++) {
			System.out.print(unOrderList[i] + " ");
		}
	}
}


//ROUND 1 : 
//Main Array : 36, 19, 29, 12, 5

//			   19, 36, 29, 12, 5
//			   19, 29, 36, 12, 5
//			   19, 29, 12, 36, 5
//			   19, 29, 12,  5, 36

//ROUND 2 : 
//Main Array : 19, 29, 12,  5, 36

//			   19, 29, 12,  5, 36
//			   19, 12, 29,  5, 36
//			   19, 12,  5, 29, 36

//ROUND 3 : 
//Main Array : 19, 12,  5, 29, 36

//			   12, 19,  5, 29, 36
//			   12,  5, 19, 29, 36

//ROUND 4 : 
//Main Array : 12,  5, 19, 29, 36

//			    5, 12, 19, 29, 36  // Sorted In List Length - 1 Iteration.
