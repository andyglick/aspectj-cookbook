
/**
 * <p>Title: MemberAccessRecipe aspect for Recipe 10.1</p>
 * <p>Description: Simple aspect providing an example of how to access a classes members from within advice.</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public privileged aspect MemberAccessRecipe 
{
   /*
   Specifies calling advice whenever a method
   matching the following rules gets executed:
   
   Class Name: MyClass
   Method Name: foo
   Method Return Type: void
   Method Parameters: an int followed by a String
   */
   pointcut executionOfFooPointCut() : execution(
      void MyClass.foo(int, String));

   // Advice declaration
   //This advice will be executed after the pointcut that picks it
   after(MyClass myClass) : executionOfFooPointCut() && this(myClass)
   {
      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "Accessing the set(float) member of the MyClass object");
      System.out.println(
         "Privileged access not required for this method call as it is public");
      myClass.setF(2.0f);
      System.out.println(
         "Using the privileged aspect access to the private f member variable");
      System.out.print("The current value of f is: ");
      System.out.println(myClass.f);
      System.out.println(
         "Signature: " + thisJoinPoint.getSignature());
      System.out.println(
         "Source Line: " + thisJoinPoint.getSourceLocation());
      System.out.println(
         "------------------------------------------------------------");
   }
}
