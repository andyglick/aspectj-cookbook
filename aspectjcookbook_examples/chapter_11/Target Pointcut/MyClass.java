
public class MyClass
{
   private AnotherClass anotherObject = new AnotherClass();

   public void foo(int number, String name)
   {
      anotherObject.foo(2, "Alisdair");
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
      myObject.foo(1, "Laura");

      MyClass anotherMyClass = myObject.clone(myObject);

      anotherMyClass.foo(3, "Kerry");
   }
}
