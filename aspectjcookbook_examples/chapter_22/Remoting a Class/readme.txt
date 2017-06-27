Some additional information about running this example code
-----------------------------------------------------------

Emptying the CLASSPATH before running the rmiregistry
------------------------------------------------------
The first thing to watch out for is that you will need to empty the classpath to run the rmiregistry. 
Several examples of how to do this are available at http://java.sun.com/docs/books/tutorial/rmi/running.html. 

Using the example security settings
-----------------------------------
The example comes with a simple set of security settings in the wideopen.policy file. 
To run the example you will need to add the security policy to the java command when 
you run the server, the Server class, and the client, the MainApplication class, 
by using the ÐDjava.security.profile virtual machine property. 

Switching build configurations between local and build
------------------------------------------------------
This example comes with two build configurations. The 'local' configuration will 
not weave the remoting aspect and the application will function normally in local mode. 
The 'build'configuration will incorporate the aspect and switch to using RMI.
Be aware that if you are using Eclipse and switch between modes the classes generated from
the command line by the rmic tool will be deleted and will need to be re-generated.
