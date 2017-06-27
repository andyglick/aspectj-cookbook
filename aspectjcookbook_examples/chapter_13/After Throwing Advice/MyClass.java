
public class MyClass
{
   public void foo(int number) throws Exception
   {
      if (number > 20)
      {
         throw new Exception("Any Exception");
      }
   }

   public static void main(String[] args)
   {
      // Create an instance of MyClass
      MyClass myObject = new MyClass();

      try
      {
         // Make the legitimate call to foo
         myObject.foo(1);

         // Make the illegitimate call to foo
         myObject.foo(21);
      }
      catch (Exception e)
      {
         System.out.println("Exception caught" + e.getMessage());
         e.printStackTrace();
      }
   }
}