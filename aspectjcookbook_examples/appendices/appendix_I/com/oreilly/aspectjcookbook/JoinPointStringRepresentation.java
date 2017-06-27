package com.oreilly.aspectjcookbook;

public aspect JoinPointStringRepresentation 
{
   pointcut callPointCut() : call(void MyClass.foo(int, String));

   before() : callPointCut()
   {
      System.out.println(thisJoinPoint.toString());
      System.out.println(thisJoinPoint.toShortString());
      System.out.println(thisJoinPoint.toLongString());
      System.out.println("");
      System.out.println(thisJoinPoint.getSignature().toString());
      System.out.println(thisJoinPoint.getSignature().toShortString());
      System.out.println(thisJoinPoint.getSignature().toLongString());
      System.out.println(thisJoinPoint.getSignature().getDeclaringTypeName());
      System.out.println(thisJoinPoint.getSignature().getName());
   }
}
