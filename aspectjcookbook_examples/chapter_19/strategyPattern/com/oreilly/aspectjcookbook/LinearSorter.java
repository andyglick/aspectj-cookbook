package com.oreilly.aspectjcookbook;

public class LinearSorter
{

	private void exchange(int[] numbers, int pos1, int pos2)
	{
		int tmp = numbers[pos1];
		numbers[pos1] = numbers[pos2];
		numbers[pos2] = tmp;
	}

	public void sort(int[] numbers)
	{
		int lowest = 0;

		for (int start = 0; start < numbers.length; start++)
		{
			lowest = start;

			for (int current = start; current < numbers.length; current++)
			{
				if (numbers[current] < numbers[lowest])
				{
					lowest = current;
				}
			}
			exchange(numbers, start, lowest);
		}
	}
}