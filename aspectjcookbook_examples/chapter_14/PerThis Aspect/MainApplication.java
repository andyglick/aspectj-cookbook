public class MainApplication
{
   public MainApplication()
   {
      // Create an instance of MyClass
      MyClass myObject = new MyClass();
      // Make the call to foo
      myObject.foo(1, "Russ");

      // Create an instance of MyClass
	  MyClass anotherObject = new MyClass();
      // Make another call to foo
      anotherObject.foo(2, "Kim");
   }

   public static void main(String[] args)
   {
      MainApplication application = new MainApplication();

      // Create another instance of MainApplication
	  MainApplication anotherApplication = new MainApplication();
   }
}
