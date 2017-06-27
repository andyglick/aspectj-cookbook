
public class MyClass
{
   private AnotherClass anotherObject = new AnotherClass();

   public void foo(int number, String name)
   {
      // Execise all of the calls on the AnotherClass object
      anotherObject.foo(2, "Russ");
   }

   public MyClass clone(MyClass object)
   {
      MyClass newObject = new MyClass();

      newObject.anotherObject = object.anotherObject;

      return newObject;
   }

   public static final void main(String args[])
   {
      // Create instances of the objects
      MyClass myObject = new MyClass();

      // Exercise all of the calls on the MyClass object
      myObject.foo(1, "Kim");

      MyClass anotherMyClass = myObject.clone(myObject);

      // Exercise all of the calls on the MyClass object
      anotherMyClass.foo(1, "Jason");
   }
}
