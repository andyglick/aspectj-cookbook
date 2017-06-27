package com.oreilly.aspectjcookbook;

import com.oreilly.aspectjcookbook.feature_management.LazyFeatureLoading;
import com.oreilly.aspectjcookbook.features.Feature;

public class MainApplication
{
   private Feature[] features;

   public MainApplication()
   {
      features = new Feature[2];
      
      features[0] =
         LazyFeatureLoading
            .aspectOf()
            .initializeComponent(
            "com.oreilly.aspectjcookbook.features.FeatureA");

      features[1] =
         LazyFeatureLoading
            .aspectOf()
            .initializeComponent(
            "com.oreilly.aspectjcookbook.features.FeatureB");
      
      features[0].doSomething("Hello there");
      features[0].doSomething("Hello again");

      features[1].doSomething("Hi to you too");
      features[1].doSomething("Hi again");
   }

   public static void main(String[] args)
   {
      MainApplication mainApplication =
         new MainApplication();
   }
}
