package com.in28minutes.spring.basics.springin5steps;

public class BinarySearchImpl {
	
	private SortAlgorithm sortAlgorithm;
	
	public BinarySearchImpl(SortAlgorithm sortAlgoritm) {
		super();
		this.sortAlgorithm = sortAlgoritm;
	}



	public int binarySearch(int[] numbers, int numberToSearchFor)
	{
		//Sorting the array by using Bubble sort algorithm
		int[] sortedNums = sortAlgorithm.sort(numbers);
		
		//Search the array
		
		
		//Return the array
		
		return 0;
	}
	
	
	
	
}
