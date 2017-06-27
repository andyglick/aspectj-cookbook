
public class MyClass
{
   private float f;

   public void foo(int number, String name)
   {
      System.out.println("Inside foo (int, String)");
   }

   public void setF(float f)
   {
      this.f = f;
   }

   public static void main(String[] args)
   {
      // Create an instance of MyClass
      MyClass myObject = new MyClass();

      // Make the call to foo
      myObject.foo(1, "Russ Miles");
   }
}