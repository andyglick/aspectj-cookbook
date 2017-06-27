package com.oreilly.aspectjcookbook;

public aspect TCPConnectionState 
{
   protected TCPState listening = new TCPListen();

   protected TCPState acknowledged = new TCPAcknowledged();

   protected TCPState closed = new TCPClosed();

   after(TCPConnection connection) : initialization(new ())
      && target(connection)
   {
      listening.setConnection(new SocketConnection());
      connection.setState(listening);
   }

   after(TCPConnection connection, TCPState state) : call(
      void TCPState +.acknowledge())
      && target(state)
      && this(connection)
   {
      if (connection.getState() == listening)
      {
         acknowledged.setConnection(listening.getConnection());
         connection.setState(acknowledged);
      }
   }

   after(TCPConnection connection, TCPState state) : call(
      void TCPState +.close())
      && target(state)
      && this(connection)
   {
      if ((connection.getState() == listening)
         || (connection.getState() == acknowledged))
      {
         connection.setState(closed);
      }
   }
}