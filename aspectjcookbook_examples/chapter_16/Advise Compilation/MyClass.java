
public class MyClass
{
   private ProtectedAccessClass protectedObject;

   public MyClass(ProtectedAccessClass protectedObject)
   {
      this.protectedObject = protectedObject;
   }

   public void foo(int number)
   {
      this.protectedObject.setValue(number);
   }

   public void print()
   {
      System.out.println(
         "Printing value from protected class within MyClass object: "
            + this.protectedObject.getValue());
   }

   public static void main(String[] args)
   {
      ProtectedAccessClass protectedObject =
         new ProtectedAccessClass();

      MyClass myObject = new MyClass(protectedObject);

      myObject.foo(100);
      myObject.print();

      protectedObject.setValue(200);

      System.out.println(
         "Protected value from protected object within static main block: "
            + protectedObject.getValue());
   }
}