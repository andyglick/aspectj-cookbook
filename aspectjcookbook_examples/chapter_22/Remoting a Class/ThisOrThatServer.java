import java.rmi.*;

public interface ThisOrThatServer extends Remote
{
   public void foo() throws RemoteException;
}
