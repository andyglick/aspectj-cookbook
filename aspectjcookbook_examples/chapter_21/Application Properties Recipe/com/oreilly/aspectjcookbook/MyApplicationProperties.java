
package com.oreilly.aspectjcookbook;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public privileged aspect MyApplicationProperties 
{
   // Default property values
   
   private static final String PROPERTY_FILE_SYSTEM_PROPERTY = "props";
   
   private static final String DEFAULT_PROPERTIES_FILENAME = "myapplication.properties";
   
   private static final String MYCLASS_PROPERTY_NAME = "com.oreilly.aspectjcookbook.MyClass.property";
   
   private static final String MAINAPPLICATION_PROPERTY_NAME = "com.oreilly.aspectjcookbook.MainApplication.property";
   
   private static final int DEFAULT_MAINAPPLICATION_PROPERTY = 1;
   
   private static final String DEFAULT_MYCLASS_PROPERTY = "Property Initialized:";
   
   // In this example the properties are stored simply as Java properties
   // In a properties file
   
   Properties applicationProperties = new Properties();
   
   File propertiesFile;
   
   // Load Properties
   
   public MyApplicationProperties()
   {
      // Note. Aspects are initialized even before the MainApplication.
      try
      {         
         String propertyFilename = System.getProperty(PROPERTY_FILE_SYSTEM_PROPERTY);
         if (propertyFilename != null)
         {
            propertiesFile = new File(propertyFilename);
         }
         else
         {
            propertiesFile = new File(DEFAULT_PROPERTIES_FILENAME);
         }
         FileInputStream inputStream = new FileInputStream(propertiesFile);
         applicationProperties.load(inputStream);
         inputStream.close();
      }
      catch (Exception e)
      {
         // Just using default properties instead.
         System.err.println("Unable to load properties file, reverting to default values");
      }
      
   }
   
   // Supply Properties
   
   public pointcut mainApplicationInitialization() : staticinitialization(MainApplication);
   
   after() : mainApplicationInitialization()
   {
      try
      {
         int mainApplicationProperty = new Integer(applicationProperties.getProperty(MAINAPPLICATION_PROPERTY_NAME)).intValue();
         
         MainApplication.property = mainApplicationProperty;
      }
      catch (Exception e)
      {
         MainApplication.property = DEFAULT_MAINAPPLICATION_PROPERTY;
         applicationProperties.setProperty(MAINAPPLICATION_PROPERTY_NAME, new Integer(DEFAULT_MAINAPPLICATION_PROPERTY).toString()); 
      }
   }
   
   public pointcut myClassObjectCreation(MyClass myObject) : execution(public MyClass.new(..)) && this(myObject);
   
   before(MyClass myObject) : myClassObjectCreation(myObject)
   {
      String myClassProperty = applicationProperties.getProperty(MYCLASS_PROPERTY_NAME);
      if (myClassProperty != null)
      {
         myObject.property = myClassProperty;
      }
      else
      {
         myObject.property = DEFAULT_MYCLASS_PROPERTY;
         applicationProperties.setProperty(MYCLASS_PROPERTY_NAME, DEFAULT_MYCLASS_PROPERTY);
      }
   }
   
   // Monitoring properties
   
   public pointcut monitorMainApplicationProperty(int newValue) : set(int MainApplication.property) && args(newValue);
   
   after(int newValue) : monitorMainApplicationProperty(newValue) && !within(MyApplicationProperties)
   {
      System.out.println("MainApplication.property changed to: " + newValue);
      
      applicationProperties.setProperty(MAINAPPLICATION_PROPERTY_NAME, new Integer(newValue).toString());      
      // Does not update other instances of the class, just works like a setProperty method invocation.
   }    
   
   public pointcut monitorMyClassProperty(String newValue) : set(String MyClass.property) && args(newValue);
   
   after(String newValue) : monitorMyClassProperty(newValue) && !within(MyApplicationProperties)
   {
      System.out.println("MyClass.property changed to: " + newValue);
      
      applicationProperties.setProperty(MYCLASS_PROPERTY_NAME, newValue);
      // Does not update other instances of the class, just works like a setProperty method invocation.
   }
   
   // Store properties
  
   class ShutdownMonitor implements Runnable
   {
      public ShutdownMonitor()
      {
         // Register a shutdown hook
         Thread shutdownThread = new Thread(this);
         Runtime.getRuntime().addShutdownHook(shutdownThread);

      }
      public void run()
      {
         try
         {
            FileOutputStream outputStream = new FileOutputStream(propertiesFile);
            applicationProperties.store(outputStream, "---Properties for the AO Property Manager Example---");
            outputStream.close();
         }
         catch (Exception e)
         {
            System.err.println("Unable to save properties file, will use default on next run");
         }
      }
   }
   
   private ShutdownMonitor shutdownMonitor = new ShutdownMonitor();
}
