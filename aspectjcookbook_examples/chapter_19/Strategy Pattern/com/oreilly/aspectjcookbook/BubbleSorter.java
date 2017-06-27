package com.oreilly.aspectjcookbook;

public class BubbleSorter
{
	private void exchange(int[] numbers, int pos1, int pos2)
	{
		int tmp = numbers[pos1];
		numbers[pos1] = numbers[pos2];
		numbers[pos2] = tmp;
	}

	public void sort(int[] numbers)
	{
		for (int end = numbers.length; end > 1; end--)
		{
			for (int current = 0; current < end - 1; current++)
			{
				if (numbers[current] > numbers[current + 1])
				{
					exchange(numbers, current, current + 1);
				}
			}
		}
	}
}
