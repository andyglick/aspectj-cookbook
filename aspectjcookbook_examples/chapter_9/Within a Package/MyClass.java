import packageA.AnotherClass;

public class MyClass
{
   private String name;

   public String getName()
   {
      System.out.println("In the getName() method");
      return this.name;
   }

   public void setName(String name)
   {
      System.out.println("In the setName() method");
      this.name = name;
   }

   public static final void main(String args[])
   {
      // Create instances of the objects
      MyClass myObject = new MyClass();
      AnotherClass anotherObject = new AnotherClass();

      // Demonstrating get and set join points
      myObject.setName("Sam");
      String objectName = myObject.getName();

      // Execise all of the calls on the AnotherClass object
      anotherObject.foo(2, "Laura");
   }
}
