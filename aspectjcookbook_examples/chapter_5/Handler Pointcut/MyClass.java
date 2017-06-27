
public class MyClass
{

   public void triggerMyException() throws MyException
   {
      MyException myException =
         new MyException("Boom!", "A nasty exception has occured");
      System.out.println("About to throw a MyException");
      throw myException;
   }

   public static final void main(String args[])
   {
      // Create an instance of the object
      MyClass myObject = new MyClass();

      try
      {
         myObject.triggerMyException();
      } catch (MyException me)
      {
         System.out.println("A MyException has been caught");
      }
   }
}
