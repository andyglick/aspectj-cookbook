import java.rmi.registry.*;

public class Server
{
   public static void main(String[] args)
   {
      try
      {
         ThisOrThatServerImpl server = new ThisOrThatServerImpl();
         Registry localRegistry = LocateRegistry.getRegistry();
         localRegistry.bind("TTTServer", server);
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}
