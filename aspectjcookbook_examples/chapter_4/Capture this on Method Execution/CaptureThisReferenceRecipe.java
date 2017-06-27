
public aspect CaptureThisReferenceRecipe 
{
   /*
   Specifies calling advice whenever a method
   matching the following rules gets executed:
   
   Class Name: MyClass
   Method Name: foo
   Method Return Type: void
   Method Parameters: an int followed by a String
   */
   pointcut captureThisDuringExecution(MyClass myObject) : 
      execution(void MyClass.foo(int, String)) && 
      this(myObject);

   // Advice declaration
   before(MyClass myObject) : captureThisDuringExecution(myObject)
   {

      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "In the advice attached to the execution point cut");
      System.out.println("Captured this reference: " + myObject);
      System.out.println(
         "------------------------------------------------------------");
   }
}
