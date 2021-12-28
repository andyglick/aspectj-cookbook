package com.oreilly.aspectjcookbook;

public interface AlgorithmDefinition
{
   public String runAlgorithm();

   public StringBuffer stepOne();

   public void stepTwo(StringBuffer data);

   public void stepThree(StringBuffer data);

   public String stepFour(StringBuffer data);
}