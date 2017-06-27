package com.oreilly.aspectjcookbook;

public class SpecializedAlgorithmA implements AlgorithmDefinition
{
	public void stepTwo(StringBuffer data)
	{
		data.append("Added Data For first specialized step in SpecializedAlgorithmA\n");
	}

	public void stepThree(StringBuffer data)
	{
		data.append("Added Data For second specialized step in SpecializedAlgorithmA\n");
	}
}
