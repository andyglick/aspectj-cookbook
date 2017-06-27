
/**
 * <p>Title: CallRecipe aspect for Recipe 13.4</p>
 * <p>Description: Simple aspect for demonstrating the ability to advise at compilation time</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public aspect CompilationAdviceRecipe 
{
   declare error : call(void ProtectedAccessClass.setValue(int))
      && !this(MyClass) 
      : "Must only set the ProtectedAccessClass.value from a MyClass object";

   declare warning : call(int ProtectedAccessClass.getValue())
      && !this(MyClass) 
      : "Should only be reading ProtectedAccessClass.value from a MyClass object";
}
