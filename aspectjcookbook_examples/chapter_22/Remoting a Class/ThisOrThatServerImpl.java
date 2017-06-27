import java.rmi.RemoteException;
import java.rmi.server.*;

public class ThisOrThatServerImpl extends UnicastRemoteObject implements ThisOrThatServer
{
	BusinessClass businessClass = new BusinessClass();
	
   public ThisOrThatServerImpl() throws RemoteException
   {
      
   }
   
   public void foo() throws RemoteException
   {
      this.businessClass.foo();
   }
}
