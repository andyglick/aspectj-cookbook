package com.oreilly.aspectjcookbook;

public class MainApplication
{
   public static void main(String[] args)
   {
      // Construct a simple message using our flyweight characters
      PrintableCharacter[] lineOfText = new PrintableCharacter[7];
      lineOfText[0] = new PrintableCharacter(new Character('K'));

      lineOfText[1] = new PrintableCharacter(new Character('D'));
      lineOfText[2] = new PrintableCharacter(new Character('H'));
      lineOfText[3] = new PrintableCharacter(new Character(','));
      lineOfText[4] = new PrintableCharacter(new Character('S'));
      lineOfText[5] = new PrintableCharacter(new Character('D'));
      lineOfText[6] = new PrintableCharacter(new Character('M'));

      // Print out the complete line of text
      System.out.println("\nPrinting out the stored line of text");
      for (int characterCount = 0; characterCount < lineOfText.length; characterCount++)
      {
         lineOfText[characterCount].print(false);
      }
      System.out.print("\n\n");

      // Print out the object references
      System.out.println("The actual Object References are:");
      for (int characterCount = 0; characterCount < lineOfText.length; characterCount++)
      {
         System.out.print("Character - ");
         lineOfText[characterCount].print(false);
         System.out.print(" : Object Reference - " + lineOfText[characterCount]
               + '\n');
      }
   }
}