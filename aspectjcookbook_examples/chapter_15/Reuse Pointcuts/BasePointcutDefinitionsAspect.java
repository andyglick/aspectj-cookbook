/**
 * <p>Title: BasePointcutDefinitions aspect for Recipe 12.1</p>
 * <p>Description: Simple aspect for demonstrating the ability to reuse pointcuts by extending aspects</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public abstract aspect BasePointcutDefinitionsAspect 
{
   pointcut callPointcut() : call(
      void MyClass.foo(int, String));
}
