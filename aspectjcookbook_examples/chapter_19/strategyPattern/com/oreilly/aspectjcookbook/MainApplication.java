package com.oreilly.aspectjcookbook;

public class MainApplication
{

	public static void main(String[] args)
	{
		int[] originalNumbers = { 3, 2, 6, 8, 1, 5, 6, 4, 7, 0 };

		LinearSorter linearSort = new LinearSorter();
		BubbleSorter bubbleSort = new BubbleSorter();

		Sorter sorter = new Sorter();

		System.out.println("Original Numbers array:");
		for (int count = 0; count < originalNumbers.length; count++)
		{
			System.out.print("[" + originalNumbers[count] + "]");
		}

		SortingStrategy.aspectOf().setConcreteStrategy(sorter, linearSort);

		int[] linearSortedNumbers = sorter.sort(originalNumbers);

		System.out.println("\nLinear Sorted Numbers:");
		for (int count = 0; count < linearSortedNumbers.length; count++)
		{
			System.out.print("[" + linearSortedNumbers[count] + "]");
		}

		SortingStrategy.aspectOf().setConcreteStrategy(sorter, bubbleSort);

		int[] bubbleSortedNumbers = sorter.sort(originalNumbers);

		System.out.println("\nBubble Sorted Numbers:");
		for (int count = 0; count < bubbleSortedNumbers.length; count++)
		{
			System.out.print("[" + bubbleSortedNumbers[count] + "]");
		}
	}
}
