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
	ArrayList<Integer> optimalBreak =  new ArrayList<Integer>();
	
	// holds starting and ending index for the word
	int[] startEndIdx = new int[2];

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

		// this means no breaks have been performed -- no need to copy out word, since it's not a substring...
		if (optimalBreak.isEmpty()){
			startEndIdx[0] = 0;
			startEndIdx[1] = word.length();
		} else {
			// copy of word that has been split at the indexes seen previously
			tempWord = word.substring(startEndIdx[0], startEndIdx[1]);
		}

		// the cost of cutting the current word...
		int len = tempWord.length();

		// non-empty string and size > 0
		if(isSingleBreakItem(breakList)){	

			// check if the last item in breakList is feasible or not
			int result = isFeasible(tempWord, breakList.get(0));

			if (result != 0){
				optimalBreak.add(breakList.get(0));
			}

			return result;
		}
		
		// we initially set the size of the left and right sub-string values to the length of word
		// because, if a cut is not feasible, and we compare the lengths, the cut that is possible will be chosen
		int[] sizeLeftRight = {word.length(), word.length()};

		// left break point value
		int leftElem = breakList.get(0);

		// right break point value
		int rightElem = breakList.get(breakList.size()-1);
		
		// left elem
		if (isFeasible(word, leftElem) != 0){
			sizeLeftRight[0] = tempWord.substring(leftElem).length();
			//leftCost = word.length() + totalCost(word.substring(breakList.get(0)), breakList);
		}

		// right elem
		if (isFeasible(word, rightElem) != 0){
			sizeLeftRight[1] = tempWord.substring(startEndIdx[0], rightElem).length();
			//rightCost = word.length() + totalCost(word.substring(0,breakList.get(breakList.size()-1)), breakList);
		}

		// 0 is left, 1 is right
		// take the minimum of the two values
		int min = compareLeftRight(sizeLeftRight[0], sizeLeftRight[1]);

		// left is smaller
		if (min == 0){
			optimalBreak.add(optimalBreak.size(), leftElem);
			startEndIdx[0] = leftElem;
			// remove left element
			breakList.remove(0);
		
		// right is smaller
		} else {
			optimalBreak.add(optimalBreak.size(), rightElem);
			startEndIdx[1] = rightElem+1;
			// remove right element
			breakList.remove(breakList.get(breakList.size()-1));
		}

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
	int isFeasible(String word, int item){
		if (item >= word.length()-1 || item < 0){
			return 0;
		}

		return word.length();
	}

	// returns the index of the two substrings from word
	// 0 is the left item
	// 1 is the right
	int compareLeftRight(int left, int right){
		if(left < right){
			return 0;		
		}
	
		return 1;
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
		String w= "Holiday";
		ArrayList<Integer> b= new ArrayList<Integer>();
		b.add(0);
		b.add(3);
		int cost = x.totalCost(w,b);

		System.out.println(cost);

	}

}