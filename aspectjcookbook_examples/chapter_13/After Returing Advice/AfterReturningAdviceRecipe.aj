/**
 * <p>Title: AfterReturningAdvice aspect for Recipe 10.6</p>
 * <p>Description: Simple aspect for demonstrating the use of after returning advice.</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public aspect AfterReturningAdviceRecipe 
{
   /*
   Specifies calling advice whenever a method
   matching the following rules gets called:
   
   Class Name: MyClass
   Method Name: foo
   Method Return Type: void
   Method Parameters: an int followed by a String
   */
   pointcut callPointCut() : call(void MyClass.foo(int));

   // Advice declaration
   //This advice will be executed before the pointcut that picks it
   after() returning : callPointCut()
      && !within(AfterReturningAdviceRecipe +)
   {
      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "Source Location: "
            + thisJoinPoint.getStaticPart().getSourceLocation());
      System.out.println(
         "------------------------------------------------------------");
   }
}
