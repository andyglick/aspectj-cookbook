
public class MyClass extends AnotherClass
{
   private String name;

   public MyClass(int number, String name)
   {
      super(number);
      System.out.println("Initializing MyClass");
      this.name = name;
   }

   public static final void main(String args[])
   {
      // Create an instance of the object
      MyClass myObject = new MyClass(123456, "Russ");
   }
}
