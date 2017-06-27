/**
 * <p>Title: CallRecipe aspect for Recipe 10.10</p>
 * <p>Description: Simple aspect for demonstrating the ability to advise aspects</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public aspect AdvisedAspect 
{
   /*
   Specifies calling advice whenever a method
   matching the following rules gets called:
   
   Class Name: MyClass
   Method Name: foo
   Method Return Type: void
   Method Parameters: an int followed by a String
   */
   pointcut callPointCut(MyClass myObject) : call(
      void MyClass.foo(int, String))
      && target(myObject);

   // Advice declaration
   //This advice will be executed before the pointcut that picks it
   before(MyClass myObject) : callPointCut(myObject)
      && !within(AdvisedAspect +)
   {

      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "In the advice attached to the call point cut");
      System.out.println(
         "Signature: "
            + thisJoinPoint.getStaticPart().getSignature());
      System.out.println(
         "Source Line: "
            + thisJoinPoint.getStaticPart().getSourceLocation());

      myObject.foo(2, "Kim");

      System.out.println(
         "------------------------------------------------------------");

   }
}
