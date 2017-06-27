
public class MainApplication
{
   public MainApplication()
   {
      // Create an instance of MyClass
      MyClass myObject = new MyClass();
      // Make the call to foo
      myObject.foo(1, "Russ");
      
      // Make the call to foo
      myObject.foo(2, "Kim");
   }

   public static void main(String[] args)
   {
      MainApplication application = new MainApplication();

      // Create an instance of MyClass
      MyClass yetAnotherObject = new MyClass();
      // Make the call to foo
      yetAnotherObject.foo(3, "Bobs");
   }
}
