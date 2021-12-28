package com.oreilly.aspectjcookbook;

public class MainApplication
{
	public static void main(String[] args)
	{
		AlgorithmDefinition algorithm;

		System.out.println("Using first algorithm implementation");
		algorithm = new SpecializedAlgorithmA();
		System.out.println(algorithm.runAlgorithm());

		System.out.println("Using second algorithm implementation");
		algorithm = new SpecializedAlgorithmB();
		System.out.println(algorithm.runAlgorithm());
	}
}
