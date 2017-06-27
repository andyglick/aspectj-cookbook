
public aspect CaptureCallParametersRecipe 
{
   /*
   Specifies calling advice whenever a method
   matching the following rules gets called:
   
   Class Name: MyClass
   Method Name: foo
   Method Return Type: void
   Method Parameters: an int followed by a String
   */
   pointcut captureCallParameters(int value, String name) : 
      call(void MyClass.foo(int, String)) && 
      args(value, name);

   // Advice declaration
   before(int value, String name) : captureCallParameters(value, name)
   {
      System.out.println(
         "------------------- Aspect Advice Logic --------------------");
      System.out.println(
         "In the advice attached to the call point cut");
      System.out.println("Captured int parameter on method: " + value);
      System.out.println("Captured String parameter on method: " + name);
      System.out.println(
         "------------------------------------------------------------");
   }
}
