package com.oreilly.aspectjcookbook;

public aspect DefaultAlgorithmImplementation 
{	
   public String AlgorithmDefinition.runAlgorithm()
   {
      StringBuffer dataInProcess = this.stepOne();
      this.stepTwo(dataInProcess);
      this.stepThree(dataInProcess);
      return this.stepFour(dataInProcess);
   }
   
   public StringBuffer AlgorithmDefinition.stepOne()
   {
      return new StringBuffer();
   }
   
   public String AlgorithmDefinition.stepFour(StringBuffer data)
   {
      return data.toString();
   }
}
