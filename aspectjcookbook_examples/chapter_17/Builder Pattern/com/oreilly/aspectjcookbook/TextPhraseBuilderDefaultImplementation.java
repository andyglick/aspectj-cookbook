package com.oreilly.aspectjcookbook;

public aspect TextPhraseBuilderDefaultImplementation 
{
   public StringBuffer TextPhraseBuilder.result = new StringBuffer();
   
   public String TextPhraseBuilder.getResult()
   {
      return result.toString();
   }
   
   /**
    * Declares a compiler error that gets reported if other classes (except
    * Builders or this aspect) try to access the result variable.
    */
   
   declare error : (
         set(public StringBuffer TextPhraseBuilder +.result)
         || get(public StringBuffer TextPhraseBuilder +.result))
         && !(within(TextPhraseBuilder +)
               || within(TextPhraseBuilderDefaultImplementation)) : "variable result is aspect protected. use getResult() to access it";
}
