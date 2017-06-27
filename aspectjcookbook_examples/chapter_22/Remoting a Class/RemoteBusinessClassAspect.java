
import java.rmi.*;

public aspect RemoteBusinessClassAspect 
{
   public pointcut callBusinessClassFooInMain() : call(public void BusinessClass.foo()) &&
   withincode(public void MainApplication.main(String[]));
   
   void around() : callBusinessClassFooInMain()
   {
      try
      {
         ThisOrThatServer rmtServer = (ThisOrThatServer) Naming.lookup("rmi://localhost/TTTServer");
         rmtServer.foo();
      }
      catch (Exception e)
      {
         System.err.println("Problems occured when attempting " +
         "to use remote object, default to local");
         proceed();
      }
   }
}
