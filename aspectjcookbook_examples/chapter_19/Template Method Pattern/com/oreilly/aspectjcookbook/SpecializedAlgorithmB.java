package com.oreilly.aspectjcookbook;

public class SpecializedAlgorithmB implements AlgorithmDefinition
{
	public void stepTwo(StringBuffer data)
	{
		data.append("Added Data For first specialized step in SpecializedAlgorithmB\n");
	}

	public void stepThree(StringBuffer data)
	{
		data.append("Added Data For second specialized step in SpecializedAlgorithmB\n");
	}
}
