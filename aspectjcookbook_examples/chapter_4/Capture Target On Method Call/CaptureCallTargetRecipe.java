
public aspect CaptureCallTargetRecipe 
{
   /*
   Specifies calling advice whenever a method
   matching the following rules gets called:
   
   Class Name: MyClass
   Method Name: foo
   Method Return Type: void
   Method Parameters: an int followed by a String
   */
   pointcut captureCallTarget(MyClass myObject) : 
      call(void MyClass.foo(int, String)) && 
      target(myObject);

   // Advice declaration
   before(MyClass myObject) : captureCallTarget(myObject)
   {

      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "In the advice attached to the call point cut");
      System.out.println("Captured target object for the method call: " + myObject);
      System.out.println(
         "------------------------------------------------------------");
   }
}
