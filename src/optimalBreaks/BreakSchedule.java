package optimalBreaks;

import java.util.ArrayList;
//import java.util.*;

public class BreakSchedule {
	
	
	// Use this class to implement programs for Tasks 2 & 3. Your file must not change the package name,
	// nor the class name. You must not change the names nor the signatures of the two program stubs
	// in this file. You may augment this file with any other method or variable/data declarations that you
	// might need to implement the dynamic programming strategy requested for Tasks 2&3.
	// Make sure however that all your declarations are public.
	
	// TASK 1

	// Precondition: word is a string and breakList is an array of integers in strictly increasing order
	//               the last element of breakList is no more than the number of characters in word.
	// Postcondition: Return the minimum total cost of breaking the string word into |breakList|+1 pieces, where 
	//                the position of each each break is specified by the integers in breakList. 
	//                Refer to the assignment specification for how a single break contributes to the cost.
	
	// holds list for best cuts to perform
	ArrayList<Integer> optimalBreak;
	
	// holds starting and ending index for the word
	int[] wordMarker;

	// ...
	boolean wordIsSet = false;

	
	public void setWordMarker(String word){
		
		if (wordIsSet){
			return;
		}

		optimalBreak =  new ArrayList<Integer>();
		wordIsSet = true;

		wordMarker = new int[2];

		wordMarker[0] = 0;
		wordMarker[1] = word.length();
		
	}

	int totalCost (String word, ArrayList<Integer> breakList){ 

		// NULL
		if (isEmpty(word, breakList)){
			return 0;
		}

		// no more items in list
		if (isSizeZero(word, breakList)){
			return 0;
		}
		
		// init tempWord to word
		String tempWord = word;

		if (!wordIsSet){
			setWordMarker(word);
		} else {
			tempWord = word.substring(wordMarker[0], wordMarker[1]);
		}

		// the cost of cutting the current word...
		int len = tempWord.length();

		// non-empty string and size > 0
		if(isSingleBreakItem(breakList)){	
			
			// check if the last item in breakList is feasible or not
			if (costOfSingleItem(word, breakList.get(0)) != 0){
				optimalBreak.add(breakList.get(0));
				return len;
			}

			return 0;
		}
		
		determineOptimalCut(word, tempWord, breakList);

		return len + totalCost(word, breakList);
	}
	 

	// only one item in breakList
	boolean isSingleBreakItem(ArrayList<Integer> breakList){	
		return breakList.size() == 1;
	}

	// check if null
	boolean isEmpty(String word, ArrayList<Integer> breakList){
		return word == null || breakList == null;
	}

	// check length of word && breakList
	boolean isSizeZero(String word, ArrayList<Integer> breakList){
		return word.length() == 0 || breakList.size() == 0;
	}

	// if the break index is greater than the word's last index, not feasible
	int costOfSingleItem(String word, int item){
		if (item >= word.length()-1 || item < 0){
			return 0;
		}

		return word.length();
	}

	// determine to cut from left or right
	public void determineOptimalCut(String word, String tempWord, ArrayList<Integer> breakList){
		// initialise costOfCuts to the length of the word itself
		int[] costOfCuts = {word.length(), word.length()};

		// left break point value
		int leftElem = breakList.get(0);

		// right break point value
		int rightElem = breakList.get(breakList.size()-1);
		
		// left elem
		if (costOfSingleItem(word, leftElem) != 0){
			// review this and the feasible for rightElem
			//sizeLeftRight[0] = (wordMarker[1] - leftElem);
			
			costOfCuts[0] = tempWord.substring(leftElem+1, wordMarker[1]).length();
			
			//leftCost = word.length() + totalCost(word.substring(breakList.get(0)), breakList);
		}

		// right elem
		if (costOfSingleItem(word, rightElem) != 0){
			//sizeLeftRight[1] = (rightElem - wordMarker[0]);
			
			costOfCuts[1] = tempWord.substring(wordMarker[0], rightElem).length();
			
			//rightCost = word.length() + totalCost(word.substring(0,breakList.get(breakList.size()-1)), breakList);
		}

		// left is smaller
		if (costOfCuts[0] < costOfCuts[1]){
			optimalBreak.add(optimalBreak.size(), leftElem);
			wordMarker[0] = leftElem+1;
			// remove left element
			breakList.remove(0);
		
		// right is smaller
		} else {
			optimalBreak.add(optimalBreak.size(), rightElem);
			wordMarker[1] = rightElem+1;
			// remove right element
			breakList.remove(breakList.get(breakList.size()-1));
		}
	}


	// TASK 3

	// Precondition: word is a string and breakList is an array of integers in strictly increasing order
	//               the last element of breakList is no more than the number of characters in word.
	// Postcondition: Return the schedule of breaks so that word is broken according to the list of
	// 					breaks specified in breakList which yields the minimum total cost.
	 
	ArrayList<Integer> breakSchedule (String word, ArrayList<Integer> breakList){ 

		// check if word or breakList is null
		if (isEmpty(word, breakList)){
			return null;
		}

		// if the total cost is 0, then the breaks suggested are not feasible, and hence
		// we return null.
		if (totalCost(word, breakList) == 0){
			return null;
		}

		// otherwise we return the arrayList for optimal breakage
		return optimalBreak;
	}	 



	public static void main(String[] args){

		BreakSchedule x= new BreakSchedule();
		String w= "abcdefghijk";
		ArrayList<Integer> b= new ArrayList<Integer>();
		b.add(3);
		b.add(8);
		int cost = x.totalCost(w,b);
		System.out.println(cost);

	}

}