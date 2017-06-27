
public class MainApplication
{
   public MainApplication()
   {
      // Create an instance of MyClass
      MyClass myObject = new MyClass();
      
      // Make the call to foo
      myObject.foo(1, "Russ");
      
	  // Make another call to the same object
	  myObject.foo(2, "Kim");
   }

   public static void main(String[] args)
   {
      MainApplication application = new MainApplication();
   }
}
