
/**
 * <p>Title: Recipe 11.4</p>
 * <p>Description: Simple Class for demonstrating inner aspects</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public class MyClass
{

   /*
      Specifies calling advice whenever a method
      matching the following rules gets called:
   
      Class Name: MyClass
      Method Name: *
      Method Return Type: * (any return type)
      Method Parameters: .. (any parameters0
      */
   private static aspect CallMethods 
   {
      pointcut callPointCut() : call(* MyClass.* (..));

      // Advice declaration
      before() : callPointCut() && !within(CallMethods +)
      {

         System.out.println(
            "--------------- Aspect Advice Logic ----------------");
         System.out.println(
            "In the advice attached to the call point cut");
         System.out.println(
            "Signature: "
               + thisJoinPoint.getStaticPart().getSignature());
         System.out.println(
            "Source Line: "
               + thisJoinPoint.getStaticPart().getSourceLocation());
         System.out.println(
            "----------------------------------------------------");
      }
   }

   public void foo(int number, String name)
   {
      System.out.println("Inside foo (int, String)");
   }

   public void bar(String name)
   {
      System.out.println("Inside bar (String)");
      this.privateMethod();
   }

   private void privateMethod()
   {
      System.out.println("In privateMethod ()");
   }

   public static void main(String[] args)
   {
      // Create an instance of MyClass
      MyClass myObject = new MyClass();
      // Make the call to foo
      myObject.foo(1, "Russ");
      //		Make the call to bar
      myObject.bar("Kim");
   }
}